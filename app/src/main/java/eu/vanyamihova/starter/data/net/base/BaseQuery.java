package eu.vanyamihova.starter.data.net.base;

import javax.inject.Inject;

import eu.vanyamihova.starter.application.AndroidApplication;
import eu.vanyamihova.starter.BuildConfig;
import eu.vanyamihova.starter.data.exception.NetworkConnectionException;
import eu.vanyamihova.starter.data.executor.ThreadPoolExecutor;
import eu.vanyamihova.starter.data.executor.priority.PriorityRunnable;
import eu.vanyamihova.starter.data.net.NetworkUtils;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Parent of all queries.
 * It constructs the Retrofit client, depending from DEV or PROD mode. It checks for available
 * network connection, if there is none - throws exception and it doesn't trigger the query.
 *
 * Created by Vanya Mihova 12.01.2018
 */
public abstract class BaseQuery<S, L extends BaseQueryCompleteListener> {

    private String mBaseUrl;
    private S mService;
    protected L mListener;
    @Inject
    protected NetworkUtils networkUtils;

    protected BaseQuery(String baseUrl, L listener) {
        AndroidApplication.inject(this);
        this.mBaseUrl = baseUrl;
        this.mListener = listener;
        this.mService = (S) configRetrofit().create(getServiceClass());
    }

    private Retrofit configRetrofit() {
        if (BuildConfig.DEBUG) {
            return debugConfig();
        }
        return new Retrofit.Builder()
                .baseUrl(this.mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private Retrofit debugConfig() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        return new Retrofit.Builder()
                .baseUrl(this.mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    protected abstract Class getServiceClass();
    protected abstract void makeQueryFrom(S service);

    /**
     * Pass {@link PriorityRunnable} implementation for saving data on background thread
     * @param runnable
     */
    protected void save(PriorityRunnable runnable) {
        ThreadPoolExecutor.getInstance().forBackgroundTasks()
                .execute(runnable);
    }

    /**
     * Check for the network connection and if there is no, throw {@link NetworkConnectionException}
     */
    public void sync() throws NetworkConnectionException {
        // Check the internet connection
        if (!this.networkUtils.isConnected()) {
            throw new NetworkConnectionException();
        }
        this.makeQueryFrom(this.mService);
    }

}
