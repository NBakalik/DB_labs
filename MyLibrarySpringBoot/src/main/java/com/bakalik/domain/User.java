package com.bakalik.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "zip_code")
    private String zipCode;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id", nullable = false)
    private Gender genderByGenderId;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City cityByCityId;

    @ManyToOne
    @JoinColumn(name = "user_card_id", referencedColumnName = "id", nullable = false)
    private UserCard userCardByUserCardId;

    public User(String name, String surname, String birthday, String streetAddress, String zipCode, String phone, String email, Gender genderByGenderId, City cityByCityId, UserCard userCardByUserCardId) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.phone = phone;
        this.email = email;
        this.genderByGenderId = genderByGenderId;
        this.cityByCityId = cityByCityId;
        this.userCardByUserCardId = userCardByUserCardId;
    }
}
