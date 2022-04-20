package com.controller.controller;

import com.controller.model.Product;
import com.controller.service.IProductService;
import com.controller.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService= new ProductService();

    @GetMapping
    public ModelAndView showAllProduct(){
        List<Product> products = productService.findAll();
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products",products);
        return modelAndView;
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "/product/create";
    }
    @PostMapping("/save")
    public String create(RedirectAttributes redirectAttributes,Product product){
        product.setId((long) (Math.random()*10000));
        productService.save(product);
        redirectAttributes.addFlashAttribute("message","create success!");
        return "redirect:/product/list";

    }

}
