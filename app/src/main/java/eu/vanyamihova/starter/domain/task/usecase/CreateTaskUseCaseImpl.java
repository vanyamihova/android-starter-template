package eu.vanyamihova.starter.domain.task.usecase;

import eu.vanyamihova.starter.domain.base.exception.InvalidTaskException;
import eu.vanyamihova.starter.domain.task.Task;
import eu.vanyamihova.starter.domain.task.TaskValidator;

/**
 * Created by Vanya Mihova on 18.01.2018
 */

public final class CreateTaskUseCaseImpl extends BaseTaskUseCase implements CreateTaskUseCase {

    private static CreateTaskUseCase sInstance = new CreateTaskUseCaseImpl();

    public static CreateTaskUseCase getInstance() {
        return sInstance;
    }

    private TaskValidator taskValidator;

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
