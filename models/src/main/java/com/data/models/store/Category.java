package com.data.models.store;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ID_SEQ")
    @SequenceGenerator(name = "CATEGORY_ID_SEQ", sequenceName = "CATEGORY_ID_SEQ", allocationSize = 1)
    private long id;
    private String categoryName;
    private String imageName;
    private String description;
    private boolean status;
    private int parentId; // only used if category has  sub-category thus this category refer to another one

   // @CreationTimestamp
    private String createdAt;
   // @UpdateTimestamp
    private String updatedAt;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "category_product",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id")})
    @JsonIgnore
    private List<Product> products = new ArrayList<>();

    //TODO : add many to many relationship with products

   public Category(){
        super();
    }

    public Category(String categoryName, String imageName, String description, boolean status, int parentId, String createdAt, String updatedAt) {
        this.categoryName = categoryName;
        this.imageName = imageName;
        this.description = description;
        this.status = status;
        this.parentId = parentId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
