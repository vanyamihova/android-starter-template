package eu.vanyamihova.starter.data.net.base;

import eu.vanyamihova.starter.data.executor.ThreadPoolExecutor;
import eu.vanyamihova.starter.data.executor.priority.Priority;
import eu.vanyamihova.starter.data.executor.priority.PriorityRunnable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Hide the Callback from the queries and returns only response reference
 * <p>
 * Created by Vanya Mihova on 19.01.2018
 */

public abstract class BaseCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        ThreadPoolExecutor.getInstance().forBackgroundTasks()
                .execute(new PriorityRunnable(Priority.HIGH) {
                    @Override
                    public void run() {
                        onResponse(response);
                    }
                });
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        //
    }

    public abstract void onResponse(Response<T> response);

}
