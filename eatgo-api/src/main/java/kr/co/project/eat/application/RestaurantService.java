package kr.co.project.eat.application;

import kr.co.project.eat.domain.MenuItem;
import kr.co.project.eat.domain.MenuItemRepository;
import kr.co.project.eat.domain.Restaurant;
import kr.co.project.eat.domain.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    MenuItemRepository  menuItemRepository;


    public RestaurantService(RestaurantRepository restaurantRepository, MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }
    public List<Restaurant> getRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }

    public Restaurant getRestaurant(Long id){
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        //기본정보 + 메뉴 정보 .

        List<MenuItem> menuItems = menuItemRepository.findAllByRestaurantId(id);
        restaurant.setMenuItems(menuItems);

        return restaurant;
    }

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
//    @Transactional
//    public Restaurant updateRestaurant(Long id, Long categoryId,
//                                       String name, String address) {
//        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);
//
//        restaurant.updateInformation(categoryId, name, address);
//
//        return restaurant;
//    }

}
