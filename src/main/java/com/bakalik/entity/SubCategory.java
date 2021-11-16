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
@Table(name = "sub_category", schema = "bakalik_db", catalog = "")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category categoryByCategoryId;

    public SubCategory(String name, Category categoryByCategoryId) {
        this.name = name;
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
