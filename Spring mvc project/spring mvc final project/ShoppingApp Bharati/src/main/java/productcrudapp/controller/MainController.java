package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.Dao.ProductDao;
import productcrudapp.model.Product;


@Controller

public class MainController {
	@Autowired
	private ProductDao productdao;
	
	
	@RequestMapping("/")
	public String home(Model m) {
		List<Product> products = productdao.getProducts();
		m.addAttribute("product", products);
		return "index";
	}
/*	@RequestMapping("/login")
	public String Login(Model m) {
		List<Product> products = productdao.getProducts();
		m.addAttribute("title", products);
		return "Login";
	}  */

	@RequestMapping("/add-product")
	public String addProduct(Model m) {
		m.addAttribute("title", "Add product");
		return "add_product_form";
	}

	@RequestMapping(value = "/handle-product", method = RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		productdao.createProduct(product);
		RedirectView redirectView = new RedirectView();

		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("delete/{id}")
	public RedirectView deleteProduct(@PathVariable("id") int productId, HttpServletRequest request) {
		this.productdao.deleteProduct(productId);
		RedirectView redirectView = new RedirectView();

		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

}
