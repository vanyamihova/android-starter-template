package eu.vanyamihova.starter.domain.sync;

import eu.vanyamihova.starter.data.net.task.GetTasksResponse;
import io.reactivex.Observable;

/**
 * Interface that represents a Repository for getting different data from REST APIs.
 * <p>
 * Created by Vanya Mihova on 21.01.2018
 */

public interface SyncRepository {

    Observable<GetTasksResponse> getTasks();

}
