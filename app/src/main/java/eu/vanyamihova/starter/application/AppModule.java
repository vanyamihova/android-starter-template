package eu.vanyamihova.starter.application;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import eu.vanyamihova.starter.data.DataModule;
import eu.vanyamihova.starter.domain.DomainModule;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 18.04.2019
 */
@Module(includes = {DomainModule.class, DataModule.class})
public final class AppModule {

    @Provides
    public static Context provideContext(Application application) {
        return application.getApplicationContext();
    }

}
