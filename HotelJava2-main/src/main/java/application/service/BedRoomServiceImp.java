package application.service;

import application.domain.BedRoom;
import application.domain.BedRoomType;
import application.service.outputs.BedRoomService;
import application.service.ports.BedRoomRepositoryPort;
import application.service.ports.BedRoomTypeRepositoryPort;


import java.util.List;
import java.util.Optional;

public class BedRoomServiceImp implements BedRoomService {



    private final BedRoomRepositoryPort bedRoomRepositoryPort;
    private final BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort;


    public BedRoomServiceImp(BedRoomRepositoryPort bedRoomRepositoryPort, BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort) {
        this.bedRoomRepositoryPort = bedRoomRepositoryPort;
        this.bedRoomTypeRepositoryPort = bedRoomTypeRepositoryPort;
    }


    @Override
    public BedRoom createBedRoom(int roomId,String room,int typeId,double  price,String state) {

        // En este punto resuelvo la agregación como una regla de negocio
        // He convertido este paso un metodo , para poder reutilizarlo en el update
        BedRoomType bedRoomType = addBedRoomType(typeId);

        //agregué esta validación para que no permita crear id duplicados

        if (bedRoomRepositoryPort.findBedRoomById(roomId).isPresent()) {
            throw new IllegalArgumentException("Ya existe una habitación con id: " + roomId);
        }

        BedRoom bedRoom = new BedRoom(roomId, room, bedRoomType, price, state);

        bedRoomRepositoryPort.saveBedRoom(bedRoom);

        return bedRoom;
    }




    @Override
    public BedRoom updateBedRoom(int id,String room,int typeId,double  price,String state) {

        // Este bloque de codigo busca la habitación que se debe actualizar:

        BedRoom bedRoom = bedRoomRepositoryPort.findBedRoomById(id)
                .orElseThrow(()-> new IllegalArgumentException(
                "Habitación no encontrada"
        ));

        BedRoomType bedRoomType = addBedRoomType(typeId);

        bedRoom.setRoom(room);
        bedRoom.setBedRoomType(bedRoomType);
        bedRoom.setPrice(price);
        bedRoom.setState(state);

        bedRoomRepositoryPort.updateBedRoom(bedRoom.getRoomId(),bedRoom);
        return bedRoom;
    }

    @Override
    public Optional<BedRoom> getBedRoomById(int id) {
        return bedRoomRepositoryPort
                .findBedRoomById(id);
    }

    @Override
    public List<BedRoom> getAllBedRooms() {

        return bedRoomRepositoryPort.findAllBedRooms();
    }

    @Override
    public void deleteBedRoomById(int id) {

        bedRoomRepositoryPort.deleteBedRoomById(id);

    }

    // Separé en un metodo la logica que busca el bedRoomType , para poder reutilizarla
    // en el create y update, asi puedo llamarla en  ambos métodos

    private BedRoomType addBedRoomType(int typeId){
        BedRoomType bedRoomType =bedRoomTypeRepositoryPort
                .findBedRoomTypeById(typeId)
                .orElseThrow(()-> new IllegalArgumentException(
                        "No existe un tipo de habitación con id " + typeId
                ));
        return bedRoomType;
    }
}
