package eu.vanyamihova.starter.presentation.app.splash;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import javax.inject.Inject;

import eu.vanyamihova.starter.domain.usecase.sync.SyncUseCase;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 27.04.2019
 */
public final class SplashModel implements SplashContract.Model {

    private SyncUseCase syncUseCase;
    private MutableLiveData<Object> livaData;
    private CompositeDisposable compositeDisposable;

    @Inject
    public SplashModel(SyncUseCase syncUseCase) {
        this.syncUseCase = syncUseCase;
        this.livaData = new MutableLiveData<>();
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public LiveData<Object> fetchData() {
        Disposable disposable = syncUseCase.sync()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> livaData.postValue(true));

        compositeDisposable.add(disposable);
        return livaData;
    }

    @Override
    public void clear() {
        compositeDisposable.clear();
    }
}
