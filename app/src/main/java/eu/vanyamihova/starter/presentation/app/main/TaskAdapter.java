package eu.vanyamihova.starter.presentation.app.main;

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import eu.vanyamihova.starter.R;
import eu.vanyamihova.starter.presentation.base.BaseRecyclerViewAdapter;
import eu.vanyamihova.starter.presentation.base.BaseViewHolder;
import eu.vanyamihova.starter.presentation.model.task.TaskViewModel;

/**
 * Created by Vanya Mihova on 21.01.2018
 */

final class TaskAdapter extends BaseRecyclerViewAdapter<TaskViewModel, TaskAdapter.TaskViewHolder> {

    TaskAdapter() {
        super(new ArrayList<>());
    }

    @Override
    public int layoutId() {
        return R.layout.adapter_item_task_view;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(View view) {
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, TaskViewModel item) {
        holder.taskTitleView.setText(item.getTitle());
        holder.taskCompletedView.setText(item.getCompleted());
    }

    /**
     * Task View Holder Class
     */
    protected final class TaskViewHolder extends BaseViewHolder {

        @BindView(R.id.task_title) TextView taskTitleView;
        @BindView(R.id.task_completed) TextView taskCompletedView;

        public TaskViewHolder(View itemView) {
            super(itemView);
        }

    }

}
