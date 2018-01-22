package eu.vanyamihova.starter.presentation.model.task;

/**
 * Created by Vanya Mihova on 18.01.2018
 */

public final class TaskViewModel {

    private final int id;
    private int userId;
    private String title;
    private boolean completed;

    public TaskViewModel(int id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getCompleted() {
        return ((completed) ? TaskCompletion.DONE : TaskCompletion.PENDING).getLabel();
    }

    @Override
    public String toString() {
        return "TaskViewModel[" +
                "id:" + this.id + "; " +
                "title:" + this.title + "; " +
                "completed:" + this.completed +
                "]";
    }
}
