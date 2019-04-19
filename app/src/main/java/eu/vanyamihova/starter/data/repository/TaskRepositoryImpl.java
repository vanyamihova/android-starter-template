package eu.vanyamihova.starter.data.repository;

import java.util.List;

import javax.inject.Inject;

import eu.vanyamihova.starter.data.datastore.AppDatabaseManager;
import eu.vanyamihova.starter.data.datastore.task.TaskDao;
import eu.vanyamihova.starter.data.datastore.task.TaskEntity;
import eu.vanyamihova.starter.data.datastore.task.TaskEntityMapper;
import eu.vanyamihova.starter.data.executor.ThreadPoolExecutor;
import eu.vanyamihova.starter.domain.base.interactor.UseCase;
import eu.vanyamihova.starter.domain.task.Task;
import eu.vanyamihova.starter.domain.task.TaskRepository;

/**
 * Implementation of the repository which is positioned in the `domain` layer.
 * Task Repository is used to fetch/manage data from the database using background threads.
 * <p>
 * All of the queries MUST be proceed on background thread!
 * <p>
 * Created by Vanya Mihova on 21.01.2018
 */
public class TaskRepositoryImpl implements TaskRepository {

    private TaskDao taskDao;

    @Inject
    public TaskRepositoryImpl() {
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
