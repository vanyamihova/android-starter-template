package eu.vanyamihova.starter.presentation.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import eu.vanyamihova.starter.presentation.common.loadingview.LoadingViewDelegate;

/**
 * Parent of all fragments which are not shown with FragmentManager
 * Created by  Vanya Mihova on 28.01.17.
 */
public abstract class BaseFragment extends Fragment implements LoadingViewDelegate {


    protected BaseActivity mBaseActivity;

    protected View view;

    protected BaseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Build the view from the container
        this.buildView(container);

        // Call some specific logic for the child-fragment
        onCreateView();
        //Return the view
        return view;
    }

    protected void buildView(ViewGroup container) {
        if (view != null) {
            // If view is not empty, remove it from the parent
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }

        view = LayoutInflater
                .from(container.getContext())
                .inflate(layoutId(), container, false);
        ButterKnife.bind(this, view);

        // Register bus
//        bus.register(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {}

    public abstract int layoutId();

    public abstract void onCreateView();

//    public void showMessage(Object message) {
//        this.mBaseActivity.showMessage(message);
//    }

    @Override
    public void showLoading() {
        if (this.mBaseActivity != null) {
            this.mBaseActivity.showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (this.mBaseActivity != null) {
            this.mBaseActivity.hideLoading();
        }
    }

}
