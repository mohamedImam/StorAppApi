package com.store.Services;

import com.data.models.ConstantClass;
import com.data.models.Repositories.Store.BrandRepository;
import com.data.models.Responses.CommonResponse;
import com.data.models.Responses.MainResponse;
import com.data.models.store.Brands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/28/2020  : 15:22
 */
@Service
public class BrandsService {
    @Autowired
    BrandRepository brandRepository;
    public MainResponse getAllBrands()
    {
        MainResponse mainResponse=new MainResponse();
        List<Brands> brands=brandRepository.findAll();
        mainResponse.setData(brands);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;

    }
    public MainResponse newBrands(Brands brands)
    {
        MainResponse mainResponse=new MainResponse();

        brandRepository.save(brands);
       // mainResponse.setData(brands);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }
}
