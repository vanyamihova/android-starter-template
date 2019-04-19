package eu.vanyamihova.starter.data.net;

import eu.vanyamihova.starter.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Builder that constructs the Retrofit client,
 * depending from DEV or PROD mode.
 *
 * @author Vanya Mihova <vanya.mihova89@gmail.com>
 * @since 18.04.2019
 */
final class RetrofitBuilder {

    RetrofitBuilder() {
    }

    public Retrofit build(String url) {
        if (BuildConfig.DEBUG) {
            return debugConfig(url);
        }
        return productionConfig(url);
    }

    private Retrofit productionConfig(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private Retrofit debugConfig(String url) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

}
