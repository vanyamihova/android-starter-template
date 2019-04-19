package eu.vanyamihova.starter.presentation.app;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import eu.vanyamihova.starter.presentation.app.main.MainActivity;
import eu.vanyamihova.starter.presentation.app.main.MainActivitySubcomponent;
import eu.vanyamihova.starter.presentation.app.splash.SplashActivity;
import eu.vanyamihova.starter.presentation.app.splash.SplashSubcomponent;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 18.04.2019
 */
@Module(subcomponents = {SplashSubcomponent.class, MainActivitySubcomponent.class})
public abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ClassKey(SplashActivity.class)
    abstract AndroidInjector.Factory<?> bindSplashActivityInjectorFactory(SplashSubcomponent.Factory factory);

    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?> bindMainActivityInjectorFactory(MainActivitySubcomponent.Factory factory);

}
