package eu.vanyamihova.starter.data.net.base;

/**
 * Parent of queries.
 * <p>
 * Created by Vanya Mihova 12.01.2018
 */
public abstract class BaseQuery<S, L extends BaseQueryCompleteListener> {

    protected L mListener;
    private String mBaseUrl;

    protected BaseQuery(String baseUrl, L listener) {
        this.mBaseUrl = baseUrl;
        this.mListener = listener;
    }

    public abstract Class<S> getServiceClass();

    public String getUrl() {
        return mBaseUrl;
    }

    public abstract void makeQueryFrom(S service);

}
