package eu.vanyamihova.starter.presentation.screen.splashactivity;

/**
 * Created by Vanya Mihova on 19.01.2018
 */

public interface SplashContract {

    interface View {
        void finishLoading();
    }

    interface Presenter {
        void load();
    }

}
