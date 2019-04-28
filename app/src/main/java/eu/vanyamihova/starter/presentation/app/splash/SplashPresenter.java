package eu.vanyamihova.starter.presentation.app.splash;

import javax.inject.Inject;

/**
 * Created by Vanya Mihova on 19.01.2018
 */

public final class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View view;
    private SplashContract.Model model;

    @Inject
    public SplashPresenter(SplashContract.Model model) {
        this.model = model;
    }

    @Override
    public void delegateView(SplashContract.View view) {
        this.view = view;
    }

    @Override
    public void loadData() {
        if (view == null) {
            return;
        }
        model.fetchData()
                .observe(view.getLifecycleOwner(), o -> view.openApplicationContent());
    }

    @Override
    public void destroy() {
        model.clear();
    }
}
