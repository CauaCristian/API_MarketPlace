package com.caua.api_marketplace.Mappers;

import com.caua.api_marketplace.DTO.Product.ProductDTO;
import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import com.caua.api_marketplace.Repository.User.UserProducerRepository;
import com.caua.api_marketplace.Repository.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductMapper {
    @Autowired
    UserProducerRepository userProducerRepository;

    public ProductDTO ProductModelToProductDTO(ProductModel productModel) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productModel.getId());
        productDTO.setName(productModel.getName());
        productDTO.setPrice(productModel.getPrice());
        productDTO.setCategory(productModel.getCategory());
        productDTO.setQuantity(productModel.getQuantity());
        productDTO.setProducerId(productDTO.getProducerId());
        return productDTO;
    }
    public ProductModel ProductDTOToProductModel(ProductDTO productDTO) {
        ProductModel productModel = new ProductModel();
        productModel.setId(productDTO.getId());
        productModel.setName(productDTO.getName());
        productModel.setPrice(productDTO.getPrice());
        productModel.setCategory(productDTO.getCategory());
        productModel.setQuantity(productDTO.getQuantity());
        var userProducerModel = userProducerRepository.findById(productDTO.getProducerId());
        if (userProducerModel.isPresent()) {
            UserProducerModel userProducer = userProducerModel.get();
            productModel.setProducer(userProducer);
            return productModel;
        }
        else{
            throw new RuntimeException();
        }
    }
}
