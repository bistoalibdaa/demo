package com.example.demo;

public class EmployeeSummaryDTO {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    private Long id;
    private String name;
    private String department;

    public EmployeeSummaryDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.department = employee.getDepartment();
    }


}
