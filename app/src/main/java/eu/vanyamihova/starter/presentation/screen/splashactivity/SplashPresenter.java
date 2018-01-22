package eu.vanyamihova.starter.presentation.screen.splashactivity;

import eu.vanyamihova.starter.data.net.sync.SyncRepositoryImpl;
import eu.vanyamihova.starter.domain.sync.SyncRepository;

/**
 * Created by Vanya Mihova on 19.01.2018
 */

final class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;
    private SyncRepository syncRepository;

    SplashPresenter(SplashContract.View view) {
        this.mView = view;
        this.syncRepository = SyncRepositoryImpl.getInstance();
        this.load();
    }

    @Override
    public void load() {
        this.syncRepository.getTasks(() -> mView.finishLoading());
    }
}
