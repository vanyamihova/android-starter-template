package eu.vanyamihova.starter.presentation.model.task;

import eu.vanyamihova.starter.domain.task.Task;

/**
 * A mapper for transforming {@link Task} to {@link TaskViewModel}.
 * It is used in the implementation of the presenters to transform objects for `presentation` layer.
 *
 * Created by Vanya Mihova on 18.01.2018
 */

public final class TaskViewMapper {

    public TaskViewMapper() {
    }

    public TaskViewModel transform(Task task) {
        return new TaskViewModel(
                task.getId(),
                task.getTitle(),
                task.isCompleted()
        );
    }

}
