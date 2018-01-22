package eu.vanyamihova.starter.presentation.common.loadingview;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;

/**
 * Created by Vanya Mihova on 12.01.2018
 */

public class LoadingViewFactory {

    public static LoadingView build(Context context) {
        return new LoadingViewFactory(context).build();
    }

    private Context mContext;

    private LoadingViewFactory(Context context) {
        this.mContext = context;
    }

    private LoadingView build() {
        LoadingView loadingView = new LoadingView(mContext);
        loadingView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        ViewGroup rootView = (ViewGroup) ((ViewGroup) ((Activity)mContext).findViewById(android.R.id.content)).getChildAt(0);
        rootView.addView(loadingView);

        return loadingView;
    }

}
