package eu.vanyamihova.starter.presentation.screen.mainactivity;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import eu.vanyamihova.starter.R;
import eu.vanyamihova.starter.devtool.DebugManager;
import eu.vanyamihova.starter.presentation.base.BaseActivity;
import eu.vanyamihova.starter.presentation.model.task.TaskViewModel;

public class MainActivity extends BaseActivity implements MainContract.View {

    private TaskAdapter mAdapter;

    @BindView(R.id.recycler_view) RecyclerView recyclerView;

    @Override
    public int injectLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new TaskAdapter();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        new MainPresenter(this).getTasks().observe(this, taskViewModels -> {
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
