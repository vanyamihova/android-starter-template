package eu.vanyamihova.starter.data.executor.thread;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * Main thread executor
 *
 * Created by Vanya Mihova on 19.01.2018
 */

public class MainThreadExecutor implements Executor {

    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(@NonNull Runnable runnable) {
        handler.post(runnable);
    }

}
