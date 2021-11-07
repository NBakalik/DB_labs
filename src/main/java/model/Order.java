package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Order {
    private int id;
    private int userId;
    private String time;
    private int city;
    private int deliveryId;
    private double totalPrice;
    private int orderStatus;

    public Order(int userId, String time, int city, int deliveryId, double totalPrice, int orderStatus) {
        this.userId = userId;
        this.time = time;
        this.city = city;
        this.deliveryId = deliveryId;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
    }
}
