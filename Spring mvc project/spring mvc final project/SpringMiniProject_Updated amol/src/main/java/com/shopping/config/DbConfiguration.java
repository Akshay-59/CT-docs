package com.shopping.config;


import com.shopping.service.CategoryService;
import com.shopping.service.Impl.CategoryServiceImpl;
import com.shopping.service.Impl.OrderDetailsServiceImpl;
import com.shopping.service.Impl.ProductServiceImpl;
import com.shopping.service.Impl.UserServiceImpl;
import com.shopping.service.OrderDetailsService;
import com.shopping.service.ProductService;
import com.shopping.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

@Configuration
public class DbConfiguration {
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setPrefix("/WEB-INF/views/");
        vr.setSuffix(".jsp");
        return vr;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        driverManagerDataSource.setUrl("jdbc:sqlserver://localhost;databaseName=shopping;instanceName=SQLEXPRESS;encrypt=true;trustServerCertificate=true;");
        driverManagerDataSource.setUsername("sa");
        driverManagerDataSource.setPassword("password_123");
        return driverManagerDataSource;
    }


    @Bean
    public JdbcTemplate getJdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        return jdbcTemplate;
    }

    @Bean
    public UserService getUserService() {
        UserServiceImpl userService = new UserServiceImpl();
        userService.setJdbcTemplate(getJdbcTemplate());
        return userService;
    }

    @Bean
    public ProductService getProductService() {
        ProductServiceImpl productService = new ProductServiceImpl();
        productService.setJdbcTemplate(getJdbcTemplate());
        return productService;
    }


    @Bean
    public CategoryService getCategoryService() {
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        categoryService.setJdbcTemplate(getJdbcTemplate());
        return categoryService;
    }

    @Bean
    public OrderDetailsService getOrderDetailsService() {
        OrderDetailsServiceImpl orderDetailsService = new OrderDetailsServiceImpl();
        orderDetailsService.setJdbcTemplate(getJdbcTemplate());
        return orderDetailsService;
    }

}
