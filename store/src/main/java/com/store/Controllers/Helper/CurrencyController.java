package com.store.Controllers.Helper;

import com.data.models.Responses.MainResponse;
import com.data.models.store.Heplers.StoreCurrency;
import com.store.Services.Helpers.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/28/2020  : 17:43
 */

@RestController
@RequestMapping("/store/Currency")
@CrossOrigin(origins = "*")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @PostMapping("/newCurrency")
    public MainResponse newCurrency(@RequestBody StoreCurrency storeCurrency)
    {
        return currencyService.newCurrency(storeCurrency);
    }
}
