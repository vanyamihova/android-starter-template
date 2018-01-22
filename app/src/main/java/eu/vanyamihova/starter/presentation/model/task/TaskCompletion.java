package eu.vanyamihova.starter.presentation.model.task;

/**
 * Created by Vanya Mihova on 22.01.2018
 */

public enum TaskCompletion {
    DONE("done"),
    PENDING("pending");

    private String mLabel;

    TaskCompletion(String label) {
        this.mLabel = label;
    }

    public String getLabel() {
        return mLabel;
    }

}
