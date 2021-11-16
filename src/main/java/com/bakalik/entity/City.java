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
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id", nullable = false)
    private Region regionByRegionId;

    public City(String name, Region regionByRegionId) {
        this.name = name;
        this.regionByRegionId = regionByRegionId;
    }
}
