package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Gender {
    private int id;
    private String gender;

    public Gender(String gender) {
        this.gender = gender;
    }
}
