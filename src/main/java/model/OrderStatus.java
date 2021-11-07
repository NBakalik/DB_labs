package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderStatus {
    private int id;
    private String status;

    public OrderStatus(String status) {
        this.status = status;
    }
}
