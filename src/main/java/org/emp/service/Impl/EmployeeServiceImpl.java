package org.emp.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.emp.dto.Employee;
import org.emp.entity.EmployeeEntity;
import org.emp.repository.EmployeeRepository;
import org.emp.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository;


    @Override
    public void addEmployee(Employee employee) {

        EmployeeEntity employeeEntity = new ObjectMapper().convertValue(employee, EmployeeEntity.class);
        repository.save(employeeEntity);
    }


    @Override
    public List<Employee> getAll() {

        List<Employee> employeList = new ArrayList<>();

        List<EmployeeEntity> allEntityList = repository.findAll();

        allEntityList.forEach(entity -> {

            employeList.add(new ObjectMapper().convertValue(entity, Employee.class));
        });
        return employeList;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        if(repository.findById(employee.getId()).isPresent()){
            repository.save(new ObjectMapper().convertValue(employee, EmployeeEntity.class));
        }
    }
}
