package eu.vanyamihova.starter.data.net.task;

import java.util.List;

import eu.vanyamihova.starter.data.datastore.AppDatabaseManager;
import eu.vanyamihova.starter.data.datastore.task.TaskDao;
import eu.vanyamihova.starter.data.executor.priority.Priority;
import eu.vanyamihova.starter.data.executor.priority.PriorityRunnable;

/**
 * Save {@link GetTasksTO} to the database
 *
 * Created by Vanya Mihova on 19.01.2018
 */

final class GetTasksSaveRunnable extends PriorityRunnable {

    private TaskDao taskDao;
    private List<GetTasksTO> tos;

    GetTasksSaveRunnable(List<GetTasksTO> tos) {
        super(Priority.IMMEDIATE);
        this.taskDao = AppDatabaseManager.get().taskDao();
        this.tos = tos;
    }

    @Override
    public void run() {
        GetTasksTOMapper mapper = new GetTasksTOMapper();
        taskDao.insertAll(mapper.transform(tos));
    }

}
