package com.store.Services;

import com.data.models.Responses.CommonResponse;
import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiExceptions.NoFoundException;
import com.data.models.Repositories.Store.CategoryRepository;
import com.data.models.Responses.MainResponse;
import com.data.models.Responses.StoreResponse.CategoriesResponse;
import com.data.models.store.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/22/2020  : 19:08
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public MainResponse getAllCategories() throws Exception {
        MainResponse mainResponse=new MainResponse();
        List<CategoriesResponse> categoriesResponseList=new ArrayList<CategoriesResponse>() ;

        List<Category> categoryList =categoryRepository.findAll();
        if(categoryList.isEmpty()){throw new NoFoundException();}
        categoryList.forEach(cat ->
        {   CategoriesResponse response=new CategoriesResponse();
            response.setId(cat.getId());
            response.setCategoryName(cat.getCategoryName());
            response.setDescription(cat.getDescription());
            response.setImageName(cat.getImageName());
            response.setCategoryNameAr(cat.getCategoryNameAr());
            categoriesResponseList.add(response);
        });
        mainResponse.setData(categoriesResponseList);
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()));
        return mainResponse;
    }

    public MainResponse getCategorById(long categoryId) {
        MainResponse mainResponse=new MainResponse();
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isEmpty()){throw new NoFoundException();}
        Category category1=category.get();
        CategoriesResponse response=new CategoriesResponse();


        response.setId(category1.getId());
        response.setCategoryName(category1.getCategoryName());
        response.setDescription(category1.getDescription());
        response.setImageName(category1.getImageName());
        mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()));
        mainResponse.setData(response);
        return mainResponse;
    }

    public MainResponse AddCategory(Category category)  {

        System.out.println(category.getCategoryName());
        MainResponse mainResponse=new MainResponse();
        Category category1 = new Category();
        category1.setCategoryName(category.getCategoryName());
        System.out.println(category1.getCategoryName());
        try {
        categoryRepository.save(category);
                mainResponse .setResponse(new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID()));
        return mainResponse;
        }catch (Exception e) {
            mainResponse.setResponse(new CommonResponse(ConstantClass.ErorrMesseges.FailMes + " - " + e.getMessage(), ConstantClass.ErorrCodes.FAIL_CODE, ConstantClass.StatusMesseges.FalseStatus, ConstantClass.HelperClass.getUUID()));
       return mainResponse;
        }

    }
}
