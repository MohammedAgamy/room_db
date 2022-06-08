package com.example.room_db;

import android.app.Application;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LiveMoelData extends AndroidViewModel {
    RepositoryLiveData mRepositoryLiveData;
    LiveData<List<Model>> mLiveData;


    public LiveMoelData(@NonNull Application application) {
        super(application);
        mRepositoryLiveData = new RepositoryLiveData(application);
        mLiveData = mRepositoryLiveData.getGetAllData();
    }


    public void insert(Model model) {
        mRepositoryLiveData.insert(model);
    }

    public void update(Model model) {
        mRepositoryLiveData.update(model);
    }

    public void delete(Model model) {
        mRepositoryLiveData.delete(model);
    }

    public void deleteAll() {
        mRepositoryLiveData.deleteAllData();
    }

    public LiveData<List<Model>> getAllData() {
      return   mRepositoryLiveData.getGetAllData();
    }

}
