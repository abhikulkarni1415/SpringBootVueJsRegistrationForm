package com.example.Registration.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Registration.Dto.EmployeeDTO;
import com.example.Registration.Entity.Employee;
import com.example.Registration.Repo.EmployeeRepo;

@Service
public class EmployeeServiceIMPL implements EmployeeService 
 {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public String addEmployee(EmployeeDTO employeeDTO) 
       {

        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getAddress(),
                employeeDTO.getMobile()
        );
        employeeRepo.save(employee);
        return employee.getEmployeename();
    }
}
