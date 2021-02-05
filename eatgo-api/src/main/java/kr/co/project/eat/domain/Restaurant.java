package kr.co.project.eat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.internal.build.AllowPrintStacktrace;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Restaurant {
    @Id
    @GeneratedValue
    private  Long id;
    private  String name;
    private  String address;

    @Transient
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();


    public Restaurant(Long id,String name,String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public String getAddress () {

        return address;
    }

    public String getInformation() {

        return name +" in " + address;
    }

    public void setId(long id) {

        this.id = id;
    }

    public List<MenuItem> getMenuItems(){

        return menuItems;
    }


    public void addMenuItem(MenuItem menuItem) {

        menuItems.add(menuItem);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        for(MenuItem menuItem : menuItems){
            addMenuItem(menuItem);
        }
    }

}
