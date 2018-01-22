package eu.vanyamihova.starter.data.net.task;

import eu.vanyamihova.starter.data.net.base.BaseQueryCompleteListener;

/**
 * Listener used in response from `GetTasksQuery`.
 * If the query has some specific errors, they must be extended here.
 *
 * Created by Vanya Mihova on 12.01.2018
 */

public interface GetTasksListener extends BaseQueryCompleteListener {
}
