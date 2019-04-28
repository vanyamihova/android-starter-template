package eu.vanyamihova.starter.devtool;

import android.util.Log;

import eu.vanyamihova.starter.BuildConfig;


/**
 * Keep logic for debug purposes
 * <p>
 * Created by Vanya Mihova on 02.02.17.
 */
public class DebugManager {

    private static final String TAG = "DEBUG_MANAGER";

    public static void log(String message) {
        log(message, null);
    }

    public static void log(String message, Exception e) {
        if (isInDebugMode()) {
            DebugManager debugManager = new DebugManager();
            debugManager.logGenericFailure(message, e);
        }
    }

    private static boolean isInDebugMode() {
        return BuildConfig.DEBUG;
    }

    private void logGenericFailure(String message, Exception e) {
        if (e == null) {
            Log.d(TAG, message);
            return;
        }
        Log.e(TAG, message, e);
    }

}
