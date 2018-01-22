package eu.vanyamihova.starter.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Check for network connection
 *
 * Created by Vanya Mihova on 12.01.2018
 */

@Singleton
public final class NetworkUtils {

  private final ConnectivityManager connectivityManager;

  @Inject
  public NetworkUtils(final Context context) {
    connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
  }

  public boolean isConnected() {
    final NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
  }

}
