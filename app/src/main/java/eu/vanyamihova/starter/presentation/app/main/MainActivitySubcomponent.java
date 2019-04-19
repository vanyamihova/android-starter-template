package eu.vanyamihova.starter.presentation.app.main;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
@MainActivityScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {
    }

}
