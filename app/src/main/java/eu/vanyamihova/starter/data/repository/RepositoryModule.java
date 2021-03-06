package eu.vanyamihova.starter.data.repository;

import dagger.Binds;
import dagger.Module;
import eu.vanyamihova.starter.data.repository.synchronization.SyncRepositoryImpl;
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
