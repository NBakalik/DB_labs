package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CardBonus {
    private int id;
    private String name;
    private Double discount;

    public CardBonus(String name, Double discount){
        this.name = name;
        this.discount = discount;
    }
}
