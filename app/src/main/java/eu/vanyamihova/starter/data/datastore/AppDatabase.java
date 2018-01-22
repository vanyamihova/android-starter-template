package eu.vanyamihova.starter.data.datastore;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import eu.vanyamihova.starter.data.datastore.task.TaskDao;
import eu.vanyamihova.starter.data.datastore.task.TaskEntity;

/**
 * Configuration for the database.
 *
 * Created by Vanya Mihova on 18.01.2018
 */
@Database(version = 1, entities = {
        TaskEntity.class
})
public abstract class AppDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
