package eu.vanyamihova.starter.data.executor.priority;

/**
 * Hold the priority of the threads.
 *
 * Created by Vanya Mihova on 19.01.2018
 */

public class PriorityRunnable implements Runnable {

    private final Priority priority;

    public PriorityRunnable(Priority priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        // nothing to do here.
    }

    Priority getPriority() {
        return priority;
    }

}
