package eu.vanyamihova.starter.presentation.common.loadingview;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.vanyamihova.starter.R;
import eu.vanyamihova.starter.devtool.DebugManager;

/**
 * Created by Vanya Mihova on 28.01.17.
 */
public class LoadingView extends FrameLayout {

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    @BindView(R.id.tv_loading_message)
    protected TextView loadingMessageView;

    private AlertDialog.Builder mAlertBuilder;
    private AlertDialog mDialog;

    private void init() {
        View alertLayout = inflate(getContext(), R.layout.layout_loading, null);
        ButterKnife.bind(this, alertLayout);

        this.mAlertBuilder = new AlertDialog.Builder(getContext());
        // this is set the view from XML inside AlertDialog
        this.mAlertBuilder.setView(alertLayout);
        // disallow cancel of AlertDialog on click of back button and outside touch
        this.mAlertBuilder.setCancelable(false);
        // Create dialog
        this.mDialog = this.mAlertBuilder.create();
    }

    private void setMessage(String message) {
        if (TextUtils.isEmpty(message)) {
            message = this.convertResourceIntoString(R.string.loading_default);
        }
        loadingMessageView.setText(message);
    }

    public void showLoading() {
        this.showLoading(R.string.loading_default);
    }

    public void showLoading(Object messageResource) {
        String message = "";

        // If the 'messageResource' is Integer
        if (messageResource instanceof Integer) {
            message = this.convertResourceIntoString((int)messageResource);
        }

        // If the 'messageResource' is String
        if (messageResource instanceof String) {
            message = (String) messageResource;
        }

        // Set message in the view
        this.setMessage(message);

        // Open the dialog
        this.mDialog.show();
    }

    public void hideLoading() {
        this.mDialog.dismiss();
    }

    private String convertResourceIntoString(Integer messageResource) {
        String message = "";
        try {
            message = getContext().getResources().getString(messageResource);
        } catch (Exception e) {
            DebugManager.log("Message Resource in Loading View", e);
        }
        return message;
    }

}
