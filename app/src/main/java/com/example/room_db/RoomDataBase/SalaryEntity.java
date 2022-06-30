package com.example.room_db.RoomDataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "salaryTable"
        , foreignKeys = {@ForeignKey(entity = EmployeeEntity.class
        , parentColumns = {"empId"}
        , childColumns = {"empId"}
        , onUpdate = ForeignKey.CASCADE, onDelete = ForeignKey.CASCADE)})
public class SalaryEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "salaryId")
    private int id;
    private String amount;
    private java.util.Date Date;
    private long empId;


    public SalaryEntity(int id, String amount, Date date, long empId) {
        this.id = id;
        this.amount = amount;
        Date = date;
        this.empId = empId;
    }

    public SalaryEntity() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }
}
