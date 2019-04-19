package eu.vanyamihova.starter.presentation.navigator;

import android.content.Context;
import android.content.Intent;

import eu.vanyamihova.starter.presentation.app.main.MainActivity;

/**
 * Created by Vanya Mihova on 21.01.2018
 */

public class NavigatorImpl implements Navigator {

    private static Navigator sInstance = new NavigatorImpl();

    public static Navigator getInstance() {
        return sInstance;
    }

    @Override
    public void navigateToMainView(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

}
