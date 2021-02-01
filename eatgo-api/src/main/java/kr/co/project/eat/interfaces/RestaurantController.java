package kr.co.project.eat.interfaces;


import kr.co.project.eat.application.RestaurantService;
import kr.co.project.eat.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@CrossOrigin
@RestController
public class RestaurantController {

    public static final String address = "Seoul";
    @Autowired
    private RestaurantService restaurantService;


    @GetMapping("/restaurants")
    public List<Restaurant> list(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;

    }
    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id){
       Restaurant restaurant = restaurantService.getRestaurant(id);
        //기본정보 + 메뉴 정보 .

//        Restaurant restaurant = restaurantRepository.findById(id);
//
//        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
//        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@RequestBody Restaurant resource) throws URISyntaxException {
        String name = resource.getName();
        String address = resource.getAddress();

        Restaurant restaurant = new Restaurant( name,address);
        restaurantService.addRestaurant(restaurant);

        URI location = new URI("/restaurants/" + restaurant.getId());
        return ResponseEntity.created(location).body("{}");
    }

}
