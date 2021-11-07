package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Item {
    private int id;
    private String name;
    private String description;
    private String image;
    private String brand;
    private String model;
    private String configuration;
    private double price;
    private int subCategory;

    public Item(String name, String description, String image, String brand, String model, String configuration, double price, int subCategory) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.brand = brand;
        this.model = model;
        this.configuration = configuration;
        this.price = price;
        this.subCategory = subCategory;
    }
}
