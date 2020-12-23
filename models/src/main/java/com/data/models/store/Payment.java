package com.data.models.store;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    //TODO:: EITHER CONNECT TO CUSTOMER BY ONE TO MANY
    //TODO:: CONNECT TO ORDER ONE TO ONE ( EVERY ORDER HAS ONE PAYMENT)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENT_ID_SEQ")
    @SequenceGenerator(name = "PAYMENT_ID_SEQ", sequenceName = "PAYMENT_ID_SEQ", allocationSize = 1)
    private long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
