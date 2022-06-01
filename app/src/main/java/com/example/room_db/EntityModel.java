package com.example.room_db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "testRoom")
public class EntityModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "wordName")
    private String wordName;
    private String wordMean;
    private String wordType;

    public EntityModel(String wordName, String wordMean, String wordType) {
        this.wordName = wordName;
        this.wordMean = wordMean;
        this.wordType = wordType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getWordMean() {
        return wordMean;
    }

    public void setWordMean(String wordMean) {
        this.wordMean = wordMean;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }
}
