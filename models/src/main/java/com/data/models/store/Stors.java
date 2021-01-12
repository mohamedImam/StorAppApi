package com.data.models.store;

import com.data.models.delivery.LocationPoint;

import javax.persistence.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 01/03/2021  : 11:04
 */
@SuppressWarnings("ALL")
@Entity
public class Stors {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_ID_SEQ")
    @SequenceGenerator(name = "STORE_ID_SEQ", sequenceName = "STORE_ID_SEQ", allocationSize = 1)
    private long Id;
    private String storeName;
    private String storeNameAr;
    private String StoreLocation;

    public Stors() {
    }

    public Stors(long id, String storeName, String storeNameAr, String storeLocation) {
        Id = id;
        this.storeName = storeName;
        this.storeNameAr = storeNameAr;
        StoreLocation = storeLocation;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreNameAr() {
        return storeNameAr;
    }

    public void setStoreNameAr(String storeNameAr) {
        this.storeNameAr = storeNameAr;
    }

    public String getStoreLocation() {
        return StoreLocation;
    }

    public void setStoreLocation(String storeLocation) {
        StoreLocation = storeLocation;
    }
}

