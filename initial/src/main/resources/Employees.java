package com.example.demo;

import java.util.ArrayList;
import java.util.List;

//store a list of all employees in an Array

public class Employees {

    private List<Employee> employeeList;

    public List<Employee> getEmployeeList()
    {

        if (employeeList == null) {

            employeeList = 
                new ArrayList<>();


        }

        return employeeList;
    }


    public void
    setEmployeeList(
        List<Employee> employeeList)
    {

        this.employeeList
            = employeeList;

    }
    
}