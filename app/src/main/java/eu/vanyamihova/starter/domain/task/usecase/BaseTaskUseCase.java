package eu.vanyamihova.starter.domain.task.usecase;

import javax.inject.Inject;

import eu.vanyamihova.starter.AndroidApplication;
import eu.vanyamihova.starter.domain.task.TaskRepository;

/**
 * Created by Vanya Mihova on 23.01.2018
 */

public abstract class BaseTaskUseCase {

    @Inject
    protected TaskRepository taskRepository;

    BaseTaskUseCase() {
        AndroidApplication.inject(this);
    }

}
