package eu.vanyamihova.starter.presentation.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import eu.vanyamihova.starter.R;
import eu.vanyamihova.starter.presentation.common.loadingview.LoadingView;
import eu.vanyamihova.starter.presentation.common.loadingview.LoadingViewDelegate;
import eu.vanyamihova.starter.presentation.common.loadingview.LoadingViewFactory;
import eu.vanyamihova.starter.presentation.navigator.Navigator;
import eu.vanyamihova.starter.presentation.navigator.NavigatorImpl;

/**
 * Parent of all activities
 * <p>
 * Created by  Vanya Mihova on 21.01.17
 */
public abstract class BaseActivity extends AppCompatActivity implements LoadingViewDelegate {

    protected Navigator navigator = NavigatorImpl.getInstance();
    private LoadingView loadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        pendingTransition();
        // set content view
        setContentView(injectLayout());
        // set Butter Knife
        ButterKnife.bind(this);
        // Build loading view on every new activity
        this.loadingView = LoadingViewFactory.build(this);
        onCreateView();
    }

    protected abstract void onCreateView();

    private void pendingTransition() {
        if (haveAnimationOnTransition()) {
            overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out);
            return;
        }
        this.overridePendingTransition(0, 0);
    }

    public abstract int injectLayout();

    /**
     * This method could be overriden in the children of the class. It defends if there is some
     * animation when the activities have changed.
     *
     * @return true by default
     */
    protected boolean haveAnimationOnTransition() {
        return true;
    }

    /**
     * From LoadingViewDelegate - show the loading view
     */
    @Override
    public void showLoading() {
        loadingView.showLoading();
    }

    /**
     * From LoadingViewDelegate - hide the loading view
     */
    @Override
    public void hideLoading() {
        loadingView.hideLoading();
    }

}
