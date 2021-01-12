package com.data.models.Repositories.Store;

import com.data.models.store.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product>  findByCategoryId(long categoryId);
    List<Product>  findByBrandId(long brandId);
}
