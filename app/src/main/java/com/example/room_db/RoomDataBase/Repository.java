package com.example.room_db.RoomDataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.Date;
import java.util.List;

public class Repository {

    private EmployeeDao employeeDao;
    private SalaryDao salaryDao;

    public Repository(Application application) {
        MyDataBaseRoom myDataBaseRoom = MyDataBaseRoom.getDatabase(application);
        employeeDao = myDataBaseRoom.employeeDao();
        salaryDao = myDataBaseRoom.salaryDao();

    }

    ///Employee dao method

    void insertEmployee(EmployeeEntity... employeeEntities) {
        MyDataBaseRoom.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDao.insertEmployee(employeeEntities);
            }
        });
    }

    void updateEmployee(EmployeeEntity... employeeEntities) {
        MyDataBaseRoom.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDao.updateEmployee(employeeEntities);
            }
        });
    }

    void deleteEmployee(EmployeeEntity... employeeEntities) {
        MyDataBaseRoom.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDao.deleteEmployee(employeeEntities);
            }
        });
    }

    void deleteEmployee(String email) {
        MyDataBaseRoom.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                employeeDao.deleteEmployee(email);
            }
        });
    }

    LiveData<List<EmployeeEntity>> getAllEmployee() {

        return employeeDao.getAllEmployee();

    }

    LiveData<List<EmployeeEntity>> getAllEmployeeEmail(String email) {
        return employeeDao.getAllEmployeeEmail(email);

    }

    ///Salary dao method
    void insertSalary(SalaryEntity salaryEntity) {
        MyDataBaseRoom.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                salaryDao.insertSalary(salaryEntity);
            }
        });
    }

    void updateSalary(SalaryEntity salaryEntity) {
        MyDataBaseRoom.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                salaryDao.updateSalary(salaryEntity);
            }
        });
    }

    void deleteSalary(SalaryEntity salaryEntity) {
        MyDataBaseRoom.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                salaryDao.deleteSalary(salaryEntity);
            }
        });
    }

    LiveData<List<SalaryEntity>> getEmployeeSalary(long empId) {

        return salaryDao.getEmployeeSalary(empId);

    }

    LiveData<List<SalaryEntity>> getEmployeeSalary(long empId, Date from, Date to) {
        return salaryDao.getEmployeeSalary(empId, from, to);

    }

    void getSalarySum(double empId, DoubleValueListener doubleValueListener) {
        MyDataBaseRoom.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                double sum = salaryDao.getSalarySum(empId);
                doubleValueListener.getSum(sum);
            }
        });
    }

    public interface DoubleValueListener {
        public void getSum(Double sum);

    }
}
