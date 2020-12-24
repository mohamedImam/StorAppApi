package com.store.Services;

import com.data.models.CommonResponse;
import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiExceptions.NoFoundException;
import com.data.models.Repositories.ProductRepository;
import com.data.models.store.Category;
import com.data.models.store.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/23/2020  : 13:27
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() throws Exception {
        List<Product>   productList=productRepository.findAll();
        if(productList.isEmpty()){throw new NoFoundException();}
        return productList;
    }

    public Product getProductById(long productId) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()){throw new NoFoundException();}
        return product.get();
    }

    public CommonResponse AddProduct(Product product) throws Exception {
        productRepository.save(product);
        return new CommonResponse(
                ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        );
    }
}
