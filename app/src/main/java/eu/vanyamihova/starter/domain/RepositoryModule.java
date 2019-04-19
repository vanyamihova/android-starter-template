package eu.vanyamihova.starter.domain;

import dagger.Binds;
import dagger.Module;
import eu.vanyamihova.starter.data.repository.SyncRepositoryImpl;
import eu.vanyamihova.starter.data.repository.TaskRepositoryImpl;
import eu.vanyamihova.starter.domain.sync.SyncRepository;
import eu.vanyamihova.starter.domain.task.TaskRepository;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
@Module
public abstract class RepositoryModule {

    @Binds
    abstract SyncRepository provideSyncRepository(SyncRepositoryImpl syncRepository);

    @Binds
    abstract TaskRepository provideTaskRepository(TaskRepositoryImpl taskRepository);

}
