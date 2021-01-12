package com.data.models.store;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/28/2020  : 15:09
 */
@SuppressWarnings("ALL")
@Entity
public class Brands implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRANDS_ID_SEQ")
    @SequenceGenerator(name = "BRANDS_ID_SEQ", sequenceName = "BRANDS_ID_SEQ", allocationSize = 1)
    private long id;
    private String brandName;
    private String brandNameAr;
    private String description;
    private String   brandMade;
    private String   brandImage;
    private long categoryId;

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandNameAr() {
        return brandNameAr;
    }

    public void setBrandNameAr(String brandNameAr) {
        this.brandNameAr = brandNameAr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandMade() {
        return brandMade;
    }

    public void setBrandMade(String brandMade) {
        this.brandMade = brandMade;
    }


}
