package com.caua.api_marketplace.Repository.Product;

import com.caua.api_marketplace.Models.Product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,Long> {
}
