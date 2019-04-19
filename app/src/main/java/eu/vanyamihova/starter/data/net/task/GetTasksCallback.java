package eu.vanyamihova.starter.data.net.task;

import java.util.List;

import eu.vanyamihova.starter.data.net.base.BaseCallback;
import retrofit2.Response;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 18.04.2019
 */
public class GetTasksCallback extends BaseCallback<List<GetTasksDTO>> {

    private GetTasksListener listener;

    public GetTasksCallback(GetTasksListener listener) {
        this.listener = listener;
    }

    @Override
    public void onResponse(Response<List<GetTasksDTO>> response) {
        // Saving response into database
        GetTasksSaveRunnable runnable = new GetTasksSaveRunnable(response.body());
        runnable.run();

        listener.onComplete();
    }

}
