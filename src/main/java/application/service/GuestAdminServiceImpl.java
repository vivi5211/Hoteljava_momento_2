package application.service;

import application.domain.Guest;
import application.service.outputs.GuestAdminService;
import application.service.ports.GuestRepositoryPort;

import java.util.List;

public class GuestAdminServiceImpl implements GuestAdminService {

    private final GuestRepositoryPort guestRepositoryPort;

    public GuestAdminServiceImpl(GuestRepositoryPort guestRepositoryPort) {
        this.guestRepositoryPort = guestRepositoryPort;
    }

    @Override
    public List<Guest> getGuests() {
        return guestRepositoryPort.findAll();
    }

    @Override
    public void deleteGuest(int id) {
        guestRepositoryPort.deleteById(id);
    }
}