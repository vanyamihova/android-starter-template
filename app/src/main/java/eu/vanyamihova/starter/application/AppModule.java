package eu.vanyamihova.starter.application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import eu.vanyamihova.starter.data.datastore.task.TaskRepositoryImpl;
import eu.vanyamihova.starter.data.net.NetworkUtils;
import eu.vanyamihova.starter.data.net.base.BaseQuery;
import eu.vanyamihova.starter.data.net.sync.SyncRepositoryImpl;
import eu.vanyamihova.starter.data.net.task.GetTasksQuery;
import eu.vanyamihova.starter.domain.sync.SyncRepository;
import eu.vanyamihova.starter.domain.task.TaskRepository;
import eu.vanyamihova.starter.domain.task.usecase.BaseTaskUseCase;
import eu.vanyamihova.starter.domain.task.usecase.CreateTaskUseCaseImpl;
import eu.vanyamihova.starter.domain.task.usecase.GetTaskDetailsUseCaseImpl;
import eu.vanyamihova.starter.domain.task.usecase.GetTasksUseCase;
import eu.vanyamihova.starter.domain.task.usecase.GetTasksUseCaseImpl;
import eu.vanyamihova.starter.presentation.screen.mainactivity.MainPresenter;
import eu.vanyamihova.starter.presentation.screen.splashactivity.SplashPresenter;

/**
 * Created by Vanya Mihova on 23.01.2018
 */
@Module(injects = {
        // Queries
        BaseQuery.class, GetTasksQuery.class,
        // Use Cases
        BaseTaskUseCase.class, CreateTaskUseCaseImpl.class, GetTaskDetailsUseCaseImpl.class,
        GetTasksUseCaseImpl.class,
        // Presenters
        SplashPresenter.class, MainPresenter.class,
})
final class AppModule {

    private android.content.Context mContext;

    AppModule(android.content.Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    NetworkUtils provideNetworkUtils() {
        return new NetworkUtils(mContext);
    }

    @Provides
    @Singleton
    TaskRepository provideTaskRepository() {
        return TaskRepositoryImpl.getInstance();
    }

    @Provides
    @Singleton
    SyncRepository provideSyncRepository() {
        return SyncRepositoryImpl.getInstance();
    }

    @Provides
    @Singleton
    GetTasksUseCase provideGetTasksUseCase() {
        return GetTasksUseCaseImpl.getInstance();
    }

}
