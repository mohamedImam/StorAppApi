package com.store.Controllers;

import com.data.models.Responses.MainResponse;
import com.data.models.store.Suppliers;
import com.store.Services.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/27/2020  : 11:33
 */
@RestController
@RequestMapping("/store/Supplier")
@CrossOrigin(origins = "*")
public class SuppliersController {
    @Autowired
    SuppliersService suppliersService;

    @GetMapping("/getAllSuppliers")
    public MainResponse getAllSuppliers()
    {
        return  suppliersService.getAllSuppliers();
    }
    @GetMapping("/getSupplierById/{productId}")
    public MainResponse getSupplierById(@PathVariable int productId)
    {
        return  suppliersService.getSupplierById(productId);
    }
    @PostMapping("/AddSupplier")
    public MainResponse AddSupplier(@RequestBody Suppliers supplier)
    {
        System.out.println(supplier.getSupplierNameAr()+"------------------");
        return  suppliersService.AddSupplier(supplier);
    }
}
