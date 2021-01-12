package com.store.Services;

import com.data.models.ConstantClass;
import com.data.models.Repositories.Store.SupplierRepository;
import com.data.models.Responses.CommonResponse;
import com.data.models.Responses.MainResponse;
import com.data.models.Responses.StoreResponse.SupplierResponse;
import com.data.models.store.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/27/2020  : 11:37
 */
@Service
public class SuppliersService {
    @Autowired
    SupplierRepository supplierRepository;

    public MainResponse getAllSuppliers ()
    {
        List<Suppliers> suppliersList =new ArrayList<Suppliers>();
        List<SupplierResponse> supplierResponses=new ArrayList<SupplierResponse>();
        MainResponse mainResponse=new MainResponse();

        suppliersList=supplierRepository.findAll();
        suppliersList.forEach(supplier ->
    {
        SupplierResponse response=new SupplierResponse();
        response.setId(supplier.getId());
        response.setStatus(supplier.isStatus());
        response.setSupplierName(supplier.getSupplierName());
        response.setSupplierNameAr(supplier.getSupplierNameAr());
        response.setStoreName(supplier.getStoreName());
        response.setStoreNameAr(supplier.getStoreNameAr());
                supplierResponses.add(response);
    }
    );
        mainResponse.setData(supplierResponses);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));

return mainResponse;
    }

    public MainResponse getSupplierById(int supplierId)
    { MainResponse mainResponse=new MainResponse();
        SupplierResponse responses=new SupplierResponse();
        Optional<Suppliers> supplier=supplierRepository.findById(supplierId);
        Suppliers Supplier1=supplier.get();
        responses.setId(Supplier1.getId());
        responses.setSupplierName(Supplier1.getSupplierName());
        responses.setSupplierNameAr(Supplier1.getSupplierNameAr());
        responses.setStoreName(Supplier1.getStoreName());
        responses.setStoreNameAr(Supplier1.getStoreNameAr());
        mainResponse.setData(responses);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }
    public MainResponse AddSupplier (Suppliers supplier)
    { MainResponse mainResponse=new MainResponse();
try {
        supplierRepository.save(supplier);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()
        ));
        return mainResponse;
    }catch (Exception e) {
    mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.FailMes + " - " + e.getMessage(), ConstantClass.ErorrCodes.FAIL_CODE, ConstantClass.StatusMesseges.FalseStatus, ConstantClass.HelperClass.getUUID()));
}
return mainResponse;
    }

}
