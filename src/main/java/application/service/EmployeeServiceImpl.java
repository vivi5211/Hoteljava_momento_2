package application.service;

import application.domain.Employee;
import application.service.outputs.EmployeeService;
import application.service.ports.EmployeeRepositoryPort;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryPort employeeRepositoryPort;

    public EmployeeServiceImpl(EmployeeRepositoryPort employeeRepositoryPort) {
        this.employeeRepositoryPort = employeeRepositoryPort;
    }

    @Override
    public Employee createEmployee(int id, String name, String lastName, String email,
                                   String password, boolean state, String position, double salary) {
        if (employeeRepositoryPort.findById(id).isPresent()) {
            throw new IllegalArgumentException("Ya existe un empleado con id: " + id);
        }
        Employee employee = new Employee(id, name, lastName, email, password, state, position, salary);
        return employeeRepositoryPort.save(employee);
    }

    @Override
    public Employee updateEmployee(int id, String name, String lastName, String email,
                                   String password, boolean state, String position, double salary) {
        Employee employee = employeeRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPassword(password);
        employee.setState(state);
        employee.setPosition(position);
        employee.setSalary(salary);
        return employeeRepositoryPort.update(id, employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepositoryPort.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepositoryPort.findAll();
    }

    @Override
    public void deleteEmployeeById(int id) {
        employeeRepositoryPort.deleteById(id);
    }
}