package kr.co.project.eat.interfaces;


import kr.co.project.eat.application.RestaurantService;
import kr.co.project.eat.domain.MenuItem;
import kr.co.project.eat.domain.MenuItemRepository;
import kr.co.project.eat.domain.Restaurant;
import kr.co.project.eat.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

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
}
