package com.data.models.store;

import javax.persistence.*;


@Entity
public class Suppliers {
    //TODO:: One Supplier to Many Products

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPPLIER_ID_SEQ")
    @SequenceGenerator(name = "SUPPLIER_ID_SEQ", sequenceName = "SUPPLIER_ID_SEQ", allocationSize = 1)
    private  int Id;
    private String supplierName;
    private String supplierNameAr;
    private String storeName;
    private String storeNameAr;
    private boolean status;

    public Suppliers() {
    }

    public String getSupplierNameAr() {
        return supplierNameAr;
    }

    public void setSupplierNameAr(String supplierNameAr) {
        this.supplierNameAr = supplierNameAr;
    }

    public String getStoreNameAr() {
        return storeNameAr;
    }

    public void setStoreNameAr(String storeNameAr) {
        this.storeNameAr = storeNameAr;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
