package eu.vanyamihova.starter.presentation.screen.splashactivity;

import javax.inject.Inject;

import eu.vanyamihova.starter.application.AndroidApplication;
import eu.vanyamihova.starter.domain.sync.SyncRepository;

/**
 * Created by Vanya Mihova on 19.01.2018
 */

public final class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;
    @Inject
    SyncRepository syncRepository;

    SplashPresenter(SplashContract.View view) {
        AndroidApplication.inject(this);
        this.mView = view;
        this.load();
    }

    @Override
    public void load() {
        this.syncRepository.getTasks(() -> mView.finishLoading());
    }
}
