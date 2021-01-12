package com.data.models.Repositories.Store;


import com.data.models.store.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailsRepository  extends JpaRepository<OrderDetails,Long> {
    List<OrderDetails> findByOrderId(long orderId);
    OrderDetails deleteByOrderId(long orderId);
}
