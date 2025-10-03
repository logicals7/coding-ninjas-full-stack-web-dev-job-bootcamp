package com.example.CarService.service;

import com.example.CarService.domain.Vehicle;
import com.example.CarService.repository.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**

 1. Implement the interface Registration and Override the method registerCar() and getNewCar() in CarRegistrationService.
 2. Also,autowire car of type Vehicle and use it in method registerCar() and getNewCar().

**/

@Service
public class CarRegistrationService implements Registration {

    @Autowired
    private Vehicle car;

    @Override
    public Boolean registerCar(String vehicleNo, String vehicleName, String CarDetails, String CarWork) {
        if (vehicleNo == null || vehicleNo.trim().isEmpty()) {
            // Fails validation, returns false, controller sends back "carregister"
            return false;
        }
        car.createVehicle(vehicleNo, vehicleName, CarDetails, CarWork);
        return car.saveVehicleDetails();
    }

    @Override
    public Vehicle getNewCar() {
        return this.car;
    }
}
