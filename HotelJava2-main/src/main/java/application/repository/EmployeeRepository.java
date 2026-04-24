package application.repository;

import application.domain.Employee;
import application.service.ports.EmployeeRepositoryPort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository implements EmployeeRepositoryPort {

    private final List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee(1, "Carlos", "Ríos", "carlos@hotel.com", "admin123", true, "Recepcionista", 2500000),
            new Employee(2, "Laura", "Torres", "laura@hotel.com", "admin456", true, "Gerente", 5000000)
    ));

    @Override
    public Employee save(Employee employee) {
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(int id, Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.set(i, employee);
                return employee;
            }
        }
        throw new IllegalArgumentException("Empleado con id " + id + " no encontrado");
    }

    @Override
    public Optional<Employee> findById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public void deleteById(int id) {
        boolean removed = employees.removeIf(e -> e.getId() == id);
        if (removed) {
            System.out.println("Empleado con id " + id + " eliminado.");
        } else {
            System.out.println("Empleado con id " + id + " no encontrado.");
        }
    }
}