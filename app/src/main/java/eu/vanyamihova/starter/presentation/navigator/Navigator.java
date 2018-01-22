package eu.vanyamihova.starter.presentation.navigator;

import android.content.Context;

/**
 * Navigate the app to different views.
 *
 * Created by Vanya Mihova on 21.01.2018
 */

public interface Navigator {

    /**
     * Open Main View Activity by passing the current context.
     * @param context
     */
    void navigateToMainView(Context context);

}
