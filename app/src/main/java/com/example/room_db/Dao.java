package com.example.room_db;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EntityModel entityModel);

    @Update
    void update(EntityModel entityModel);

    @Delete
    void delete(EntityModel entityModel);

    @Query("delete from entitymodel")
    void deleteAll(EntityModel entityModel);

    @Query("SELECT * FROM entitymodel")
    LiveData<List<EntityModel>> getAllData();


}
