package com.delivery.Controllers;

import com.data.models.Responses.MainResponse;
import com.delivery.Services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/22/2020  : 19:13
 */
@RestController
@RequestMapping("/store/Delivery")
@CrossOrigin(origins = "*")
public class DeliveryController {
    @Autowired
    DeliveryService deliveryService;




}
