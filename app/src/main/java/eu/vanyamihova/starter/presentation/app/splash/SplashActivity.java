package eu.vanyamihova.starter.presentation.app.splash;

import javax.inject.Inject;

import eu.vanyamihova.starter.R;
import eu.vanyamihova.starter.presentation.base.BaseActivity;

/**
 * Created by Vanya Mihova on 19.01.2018
 */

public final class SplashActivity extends BaseActivity implements SplashContract.View {

    @Inject
    SplashContract.Presenter splashPresenter;

    @Override
    public int injectLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreateView() {
        splashPresenter.load()
                .observe(this, o -> finishLoading());
    }

    @Override
    public void finishLoading() {
        navigator.navigateToMainView(this);
    }

}
