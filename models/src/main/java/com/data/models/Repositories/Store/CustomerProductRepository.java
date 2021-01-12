package com.data.models.Repositories.Store;

import com.data.models.store.CustomerProducts;
import com.data.models.store.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/29/2020  : 10:35
 */
public interface CustomerProductRepository extends JpaRepository<CustomerProducts,Long> {

    List<CustomerProducts> findByCustomerId(long customerId);
     CustomerProducts  findByCustomerIdAndId(long customerId,long id);
}
