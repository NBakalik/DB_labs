package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SubCategory {
    private Integer id;
    private Integer categoryId;
    private String name;

    public SubCategory(Integer categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }
}
