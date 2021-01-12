package com.data.models.store.Heplers;

import javax.persistence.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/28/2020  : 17:34
 */
@Entity
public class StoreCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Currency_ID_SEQ")
    @SequenceGenerator(name = "Currency_ID_SEQ", sequenceName = "Currency_ID_SEQ", allocationSize = 1)
    private long id;
    private String currencyName;
    private String currencyNameAr;
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyNameAr() {
        return currencyNameAr;
    }

    public void setCurrencyNameAr(String currencyNameAr) {
        this.currencyNameAr = currencyNameAr;
    }
}
