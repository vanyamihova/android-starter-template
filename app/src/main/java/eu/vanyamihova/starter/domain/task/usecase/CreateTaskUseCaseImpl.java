package eu.vanyamihova.starter.domain.task.usecase;

import eu.vanyamihova.starter.domain.base.exception.InvalidTaskException;
import eu.vanyamihova.starter.domain.task.Task;
import eu.vanyamihova.starter.domain.task.TaskRepository;
import eu.vanyamihova.starter.domain.task.TaskValidator;

/**
 * Created by Vanya Mihova on 18.01.2018
 */

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private TaskValidator taskValidator;
    private TaskRepository taskRepository;

    public CreateTaskUseCaseImpl() {
        this.taskValidator = new TaskValidator();
    }

    @Override
    public void execute(Task task, Callback callback) {
        if (taskValidator.isValid(task)) {
            this.onValidTask(task, callback);
        } else {
            callback.onError(new InvalidTaskException());
        }
    }

    private void onValidTask(Task task, Callback callback) {
        try {
            taskRepository.createTask(task);
            callback.onSuccess();
        } catch (final Throwable throwable) {
            callback.onError(throwable);
        }
    }

}
