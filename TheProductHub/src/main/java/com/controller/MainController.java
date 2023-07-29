package com.controller;

import com.dao.ProductDao;
import com.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ProductDao productDao;
    @RequestMapping("/")
    public String home(Model model) {
        List<Product> productList=productDao.getProducts();
        model.addAttribute("products",productList);
        return "index";
    }

    @RequestMapping("/add_Product")
    public String addProduct(Model m) {
        m.addAttribute("title", "Add Product");
        return "add_Product";
    }

    @RequestMapping(value="/handle-product", method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
        System.out.println(product);
        this.productDao.createProduct(product);
        RedirectView rw = new RedirectView();
        rw.setUrl(request.getContextPath()+"/");
        return rw;
    }
    @RequestMapping("/delete/{id}")
    public RedirectView deleteProduct(@PathVariable("id") int id,HttpServletRequest request) {
    	this.productDao.deleteProduct(id);
    	RedirectView rw = new RedirectView();
        rw.setUrl(request.getContextPath()+"/");
        return rw;
    }
    
    @RequestMapping("/update/{id}")
    public String updateForm(@PathVariable("id") int id, Model model) {
    	
    	Product product=this.productDao.getProducts(id);
    	model.addAttribute("product",product);
    	return "update_form";
    }
    
    
    
}