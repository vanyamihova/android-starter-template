package eu.vanyamihova.starter.domain.usecase.sync;

import eu.vanyamihova.starter.data.net.task.GetTasksResponse;
import io.reactivex.Observable;

/**
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 19.04.2019
 */
public interface SyncUseCase {
    Observable<GetTasksResponse> sync();
}
