package eu.vanyamihova.starter.domain.sync;

/**
 * Interface that represents a Repository for getting different data from REST APIs.
 *
 * Created by Vanya Mihova on 21.01.2018
 */

public interface SyncRepository {

    /**
     * Pass a {@link CompleteListener} which will process the result onComplete()
     */
    void getTasks(CompleteListener listener);

    interface CompleteListener {
        void onComplete();
    }

}
