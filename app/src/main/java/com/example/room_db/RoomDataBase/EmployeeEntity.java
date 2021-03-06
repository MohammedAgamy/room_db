package com.example.room_db.RoomDataBase;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;

@Entity(tableName = "employeeTable")
@TypeConverters(DateConverter.class)
public class EmployeeEntity {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "empId")
    private int id;
    private String name;
    private String email;
    private Date birthDay;


    public EmployeeEntity(@NonNull int id, String name, String email, Date birthDay) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
    }

    public EmployeeEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
