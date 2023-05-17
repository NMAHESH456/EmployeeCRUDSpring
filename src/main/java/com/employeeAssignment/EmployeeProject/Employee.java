package com.employeeAssignment.EmployeeProject;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
@SequenceGenerator(name = "employee_seq", sequenceName = "employee_sequence", allocationSize = 1)

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")


    private long id;
    private String  EmployeeName;
    private String  EmployeeEmail;
    private String  EmployeeRole;

    public Employee() {
    }

    public Employee(long id, String employeeName, String employeeEmail, String employeeRole) {
        super();
        this.id = id;
        EmployeeName = employeeName;
        EmployeeEmail = employeeEmail;
        EmployeeRole = employeeRole;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return EmployeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        EmployeeEmail = employeeEmail;
    }

    public String getEmployeeRole() {
        return EmployeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        EmployeeRole = employeeRole;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", EmployeeEmail='" + EmployeeEmail + '\'' +
                ", EmployeeRole='" + EmployeeRole + '\'' +
                '}';
    }

}
