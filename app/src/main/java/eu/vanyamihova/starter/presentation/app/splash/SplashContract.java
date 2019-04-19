package eu.vanyamihova.starter.presentation.app.splash;

import androidx.lifecycle.LiveData;

/**
 * Created by Vanya Mihova on 19.01.2018
 */
public interface SplashContract {

    interface View {
        void finishLoading();
    }

    interface Presenter {
        LiveData<Object> load();
    }

}
