package com.example.demo; 
  
import java.net.URI; 
import org.springframework.beans 
    .factory.annotation.Autowired; 
import org.springframework.http 
    .ResponseEntity; 
import org.springframework.web.bind 
    .annotation.GetMapping; 
import org.springframework.web.bind 
    .annotation.PostMapping; 
import org.springframework.web.bind 
    .annotation.RequestBody; 
import org.springframework.web.bind 
    .annotation.RequestMapping; 
import org.springframework.web.bind 
    .annotation.RestController; 
import org.springframework.web.servlet 
    .support.ServletUriComponentsBuilder; 

//Import defined classes
import com.example.demo.Employees;
import com.example.demo.EmployeeManager;
import com.example.demo.Employee;

//Create REST controller
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
  private EmployeeManager employeeManager;
        
        //Implemene GET method for employee list
    @GetMapping(
        path = "/",
        produces = "application/json")

    public Employees getEmployees()
    {

        return employeeManager
            .getAllEmployees();
    }

        //Create POST method to add employee to list

    @PostMapping(
        path = "/",
        consumes = "application/json",
        produces = "application/json")
    public ResponseEntity<Object> addEmployee(
        @RequestBody Employee employee)
    {

        //create id of employee from number of employees

        Integer id
            = employeeManager
                    .getAllEmployees()
                    .getEmployeeList()
                    .size()
                + 1;

            employee.setId(id);

            employeeManager
                .addEmployee(employee);

            URI location
                = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{{id}")
                        .buildAndExpand(
                            employee.getId())
                        .toUri();

                    return ResponseEntity
                .created(location)
                .build();
    }
     
}