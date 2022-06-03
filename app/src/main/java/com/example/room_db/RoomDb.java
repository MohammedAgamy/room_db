package com.example.room_db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = EntityModel.class, version = 1)
public abstract class RoomDb extends RoomDatabase {

    private static RoomDb roomDbInstance;

    public abstract Dao dao();

    public static RoomDb getInstance(Context context) {
        if (roomDbInstance == null) {
            roomDbInstance = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDb.class, "TestRoom")
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return roomDbInstance;

    }


    private static RoomDatabase.Callback dataBaseCallBack = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new DataAsyncTask(roomDbInstance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };

    public static class DataAsyncTask extends AsyncTask<Void, Void, Void> {
        public Dao dao;

        public DataAsyncTask(RoomDb roomDb) {
            dao = roomDb.dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //dao.insert(new EntityModel("","",""));
            return null;
        }
    }
}
