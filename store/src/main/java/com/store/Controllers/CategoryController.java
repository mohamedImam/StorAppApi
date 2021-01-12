package com.store.Controllers;

import com.data.models.ErrorHandler.ApiExceptions.NoFoundException;
import com.data.models.Responses.MainResponse;
import com.data.models.store.Category;
import com.store.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public MainResponse getAllCategories()
    {
        try { return  categoryService.getAllCategories();
        }catch (Exception e) {throw new NoFoundException(); }
    }

    @GetMapping("/getCategoryById/{categoryId}")
    public MainResponse getCategoryById(@PathVariable long categoryId)
    {return  categoryService.getCategorById(categoryId); }

    @PostMapping("/AddCategory")
    public MainResponse AddCategory(@RequestBody Category category)  {
            return categoryService.AddCategory(category);
        }


}
