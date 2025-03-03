package com.caua.api_marketplace.Repository.Product;

import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Long> {
    List<ProductModel> findByCategory(String category);
    List<ProductModel> findByProducer(UserProducerModel producer);
}
