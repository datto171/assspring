package aptech.fpt.spring.controller;

import aptech.fpt.spring.entity.Product;
import aptech.fpt.spring.entity.ProductValidator;
import aptech.fpt.spring.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductModel productModel;

    @RequestMapping(path = "/product/create", method = RequestMethod.GET)
    public String createProduct(@ModelAttribute Product p) {
        return "product-form";
    }

    @RequestMapping(path = "/product/create", method = RequestMethod.POST)
    public String saveProduct(@Valid Product product, BindingResult result) {
        new ProductValidator().validate(product, result);
        if (result.hasErrors()) {
            return "product-form";
        }
        productModel.save(product);
        return "redirect:/product/create";
    }

    @RequestMapping(path = "/product/edit/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable int id, Model model) {
        Optional<Product> optionalProduct = productModel.findById(id);
        if (optionalProduct.isPresent()) {
            model.addAttribute("product", optionalProduct.get());
            return "product-form";
        } else {
            return "not-found";
        }
    }

    @RequestMapping(path = "/product/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable int id) {
        Optional<Product> optionalProduct = productModel.findById(id);
        if (optionalProduct.isPresent()) {
            productModel.delete(optionalProduct.get());
            return "redirect:/product/list";
        } else {
            return "not-found";
        }
    }

    @RequestMapping(path = "/product/list", method = RequestMethod.GET)
    public String getListProduct(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int limit) {
        model.addAttribute("pagination", productModel.findAll(PageRequest.of(page - 1, limit)));
        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        model.addAttribute("datetime", Calendar.getInstance().getTime());
        return "product-list";
    }
}
