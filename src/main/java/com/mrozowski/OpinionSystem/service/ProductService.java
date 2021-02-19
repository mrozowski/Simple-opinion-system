package com.mrozowski.OpinionSystem.service;

import com.mrozowski.OpinionSystem.model.Opinion;
import com.mrozowski.OpinionSystem.model.Product;
import com.mrozowski.OpinionSystem.repository.OpinionRepository;
import com.mrozowski.OpinionSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final OpinionRepository opinionRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, OpinionRepository opinionRepository) {
        this.productRepository = productRepository;
        this.opinionRepository = opinionRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Opinion> getProductOpinion(long product_id){
        return opinionRepository.findAll()
                .stream()
                .filter(e -> e.getProductId() == product_id)
                .collect(Collectors.toList());
    }

    public void addOpinion(Opinion opinion){
        //add new opinion
        opinionRepository.save(opinion);

        //update average rating of product
        updateAverageRating(opinion.getId());

    }

    private void updateAverageRating(long id) {
        //get new average
        DoubleSummaryStatistics doubleSummaryStatistics = getProductOpinion(id)
                .stream()
                .mapToDouble(Opinion::getScore)
                .summaryStatistics();

        double average = doubleSummaryStatistics.getAverage();
        System.out.println(doubleSummaryStatistics);

        //update average rating of product
        productRepository.updateAverageRating(id, average);
    }

    public void deleteOpinion(long id) {
        opinionRepository.deleteById(id); //delete opinion with given id
        updateAverageRating(id);          //and update average rating of product
    }
}
