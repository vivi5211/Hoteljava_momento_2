package application.configuration;

import application.repository.*;
import application.service.*;
import application.service.outputs.*;
import application.service.ports.*;
import application.userinterface.MenuApp;
import application.view.*;

public class Config {

    public static MenuApp createMenuApp() {

        // BedRoomType
        BedRoomTypeRepositoryPort bedRoomTypeRepositoryPort = new BedRoomTypeRepository();
        BedRoomTypeService bedRoomTypeService = new BedRoomTypeServiceImpl(bedRoomTypeRepositoryPort);
        BedRoomTypeView bedRoomTypeView = new BedRoomTypeView(bedRoomTypeService);

        // BedRoom
        BedRoomRepositoryPort bedRoomRepositoryPort = new BedRoomRepository();
        BedRoomService bedRoomService = new BedRoomServiceImp(bedRoomRepositoryPort, bedRoomTypeRepositoryPort);
        BedRoomView bedRoomView = new BedRoomView(bedRoomService);

        // Guest
        GuestRepositoryPort guestRepositoryPort = new GuestRepository();
        GuestService guestService = new GuestServiceImpl(guestRepositoryPort);
        GuestView guestView = new GuestView(guestService);

        // Employee
        EmployeeRepositoryPort employeeRepositoryPort = new EmployeeRepository();
        EmployeeService employeeService = new EmployeeServiceImpl(employeeRepositoryPort);
        EmployeeView employeeView = new EmployeeView(employeeService);

        return new MenuApp(guestView, bedRoomView, bedRoomTypeView, employeeView);
    }
}