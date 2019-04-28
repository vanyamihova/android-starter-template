package eu.vanyamihova.starter.presentation.app.splash;

import androidx.lifecycle.LifecycleOwner;

import javax.inject.Inject;

import eu.vanyamihova.starter.R;
import eu.vanyamihova.starter.presentation.base.BaseActivity;

/**
 * Created by Vanya Mihova on 19.01.2018
 */

public final class SplashActivity extends BaseActivity implements SplashContract.View {

    @Inject
    SplashContract.Presenter presenter;

    @Override
    public int injectLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreateView() {
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.delegateView(this);
        presenter.loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    @Override
    public LifecycleOwner getLifecycleOwner() {
        return this;
    }

    @Override
    public void openApplicationContent() {
        navigator.navigateToMainView(this);
    }

}
