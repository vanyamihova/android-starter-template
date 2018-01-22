package eu.vanyamihova.starter.data.executor.thread;

import java.util.concurrent.TimeUnit;

import eu.vanyamihova.starter.data.executor.priority.PriorityThreadFactory;
import eu.vanyamihova.starter.data.executor.priority.PriorityThreadPoolExecutor;

/**
 * Background thread executor
 *
 * Created by Vanya Mihova on 21.01.2018
 */

public class BackgroundThreadExecutor extends PriorityThreadPoolExecutor {

    public BackgroundThreadExecutor(int coreNumber) {
        super(
                coreNumber * 2,
                coreNumber * 2,
                60L,
                TimeUnit.SECONDS,
                new PriorityThreadFactory(android.os.Process.THREAD_PRIORITY_BACKGROUND, THREAD_NAME)
        );
    }

    private final static String THREAD_NAME = "BACKGROUND_THREAD";

}
