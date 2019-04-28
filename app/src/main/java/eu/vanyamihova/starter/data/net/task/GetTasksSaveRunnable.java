package eu.vanyamihova.starter.data.net.task;

import eu.vanyamihova.starter.data.datastore.AppDatabaseManager;
import eu.vanyamihova.starter.data.datastore.task.TaskDao;
import eu.vanyamihova.starter.data.net.mapper.GetTasksDTOMapper;
import eu.vanyamihova.starter.devtool.DebugManager;

/**
 * Save {@link GetTasksDTO} to the database
 * <p>
 * Created by Vanya Mihova on 19.01.2018
 */

final class GetTasksSaveRunnable {

    private TaskDao taskDao;
    private GetTasksDTOMapper mapper;

    GetTasksSaveRunnable() {
        this.taskDao = AppDatabaseManager.get().taskDao();
        this.mapper = new GetTasksDTOMapper();
    }

    void run(GetTasksResponse response) {
        DebugManager.log("Insert all data from Get Tasks Response");
        taskDao.insertAll(mapper.transform(response));
    }

}
