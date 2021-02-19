package com.mrozowski.OpinionSystem.api;

import com.mrozowski.OpinionSystem.model.Opinion;
import com.mrozowski.OpinionSystem.model.Product;
import com.mrozowski.OpinionSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/product")
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(path = "{id}")
    public List<Opinion> getProductOpinions(@PathVariable("id") long productId){
        return productService.getProductOpinion(productId);
    }

    @PostMapping
    public void addNewOpinion(@RequestBody Opinion opinion){
        productService.addOpinion(opinion);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteOpinion(@PathVariable("id") long id){
        productService.deleteOpinion(id);
    }




}
