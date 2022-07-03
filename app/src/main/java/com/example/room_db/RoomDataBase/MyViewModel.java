package com.example.room_db.RoomDataBase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

public class MyViewModel extends AndroidViewModel {
    Repository repository;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }


    ///Employee dao method

    public void insertEmployee(EmployeeEntity... employeeEntities) {
        repository.insertEmployee(employeeEntities);
    }

    public void updateEmployee(EmployeeEntity... employeeEntities) {
        repository.updateEmployee(employeeEntities);
    }

    public void deleteEmployee(EmployeeEntity... employeeEntities) {
        repository.deleteEmployee();
    }

    public void deleteEmployee(String email) {
        repository.deleteEmployee(email);
    }

    public LiveData<List<EmployeeEntity>> getAllEmployee() {

        return repository.getAllEmployee();

    }

    public LiveData<List<EmployeeEntity>> getAllEmployeeEmail(String email) {
        return repository.getAllEmployeeEmail(email);

    }

    ///Salary dao method
    public void insertSalary(SalaryEntity salaryEntity) {
        repository.insertSalary(salaryEntity);
    }

    public void updateSalary(SalaryEntity salaryEntity) {
        repository.updateSalary(salaryEntity);

    }

    public void deleteSalary(SalaryEntity salaryEntity) {
        repository.deleteSalary(salaryEntity);

    }

    public LiveData<List<SalaryEntity>> getEmployeeSalary(long empId) {

        return repository.getEmployeeSalary(empId);

    }

    public LiveData<List<SalaryEntity>> getEmployeeSalary(long empId, Date from, Date to) {
        return repository.getEmployeeSalary(empId, from, to);

    }

    public void getSalarySum(double empId, Repository.DoubleValueListener doubleValueListener) {
        repository.getSalarySum(empId, doubleValueListener);
    }


}
