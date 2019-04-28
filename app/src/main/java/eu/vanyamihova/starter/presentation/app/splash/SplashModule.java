package eu.vanyamihova.starter.presentation.app.splash;

import dagger.Binds;
import dagger.Module;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 18.04.2019
 */
@Module
public abstract class SplashModule {

    @SplashActivityScope
    @Binds
    abstract SplashContract.Presenter bindSplashContractPresenter(SplashPresenter splashPresenter);

    @SplashActivityScope
    @Binds
    abstract SplashContract.Model bindSplashContractModel(SplashModel splashModel);

}
