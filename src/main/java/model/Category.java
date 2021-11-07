package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Category {
    private int id;
    private String name;

    public Category(String name){
        this.name = name;
    }
}
