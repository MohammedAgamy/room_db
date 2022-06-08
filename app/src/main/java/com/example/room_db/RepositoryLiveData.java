package com.example.room_db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RepositoryLiveData {
    private Dao dao;
    private LiveData<List<Model>> getAllData;

    public RepositoryLiveData(Context context) {

        RoomDb roomDb = RoomDb.getInstance(context);
        dao = roomDb.dao();
        getAllData = dao.getAllData();

    }

    public void insert(Model model) {

        new InsertAsyncTask(dao).execute(model);
    }

    public void update(Model model) {

        new UpdateAsyncTask(dao).execute(model);
    }

    public void delete(Model model) {
        new DeleteAsyncTask(dao).execute(model);
    }

    public LiveData<List<Model>> getGetAllData() {
        return getAllData;
    }

    public void deleteAllData() {
        new DeleteAllAsyncTask(dao);
    }


    public static class InsertAsyncTask extends AsyncTask<Model, Void, Void> {
        private Dao dao;

        public InsertAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Model... models) {
            dao.insert(models[0]);
            return null;
        }
    }

    public static class UpdateAsyncTask extends AsyncTask<Model, Void, Void> {
        private Dao dao;

        public UpdateAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Model... models) {
            dao.update(models[0]);
            return null;
        }
    }

    public static class DeleteAsyncTask extends AsyncTask<Model, Void, Void> {
        private Dao dao;

        public DeleteAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Model... models) {
            dao.delete(models[0]);
            return null;
        }
    }

    public static class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private Dao dao;

        public DeleteAllAsyncTask(Dao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAll();
            return null;
        }
    }
}
