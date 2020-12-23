package com.data.models.Repositories;


import com.data.models.store.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository  extends JpaRepository<OrderDetails,Long> {
}
