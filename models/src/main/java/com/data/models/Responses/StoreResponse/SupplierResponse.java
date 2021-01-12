package com.data.models.Responses.StoreResponse;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/27/2020  : 11:39
 */
public class SupplierResponse {
    private  int Id;
    private String SupplierName;
    private String SupplierNameAr;
    private String StoreName;
    private String StoreNameAr;
    private boolean status;

    public SupplierResponse() {
    }

    public SupplierResponse(int id, String supplierName, String supplierNameAr, String storeName, String storeNameAr, boolean status) {
        Id = id;
        SupplierName = supplierName;
        SupplierNameAr = supplierNameAr;
        StoreName = storeName;
        StoreNameAr = storeNameAr;
        this.status = status;
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

    public String getSupplierNameAr() {
        return SupplierNameAr;
    }

    public void setSupplierNameAr(String supplierNameAr) {
        SupplierNameAr = supplierNameAr;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getStoreNameAr() {
        return StoreNameAr;
    }

    public void setStoreNameAr(String storeNameAr) {
        StoreNameAr = storeNameAr;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
