package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Payment;
import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
@SessionAttributes("carts")

public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("carts")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping
    public String home(Pageable pageable,@ModelAttribute("carts") Cart cart,Model model) {
        Page<Product> products;
        products = productService.findAll(pageable);
        model.addAttribute("products", products);
        return "home";

    }

    @GetMapping("/product/{id}")
    public ModelAndView productForm(@PathVariable long id, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("info", "product", productService.findOne(id));

        return modelAndView;
    }

    @PostMapping("/product")
    public String addCart(Product product, @ModelAttribute("carts") Cart cart, Model model) {
        if (cart.contain(product.getId())){
            model.addAttribute("success","San pham da nay da nam trong gio hang");
            return "info";
        }
        cart.addCart(productService.findOne(product.getId()));
        return "redirect:/";

    }


    @GetMapping("/listcart")
    public String listCart(@ModelAttribute("carts") Cart cart){
        return "listcart";
    }

    @GetMapping("/payment")
    public String payment(long id,String name,String count, String price,String model,Model models){
        System.out.println(count);
        models.addAttribute("payment", new Payment(id,name,price,count,model));
        return "payment";

    }

    @PostMapping("/payment/{id}")
    public String payment(@PathVariable long id,@ModelAttribute("carts") Cart cart){
        cart.remove(id);
        return "redirect:/listcart";
    }

    @PostMapping("/remove/{id}")
    public String removeProductCart(@PathVariable long id, @ModelAttribute("carts") Cart cart){
        cart.remove(id);
        return "redirect:/listcart";
    }

}
