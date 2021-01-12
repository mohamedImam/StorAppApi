package com.data.models.Responses.StoreResponse;

import com.data.models.Requests.StoreRequests.OrderRequest;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/28/2020  : 10:39
 */
public class OrderDetailsResponse extends OrderRequest {
    private String dataTime;
    private double totalPrice;
    private long currency;

    public long getCurrency() {
        return currency;
    }

    public void setCurrency(long currency) {
        this.currency = currency;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
