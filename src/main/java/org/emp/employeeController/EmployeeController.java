package org.emp.employeeController;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.service.EmployeeService;
import org.emp.service.Impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/emp-controller")
//http://localhost:8080/emp-controller/add-employee
@RequiredArgsConstructor
public class EmployeeController {
   EmployeeService service;
    @PostMapping("add-employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee){
         service.addEmployee(employee);
    }
    @GetMapping("get-all")
    public List<Employee> getAll(){
        return service.getAll();
    }

    @DeleteMapping("delete-emp/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable Long id){
     service.deleteEmployeeById(id);
     return "Deleted";
    }
    @PutMapping("/update-employee")
    public void updateEmployee(@RequestBody Employee employee){
     service.updateEmployee(employee);
    }
}
