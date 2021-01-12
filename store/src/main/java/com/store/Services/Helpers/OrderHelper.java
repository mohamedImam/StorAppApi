package com.store.Services.Helpers;

import com.data.models.Repositories.Store.OrderDetailsRepository;
import com.data.models.Repositories.Store.OrderRepository;
import com.data.models.Responses.StoreResponse.OrderDetailsResponse;
import com.data.models.store.Order;
import com.data.models.store.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/29/2020  : 19:46
 */
@Service
public class OrderHelper {
    @Autowired
    OrderRepository orderRepository;
    OrderDetailsRepository orderDetailsRepository;

    public void rollbackOrder(Order order) {
        try {
            orderRepository.delete(order);
            orderDetailsRepository.deleteByOrderId(order.getId());
        } catch (Exception e) {
   e.getMessage();
        }
    }
}
