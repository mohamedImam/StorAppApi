package com.store.Services;

import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiExceptions.InsufficientStockException;
import com.data.models.ErrorHandler.ApiExceptions.NoFoundException;
import com.data.models.ErrorHandler.ApiExceptions.ProductPriceException;
import com.data.models.Repositories.Store.*;
import com.data.models.Requests.StoreRequests.OrderRequest;
import com.data.models.Responses.CommonResponse;
import com.data.models.Responses.MainResponse;
import com.data.models.Responses.StoreResponse.NewOrderResponse;
import com.data.models.Responses.StoreResponse.OrderDetailsResponse;
import com.data.models.Responses.StoreResponse.ProductQantityResponse;
import com.data.models.store.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.Services.Helpers.OrderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/27/2020  : 13:59
 */
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderHelper orderHelper;

public MainResponse newOrder(OrderRequest orderRequest)
    {
        long orderId;
        AtomicReference<Double> ordersPriceSum= new AtomicReference<>((double) 0);
        Order order=new Order();
        ObjectMapper objectMapper = new ObjectMapper();
        MainResponse mainResponse=new MainResponse();
        NewOrderResponse newOrderResponse=new NewOrderResponse();
        Optional<Customer> customer=customerRepository.findById(orderRequest.getCustomerId());
        if (customer.isEmpty()){throw new NoFoundException();
        }
       //
      //  try {
            order.setDataTime(ConstantClass.DATE_TIME_FORMAT.format(new Date()));
            order.setDescription(orderRequest.getDescription());
           // order.setTotalPrice(orderRequest.getTotalPrice());
        order.setStatus(ConstantClass.ConstantCodes.PENDING);
            order.setCustomerId(orderRequest.getCustomerId());
            orderRepository.save(order);
            orderId = order.getId();
            System.out.println(orderId + "-----------------------------------");


            List<OrderDetails> requestOrderDetails = objectMapper.convertValue(orderRequest.getOrderDetails(), new TypeReference<List<OrderDetails>>() {
            });

            requestOrderDetails.forEach(loopRequestOrderDetails ->
            {
                Stock stock=stockRepository.findByProductId(loopRequestOrderDetails.getProductId());
            int quantity=stock.getQuantity();
                if(getQantity(loopRequestOrderDetails.getProductId())<loopRequestOrderDetails.getQuantity())
                {  orderHelper.rollbackOrder(order);
                    throw new InsufficientStockException();}

                Optional<Product> product=productRepository.findById(loopRequestOrderDetails.getProductId());
                if(product.get().getPrice()>loopRequestOrderDetails.getPrice()||product.get().getPrice()<loopRequestOrderDetails.getPrice())
                {orderHelper.rollbackOrder(order);
                    throw new ProductPriceException();}

                    ordersPriceSum.set(ordersPriceSum.get() + loopRequestOrderDetails.getPrice());
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setOrderId(orderId);
                    orderDetails.setPrice(loopRequestOrderDetails.getPrice());
                    orderDetails.setQuantity(loopRequestOrderDetails.getQuantity());
                    orderDetails.setProductId(loopRequestOrderDetails.getProductId());
                    orderDetails.setCurrency(loopRequestOrderDetails.getCurrency());
                    orderDetailsRepository.save(orderDetails);
                    stock.setQuantity(quantity-loopRequestOrderDetails.getQuantity());
                    stockRepository.save(stock);

            });
            /*TODO change this sec*/
            Optional<Order> orderT=orderRepository.findById(orderId);
            orderT.get().setTotalPrice(ordersPriceSum.get());
            orderRepository.save(orderT.get());
        newOrderResponse.setOrderId(orderId);
        mainResponse.setData(newOrderResponse);
            mainResponse .setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                    ConstantClass.ErorrCodes.SUCCESS_CODE,
                    ConstantClass.StatusMesseges.TrueStatus,
                    ConstantClass.HelperClass.getUUID()));
            return mainResponse;
       /* }catch (Exception e) {
            mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.FailMes + " - " + e.getMessage(), ConstantClass.ErorrCodes.FAIL_CODE, ConstantClass.StatusMesseges.FalseStatus, ConstantClass.HelperClass.getUUID()));
            return mainResponse;
        }*/
    }

    public MainResponse checkQantity(long productId)
    {
        MainResponse  mainResponse=new MainResponse();
        ProductQantityResponse qantity=new ProductQantityResponse();
        Stock stock=stockRepository.findByProductId(productId);
        qantity.setQantity(stock.getQuantity());
        qantity.setProductId(productId);
        mainResponse.setData(qantity);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }

    public int getQantity(long productId)
    {
        Stock stock=stockRepository.findByProductId(productId);
        return stock.getQuantity();
    }

    public  MainResponse GetOrderDetails(long orderId)
    {
        MainResponse mainResponse=new MainResponse();
        OrderDetailsResponse orderDetailsResponse=new OrderDetailsResponse();


         Optional<Order> order=orderRepository.findById(orderId);
        orderDetailsResponse.setCustomerId(order.get().getCustomerId());
        orderDetailsResponse.setDescription(order.get().getDescription());
        orderDetailsResponse.setDataTime(order.get().getDataTime());
        orderDetailsResponse.setTotalPrice(order.get().getTotalPrice());
        orderDetailsResponse.setCurrency(order.get().getCurrency());

        List<OrderDetails> orderDetails=orderDetailsRepository.findByOrderId(orderId);
        orderDetailsResponse.setOrderDetails(orderDetails);

        mainResponse.setData(orderDetailsResponse);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }
}
