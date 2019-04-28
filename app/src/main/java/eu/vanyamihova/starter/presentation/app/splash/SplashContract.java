package eu.vanyamihova.starter.presentation.app.splash;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;

/**
 * Created by Vanya Mihova on 19.01.2018
 */
public interface SplashContract {

    interface View {
        void openApplicationContent();

        LifecycleOwner getLifecycleOwner();
    }

    interface Presenter {
        void delegateView(View view);

        void loadData();

        void destroy();
    }

    interface Model {
        LiveData<Object> fetchData();

        void clear();
    }

}
