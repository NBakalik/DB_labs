package com.bakalik.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "sub_category_id", referencedColumnName = "id", nullable = false)
    private SubCategory subCategoryBySubCategoryId;
    @ManyToMany(mappedBy = "items")
    @ToString.Exclude
    private Set<Order> orders;

    public Item(String name, String description, String brand, String model, Double price, SubCategory subCategoryBySubCategoryId) {
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.subCategoryBySubCategoryId = subCategoryBySubCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Item item = (Item) o;
        return id != null && Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
