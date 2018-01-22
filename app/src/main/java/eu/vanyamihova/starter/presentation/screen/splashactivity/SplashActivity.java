package eu.vanyamihova.starter.presentation.screen.splashactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import eu.vanyamihova.starter.R;
import eu.vanyamihova.starter.presentation.base.BaseActivity;

/**
 * Created by Vanya Mihova on 19.01.2018
 */

public class SplashActivity extends BaseActivity implements SplashContract.View {

    @Override
    public int injectLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new SplashPresenter(this);
    }

    @Override
    public void finishLoading() {
        navigator.navigateToMainView(this);
    }

}
