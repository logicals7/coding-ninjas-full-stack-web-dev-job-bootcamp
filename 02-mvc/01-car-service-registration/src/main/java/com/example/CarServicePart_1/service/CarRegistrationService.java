package com.example.CarServicePart_1.service;

import com.example.CarServicePart_1.domain.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

public class CarRegistrationService implements VehicleRegistrationService{

    @Autowired
    Vehicle car;


    @Override
    public Vehicle getVehicle() {
        return car;
    }

    @Override
    public void registerCar(String RegistrationNumber, String CarName, String CarDetails, String WorkDone) {
        car.createVehicle(RegistrationNumber, CarName, CarDetails, WorkDone);
        car.saveVehicleDetails();
    }
}
