package com.example.CarServicePart_1.domain;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle {

    String RegisterationNumber;
    String CarName;
    String CarDetails;
    String CarWork;
    Integer CarId;

    public String getRegisterationNumber() {
        return RegisterationNumber;
    }

    public void setRegisterationNumber(String registerationNumber) {
        RegisterationNumber = registerationNumber;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String carName) {
        CarName = carName;
    }

    public String getCarDetails() {
        return CarDetails;
    }

    public void setCarDetails(String carDetails) {
        CarDetails = carDetails;
    }

    public String getCarWork() {
        return CarWork;
    }

    public void setCarWork(String carWork) {
        CarWork = carWork;
    }

    public Integer getCarId() {
        return CarId;
    }

    public void setCarId(Integer carId) {
        CarId = carId;
    }

    @Override
    public Boolean saveVehicleDetails() {
        System.out.println("Saving Car Details for Registration Number: " + this.RegisterationNumber);
        return true;
    }

    @Override
    public void createVehicle(String registrationNumber, String carName, String carDetails, String carWork) {
        setRegisterationNumber(registrationNumber);
        setCarName(carName);
        setCarDetails(carDetails);
        setCarWork(carWork);
    }
}