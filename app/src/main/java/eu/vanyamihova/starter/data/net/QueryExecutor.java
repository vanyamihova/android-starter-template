package eu.vanyamihova.starter.data.net;

import javax.inject.Inject;

import eu.vanyamihova.starter.data.exception.NetworkConnectionException;
import eu.vanyamihova.starter.data.net.base.BaseQuery;
import io.reactivex.Observable;

/**
 * Executor that checks for available network connection,
 * if there is none - throws exception and it doesn't trigger the query.
 *
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 18.04.2019
 */
public class QueryExecutor {

    private NetworkUtils networkUtils;
    private RetrofitBuilder retrofitBuilder;

    @Inject
    public QueryExecutor(NetworkUtils networkUtils) {
        this.networkUtils = networkUtils;

    }

    /**
     * Check for the network connection and if there is no, throw {@link NetworkConnectionException}
     */
    public <S, R> Observable<R> execute(BaseQuery<S, R> query) throws NetworkConnectionException {
        // Check the internet connection
        if (!networkUtils.isConnected()) {
            throw new NetworkConnectionException();
        }

        Class<S> clazz = query.getServiceClass();

        this.retrofitBuilder = new RetrofitBuilder();
        S service = retrofitBuilder
                .build(query.getUrl())
                .create(clazz);

        return query.makeQueryFrom(service);
    }

}
