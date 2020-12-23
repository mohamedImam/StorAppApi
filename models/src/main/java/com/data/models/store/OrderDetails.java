package com.data.models.store;

import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
public class OrderDetails {
    //TODO:: One Order To Many Details
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDERS_DETAILS_ID_SEQ")
    @SequenceGenerator(name = "ORDERS_DETAILS_ID_SEQ", sequenceName = "ORDERS_DETAILS_ID_SEQ" , allocationSize = 1)
    private long id;
    private long serialno;

    @ManyToOne(
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
    private Order order;

    public OrderDetails() {
    }

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

    public long getSerialno() {
        return serialno;
    }

    public void setSerialno(long serialno) {
        this.serialno = serialno;
    }
    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", order=" + order +
                '}';
    }
}
