package com.coding.models;

public class Item {

    private Integer itemId;
    private Integer id; //Clé étrangère de la table users
    private String name;
    private String description;
    private Integer quantity;

    public int getItemId() {return itemId;}
    public void setItemId(Integer itemId) {this.itemId = itemId;}

    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {return quantity;}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}
}