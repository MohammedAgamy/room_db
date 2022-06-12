package com.example.room_db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "newData")
public class Model {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "wordName")
    private String wordName;


    public Model(String wordName) {
        this.wordName = wordName;

    }
    public int getId() {
        return id;
    }

    public String getWordName() {
        return wordName;
    }


    public void setId(int id) {
        this.id = id;
    }
}
