package com.shoppingapp.controller;

import com.shoppingapp.config.DbConfiguration;
import com.shoppingapp.dto.GetById;
import com.shoppingapp.model.Category;
import com.shoppingapp.model.Product;
import com.shoppingapp.service.CategoryService;
import com.shoppingapp.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    ApplicationContext context = new AnnotationConfigApplicationContext(DbConfiguration.class);

    ProductService productService = context.getBean("getProductService", ProductService.class);

    CategoryService categoryService = context.getBean("getCategoryService", CategoryService.class);



    @RequestMapping(value = "/getAllProducts")
    public ModelAndView getAllProducts() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.getAllProducts();
        modelAndView.setViewName("listProducts");
        modelAndView.addObject("products",products);
        List<String> categoryList = new ArrayList();
        for (Product product : products) {
            categoryList.add(categoryService.getCategoryById(product.getProductCategoryId()).getName());
        }
        modelAndView.addObject("categories",categoryList);
        return modelAndView;
    }

//    @RequestMapping(value = "/getProductById")
    public ModelAndView getProductById(int id) {
        List<Product> products = new ArrayList();
        List<String> categoryList = new ArrayList();
        Product product = productService.getProductById(id);
        products.add(product);
        categoryList.add(categoryService.getCategoryById(product.getProductCategoryId()).getName());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products",products);
        modelAndView.addObject("categories",categoryList);
        modelAndView.setViewName("listProducts");
        return modelAndView;
    }

    @RequestMapping(value = "/getProductById")
    public ModelAndView getProductById(@ModelAttribute GetById getById) {
        ModelAndView modelAndView = new ModelAndView();
        if(getById.getId() == 0) {
            modelAndView.setViewName("enterId");
            modelAndView.addObject("action","/getProductById");
            return modelAndView;
        }
        else {
            return getProductById(getById.getId());
        }
    }


    @RequestMapping(value = "/deleteProductById")
    public ModelAndView deleteProductById(@ModelAttribute GetById getById) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("enterId");
        if(getById.getId() == 0) {
            modelAndView.addObject("action","/deleteProductById");
        }
        else {
            productService.deleteProductById(getById.getId());
            modelAndView.addObject("message","Product with id "+getById.getId()+" deleted Successfully");
        }
        return modelAndView;

    }


    @RequestMapping(value = "/addEditProduct" )
    public ModelAndView addEditProduct(@ModelAttribute Product product) {
        ModelAndView modelAndView = new ModelAndView();


        if(product.getId() == 0) {

            productService.saveProduct(product);
            modelAndView.addObject("successMessage","Product Added Successfully");
        }
        else {
            productService.updateProduct(product);
            modelAndView.addObject("successMessage","Product Updated Successfully");
        }
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(value="/addProd")
    public ModelAndView addProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("categories",categoryService.getCategories());
        modelAndView.setViewName("addProduct");
        return modelAndView;
    }


    @RequestMapping(value="/editProd")
    public ModelAndView editProduct() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.getAllProducts();
        modelAndView.addObject("products",products);
        List<String> productCategories = new ArrayList();

        for (Product product : products) {
            productCategories.add(categoryService.getCategoryById(product.getProductCategoryId()).getName());
        }

        modelAndView.addObject("productCategories",productCategories);
        modelAndView.addObject("categories",categoryService.getCategories());
        modelAndView.setViewName("editProduct");
        return modelAndView;
    }


}
