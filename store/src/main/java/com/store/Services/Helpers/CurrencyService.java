package com.store.Services.Helpers;

import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiExceptions.CurrencyException;
import com.data.models.Repositories.Store.CurrencyRepository;
import com.data.models.Responses.CommonResponse;
import com.data.models.Responses.MainResponse;
import com.data.models.store.Heplers.StoreCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/28/2020  : 17:40
 */
@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;
    public MainResponse newCurrency (StoreCurrency storeCurrency)
    { MainResponse mainResponse=new MainResponse();
        currencyRepository.save(storeCurrency);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }
    public String getCurrencyName(long currencyId)
    {
        Optional<StoreCurrency> storeCurrency=currencyRepository.findById(currencyId);
        if (storeCurrency.isEmpty()){throw new CurrencyException(); }
        return storeCurrency.get().getCurrencyName();
    }
}
