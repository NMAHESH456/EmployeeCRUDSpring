package com.employeeAssignment.EmployeeProject;

import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Id> {
    Optional<Employee> findById(long id);

    void deleteById(long id);
}
