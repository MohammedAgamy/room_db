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
    @ColumnInfo(name = "wordMean")
    private String wordMean;
    @ColumnInfo(name = "wordType")
    private String wordType;

    public Model(String wordName, String wordMean, String wordType) {
        this.wordName = wordName;
        this.wordMean = wordMean;
        this.wordType = wordType;
    }

    public int getId() {
        return id;
    }

    public String getWordName() {
        return wordName;
    }

    public String getWordMean() {
        return wordMean;
    }

    public String getWordType() {
        return wordType;
    }
}
