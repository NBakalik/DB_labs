package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Region {
    private int id;
    private String region;

    public Region(String region) {
        this.region = region;
    }
}
