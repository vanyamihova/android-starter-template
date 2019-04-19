package eu.vanyamihova.starter.presentation.app.main;

import dagger.Binds;
import dagger.Module;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
@Module
public abstract class MainActivityModule {

    @MainActivityScope
    @Binds
    abstract MainContract.Presenter provideMainContractPresenter(MainPresenter mainPresenter);


}
