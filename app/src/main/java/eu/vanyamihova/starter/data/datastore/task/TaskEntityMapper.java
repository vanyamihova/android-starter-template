package eu.vanyamihova.starter.data.datastore.task;

import java.util.ArrayList;
import java.util.List;

import eu.vanyamihova.starter.data.utils.ListUtils;
import eu.vanyamihova.starter.domain.task.Task;

/**
 * A mapper for transforming {@link TaskEntity} to {@link Task}.
 * It is used in the implementation of the repository to transform objects for `domain` layer.
 *
 * Created by Vanya Mihova on 21.01.2018
 */

public final class TaskEntityMapper {

    public TaskEntityMapper() {
    }

    public List<Task> transform(List<TaskEntity> entities) {
        List<Task> tasks = new ArrayList<>();

        if (!ListUtils.isEmpty(entities)) {
            for (TaskEntity entity : entities) {
                tasks.add(this.transform(entity));
            }
        }
        return tasks;
    }

    private Task transform(TaskEntity to) {
        Task task = new Task((int)to.getId());
        task.setTitle(to.getTitle());
        task.setCompleted(to.isCompleted());
        return task;
    }

}
