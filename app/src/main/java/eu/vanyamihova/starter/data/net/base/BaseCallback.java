package eu.vanyamihova.starter.data.net.base;

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
        onResponse(response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        //
    }

    public abstract void onResponse(Response<T> response);

}
