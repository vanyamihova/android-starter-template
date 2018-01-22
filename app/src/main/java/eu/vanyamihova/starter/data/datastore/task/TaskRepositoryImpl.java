package eu.vanyamihova.starter.data.datastore.task;

import java.util.List;

import eu.vanyamihova.starter.data.datastore.AppDatabaseManager;
import eu.vanyamihova.starter.data.executor.ThreadPoolExecutor;
import eu.vanyamihova.starter.domain.base.interactor.UseCase;
import eu.vanyamihova.starter.domain.task.Task;
import eu.vanyamihova.starter.domain.task.TaskRepository;

/**
 * Implementation of the repository which is positioned in the `domain` layer.
 * Task Repository is used to fetch/manage data from the database using background threads.
 *
 * All of the queries MUST be proceed on background thread!
 *
 * Created by Vanya Mihova on 21.01.2018
 */

public class TaskRepositoryImpl implements TaskRepository {

    private static TaskRepository sInstance = new TaskRepositoryImpl();

    public static TaskRepository getInstance() {
        return sInstance;
    }

    private TaskDao taskDao;

    private TaskRepositoryImpl() {
        this.taskDao = AppDatabaseManager.get().taskDao();
    }

    @Override
    public void createTask(Task task) {
        //
    }

    @Override
    public void getTasks(UseCase.Callback<List<Task>> callback) {
        TaskEntityMapper mapper = new TaskEntityMapper();
        ThreadPoolExecutor.getInstance().forBackgroundTasks()
                .execute(() -> {
                    List<TaskEntity> entities = taskDao.loadAll();
                    callback.onSuccess(mapper.transform(entities));
                });
    }

    @Override
    public Task getTaskById(int id) {
        return null;
    }

}
