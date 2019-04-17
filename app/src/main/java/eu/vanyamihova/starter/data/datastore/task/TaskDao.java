package eu.vanyamihova.starter.data.datastore.task;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * Task Data Access Object
 *
 * Created by Vanya Mihova on 18.01.2018
 */
@Dao
public interface TaskDao {

    @Query("SELECT * FROM task")
    List<TaskEntity> loadAll();

    @Query("SELECT * FROM task WHERE taskId IN (:taskIds)")
    LiveData<List<TaskEntity>> loadAllByTaskIds(int... taskIds);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<TaskEntity> tasks);

    @Delete
    void delete(TaskEntity task);

}
