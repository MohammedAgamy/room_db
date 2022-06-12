package com.example.room_db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    AdapterWord adapterWord;
    LiveMoelData liveMoelData;
    List<Model> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniView();
    }

    private void iniView() {
        recyclerView = findViewById(R.id.recycler);
        floatingActionButton = findViewById(R.id.addword);

        mList = new ArrayList<>();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });


        adapterWord = new AdapterWord();
        recyclerView.setAdapter(adapterWord);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapterWord.notifyDataSetChanged();

        liveMoelData = new ViewModelProvider(this).get(LiveMoelData.class);
        liveMoelData.getAllData().observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
                //adapterWord.setWord(models);
               // Toast.makeText(MainActivity.this, models.get(1).getWordName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}