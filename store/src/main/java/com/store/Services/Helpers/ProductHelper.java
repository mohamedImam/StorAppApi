package com.store.Services.Helpers;

import com.data.models.Repositories.Store.ProductRepository;
import com.data.models.Repositories.Store.StockRepository;
import com.data.models.store.Product;
import com.data.models.store.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/28/2020  : 12:39
 */
@Service
public class ProductHelper {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    StockRepository stockRepository;

    public boolean isAvailable (long productId)
    {
        System.out.println(productId+"********************************");
      //  Optional<Product> product=productRepository.findById(productId);
        Optional<Product> product = productRepository.findById(productId);
        if(!product.isEmpty())
        {
            Stock stock=stockRepository.findByProductId(productId);
            if (stock.getQuantity()>0)
            {return true;}
        }

            return false;

    }
}
