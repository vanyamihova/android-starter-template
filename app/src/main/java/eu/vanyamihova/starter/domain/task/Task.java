package eu.vanyamihova.starter.domain.task;

/**
 * Structure for a valid Domain Object.
 *
 * Created by Vanya Mihova on 12.01.2018
 */

public final class Task {

    private final int id;
    private int userId;
    private String title;
    private boolean completed;

    public Task(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
