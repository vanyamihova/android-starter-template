package eu.vanyamihova.starter.data.executor.priority;

import androidx.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Vanya Mihova on 19.01.2018
 */

public class PriorityThreadFactory implements ThreadFactory {

    private final int mThreadPriority;
    private final String mThreadName;

    public PriorityThreadFactory(int threadPriority, String threadName) {
        this.mThreadPriority = threadPriority;
        this.mThreadName = threadName;
    }

    @Override
    public Thread newThread(@NonNull Runnable runnable) {
        Runnable wrapperRunnable = () -> {
            try {
                android.os.Process.setThreadPriority(this.mThreadPriority);
            } finally {
                runnable.run();
            }
        };
        return new Thread(wrapperRunnable, this.mThreadName);
    }

}
