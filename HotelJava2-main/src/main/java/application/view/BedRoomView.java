package application.view;

import application.domain.BedRoom;
import application.service.BedRoomStateSelector;
import application.service.outputs.BedRoomService;
import application.util.FormValidationUtil;

import java.util.List;

public class BedRoomView {

    private final BedRoomService bedRoomService;



    public BedRoomView(BedRoomService bedRoomService) {
        this.bedRoomService = bedRoomService;
    }

    public void createBedRoom() {

        System.out.println("Crear habitación");
        try {
            // Recolecta datos
            int roomId = FormValidationUtil.validateInt("Ingrese el Id de la habitación");
            String room = FormValidationUtil.validateString("Ingrese el número de habitación");
            int typeId = FormValidationUtil.validateInt("Ingrese el id del tipo");
            double price = FormValidationUtil.validateDouble("Ingrese el precio");
            String state = BedRoomStateSelector.bedRoomAddState();

            // Delega al servicio con los datos ya listos
            BedRoom created = bedRoomService.createBedRoom(roomId, room, typeId, price, state);
            System.out.println("Habitación creada: " + created.getRoomId());
        }catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void getAllBedRooms() {
        System.out.println("Mostrando todas las habitaciones...");

        List<BedRoom> bedRoomList = bedRoomService.getAllBedRooms();

        for (BedRoom bedroom : bedRoomList) {
            System.out.println(bedroom.getRoomId() + " "
                    + bedroom.getRoom() + " "
                    + bedroom.getBedRoomType().getType() + " "  // ← aquí accedes al tipo agregado
                    + bedroom.getPrice() + " "
                    + bedroom.getState());
        }
    }


    public void getBedRoomById(){
        System.out.println("Buscar habitación por Id");
        BedRoom bedRoom = bedRoomService.getBedRoomById(FormValidationUtil
                .validateInt("Ingrese el id de la Habitacion"))
                .orElseThrow(() -> new IllegalArgumentException(
                        "Habitacion no encontrada"
                ));


        System.out.println(bedRoom.getRoomId() + " "
                + bedRoom.getRoom() + " "
                + bedRoom.getBedRoomType().getType() + " "
                + bedRoom.getPrice() + " "
                + bedRoom.getState());

    }


    public void updateBedRoom(){

        int id = FormValidationUtil.validateInt("Ingrese el id de la habitación a Actualizar");

        int option= FormValidationUtil.validateInt("1. Seleccione campo a actualizar" +
                "1. id 2. Numero de hab 3. tipo de habitacion 4. Precio 5. Estado");

        BedRoom currentBedRoom = bedRoomService.getBedRoomById(id).orElseThrow(()-> new IllegalArgumentException(
                "Habitacion no existe"
        ));

        String room = currentBedRoom.getRoom();
        int typeId = currentBedRoom.getBedRoomType().getIdType();
        double price = currentBedRoom.getPrice();
        String state = currentBedRoom.getState();

        System.out.println("Habitación Actual" +"\n" +
                "id" + id + "\n" +
                "Numero" + room + "\n" +
                "Tipo" + typeId + "\n" +
                "Estado: " + state) ;


        switch (option){

            case 1:
                room = FormValidationUtil.validateString("Actualizar habitación");
                break;
            case 2:
                typeId = FormValidationUtil.validateInt("Ingrese el id del tipo a actulizar");
                break;
            case 3:
                price= FormValidationUtil.validateDouble("Ingrese el nuevo precio");
                break;
            case 4:
                state= BedRoomStateSelector.bedRoomAddState();
                break;
            default:
                System.out.println("Seleccione una opción valida");

        }



        bedRoomService.updateBedRoom(id,room,typeId,price,state );

    }


    public void deleteBedRoomById(){
        bedRoomService.deleteBedRoomById(FormValidationUtil.validateInt("Ingrese el id de habitación a eliminar"));
    }



}
