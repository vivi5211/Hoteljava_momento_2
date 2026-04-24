package application.repository;

import application.domain.BedRoomType;
import application.service.ports.BedRoomTypeRepositoryPort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BedRoomTypeRepository implements BedRoomTypeRepositoryPort {

    private final List<BedRoomType> bedRoomTypes = new ArrayList<>(Arrays.asList(
            new BedRoomType(1, "Single"),
            new BedRoomType(2, "Doble"),
            new BedRoomType(3, "Suite"),
            new BedRoomType(4, "Grupal")
    ));

    @Override
    public BedRoomType saveBedRoomType(BedRoomType bedRoomType) {
        bedRoomTypes.add(bedRoomType);
        return bedRoomType;
    }

    @Override
    public BedRoomType updateBedRoomType(int id, BedRoomType bedRoomType) {
        for (int i = 0; i < bedRoomTypes.size(); i++) {
            if (bedRoomTypes.get(i).getIdType() == id) {
                bedRoomTypes.set(i, bedRoomType);
                return bedRoomType;
            }
        }
        throw new IllegalArgumentException("Tipo de habitación con id " + id + " no encontrado");
    }

    @Override
    public Optional<BedRoomType> findBedRoomTypeById(int id) {
        for (BedRoomType bedRoomType : bedRoomTypes) {
            if (bedRoomType.getIdType() == id) {
                return Optional.of(bedRoomType);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<BedRoomType> findAllBedRoomTypes() {
        return bedRoomTypes;
    }

    @Override
    public void deleteBedRoomTypeById(int id) {
        boolean removed = bedRoomTypes.removeIf(b -> b.getIdType() == id);
        if (removed) {
            System.out.println("Tipo de habitación con id " + id + " eliminado.");
        } else {
            System.out.println("Tipo de habitación con id " + id + " no encontrado.");
        }
    }
}