package com.shoppingapp.config;

import com.shoppingapp.service.CategoryService;
import com.shoppingapp.service.OrderDetailsService;
import com.shoppingapp.service.ProductService;
import com.shoppingapp.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
        driverManagerDataSource.setUrl("jdbc:sqlserver://localhost;databaseName=shopping;instanceName=SQLEXPRESS;encrypt=true;");
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
        UserService userService = new UserService();
        userService.setJdbcTemplate(getJdbcTemplate());
        return userService;
    }

    @Bean
    public ProductService getProductService() {
        ProductService productService = new ProductService();
        productService.setJdbcTemplate(getJdbcTemplate());
        return productService;
    }


    @Bean
    public CategoryService getCategoryService() {
        CategoryService categoryService = new CategoryService();
        categoryService.setJdbcTemplate(getJdbcTemplate());
        return categoryService;
    }

    @Bean
    public OrderDetailsService getOrderDetailsService() {
        OrderDetailsService orderDetailsService = new OrderDetailsService();
        orderDetailsService.setJdbcTemplate(getJdbcTemplate());
        return orderDetailsService;
    }

}
