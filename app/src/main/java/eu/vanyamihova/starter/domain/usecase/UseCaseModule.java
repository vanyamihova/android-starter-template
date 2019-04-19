package eu.vanyamihova.starter.domain.usecase;

import dagger.Binds;
import dagger.Module;
import eu.vanyamihova.starter.domain.task.usecase.GetTasksUseCase;
import eu.vanyamihova.starter.domain.task.usecase.GetTasksUseCaseImpl;
import eu.vanyamihova.starter.domain.usecase.sync.SyncUseCase;
import eu.vanyamihova.starter.domain.usecase.sync.SyncUseCaseImpl;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
@Module
public abstract class UseCaseModule {

    @Binds
    abstract SyncUseCase bindSyncUseCase(SyncUseCaseImpl syncRepository);

    @Binds
    abstract GetTasksUseCase bindGetTasksUseCase(GetTasksUseCaseImpl getTasksUseCase);

}
