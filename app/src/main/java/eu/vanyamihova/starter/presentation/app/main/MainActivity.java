package eu.vanyamihova.starter.presentation.app.main;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import eu.vanyamihova.starter.R;
import eu.vanyamihova.starter.devtool.DebugManager;
import eu.vanyamihova.starter.presentation.base.BaseActivity;
import eu.vanyamihova.starter.presentation.model.task.TaskViewModel;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainContract.Presenter mainPresenter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private TaskAdapter mAdapter;

    @Override
    public int injectLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreateView() {
        mAdapter = new TaskAdapter();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        mainPresenter.delegateView(this);
        mainPresenter.getTasks().observe(this, taskViewModels -> {
            showTasks(taskViewModels);
            hideLoadingIndicator();
        });
    }

    @Override
    public void showTasks(List<TaskViewModel> taskViewModels) {
        mAdapter.setNewList(taskViewModels);
    }

    @Override
    public void showErrorMessage(String message) {
        DebugManager.log(message);
    }

    @Override
    public void showLoadingIndicator() {
        // Show loading
        DebugManager.log("Start loading");
    }

    @Override
    public void hideLoadingIndicator() {
        // Hide loading
        DebugManager.log("Hide loading");
    }
}
