package com.store.Services;

import com.data.models.Repositories.Store.BrandRepository;
import com.data.models.Repositories.Store.CurrencyRepository;
import com.data.models.Repositories.Store.CustomerProductRepository;
import com.data.models.Responses.CommonResponse;
import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiExceptions.NoFoundException;
import com.data.models.Repositories.Store.ProductRepository;
import com.data.models.Responses.MainResponse;
import com.data.models.Responses.StoreResponse.ProductResponse;
import com.data.models.store.CustomerProducts;
import com.data.models.store.Heplers.StoreCurrency;
import com.data.models.store.Product;
import com.store.Services.Helpers.CurrencyService;
import com.store.Services.Helpers.ProductHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private ProductHelper helper ;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    CustomerProductRepository customerProductRepository;
    @Autowired
    CurrencyService currencyService;

    public MainResponse getAllProducts() {
        MainResponse mainResponse=new MainResponse();
        List<ProductResponse> productResponseList=new ArrayList<ProductResponse>() ;

        List<Product>   productList=productRepository.findAll();
        if(productList.isEmpty()){throw new NoFoundException();}
        productList.forEach(product ->
        {System.out.println(product.getId()+"********************************");
            if(helper.isAvailable(product.getId())) {
                ProductResponse response = new ProductResponse();
                response.setId(product.getId());
                response.setProductName(product.getProductName());
                response.setDescription(product.getDescription());
                response.setPrice(product.getPrice());
                response.setProductNameAr(product.getProductNameAr());
                response.setDiscountPrice(product.getDiscountPrice());
                response.setStatus(product.getStatus());
                response.setCategoryId(product.getCategoryId());
                response.setCurrency(currencyService.getCurrencyName(product.getCurrency()));
                productResponseList.add(response);
            }
        });
                mainResponse.setData(productResponseList);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
            return mainResponse;
    }

    public MainResponse getProductById(long productId) {
        ProductResponse response = new ProductResponse();
        MainResponse mainResponse = new MainResponse();
        Optional<Product> product = productRepository.findById(productId);
        if (product.isEmpty()) {throw new NoFoundException();}
        Product product1 =product.get();
        response.setId(product1.getId());
        response.setProductName(product1.getProductName());
        response.setDescription(product1.getDescription());
        response.setPrice(product1.getPrice());
        response.setProductNameAr(product1.getProductNameAr());
        response.setDiscountPrice(product1.getDiscountPrice());
        response.setStatus(product1.getStatus());
        response.setCategoryId(product1.getCategoryId());
        response.setCurrency(currencyService.getCurrencyName(product1.getCurrency()));
        mainResponse.setData(response);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }

    public CommonResponse newProduct(Product product) throws Exception {
        productRepository.save(product);
        return new CommonResponse(
                ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        );
    }
    public  MainResponse getProductByCategory (long categoryId)
    {MainResponse mainResponse=new MainResponse();
        List<ProductResponse> productResponseList=new ArrayList<ProductResponse>() ;
        List<Product> productList= productRepository.findByCategoryId(categoryId);
        if(productList.isEmpty()){throw new NoFoundException();}
        productList.forEach(product ->
        {
            if(helper.isAvailable(product.getId())) {
                ProductResponse response = new ProductResponse();
                response.setId(product.getId());
                response.setProductName(product.getProductName());
                response.setDescription(product.getDescription());
                response.setPrice(product.getPrice());
                response.setProductNameAr(product.getProductNameAr());
                response.setDiscountPrice(product.getDiscountPrice());
                response.setStatus(product.getStatus());
                response.setCategoryId(product.getCategoryId());
                response.setCurrency(currencyService.getCurrencyName(product.getCurrency()));
                productResponseList.add(response);
            }
        });
        mainResponse.setData(productResponseList);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }

    public  MainResponse getProductByBrand (long brandId)
    {MainResponse mainResponse=new MainResponse();
        List<ProductResponse> productResponseList=new ArrayList<ProductResponse>() ;
        List<Product> productList= productRepository.findByBrandId(brandId);
        if(productList.isEmpty()){throw new NoFoundException();}
        productList.forEach(product ->
        {
            if(helper.isAvailable(product.getId())) {
                ProductResponse response = new ProductResponse();
                response.setId(product.getId());
                response.setProductName(product.getProductName());
                response.setDescription(product.getDescription());
                response.setPrice(product.getPrice());
                response.setProductNameAr(product.getProductNameAr());
                response.setDiscountPrice(product.getDiscountPrice());
                response.setStatus(product.getStatus());
                response.setCategoryId(product.getCategoryId());
                response.setCurrency(currencyService.getCurrencyName(product.getCurrency()));
                productResponseList.add(response);
            }
        });
        mainResponse.setData(productResponseList);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }
    public MainResponse getProductByCustomer(long customerId)
    {
        /*********************/
        MainResponse mainResponse=new MainResponse();
        List<CustomerProducts> customerProducts = customerProductRepository.findByCustomerId(customerId);
        if (customerProducts.isEmpty()) {
            throw new NoFoundException();
        }
        customerProducts.forEach(customerProducts1 -> {
                    CustomerProducts response=new CustomerProducts();
                    response.setId(customerProducts1.getId());
                    response.setProductName(customerProducts1.getProductName());
                    response.setDescription(customerProducts1.getDescription());
                    response.setPrice(customerProducts1.getPrice());
                    response.setProductNameAr(customerProducts1.getProductNameAr());
                    response.setDiscountPrice(customerProducts1.getDiscountPrice());
                    response.setStatus(customerProducts1.getStatus());
                    response.setCategoryId(customerProducts1.getCategoryId());
                    response.setCurrency(customerProducts1.getCurrency());
                    mainResponse.setData(response);
                });
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }

    public MainResponse getProductByCustomerAndProductId(long customerId,long productId)
    {
        MainResponse mainResponse=new MainResponse();
        ProductResponse response=new ProductResponse();
        CustomerProducts customerProducts=customerProductRepository.findByCustomerIdAndId(customerId,productId);
        if (customerProducts==null){throw new NoFoundException();}
        response.setId(customerProducts.getId());
        response.setProductName(customerProducts.getProductName());
        response.setDescription(customerProducts.getDescription());
        response.setPrice(customerProducts.getPrice());
        response.setProductNameAr(customerProducts.getProductNameAr());
        response.setDiscountPrice(customerProducts.getDiscountPrice());
        response.setStatus(customerProducts.getStatus());
        response.setCategoryId(customerProducts.getCategoryId());
        response.setCurrency(currencyService.getCurrencyName(customerProducts.getCurrency()));
    mainResponse.setData(response);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }
    }
