package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String surname;
    private String date;
    private int genderId;
    private int cityId;
    private String streetAddress;
    private String zipCode;
    private String phone;
    private String email;
    private String registeredAt;
    private int userCardId;

    public User(String name, String surname, String date, int genderId, int cityId, String streetAddress, String zipCode, String phone, String email, String registeredAt, int userCardId) {
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.genderId = genderId;
        this.cityId = cityId;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
        this.registeredAt = registeredAt;
        this.userCardId = userCardId;
    }
}
