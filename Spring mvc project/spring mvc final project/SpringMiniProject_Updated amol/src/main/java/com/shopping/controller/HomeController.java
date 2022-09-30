package com.shopping.controller;


import com.shopping.config.DbConfiguration;
import com.shopping.dto.OrderRequest;
import com.shopping.model.Category;
import com.shopping.model.OrderDetails;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.service.CategoryService;
import com.shopping.service.OrderDetailsService;
import com.shopping.service.ProductService;
import com.shopping.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    ApplicationContext context = new AnnotationConfigApplicationContext(DbConfiguration.class);
    UserService userService = context.getBean("getUserService", UserService.class);

    ProductService productService = context.getBean("getProductService", ProductService.class);

    CategoryService categoryService = context.getBean("getCategoryService", CategoryService.class);

    OrderDetailsService orderDetailsService = context.getBean("getOrderDetailsService", OrderDetailsService.class);
    OrderDetails  orderDetails = new OrderDetails();
    ProductController productController = new ProductController();
    UserController userController = new UserController();
    List<Map<String,String>> adminMenus = new ArrayList<>();
    String[] adminMenuKeys = new String[]{"Add Product","Update Product", "Delete Product", "Get Product by ID", "Get All Products", "Add customer", "Update Customer Information", "Delete Customer", "Get Customer by ID", "Get All Customers"};
    String[] adminMenuValues = new String[]
            {
                    "/addProd","/editProd","/deleteProductById","/getProductById",
                    "/getAllProducts",
                    "/addCustomer","/editCustomer","/deleteCustomerById",
                    "/getCustomerById","/getAllCustomers"
            };


    //handler method
    @RequestMapping("/home")
    public String getIndex() {

        return "index";

    }


    @RequestMapping(value = "/login")
    public ModelAndView login(@ModelAttribute("user") User user) {
        ModelAndView modelAndView = new ModelAndView();
        boolean isValidUser = userService.validateUser(user);
        if(isValidUser) {
            User dbUser = userService.getUserByUsername(user.getUsername());
            modelAndView.addObject("role",dbUser.getRole());
            if(dbUser.getRole().equalsIgnoreCase("customer")) {
                modelAndView.addObject("username", dbUser.getUsername());
                orderDetails.setUserId(dbUser.getId());
                return this.getAllCategories();
            }
            else {
                Map<String, String> adminMenuMap = new HashMap<>();
                for (int i = 0; i < this.adminMenuKeys.length; i++) {
                    adminMenuMap.put(this.adminMenuKeys[i], this.adminMenuValues[i]);
                }
                modelAndView.addObject("adminMenus",adminMenuMap.entrySet());
                modelAndView.setViewName("adminMenu");
                return modelAndView;
            }

        }
        else {
            modelAndView.addObject("errorMessage","Unable to find user with username : "+user.getUsername()+", please check your username or password");
            modelAndView.setViewName("error");
            return modelAndView;
        }


    }

    @RequestMapping(value = "/getCategories")
    public ModelAndView getAllCategories() {
        ModelAndView modelAndView = new ModelAndView();
        List<Category> categoryList = categoryService.getCategories();
        if (categoryList.isEmpty()) {

            modelAndView.addObject("errorMessage","No Categories Found");
            modelAndView.setViewName("error");
        }
        else {
            modelAndView.addObject("categories",categoryList);
            modelAndView.setViewName("category");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/getProductBasedOnCategory")
    public ModelAndView getProductBasedOnCategory(@RequestParam("categoryId") int categoryId) {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> products = productService.getAllProductsByCategory(categoryId);
        if(products.isEmpty()) {
            modelAndView.addObject("errorMessage","No Products available for the selected Category");
            modelAndView.setViewName("error");
        }
        else {
            orderDetails.setCategoryId(categoryId);
            modelAndView.addObject("products",products);
            modelAndView.setViewName("products");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/submitOrder")
    public ModelAndView submitOrder(@ModelAttribute OrderRequest orderRequest) {
        ModelAndView modelAndView = new ModelAndView();
        if(orderRequest.getQuantity()<=0) {
            modelAndView.addObject("errorMessage","Quantity Cannot be Negative or 0");
            modelAndView.setViewName("error");
        }

        else {
            orderDetails.setProductId(orderRequest.getProductId());
            orderDetails.setQuantity(orderRequest.getQuantity());
            Product product = productService.getProductById(orderRequest.getProductId());
            modelAndView.setViewName("thankYou");
            float total = orderDetails.getQuantity() * product.getPrice();
            if(total >= 100000.00) {
                total -= (total/10);
                modelAndView.addObject("totalMessage","Congrats! You get a 10% discount." +
                        " Your Total is "+total+" Thank you for shopping with us!");
            }
            else {
                modelAndView.addObject("totalMessage",
                        " Your Total is "+total+" Thank you for shopping with us!");
            }
            orderDetails.setTotal(total);
            orderDetailsService.submitOrder(orderDetails);
        }

    return modelAndView;
    }


}
