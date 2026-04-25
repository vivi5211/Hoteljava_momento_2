package application.repository;

import application.domain.Guest;
import application.service.ports.GuestRepositoryPort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class GuestRepository implements GuestRepositoryPort {

    private final List<Guest> guests = new ArrayList<>(Arrays.asList(
            new Guest(1, "Maria", "Gomez", "mg@mail.com", "123456", true, "Medellín", "Nuevo"),
            new Guest(2, "Juan", "Perez", "juan@mail.com", "12345678", true, "Bogotá", "Frecuente")
    ));

    @Override
    public Guest save(Guest guest) {
        guests.add(guest);
        return guest;
    }

    @Override
    public Guest update(int id, Guest guest) {
        for (int i = 0; i < guests.size(); i++) {
            if (guests.get(i).getId() == id) {
                guests.set(i, guest);
                return guest;
            }
        }
        throw new IllegalArgumentException("Huésped con id " + id + " no encontrado");
    }

    @Override
    public Optional<Guest> findById(int id) {
        for (Guest guest : guests) {
            if (guest.getId() == id) {
                return Optional.of(guest);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Guest> findAll() {
        return guests;
    }

    @Override
    public void deleteById(int id) {
        boolean removed = guests.removeIf(g -> g.getId() == id);
        if (removed) {
            System.out.println("Huésped con id " + id + " eliminado.");
        } else {
            System.out.println("Huésped con id " + id + " no encontrado.");
        }
    }
}