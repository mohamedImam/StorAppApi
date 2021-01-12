package com.data.models.store;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@SuppressWarnings("ALL")
@Entity
public class OrderDetails {
    //TODO:: One Order To Many Details
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_DETAILS_ID_SEQ")
    @SequenceGenerator(name = "ORDERS_DETAILS_ID_SEQ", sequenceName = "ORDERS_DETAILS_ID_SEQ" , allocationSize = 1)
    /*@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")*/
    private long  id ;
    private long productId;
    private double price;
    private int quantity;
    private long currency;
    @JsonIgnore
    private long orderId;
    private long storeId;

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }

    public long getCurrency() {
        return currency;
    }

    public void setCurrency(long currency) {
        this.currency = currency;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
/* @ManyToOne(
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "orders_id",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "fk_detials_orders_id"
            )
    )
    private Order order;*/

    public OrderDetails() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   /*public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
*/

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                '}';
    }
}
