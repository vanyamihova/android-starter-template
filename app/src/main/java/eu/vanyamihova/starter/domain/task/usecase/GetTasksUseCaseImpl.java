package eu.vanyamihova.starter.domain.task.usecase;

import java.util.List;

import javax.inject.Inject;

import eu.vanyamihova.starter.domain.task.Task;
import eu.vanyamihova.starter.domain.task.TaskRepository;

/**
 * Created by Vanya Mihova on 12.01.2018
 */

public final class GetTasksUseCaseImpl implements GetTasksUseCase {

    private TaskRepository taskRepository;

    @Inject
    public GetTasksUseCaseImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void execute(Void parameter, Callback<List<Task>> callback) {
        taskRepository.getTasks(callback);
    }
}
