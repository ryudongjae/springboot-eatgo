package kr.co.project.eat.domain;

import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;

import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private  Long id;
    private  String name;
    private  String address;
    private List<MenuItem> menuItems = new ArrayList<MenuItem>();


    public Restaurant(String name, String address) {
        this.name =name;
        this.address =address;
    }

    public Restaurant(Long id,String name,String address) {
        this.id = id;
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


    public void setId(long id) {
        this.id = id;
    }
}
