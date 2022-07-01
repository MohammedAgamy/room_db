package com.example.room_db.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import java.util.List;

@Dao
@TypeConverters(DateConverter.class)
public interface EmployeeDao {

    @Insert
    void insertEmployee(EmployeeEntity... employeeEntities);

    @Update
    void updateEmployee(EmployeeEntity... employeeEntities);

    @Delete
    void deleteEmployee(EmployeeEntity... employeeEntities);

    @Query("delete from employeeTable where email=:email")
    void deleteEmployee(String email);

    @Query("SELECT * FROM EMPLOYEETABLE ORDER BY NAME ASC")
    LiveData<List<EmployeeEntity>> getAllEmployee();

    @Query("select * from employeeTable where email=:email")
    LiveData<List<EmployeeEntity>> getAllEmployeeEmail(String email);








}
