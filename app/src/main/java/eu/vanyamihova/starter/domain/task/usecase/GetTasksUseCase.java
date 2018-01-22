package eu.vanyamihova.starter.domain.task.usecase;

import java.util.List;

import eu.vanyamihova.starter.domain.base.interactor.UseCase;
import eu.vanyamihova.starter.domain.task.Task;

/**
 * Created by Vanya Mihova on 21.01.2018
 */

public interface GetTasksUseCase extends UseCase<Void, List<Task>> {
}
