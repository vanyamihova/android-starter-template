package eu.vanyamihova.starter.data.repository;

import javax.inject.Inject;

import eu.vanyamihova.starter.data.exception.NetworkConnectionException;
import eu.vanyamihova.starter.data.net.QueryExecutor;
import eu.vanyamihova.starter.data.net.task.GetTasksQuery;
import eu.vanyamihova.starter.domain.sync.SyncRepository;

/**
 * Call the queries from the cloud database to save all needed data to the local database.
 * <p>
 * Created by Vanya Mihova on 21.01.2018
 */

public final class SyncRepositoryImpl implements SyncRepository {

    private QueryExecutor queryExecutor;

    @Inject
    public SyncRepositoryImpl(QueryExecutor queryExecutor) {
        this.queryExecutor = queryExecutor;
    }

    @Override
    public void getTasks(CompleteListener listener) {
        try {
            GetTasksQuery query = new GetTasksQuery(listener::onComplete);
            queryExecutor.execute(query);
        } catch (NetworkConnectionException networkException) {
            listener.onComplete();
        }
    }

}
