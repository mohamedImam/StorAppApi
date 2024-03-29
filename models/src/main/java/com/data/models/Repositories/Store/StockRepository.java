package com.data.models.Repositories.Store;

import com.data.models.store.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {

    Stock findByProductId(long prodId);
}
