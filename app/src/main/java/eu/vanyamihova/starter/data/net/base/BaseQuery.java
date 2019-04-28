package eu.vanyamihova.starter.data.net.base;

import io.reactivex.Observable;

/**
 * Parent of queries.
 * <p>
 * Created by Vanya Mihova 12.01.2018
 */
public abstract class BaseQuery<S, R> {

    private String mBaseUrl;

    protected BaseQuery(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    public abstract Class<S> getServiceClass();

    public String getUrl() {
        return mBaseUrl;
    }

    public abstract Observable<R> makeQueryFrom(S service);

}
