package application.service.outputs;

import application.domain.Employee;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee createEmployee(int id, String name, String lastName, String email,
                            String password, boolean state, String position, double salary);
    Employee updateEmployee(int id, String name, String lastName, String email,
                            String password, boolean state, String position, double salary);
    Optional<Employee> getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void deleteEmployeeById(int id);
}