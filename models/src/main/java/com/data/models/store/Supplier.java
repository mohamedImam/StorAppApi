package com.data.models.store;

import javax.persistence.*;


@Entity
public class Supplier {
    //TODO:: One Supplier to Many Products

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SUPPLIER_ID_SEQ")
    @SequenceGenerator(name = "SUPPLIER_ID_SEQ", sequenceName = "SUPPLIER_ID_SEQ", allocationSize = 1)
    private  int Id;
    private String SupplierName;
    private String StoreName;
    private boolean status;

    public Supplier() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
