package eu.vanyamihova.starter.data.net.base;

import java.io.Serializable;

/**
 * Holding the base structure of the responses.
 *
 * Created by Vanya Mihova on 21.01.17.
 */
public abstract class BaseModelTO<T> implements Serializable {

    protected String reason;
    protected boolean result;
    protected String status;
    protected T data;

    public boolean isSuccess() {
        return result;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

}
