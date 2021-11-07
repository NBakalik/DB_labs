package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserCard {
    private int id;
    private String name;

    public UserCard(String name) {
        this.name = name;
    }
}
