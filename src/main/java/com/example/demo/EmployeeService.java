package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    public List<Employee> findAll() {
        return repo.findAll();
    }

    public Employee findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employee not found with id " + id));
    }

    public Employee create(Employee p) {
        p.setId(null);
        return repo.save(p);
    }

    public Employee update(Long id, Employee p) {
        Employee existing = findById(id);
        existing.setName(p.getName());
        existing.setDepartment(p.getDepartment());
        existing.setEmail(p.getEmail());
        existing.setSalary(p.getSalary());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.delete(findById(id));
    }
}