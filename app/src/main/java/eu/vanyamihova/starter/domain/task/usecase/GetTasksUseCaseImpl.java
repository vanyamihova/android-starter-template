package eu.vanyamihova.starter.domain.task.usecase;

import java.util.List;

import eu.vanyamihova.starter.domain.task.Task;

/**
 * Created by Vanya Mihova on 12.01.2018
 */

public final class GetTasksUseCaseImpl extends BaseTaskUseCase implements GetTasksUseCase {

    private static GetTasksUseCase sInstance = new GetTasksUseCaseImpl();

    public static GetTasksUseCase getInstance() {
        return sInstance;
    }

    @Override
    public void execute(Void parameter, Callback<List<Task>> callback) {
        taskRepository.getTasks(callback);
    }
}
