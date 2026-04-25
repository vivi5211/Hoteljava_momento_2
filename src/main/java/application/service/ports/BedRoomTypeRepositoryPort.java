package application.service.ports;

import application.domain.BedRoomType;
import java.util.List;
import java.util.Optional;

public interface BedRoomTypeRepositoryPort {
    BedRoomType saveBedRoomType(BedRoomType bedRoomType);
    BedRoomType updateBedRoomType(int id, BedRoomType bedRoomType);
    Optional<BedRoomType> findBedRoomTypeById(int id);
    List<BedRoomType> findAllBedRoomTypes();
    void deleteBedRoomTypeById(int id);
}