package com.example.CarService.Controller;

import com.example.CarService.domain.Car;
import com.example.CarService.service.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @Autowired
    private Registration registration;

/**
 1. Modify the below funtion.
 2. getRegistrationPage method accepts Model as argument.
**/

    @RequestMapping("/register")
    public String getRegistrationPage(Model model){
        model.addAttribute("car", registration.getNewCar());
        return "carregister";
    }


  /*
   1. getResponsePage method uses registerCar() method to register the car submitted from carregsiter.jsp.
   2. It should return "success" if registerCar() return true else it should return "carregister".
   3. getResponsePage method uses @ModelAttribute annotation to bind data with reference to car domain.
  */
    @RequestMapping("/done")
    public String getResponsePage(@ModelAttribute("car") Car car){
        // 1. Write an if-else condition to check the input from the form.
        // The business logic for checking inputs and registering is now in the service layer.
        // We call the service layer's registerCar method.
        if(registration.registerCar(car.getRegisterationNumber(), car.getCarName(), car.getCarDetails(), car.getCarWork())){
            return "success";
        }
        else{
            return "carregister";
        }
    }
}
