package com.store.Controllers;

import com.data.models.Requests.StoreRequests.OrderRequest;
import com.data.models.Responses.MainResponse;
import com.store.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/27/2020  : 13:59
 */
@RestController
@RequestMapping("/store/Order")
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/newOrder")
    public MainResponse newOrder(@RequestBody OrderRequest orderRequest)
    {
       return orderService.newOrder(orderRequest);
    }
    @GetMapping("/GetProductQantity/{productId}")
    public MainResponse checkQantity (@PathVariable long productId)
    {
return orderService.checkQantity(productId);
    }

    @GetMapping("/GetOrderDetails/{orderId}")
    public MainResponse GetOrderDetails (@PathVariable long orderId)
    {
        return orderService.GetOrderDetails(orderId);
    }
}
