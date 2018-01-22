package eu.vanyamihova.starter.data.net.task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import eu.vanyamihova.starter.data.datastore.task.TaskEntity;
import eu.vanyamihova.starter.data.utils.ListUtils;

/**
 * A mapper for transforming {@link TaskEntity} to {@link GetTasksTO}.
 * It is used in the implementation of the repository to transform objects for `domain` layer.
 *
 * Created by Vanya Mihova on 12.01.2018
 */

final class GetTasksTOMapper implements Serializable {

    GetTasksTOMapper() {
    }

    List<TaskEntity> transform(List<GetTasksTO> tos) {
        List<TaskEntity> taskEntities = new ArrayList<>();

        if (!ListUtils.isEmpty(tos)) {
            for (GetTasksTO to : tos) {
                taskEntities.add(this.transform(to));
            }
        }
        return taskEntities;
    }

    private TaskEntity transform(GetTasksTO to) {
        return new TaskEntity(
                to.getId(),
                to.getTitle(),
                to.isCompleted()
        );
    }

}