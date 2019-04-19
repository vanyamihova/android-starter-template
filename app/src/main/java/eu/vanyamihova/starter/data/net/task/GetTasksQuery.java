package eu.vanyamihova.starter.data.net.task;

import eu.vanyamihova.starter.data.net.base.BaseQuery;
import eu.vanyamihova.starter.data.net.base.Schedulable;

/**
 * Get all tasks from the cloud server. Save the response into database.
 * <p>
 * Created by Vanya Mihova on 12.01.2018
 */

public final class GetTasksQuery extends BaseQuery<GetTasksService, GetTasksListener> implements Schedulable {

    public GetTasksQuery(GetTasksListener listener) {
        super("https://jsonplaceholder.typicode.com", listener);
    }

    @Override
    public Class<GetTasksService> getServiceClass() {
        return GetTasksService.class;
    }

    @Override
    public void makeQueryFrom(GetTasksService service) {
        GetTasksCallback callback = new GetTasksCallback(mListener);
        service.getTasks().enqueue(callback);
    }

}
