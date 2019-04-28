package eu.vanyamihova.starter.data.net.mapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import eu.vanyamihova.starter.data.datastore.task.TaskEntity;
import eu.vanyamihova.starter.data.net.task.GetTasksDTO;
import eu.vanyamihova.starter.data.net.task.GetTasksResponse;
import eu.vanyamihova.starter.data.utils.ListUtils;

/**
 * A mapper for transforming {@link TaskEntity} to {@link GetTasksDTO}.
 * It is used in the implementation of the repository to transform objects for `domain` layer.
 * <p>
 * Created by Vanya Mihova on 12.01.2018
 */

public final class GetTasksDTOMapper implements Serializable {

    public GetTasksDTOMapper() {
    }

    public List<TaskEntity> transform(GetTasksResponse response) {
        List<TaskEntity> taskEntities = new ArrayList<>();

        if (!ListUtils.isEmpty(response)) {
            for (GetTasksDTO to : response) {
                taskEntities.add(this.transform(to));
            }
        }
        return taskEntities;
    }

    private TaskEntity transform(GetTasksDTO to) {
        return new TaskEntity(
                to.getId(),
                to.getTitle(),
                to.isCompleted()
        );
    }

}
