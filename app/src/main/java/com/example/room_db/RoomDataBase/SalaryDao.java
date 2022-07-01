package com.example.room_db.RoomDataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

@Dao
@TypeConverters(DateConverter.class)
public interface SalaryDao {
    @Insert
    void insertSalary(SalaryEntity salaryEntity);

    @Update
    void updateSalary(SalaryEntity salaryEntity);

    @Delete
    void deleteSalary(SalaryEntity salaryEntity);

    @Query("select * from salaryTable Where empId=:empId order by  date desc")
    LiveData<List<SalaryEntity>> getEmployeeSalary(long empId);

    @Query("select * from salaryTable Where empId=:empId and date>=:from and date <=:to order by date desc  ")
    LiveData<List<SalaryEntity>> getEmployeeSalary(long empId, Date from, Date to);

}
