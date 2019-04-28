package eu.vanyamihova.starter.data.net.task;

import eu.vanyamihova.starter.data.net.base.BaseQuery;
import eu.vanyamihova.starter.data.net.base.Schedulable;
import eu.vanyamihova.starter.devtool.DebugManager;
import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Get all tasks from the cloud server. Save the response into database.
 * <p>
 * Created by Vanya Mihova on 12.01.2018
 */

public final class GetTasksQuery extends BaseQuery<GetTasksService, GetTasksResponse> implements Schedulable {

    private GetTasksSaveRunnable runnable;

    public GetTasksQuery() {
        super("https://jsonplaceholder.typicode.com");
        this.runnable = new GetTasksSaveRunnable();
    }

    @Override
    public Class<GetTasksService> getServiceClass() {
        return GetTasksService.class;
    }

    @Override
    public Observable<GetTasksResponse> makeQueryFrom(GetTasksService service) {
        return Observable.create(emitter -> {
            Response<GetTasksResponse> response = service.getTasks().execute();
            DebugManager.log("Received response");
            runnable.run(response.body());

            DebugManager.log("Emitter completed");
            emitter.onNext(response.body());
        });
    }

}
