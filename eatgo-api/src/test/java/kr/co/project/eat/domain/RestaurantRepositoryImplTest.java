package kr.co.project.eat.domain;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RestaurantRepositoryImplTest {

    @Test
    public void save(){
        RestaurantRepository repository = new RestaurantRepositoryImpl();

        int oldCount = repository.findAll().size();

        Restaurant restaurant = new Restaurant("Beryong","Seoul");
        repository.save(restaurant);

        assertThat(restaurant.getId(),is(1234L));

        int newCount = repository.findAll().size();

        assertThat(newCount - oldCount, is(1));
    }
}