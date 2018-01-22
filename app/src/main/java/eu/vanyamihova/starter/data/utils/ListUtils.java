package eu.vanyamihova.starter.data.utils;

import java.util.List;

/**
 * Util for Collections and Arrays
 *
 * Created by Vanya Mihova on 28.01.17.
 */
public class ListUtils {

    private ListUtils() {
        // Add a private constructor to hide to implicit public one.
    }

    public static boolean isEmpty(List list) {
        return !(list != null && !list.isEmpty());
    }

    public static boolean isEmpty(byte[] array) {
        return !(array != null && array.length > 0);
    }

}
