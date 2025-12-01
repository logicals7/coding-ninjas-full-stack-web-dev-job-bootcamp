package railway.com.example.RailwayAndMeal.communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import railway.com.example.RailwayAndMeal.Entity.Meal;

/*
 * 1. Create a method to get the Meal Details from meal service with the help
 * 	   of RestTemplate.
 * 2. Use getForEntity() method from the RestTemplate class.
 * 3. Make use of proper annotations to autowire.
 * 4. Use Postman app to test the APIs.
 */

@Service
public class MealServiceCommunicator {

    public RestTemplate restTemplate;
    private final String url = "http://localhost:8081/pantry/meal/";

    @Autowired
    MealServiceCommunicator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public Meal getMealByPnr(long pnr){
        //method-1 using the response entity class which returns the response with headers & body
        ResponseEntity<Meal> meal;
        meal = restTemplate.getForEntity(url+pnr, Meal.class);
        //method-2 using the getForObject which returns the requested object only
        //Meal meal = restTemplate.getForObject(url+pnr, Meal.class);
        return meal.getBody();
    }


	
	
}
