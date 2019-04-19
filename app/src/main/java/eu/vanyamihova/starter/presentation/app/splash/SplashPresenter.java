package eu.vanyamihova.starter.presentation.app.splash;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import eu.vanyamihova.starter.domain.usecase.sync.SyncUseCase;

/**
 * Created by Vanya Mihova on 19.01.2018
 */

public final class SplashPresenter implements SplashContract.Presenter {

    private SyncUseCase syncUseCase;
    private MutableLiveData<Object> livaData;

    @Inject
    SplashPresenter(SyncUseCase syncUseCase) {
        this.syncUseCase = syncUseCase;
        this.livaData = new MutableLiveData<>();
    }

    @Override
    public LiveData<Object> load() {
        syncUseCase.sync(() -> livaData.postValue(true));
        return livaData;
    }
}
