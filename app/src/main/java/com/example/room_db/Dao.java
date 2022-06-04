package com.example.room_db;

import android.view.Display;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert
    void insert(Model model);

    @Update
    void update(Model model);

    @Delete
    void delete(Model model);

    @SuppressWarnings("AndroidUnresolvedRoomSqlReference")
    @Query("delete from newData")
    void deleteAll();

    @SuppressWarnings("AndroidUnresolvedRoomSqlReference")
    @Query("SELECT * FROM newData")
    LiveData<List<Model>> getAllData();


}
