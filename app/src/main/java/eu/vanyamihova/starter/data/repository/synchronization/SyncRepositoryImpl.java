package eu.vanyamihova.starter.data.repository.synchronization;

import javax.inject.Inject;

import eu.vanyamihova.starter.data.exception.NetworkConnectionException;
import eu.vanyamihova.starter.data.net.QueryExecutor;
import eu.vanyamihova.starter.data.net.task.GetTasksQuery;
import eu.vanyamihova.starter.data.net.task.GetTasksResponse;
import eu.vanyamihova.starter.devtool.DebugManager;
import eu.vanyamihova.starter.domain.sync.SyncRepository;
import io.reactivex.Observable;

/**
 * Call the queries from the cloud database to save all needed data to the local database.
 * <p>
 * Created by Vanya Mihova on 21.01.2018
 */

public final class SyncRepositoryImpl implements SyncRepository {

    private QueryExecutor queryExecutor;
    private GetTasksQuery getTasksQuery;

    @Inject
    public SyncRepositoryImpl(QueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
        this.getTasksQuery = new GetTasksQuery();
    }

    @Override
    public Observable<GetTasksResponse> getTasks() {
        DebugManager.log("Start syncing tasks");
        try {
            return queryExecutor.execute(getTasksQuery);
        } catch (NetworkConnectionException networkException) {
            DebugManager.log("Returns empty observable: No Internet connection");
            return Observable.empty();
        }
    }

}
