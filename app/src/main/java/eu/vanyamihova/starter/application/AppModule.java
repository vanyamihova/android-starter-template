package eu.vanyamihova.starter.application;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import eu.vanyamihova.starter.data.DataComponent;
import eu.vanyamihova.starter.domain.DomainComponent;
import eu.vanyamihova.starter.presentation.PresentationComponent;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 18.04.2019
 */
@Module(subcomponents = {DomainComponent.class, DataComponent.class, PresentationComponent.class})
public final class AppModule {

    @Provides
    public static Context provideContext(Application application) {
        return application.getApplicationContext();
    }

}
