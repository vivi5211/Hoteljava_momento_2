package application.userinterface;

import application.util.FormValidationUtil;
import application.view.BedRoomTypeView;
import application.view.BedRoomView;
import application.view.EmployeeView;
import application.view.GuestView;

import java.util.Scanner;

public class MenuApp {

    Scanner sc = new Scanner(System.in);

    // ✅ Todos los campos declarados juntos al inicio
    private final GuestView guestView;
    private final BedRoomView bedRoomView;
    private final BedRoomTypeView bedRoomTypeView;
    private final EmployeeView employeeView;

    // ✅ Un solo constructor con los 4 parámetros
    public MenuApp(GuestView guestView, BedRoomView bedRoomView,
                   BedRoomTypeView bedRoomTypeView, EmployeeView employeeView) {
        this.guestView = guestView;
        this.bedRoomView = bedRoomView;
        this.bedRoomTypeView = bedRoomTypeView;
        this.employeeView = employeeView;
    }

    public void showMainMenu() {
        System.out.println("Bienvenido al Hotel Java");
        int init = FormValidationUtil.validateInt("Presione 1 para iniciar la aplicacion");
        while (init != 0) {
            System.out.println("Seleccione 1. Huéspedes  2. Habitaciones  3. Tipos de Hab.  4. Empleados  0. Salir");
            int option = FormValidationUtil.validateInt("Opción");
            switch (option) {
                case 1: showGuestMenu(); break;
                case 2: showBedRoomMenu(); break;
                case 3: showBedRoomTypeMenu(); break;
                case 4: showEmployeeMenu(); break;
                case 0:
                    System.out.println("Saliendo de la aplicacion");
                    init = 0;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    public void showGuestMenu() {
        System.out.println("Menu Huespedes");
        Boolean init = true;
        while (init) {
            System.out.println("1. Crear  2. Actualizar  3. Eliminar  4. Listar  5. Buscar por Id  6. Salir");
            int option = FormValidationUtil.validateInt("Opción");
            switch (option) {
                case 1: guestView.createGuest(); break;
                case 2: guestView.updateGuest(); break;
                case 3: guestView.deleteGuestById(); break;
                case 4: guestView.getAllGuests(); break;
                case 5: guestView.getGuestById(); break;
                case 6: init = false; break;
                default: System.out.println("Opcion no valida");
            }
        }
    }

    public void showBedRoomMenu() {
        System.out.println("Menu Habitaciones");
        Boolean init = true;
        while (init) {
            System.out.println("1. Crear  2. Actualizar  3. Eliminar  4. Listar  5. Buscar por Id  6. Salir");
            int option = FormValidationUtil.validateInt("Opción");
            switch (option) {
                case 1: bedRoomView.createBedRoom(); break;
                case 2: bedRoomView.updateBedRoom(); break;
                case 3: bedRoomView.deleteBedRoomById(); break;
                case 4: bedRoomView.getAllBedRooms(); break;
                case 5: bedRoomView.getBedRoomById(); break;
                case 6: init = false; break;
                default: System.out.println("Opcion no valida");
            }
        }
    }

    public void showBedRoomTypeMenu() {
        System.out.println("Menu Tipos de Habitación");
        Boolean init = true;
        while (init) {
            System.out.println("1. Crear  2. Actualizar  3. Eliminar  4. Listar  5. Buscar por Id  6. Salir");
            int option = FormValidationUtil.validateInt("Opción");
            switch (option) {
                case 1: bedRoomTypeView.createBedRoomType(); break;
                case 2: bedRoomTypeView.updateBedRoomType(); break;
                case 3: bedRoomTypeView.deleteBedRoomTypeById(); break;
                case 4: bedRoomTypeView.getAllBedRoomTypes(); break;
                case 5: bedRoomTypeView.getBedRoomTypeById(); break;
                case 6: init = false; break;
                default: System.out.println("Opción no válida");
            }
        }
    }

    public void showEmployeeMenu() {
        System.out.println("Menu Empleados");
        Boolean init = true;
        while (init) {
            System.out.println("1. Crear  2. Actualizar  3. Eliminar  4. Listar  5. Buscar por Id  6. Salir");
            int option = FormValidationUtil.validateInt("Opción");
            switch (option) {
                case 1: employeeView.createEmployee(); break;
                case 2: employeeView.updateEmployee(); break;
                case 3: employeeView.deleteEmployeeById(); break;
                case 4: employeeView.getAllEmployees(); break;
                case 5: employeeView.getEmployeeById(); break;
                case 6: init = false; break;
                default: System.out.println("Opción no válida");
            }
        }
    }
}