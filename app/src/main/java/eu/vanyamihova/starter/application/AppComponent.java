package eu.vanyamihova.starter.application;

import android.app.Application;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import eu.vanyamihova.starter.domain.RepositoryModule;
import eu.vanyamihova.starter.domain.usecase.UseCaseModule;
import eu.vanyamihova.starter.presentation.app.ActivityBuilderModule;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 18.04.2019
 */
@Component(modules = {AppModule.class, AndroidInjectionModule.class, ActivityBuilderModule.class, RepositoryModule.class, UseCaseModule.class})
public interface AppComponent {

    void inject(AndroidApplication androidApplication);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

    }

}
