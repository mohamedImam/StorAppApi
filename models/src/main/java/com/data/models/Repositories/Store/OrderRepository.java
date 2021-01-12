package com.data.models.Repositories.Store;

import com.data.models.store.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
