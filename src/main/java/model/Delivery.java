package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Delivery {
    private int id;
    private String name;

    public Delivery(String name) {
        this.name = name;
    }
}
