package eu.vanyamihova.starter.domain.task.usecase;

import java.util.List;

import eu.vanyamihova.starter.data.datastore.task.TaskRepositoryImpl;
import eu.vanyamihova.starter.domain.task.Task;
import eu.vanyamihova.starter.domain.task.TaskRepository;

/**
 * Created by Vanya Mihova on 12.01.2018
 */

public class GetTasksUseCaseImpl implements GetTasksUseCase {

    private static GetTasksUseCase sInstance = new GetTasksUseCaseImpl();

    public static GetTasksUseCase getInstance() {
        return sInstance;
    }

    private TaskRepository mTaskRepository;

//    @Inject
    GetTasksUseCaseImpl() {
        this.mTaskRepository = TaskRepositoryImpl.getInstance();
    }

    @Override
    public void execute(Void parameter, Callback<List<Task>> callback) {
        mTaskRepository.getTasks(callback);
    }
}
