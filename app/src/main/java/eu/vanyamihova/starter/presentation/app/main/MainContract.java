package eu.vanyamihova.starter.presentation.app.main;

import androidx.lifecycle.LiveData;

import java.util.List;

import eu.vanyamihova.starter.presentation.model.task.TaskViewModel;

/**
 * Created by Vanya Mihova on 18.01.2018
 */

public interface MainContract {

    interface View {
        void showTasks(List<TaskViewModel> taskViewModels);
        void showErrorMessage(String message);
        void showLoadingIndicator();
        void hideLoadingIndicator();
    }

    interface Presenter {
        LiveData<List<TaskViewModel>> getTasks();
        void delegateView(View view);
    }

}
