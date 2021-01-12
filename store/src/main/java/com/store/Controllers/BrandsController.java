package com.store.Controllers;

import com.data.models.Responses.MainResponse;
import com.data.models.store.Brands;
import com.store.Services.BrandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/28/2020  : 15:27
 */
@RestController
@RequestMapping("/store/Brands")
@CrossOrigin(origins = "*")
public class BrandsController {
    @Autowired
    BrandsService brandsService;

    @GetMapping("/getAllBrands")
    public MainResponse getAllBrands()
    {
        return brandsService.getAllBrands();
    }
    @PostMapping("/newBrand")
    public MainResponse newBrands(@RequestBody Brands brands)
    {
        return brandsService.newBrands( brands);
    }
}
