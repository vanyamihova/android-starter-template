package eu.vanyamihova.starter.presentation.screen.mainactivity;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import eu.vanyamihova.starter.domain.base.interactor.UseCase;
import eu.vanyamihova.starter.domain.task.Task;
import eu.vanyamihova.starter.domain.task.usecase.GetTasksUseCase;
import eu.vanyamihova.starter.domain.task.usecase.GetTasksUseCaseImpl;
import eu.vanyamihova.starter.presentation.model.task.TaskViewMapper;
import eu.vanyamihova.starter.presentation.model.task.TaskViewModel;

/**
 * Created by Vanya Mihova on 18.01.2018
 */

final class MainPresenter implements MainContract.Presenter, UseCase.Callback<List<Task>> {

    private MutableLiveData<List<TaskViewModel>> mLiveData;
    private MainContract.View mView;
    private GetTasksUseCase getTasksUseCase = GetTasksUseCaseImpl.getInstance();

    MainPresenter(MainContract.View view) {
        this.mView = view;
        this.mLiveData = new MutableLiveData<>();
    }

    @Override
    public LiveData<List<TaskViewModel>> getTasks() {
        this.mView.showLoadingIndicator();
        this.getTasksUseCase.execute(null, this);
        return mLiveData;
    }

    @Override
    public void onSuccess(List<Task> result) {
        if (result == null) {
            result = new ArrayList<>();
        }

        List<TaskViewModel> viewModels = new ArrayList<>();
        TaskViewMapper mapper = new TaskViewMapper();

        for (Task task : result) {
            viewModels.add(mapper.transform(task));
        }
        this.mLiveData.postValue(viewModels);
    }

    @Override
    public void onError(Throwable throwable) {
        this.mView.showErrorMessage(throwable.getMessage());
        this.mView.hideLoadingIndicator();
    }

}
