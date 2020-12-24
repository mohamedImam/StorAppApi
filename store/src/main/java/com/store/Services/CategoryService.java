package com.store.Services;

import com.data.models.CommonResponse;
import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiExceptions.NoFoundException;
import com.data.models.Repositories.CategoryRepository;
import com.data.models.store.Category;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Category> getAllCategories() throws Exception {
        List<Category> categoryList =categoryRepository.findAll();
        if(categoryList.isEmpty()){throw new NoFoundException();}
        return categoryList;
    }

    public Category getCategorById(long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isEmpty()){throw new NoFoundException();}
        return category.get();
    }

    public CommonResponse AddCategory(Category category) throws Exception {
        System.out.println(category.getCategoryName());
        Category category1 = new Category();
        category1.setCategoryName(category.getCategoryName());
        System.out.println(category1.getCategoryName());
        categoryRepository.save(category);

        return new CommonResponse(ConstantClass.ErorrMesseges.SuccessMes,
                ConstantClass.ErorrCodes.SUCCESS_CODE,
                ConstantClass.StatusMesseges.TrueStatus,
                ConstantClass.HelperClass.getUUID());
    }
}
