package eu.vanyamihova.starter.domain.task.usecase;

import eu.vanyamihova.starter.domain.task.Task;

/**
 * Created by Vanya Mihova on 12.01.2018
 */

public final class GetTaskDetailsUseCaseImpl extends BaseTaskUseCase implements GetTaskDetailsUseCase {

    private static GetTaskDetailsUseCase sInstance = new GetTaskDetailsUseCaseImpl();

    public static GetTaskDetailsUseCase getInstance() {
        return sInstance;
    }

    @Override
    public void execute(Integer taskId, Callback<Task> callback) {
        try {
            Task task = taskRepository.getTaskById(taskId);
            callback.onSuccess(task);
        } catch (Throwable throwable) {
            callback.onError(throwable);
        }
    }

}
