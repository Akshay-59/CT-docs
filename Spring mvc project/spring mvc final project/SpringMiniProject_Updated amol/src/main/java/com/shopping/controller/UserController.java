package com.shopping.controller;

import com.shopping.config.DbConfiguration;
import com.shopping.dto.GetById;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/user")
public class UserController {

    ApplicationContext context = new AnnotationConfigApplicationContext(DbConfiguration.class);
    UserService userService = context.getBean("getUserService", UserService.class);

    @RequestMapping(value = "/addEditUser")
    public void addEditUser(@ModelAttribute User user) {
        System.out.println(user.getId());
    }

    @RequestMapping("/getAllCustomers")
    public ModelAndView getAllCustomers() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users",userService.getAllUserByRole("customer"));
        modelAndView.setViewName("users");
        return modelAndView;
    }


    @RequestMapping(value = "/getCustomerById")
    public ModelAndView getProductById(@ModelAttribute GetById getById) {
        ModelAndView modelAndView = new ModelAndView();
        if(getById.getId() == 0) {
            modelAndView.setViewName("enterId");
            modelAndView.addObject("action","/getCustomerById");

        }
        else {
            List<User> users = new ArrayList<>();
            User user = userService.getUserById(getById.getId());
            users.add(user);
            modelAndView.addObject("users",users);
            modelAndView.setViewName("users");
        }
        return modelAndView;
    }


    @RequestMapping(value = "/deleteCustomerById")
    public ModelAndView deleteProductById(@ModelAttribute GetById getById) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("enterId");
        if(getById.getId() == 0) {
            modelAndView.addObject("action","/deleteCustomerById");
        }
        else {
            userService.deleteUserById(getById.getId());
            modelAndView.addObject("message","User with id "+getById.getId()+" deleted Successfully");
        }
        return modelAndView;
    }


    @RequestMapping(value = "/addEditCustomer" )
    public ModelAndView addEditCustomer(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();


        if(user.getId() == 0) {
            user.setRole("customer");
            userService.saveUser(user);
            modelAndView.addObject("successMessage","Customer Added Successfully");
        }
        else {
            userService.updateUser(user);
            modelAndView.addObject("successMessage","Customer Updated Successfully");
        }
        modelAndView.setViewName("success");

        return modelAndView;
    }

    @RequestMapping(value="/addCustomer")
    public ModelAndView addCustomer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCustomer");
        return modelAndView;
    }


    @RequestMapping(value="/editCustomer")
    public ModelAndView editCustomer() {
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = userService.getAllUserByRole("customer");
        modelAndView.addObject("users",users);
        List<String> productCategories = new ArrayList<>();
        modelAndView.setViewName("editCustomer");
        return modelAndView;
    }



}
