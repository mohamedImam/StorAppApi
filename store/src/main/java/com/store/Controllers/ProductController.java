package com.store.Controllers;

import com.data.models.Responses.CommonResponse;
import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiExceptions.NoFoundException;
import com.data.models.Responses.MainResponse;
import com.data.models.store.Product;
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
    public MainResponse getAllProduct() {
      //  try {
            return productService.getAllProducts();
        //}catch (Exception e){ throw new Exception("e.getMessage(");}

    }

    @GetMapping("/getProductById/{productId}")
    public MainResponse getProductById(@PathVariable long productId)
    {return  productService.getProductById(productId); }

    @PostMapping("/newProduct")
    public CommonResponse newCategory(@RequestBody Product product)  {
        try { return productService.newProduct(product);
        }catch (Exception e){ return new CommonResponse(ConstantClass.ErorrMesseges.FailMes+" - "+e.getMessage(),ConstantClass.ErorrCodes.FAIL_CODE,ConstantClass.StatusMesseges.FalseStatus,ConstantClass.HelperClass.getUUID()); }
    }
    @GetMapping("/getProductByCategory/{categoryId}")
    public MainResponse getProductByCategory(@PathVariable long categoryId)
    {return  productService.getProductByCategory(categoryId); }

    @GetMapping("/getProductByBrand/{brandId}")
    public MainResponse getProductByBrand(@PathVariable long brandId)
    {return  productService.getProductByBrand(brandId); }


    @GetMapping("/getProductByCustomer/{customerId}")
    public MainResponse getProductByCustomer(@PathVariable long customerId)
    {return  productService.getProductByCustomer(customerId); }

    @GetMapping("/getProductByCustomer/{customerId}/ProductId/{productId}")
  //  @GetMapping("/getProductByCustomerAndProductId/{customerId}")
    public MainResponse getProductByCustomerAndProductId(@PathVariable long customerId,@PathVariable long productId)
    {return  productService.getProductByCustomerAndProductId(customerId,productId); }
}
