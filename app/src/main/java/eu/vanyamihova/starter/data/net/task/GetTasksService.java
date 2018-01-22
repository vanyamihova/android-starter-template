package eu.vanyamihova.starter.data.net.task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vanya Mihova on 12.01.2018
 */

public interface GetTasksService {
    @GET("todos")
    Call<List<GetTasksTO>> getTasks();
}
