package application.service.outputs;

import application.domain.BedRoomType;
import java.util.List;
import java.util.Optional;

public interface BedRoomTypeService {
    BedRoomType createBedRoomType(int idType, String type);
    BedRoomType updateBedRoomType(int id, String type);
    Optional<BedRoomType> getBedRoomTypeById(int id);
    List<BedRoomType> getAllBedRoomTypes();
    void deleteBedRoomTypeById(int id);
}