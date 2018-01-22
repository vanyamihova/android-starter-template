package eu.vanyamihova.starter.devtool;

import java.util.logging.ErrorManager;

import eu.vanyamihova.starter.BuildConfig;


/**
 * Keep logic for debug purposes
 *
 * Created by Vanya Mihova on 02.02.17.
 */
public class DebugManager {

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
        ErrorManager em = new ErrorManager();
        em.error(message, e, ErrorManager.GENERIC_FAILURE);
    }

}
