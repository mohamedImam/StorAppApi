package com.delivery.Services;

import com.data.models.ConstantClass;
import com.data.models.Requests.Delivery.DeliveryOrder;
import com.data.models.Responses.CommonResponse;
import com.data.models.Responses.MainResponse;
import org.springframework.stereotype.Service;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/22/2020  : 19:13
 */
@Service
public class DeliveryService {
    public MainResponse newDeliveryOrder(DeliveryOrder deliveryOrder
    {
        MainResponse mainResponse=new MainResponse();


        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }
}
