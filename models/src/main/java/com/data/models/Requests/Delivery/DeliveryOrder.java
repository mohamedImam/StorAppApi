package com.data.models.Requests.Delivery;

import javax.persistence.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 01/03/2021  : 19:51
 */
@Entity
public class DeliveryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIVERY_ID_SEQ")
    @SequenceGenerator(name = "DELIVERY_ID_SEQ", sequenceName = "DELIVERY_ID_SEQ", allocationSize = 1)
    private  long id;
    private  String deliveryCompany;
    private double deliveryPrice;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    //private  DeliveryDetails details;
}
