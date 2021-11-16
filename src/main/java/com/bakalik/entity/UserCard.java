package com.bakalik.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Table(name = "user_card", schema = "bakalik_db", catalog = "")
public class UserCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "bonus")
    private Integer bonus;

    public UserCard(String name, Integer bonus) {
        this.name = name;
        this.bonus = bonus;
    }
}
