package eu.vanyamihova.starter.data.net.task;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Response from the cloud server
 *
 * Created by Vanya Mihova on 12.01.2018
 */

public final class GetTasksDTO implements Serializable {

    @SerializedName("id") private int id;
    @SerializedName("userId") private int userId;
    @SerializedName("title") private String title;
    @SerializedName("completed") private boolean completed;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

}
