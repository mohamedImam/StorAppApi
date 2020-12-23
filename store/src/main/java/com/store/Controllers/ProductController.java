package com.store.Controllers;

import com.data.models.CommonResponse;
import com.data.models.ConstantClass;
import com.data.models.store.Category;
import com.data.models.store.Product;
import com.store.Services.CategoryService;
import com.store.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/23/2020  : 13:27
 */
@RestController
@RequestMapping("/store/Product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/getAllProduct")
    public List<Product> getAllProduct()
    { return  productService.getAllProducts(); }

    @GetMapping("/getProductById")
    public Product getProductById(@PathVariable long productId)
    {return  productService.getProductById(productId); }

    @PostMapping("/AddProduct")
    public CommonResponse AddCategory(@RequestBody Product product)  {
        try { return productService.AddProduct(product);
        }catch (Exception e){ return new CommonResponse(ConstantClass.ErorrMesseges.FailMes+" - "+e.getMessage(),ConstantClass.ErorrCodes.FailCode,ConstantClass.StatusMesseges.FalseStatus,ConstantClass.HelperClass.getUUID()); }
    }
}
