package eu.vanyamihova.starter.data.datastore;

import androidx.room.Room;
import android.content.Context;

import static eu.vanyamihova.starter.application.AppConfiguration.DATABASE_NAME;

/**
 * This manager is caring for the instance of the database. It is created when the application has
 * started. On low memory first it destroys the relation to the database and then the app is killed.
 *
 * Created by Vanya Mihova on 18.01.2018
 */

public class AppDatabaseManager {

    private static AppDatabaseManager sInstance;

    public static void create(Context context) {
        sInstance = new AppDatabaseManager(context);
    }

    public static AppDatabase get() {
        return sInstance.mAppDatabase;
    }

    public static void close() {
        sInstance.closeDb();
    }

    private AppDatabase mAppDatabase;

    private AppDatabaseManager(Context context) {
        this.mAppDatabase = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                .build();
    }

    private void closeDb() {
        this.mAppDatabase = null;
    }
}
