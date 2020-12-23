package com.store.Controllers;

import com.data.models.CommonResponse;
import com.data.models.ConstantClass;
import com.data.models.store.Category;
import com.store.Services.CategoryService;
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
public class StroeController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories()
    { return  categoryService.getAllCategories(); }

    @GetMapping("/getCategoryById/{categoryId}")
    public Category getCategoryById(@PathVariable long categoryId)
    {return  categoryService.getCategorById(categoryId); }

    @PostMapping("/AddCategory")
    public CommonResponse AddCategory(@RequestBody Category category)  {
        try { return categoryService.AddCategory(category);
        }catch (Exception e){ return new CommonResponse(ConstantClass.ErorrMesseges.FailMes+" - "+e.getMessage(),ConstantClass.ErorrCodes.FailCode,ConstantClass.StatusMesseges.FalseStatus,ConstantClass.HelperClass.getUUID()); }
        }


}
