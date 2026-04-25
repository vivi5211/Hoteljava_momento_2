package application.view;

import application.domain.BedRoomType;
import application.service.outputs.BedRoomTypeService;
import application.util.FormValidationUtil;

import java.util.List;

public class BedRoomTypeView {

    private final BedRoomTypeService bedRoomTypeService;

    public BedRoomTypeView(BedRoomTypeService bedRoomTypeService) {
        this.bedRoomTypeService = bedRoomTypeService;
    }

    public void createBedRoomType() {
        System.out.println("Crear tipo de habitación");
        try {
            int idType = FormValidationUtil.validateInt("Ingrese el id del tipo");
            String type = FormValidationUtil.validateString("Ingrese el nombre del tipo");
            BedRoomType created = bedRoomTypeService.createBedRoomType(idType, type);
            System.out.println("Tipo creado: " + created.getIdType() + " - " + created.getType());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateBedRoomType() {
        System.out.println("Actualizar tipo de habitación");
        try {
            int id = FormValidationUtil.validateInt("Ingrese el id del tipo a actualizar");
            String type = FormValidationUtil.validateString("Ingrese el nuevo nombre del tipo");
            BedRoomType updated = bedRoomTypeService.updateBedRoomType(id, type);
            System.out.println("Tipo actualizado: " + updated.getIdType() + " - " + updated.getType());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void getBedRoomTypeById() {
        System.out.println("Buscar tipo por Id");
        BedRoomType bedRoomType = bedRoomTypeService
                .getBedRoomTypeById(FormValidationUtil.validateInt("Ingrese el id del tipo"))
                .orElseThrow(() -> new IllegalArgumentException("Tipo de habitación no encontrado"));
        System.out.println(bedRoomType.getIdType() + " - " + bedRoomType.getType());
    }

    public void getAllBedRoomTypes() {
        System.out.println("Todos los tipos de habitación:");
        List<BedRoomType> list = bedRoomTypeService.getAllBedRoomTypes();
        for (BedRoomType b : list) {
            System.out.println(b.getIdType() + " - " + b.getType());
        }
    }

    public void deleteBedRoomTypeById() {
        bedRoomTypeService.deleteBedRoomTypeById(
                FormValidationUtil.validateInt("Ingrese el id del tipo a eliminar"));
    }
}

