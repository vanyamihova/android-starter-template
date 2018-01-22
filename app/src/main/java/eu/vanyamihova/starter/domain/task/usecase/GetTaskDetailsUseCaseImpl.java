package eu.vanyamihova.starter.domain.task.usecase;

import eu.vanyamihova.starter.domain.task.Task;
import eu.vanyamihova.starter.domain.task.TaskRepository;

/**
 * Created by Vanya Mihova on 12.01.2018
 */

public class GetTaskDetailsUseCaseImpl implements GetTaskDetailsUseCase {

    private TaskRepository taskRepository;

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
