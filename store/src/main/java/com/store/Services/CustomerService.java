package com.store.Services;

import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiExceptions.CredentialsException;
import com.data.models.ErrorHandler.ApiExceptions.CustomerExceptionNotFound;
import com.data.models.ErrorHandler.ApiExceptions.NoFoundException;
import com.data.models.Repositories.Store.CategoryRepository;
import com.data.models.Repositories.Store.CurrencyRepository;
import com.data.models.Repositories.Store.CustomerProductRepository;
import com.data.models.Repositories.Store.CustomerRepository;
import com.data.models.Requests.StoreRequests.ChangeCustomerPasswordRequest;
import com.data.models.Responses.CommonResponse;
import com.data.models.Responses.MainResponse;
import com.data.models.Responses.StoreResponse.CustomerResponse;
import com.data.models.store.Category;
import com.data.models.store.Customer;
import com.data.models.store.CustomerProducts;
import com.data.models.store.Heplers.StoreCurrency;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/27/2020  : 19:07
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerProductRepository customerProductRepository;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public MainResponse newCustomer(Customer customer)
    {
        MainResponse mainResponse=new MainResponse();
        customerRepository.save(customer);

        mainResponse .setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()));
        return mainResponse;

    }
    public MainResponse GetCustomerById(long customerId)
    {
        MainResponse mainResponse=new MainResponse();
        CustomerResponse response=new CustomerResponse();
        Optional<Customer> customer=customerRepository.findById(customerId);
        Customer customer1=customer.get();
response.setCustomerEmail(customer1.getCustomerEmail());
response.setCustomerName(customer1.getCustomerName());
response.setCustomerPhone(customer1.getCustomerPhone());
response.setCustomerUserName(customer1.getCustomerUserName());
response.setCustomerPassword(customer1.getCustomerPassword());
response.setLocation(customer1.getLocation());
response.setCustomerOprator(customer1.getCustomerOprator());
        response.setStatus(customer1.getStatus());
        mainResponse.setData(response);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID())
        );
        return mainResponse;
    }
    public MainResponse ChangePassword(ChangeCustomerPasswordRequest changeCustomerPasswordRequest)
    {
        MainResponse mainResponse=new MainResponse();
   Optional< Customer> customer=customerRepository.findById(changeCustomerPasswordRequest.getCustomerId());

   if(!customer.get().getCustomerPassword().equals(changeCustomerPasswordRequest.getOldPassword()))
             {throw new CredentialsException();}

        customer.get().setCustomerPassword(changeCustomerPasswordRequest.getNewPassword());
        customerRepository.save(customer.get());

        mainResponse .setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()));
        return mainResponse;
    }

    public MainResponse NewCusomerProduct(CustomerProducts customerProducts)
    {
        MainResponse mainResponse=new MainResponse();
        ObjectNode node =mapper.createObjectNode();
        Optional<Customer> customer=customerRepository.findById(customerProducts.getCustomerId());
        if(customer.isEmpty()){throw new CustomerExceptionNotFound();}

         /*   Optional<Category> category=categoryRepository.findById(customerProducts.getCategoryId());
        if(category.isEmpty()){throw new NoFoundException();}

        Optional<StoreCurrency> storeCurrency=currencyRepository.findById(customerProducts.getCurrency());
        if(storeCurrency.isEmpty()){throw new NoFoundException();}
*/
        customerProductRepository.save(customerProducts);

        node.put("productsId",customerProducts.getId());
       mainResponse.setData(node);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID())
        );
        return mainResponse;
    }
}
