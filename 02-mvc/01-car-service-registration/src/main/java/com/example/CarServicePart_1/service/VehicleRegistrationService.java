package com.example.CarServicePart_1.service;

import com.example.CarServicePart_1.domain.Vehicle;

public interface VehicleRegistrationService {
    public Vehicle getVehicle();
    public void registerCar(String RegistrationNumber, String CarName, String CarDetails, String WorkDone);
}
