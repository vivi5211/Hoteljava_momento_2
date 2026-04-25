package application.service;

import application.domain.BedRoomType;
import application.service.outputs.BedRoomTypeService;
import application.service.ports.BedRoomTypeRepositoryPort;
import java.util.List;
import java.util.Optional;

public class BedRoomTypeServiceImpl implements BedRoomTypeService {

    private final BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort;

    public BedRoomTypeServiceImpl(BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort) {
        this.bedRoomTypeRepositoryPort = bedRoomTypeRepositoryPort;
    }

    @Override
    public BedRoomType createBedRoomType(int idType, String type) {
        if (bedRoomTypeRepositoryPort.findBedRoomTypeById(idType).isPresent()) {
            throw new IllegalArgumentException("Ya existe un tipo con id: " + idType);
        }
        BedRoomType bedRoomType = new BedRoomType(idType, type);
        return bedRoomTypeRepositoryPort.saveBedRoomType(bedRoomType);
    }

    @Override
    public BedRoomType updateBedRoomType(int id, String type) {
        BedRoomType bedRoomType = bedRoomTypeRepositoryPort.findBedRoomTypeById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tipo de habitación no encontrado"));
        bedRoomType.setType(type);
        return bedRoomTypeRepositoryPort.updateBedRoomType(id, bedRoomType);
    }

    @Override
    public Optional<BedRoomType> getBedRoomTypeById(int id) {
        return bedRoomTypeRepositoryPort.findBedRoomTypeById(id);
    }

    @Override
    public List<BedRoomType> getAllBedRoomTypes() {
        return bedRoomTypeRepositoryPort.findAllBedRoomTypes();
    }

    @Override
    public void deleteBedRoomTypeById(int id) {
        bedRoomTypeRepositoryPort.deleteBedRoomTypeById(id);
    }
}