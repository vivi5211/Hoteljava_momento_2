package application.service;

import application.domain.Guest;
import application.service.outputs.GuestService;
import application.service.ports.GuestRepositoryPort;

import java.util.List;
import java.util.Optional;

public class GuestServiceImpl implements GuestService {

    private final GuestRepositoryPort guestRepositoryPort;

    public GuestServiceImpl(GuestRepositoryPort guestRepositoryPort) {
        this.guestRepositoryPort = guestRepositoryPort;
    }

    @Override
    public Guest createGuest(int id, String name, String lastName, String email,
                             String password, boolean state, String origin, String guestType) {
        if (guestRepositoryPort.findById(id).isPresent()) {
            throw new IllegalArgumentException("Ya existe un huésped con id: " + id);
        }
        Guest guest = new Guest(id, name, lastName, email, password, state, origin, guestType);
        return guestRepositoryPort.save(guest);
    }

    @Override
    public Guest updateGuest(int id, String name, String lastName, String email,
                             String password, boolean state, String origin, String guestType) {
        Guest guest = guestRepositoryPort.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Huésped no encontrado"));
        guest.setName(name);
        guest.setLastName(lastName);
        guest.setEmail(email);
        guest.setPassword(password);
        guest.setState(state);
        guest.setOrigin(origin);
        guest.setGuestType(guestType);
        return guestRepositoryPort.update(id, guest);
    }

    @Override
    public Optional<Guest> getGuestById(int id) {
        return guestRepositoryPort.findById(id);
    }

    @Override
    public List<Guest> getAllGuests() {
        return guestRepositoryPort.findAll();
    }

    @Override
    public void deleteGuestById(int id) {
        guestRepositoryPort.deleteById(id);
    }
}