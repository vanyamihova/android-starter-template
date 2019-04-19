package eu.vanyamihova.starter.presentation.app.splash;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 18.04.2019
 */
@SplashActivityScope
@Subcomponent(modules = {SplashModule.class})
public interface SplashSubcomponent extends AndroidInjector<SplashActivity> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SplashActivity> {
    }

}


