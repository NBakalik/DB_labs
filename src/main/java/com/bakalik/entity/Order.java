package com.bakalik.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "[order]", schema = "bakalik_db")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "time")
    private String time;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    private City cityByCityId;
    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "id", nullable = false)
    private Delivery deliveryByDeliveryId;
    @Column(name = "total_price")
    private Double totalPrice;
    @ManyToOne
    @JoinColumn(name = "order_status", referencedColumnName = "id", nullable = false)
    private OrderStatus orderStatusByOrderStatus;
    @ManyToMany
    @JoinTable(name = "order_has_item", catalog = "", schema = "bakalik_db",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id", nullable = false))
    @ToString.Exclude
    private Set<Item> items;

    public Order(Integer userId, String time, City cityByCityId, Delivery deliveryByDeliveryId, Double totalPrice, OrderStatus orderStatusByOrderStatus) {
        this.userId = userId;
        this.time = time;
        this.cityByCityId = cityByCityId;
        this.deliveryByDeliveryId = deliveryByDeliveryId;
        this.totalPrice = totalPrice;
        this.orderStatusByOrderStatus = orderStatusByOrderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Order order = (Order) o;
        return id != null && Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
