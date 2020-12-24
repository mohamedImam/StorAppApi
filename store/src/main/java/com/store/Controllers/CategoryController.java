package com.store.Controllers;

import com.data.models.CommonResponse;
import com.data.models.ConstantClass;
import com.data.models.ErrorHandler.ApiExceptions.BadRequestException;
import com.data.models.ErrorHandler.ApiExceptions.NoFoundException;
import com.data.models.ErrorHandler.ApiExceptions.OperationFailedException;
import com.data.models.store.Category;
import com.store.Services.CategoryService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: mohamed Imam
 * Email : mohamed.imam@tirhal.net
 * Date : on 12/22/2020  : 19:07
 */
@RestController
@RequestMapping("/store/Category")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories()
    {
        try {
            return  categoryService.getAllCategories();
        }catch (Exception e) {
            throw new NoFoundException();
        }
    }

    @GetMapping("/getCategoryById/{categoryId}")
    public Category getCategoryById(@PathVariable long categoryId)
    {return  categoryService.getCategorById(categoryId); }

    @PostMapping("/AddCategory")
    public CommonResponse AddCategory(@RequestBody Category category)  {
        try { return categoryService.AddCategory(category);
        }catch (Exception e){
            //return new CommonResponse(ConstantClass.ErorrMesseges.FailMes+" - "+e.getMessage(),ConstantClass.ErorrCodes.FAIL_CODE,ConstantClass.StatusMesseges.FalseStatus,ConstantClass.HelperClass.getUUID());
        throw new OperationFailedException();
        }
        }


}
