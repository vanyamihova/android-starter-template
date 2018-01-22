package eu.vanyamihova.starter.data.net.task;

import java.util.List;

import eu.vanyamihova.starter.data.exception.NetworkConnectionException;
import eu.vanyamihova.starter.data.net.base.BaseCallback;
import eu.vanyamihova.starter.data.net.base.BaseQuery;
import eu.vanyamihova.starter.data.net.base.Schedulable;
import retrofit2.Response;

/**
 * Get all tasks from the cloud server. Save the response into database.
 *
 * Created by Vanya Mihova on 12.01.2018
 */

public final class GetTasksQuery extends BaseQuery<GetTasksService, GetTasksListener> implements Schedulable {

    public static void execute(GetTasksListener listener) {
        try {
            GetTasksQuery getTasksQuery = new GetTasksQuery(listener);
            getTasksQuery.sync();
        } catch (NetworkConnectionException networkException) {
            // TODO: do something
        }
    }


    private GetTasksQuery(GetTasksListener listener) {
        super("https://jsonplaceholder.typicode.com", listener);
    }

    @Override
    protected Class getServiceClass() {
        return GetTasksService.class;
    }

    @Override
    protected void makeQueryFrom(GetTasksService service) {
        service.getTasks().enqueue(new BaseCallback<List<GetTasksTO>>() {
            @Override
            public void onResponse(Response<List<GetTasksTO>> response) {
                // Saving response into database
                save(new GetTasksSaveRunnable(response.body()));
                // Send event for completing
                mListener.onComplete();
            }
        });
    }

}
