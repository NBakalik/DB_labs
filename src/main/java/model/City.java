package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class City {
    private int id;
    private String name;
    private int region;

    public City(String name, int region) {
        this.name = name;
        this.region = region;
    }
}
