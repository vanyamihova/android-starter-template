package eu.vanyamihova.starter.data.executor;

import java.util.concurrent.Executor;

import eu.vanyamihova.starter.data.executor.priority.PriorityThreadPoolExecutor;
import eu.vanyamihova.starter.data.executor.thread.BackgroundThreadExecutor;
import eu.vanyamihova.starter.data.executor.thread.MainThreadExecutor;

/**
 * Singleton class for default thread executor. It manages two type of threads
 * - one on foreground;
 * - one on background;
 *
 * It depends from the developer which one will chose. By default the `background` one is used
 * for fetching data from the database.
 *
 * Created by Vanya Mihova on 19.01.2018
 */

public final class ThreadPoolExecutor {

    /**
     * Number of cores to decide the number of threads
     */
    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    private static ThreadPoolExecutor sInstance;

    public static ThreadPoolExecutor getInstance() {
        if (sInstance == null) {
            synchronized (ThreadPoolExecutor.class) {
                sInstance = new ThreadPoolExecutor();
            }
        }
        return sInstance;
    }

    /**
     * Thread pool executor for background tasks
     */
    private final PriorityThreadPoolExecutor mForBackgroundTasks;

    /**
     * Thread pool executor for main thread tasks
     */
    private final Executor mMainThreadExecutor;

    /**
     * Constructor for ThreadPoolExecutor
     */
    private ThreadPoolExecutor() {
        // Setting the thread pool executor for mForBackgroundTasks;
        mForBackgroundTasks = new BackgroundThreadExecutor(NUMBER_OF_CORES);

        // Setting the thread pool executor for mMainThreadExecutor;
        mMainThreadExecutor = new MainThreadExecutor();
    }

    /**
     * @return the thread pool executor for background task
     */
    public java.util.concurrent.ThreadPoolExecutor forBackgroundTasks() {
        return mForBackgroundTasks;
    }

    /**
     * @return the thread pool executor for main thread task
     */
    public Executor forMainThreadTasks() {
        return mMainThreadExecutor;
    }

}
