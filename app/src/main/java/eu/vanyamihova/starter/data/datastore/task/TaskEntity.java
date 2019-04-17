package eu.vanyamihova.starter.data.datastore.task;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Do not change the access modifiers! They must be 'public' because of 'Room'
 *
 * Created by Vanya Mihova on 18.01.2018
 */

@Entity(tableName = "task")
public class TaskEntity {

    @Ignore
    private final AtomicLong counter = new AtomicLong();

    @PrimaryKey
    @ColumnInfo(name = "taskId")
    public long id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "completed")
    public boolean completed;

    public TaskEntity() {
    }

    @Ignore
    public TaskEntity(String title) {
        this.id = counter.incrementAndGet();
        this.title = title;
        this.completed = false;
    }

    @Ignore
    public TaskEntity(long id, String userName, boolean completed) {
        this.id = id;
        this.title = userName;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

}
