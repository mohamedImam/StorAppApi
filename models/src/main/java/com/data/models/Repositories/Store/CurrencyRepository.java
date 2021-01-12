package com.data.models.Repositories.Store;

import com.data.models.store.Heplers.StoreCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/28/2020  : 17:41
 */
public interface CurrencyRepository extends JpaRepository<StoreCurrency,Long> {
}
