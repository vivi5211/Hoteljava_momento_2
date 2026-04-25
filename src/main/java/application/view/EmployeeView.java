package application.view;

import application.domain.Employee;
import application.service.outputs.EmployeeService;
import application.util.FormValidationUtil;

import java.util.List;

public class EmployeeView {

    private final EmployeeService employeeService;

    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void createEmployee() {
        System.out.println("Crear Empleado");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del empleado");
            String name = FormValidationUtil.validateString("Ingrese el nombre");
            String lastName = FormValidationUtil.validateString("Ingrese el apellido");
            String email = FormValidationUtil.validateString("Ingrese el email");
            String password = FormValidationUtil.validateString("Ingrese el password");
            boolean state = FormValidationUtil.validateBoolean("Estado (true/false)");
            String position = FormValidationUtil.validateString("Ingrese el cargo");
            double salary = FormValidationUtil.validateDouble("Ingrese el salario");
            Employee created = employeeService.createEmployee(id, name, lastName, email, password, state, position, salary);
            System.out.println("Empleado creado: " + created.getId() + " - " + created.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateEmployee() {
        System.out.println("Actualizar Empleado");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del empleado a actualizar");
            Employee current = employeeService.getEmployeeById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));
            System.out.println("Datos actuales: " + current);

            String name = FormValidationUtil.validateString("Nuevo nombre (" + current.getName() + ")");
            String lastName = FormValidationUtil.validateString("Nuevo apellido (" + current.getLastName() + ")");
            String email = FormValidationUtil.validateString("Nuevo email (" + current.getEmail() + ")");
            String password = FormValidationUtil.validateString("Nuevo password");
            boolean state = FormValidationUtil.validateBoolean("Estado (true/false)");
            String position = FormValidationUtil.validateString("Nuevo cargo (" + current.getPosition() + ")");
            double salary = FormValidationUtil.validateDouble("Nuevo salario");

            Employee updated = employeeService.updateEmployee(id, name, lastName, email, password, state, position, salary);
            System.out.println("Empleado actualizado: " + updated.getId() + " - " + updated.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getEmployeeById() {
        System.out.println("Buscar Empleado por Id");
        try {
            Employee employee = employeeService.getEmployeeById(
                            FormValidationUtil.validateInt("Ingrese el id del empleado"))
                    .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));
            System.out.println(employee);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getAllEmployees() {
        System.out.println("Todos los empleados:");
        List<Employee> list = employeeService.getAllEmployees();
        for (Employee e : list) {
            System.out.println(e.getId() + " - " + e.getName() + " " + e.getLastName()
                    + " | " + e.getPosition() + " | $" + e.getSalary());
        }
    }

    public void deleteEmployeeById() {
        employeeService.deleteEmployeeById(
                FormValidationUtil.validateInt("Ingrese el id del empleado a eliminar"));
    }
}