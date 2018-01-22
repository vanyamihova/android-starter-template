package eu.vanyamihova.starter.domain.task;

import java.util.List;

import eu.vanyamihova.starter.domain.base.interactor.UseCase;

/**
 * Interface that represents a Repository for getting {@link Task} related data.
 *
 * Created by Vanya Mihova on 12.01.2018
 */
public interface TaskRepository {

    void createTask(Task task);

    /**
     * Pass a {@link UseCase.Callback} which will emit a List of {@link Task}.
     */
    void getTasks(UseCase.Callback<List<Task>> callback);

    /**
     * Pass an `id`  which will return a {@link Task}.
     *
     * @param id The task id used to retrieve task data.
     */
    Task getTaskById(final int id);

}
