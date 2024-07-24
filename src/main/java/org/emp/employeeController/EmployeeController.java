package org.emp.employeeController;

import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.service.EmployeeService;
import org.emp.service.Impl.EmployeeServiceImpl;
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
    public void addEmployee(@RequestBody Employee employee){
         service.addEmployee(employee);
    }
    @GetMapping("get-all")
    public List<EmployeeEntity> getAll(){
        return service.getAll();
    }
}
