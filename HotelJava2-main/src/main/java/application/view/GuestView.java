package application.view;

import application.domain.Guest;
import application.service.outputs.GuestService;
import application.util.FormValidationUtil;

import java.util.List;

public class GuestView {

    private final GuestService guestService;

    public GuestView(GuestService guestService) {
        this.guestService = guestService;
    }

    public void createGuest() {
        System.out.println("Crear Huésped");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del huésped");
            String name = FormValidationUtil.validateString("Ingrese el nombre");
            String lastName = FormValidationUtil.validateString("Ingrese el apellido");
            String email = FormValidationUtil.validateString("Ingrese el email");
            String password = FormValidationUtil.validateString("Ingrese el password");
            boolean state = FormValidationUtil.validateBoolean("Estado (true/false)");
            String origin = FormValidationUtil.validateString("Ingrese el origen");
            String guestType = FormValidationUtil.validateString("Ingrese el tipo de huésped");
            Guest created = guestService.createGuest(id, name, lastName, email, password, state, origin, guestType);
            System.out.println("Huésped creado: " + created.getId() + " - " + created.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateGuest() {
        System.out.println("Actualizar Huésped");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del huésped a actualizar");
            Guest current = guestService.getGuestById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Huésped no encontrado"));
            System.out.println("Datos actuales: " + current);

            String name = FormValidationUtil.validateString("Nuevo nombre (" + current.getName() + ")");
            String lastName = FormValidationUtil.validateString("Nuevo apellido (" + current.getLastName() + ")");
            String email = FormValidationUtil.validateString("Nuevo email (" + current.getEmail() + ")");
            String password = FormValidationUtil.validateString("Nuevo password");
            boolean state = FormValidationUtil.validateBoolean("Estado (true/false)");
            String origin = FormValidationUtil.validateString("Nuevo origen (" + current.getOrigin() + ")");
            String guestType = FormValidationUtil.validateString("Nuevo tipo de huésped (" + current.getGuestType() + ")");

            Guest updated = guestService.updateGuest(id, name, lastName, email, password, state, origin, guestType);
            System.out.println("Huésped actualizado: " + updated.getId() + " - " + updated.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getGuestById() {
        System.out.println("Buscar Huésped por Id");
        try {
            Guest guest = guestService.getGuestById(
                            FormValidationUtil.validateInt("Ingrese el id del huésped"))
                    .orElseThrow(() -> new IllegalArgumentException("Huésped no encontrado"));
            System.out.println(guest);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getAllGuests() {
        System.out.println("Todos los huéspedes:");
        List<Guest> list = guestService.getAllGuests();
        for (Guest g : list) {
            System.out.println(g.getId() + " - " + g.getName() + " " + g.getLastName()
                    + " | " + g.getOrigin() + " | " + g.getGuestType());
        }
    }

    public void deleteGuestById() {
        guestService.deleteGuestById(
                FormValidationUtil.validateInt("Ingrese el id del huésped a eliminar"));
    }
}// Gestion Guest - cforonda
