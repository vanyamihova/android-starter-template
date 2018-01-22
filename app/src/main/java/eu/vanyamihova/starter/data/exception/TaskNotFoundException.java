package eu.vanyamihova.starter.data.exception;

/**
 * Exception throw by the application when a Task fetch can't return a valid result.
 *
 * Created by Vanya Mihova on 12.01.2018
 */
public class TaskNotFoundException extends Exception {
    TaskNotFoundException() {
        super();
    }
}
