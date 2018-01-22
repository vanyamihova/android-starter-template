package eu.vanyamihova.starter.domain.task;

import android.text.TextUtils;

/**
 * Check if the task is a valid object.
 *
 * Created by Vanya Mihova on 18.01.2018
 */

public final class TaskValidator {

    public TaskValidator() {
    }

    public boolean isValid(Task task) {
        return task.getId() > 0 && !TextUtils.isEmpty(task.getTitle());
    }
}
