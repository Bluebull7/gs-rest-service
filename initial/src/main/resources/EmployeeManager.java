package com.example.demo;

import org.springframework
    .stereotype
    .Repository;

// Import employee class
import com.example.demo.Employees;

@Repository

//class to create a list of employees


public class EmployeeManager {

    private static Employees list 
        = new Employees();

    static
    {

        //create employees and add to the list
        list.getEmployeeList().add(
            new Employee(
                1,
                "Lance",
                "Henry",
                "Lance.Henry@HPE.com"));

        list.getEmployeeList().add(
            new Employee(
                2,
                "Stella",
                "Yun",
                "Stella@HPE.com"));

        list.getEmployeeList().add(
            new Employee(
                3,
                "James",
                "Henry",
                "James.Henry@HPE.com"));    
    }

    //Method to return the list
    public Employees getAllEmployees()
    {
        return list;
    }

        //Method to add employee to list
        public void 
        addEmployee(Employee employee)
        {
            list.getEmployeeList()
                .add(employee);
        }
}

