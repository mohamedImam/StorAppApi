package com.store.Controllers;

import com.data.models.Requests.StoreRequests.ChangeCustomerPasswordRequest;
import com.data.models.Responses.MainResponse;
import com.data.models.store.Customer;
import com.data.models.store.CustomerProducts;
import com.store.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/27/2020  : 19:00
 */
@RestController
@RequestMapping("/store/Customer")
@CrossOrigin(origins = "*")
public class CustomersController {
@Autowired
    CustomerService customerService;
    @PostMapping("/newCustomer")
    public MainResponse newCustomer(@RequestBody Customer customer)
    { return customerService.newCustomer(customer); }

    @GetMapping("/GetCustomerById/{customerId}")
    public MainResponse newCustomer(@PathVariable long customerId)
    { return customerService.GetCustomerById(customerId); }

    @PostMapping("/ChangePassword")
    public MainResponse ChangeCustomerPassword(@RequestBody ChangeCustomerPasswordRequest changeCustomerPasswordRequest)
    { return customerService.ChangePassword(changeCustomerPasswordRequest); }

    @PostMapping("/newCusomerProduct")
    public MainResponse NewCusomerProduct(@RequestBody CustomerProducts customerProducts)
    { return customerService.NewCusomerProduct(customerProducts);}


}
