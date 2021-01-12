package com.data.models.Requests.Delivery;

import com.data.models.delivery.LocationPoint;

import javax.persistence.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 01/03/2021  : 11:34
 */
@Entity
public class DeliveryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DELIVERY_DETAILS_ID_SEQ")
    @SequenceGenerator(name = "DELIVERY_DETAILS_ID_SEQ", sequenceName = "DELIVERY_DETAILS_ID_SEQ", allocationSize = 1)
    private long id;
    private long deliveryOrderId;
    private  long orderId;
    private /*LocationPoint*/String storLocation;
    private  /*LocationPoint*/String  customerLocation;
    private String packageSize;
    private  long storeId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(long deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getStorLocation() {
        return storLocation;
    }

    public void setStorLocation(String storLocation) {
        this.storLocation = storLocation;
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation;
    }

    public String getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }
}

