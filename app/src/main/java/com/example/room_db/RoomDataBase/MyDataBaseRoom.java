package com.example.room_db.RoomDataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {EmployeeEntity.class}, version = 1, exportSchema = false)
public abstract class MyDataBaseRoom extends RoomDatabase {

    public abstract EmployeeEntity wordDao();

    public abstract SalaryEntity salaryEntity();


    private static volatile MyDataBaseRoom INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MyDataBaseRoom getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDataBaseRoom.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyDataBaseRoom.class, "RoomDataBase")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}


