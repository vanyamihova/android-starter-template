package eu.vanyamihova.starter.data.net.sync;

import eu.vanyamihova.starter.data.net.task.GetTasksQuery;
import eu.vanyamihova.starter.domain.sync.SyncRepository;

/**
 * Call the queries from the cloud database to save all needed data to the local database.
 *
 * Created by Vanya Mihova on 21.01.2018
 */

public final class SyncRepositoryImpl implements SyncRepository {

    private static SyncRepository sInstance = new SyncRepositoryImpl();

    public static SyncRepository getInstance() {
        return sInstance;
    }

    @Override
    public void getTasks(CompleteListener listener) {
        GetTasksQuery.execute(listener::onComplete);
    }

}
