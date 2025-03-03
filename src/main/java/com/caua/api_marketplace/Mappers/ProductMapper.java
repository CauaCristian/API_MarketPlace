package com.caua.api_marketplace.Mappers;

import com.caua.api_marketplace.DTO.Product.CreateProductDTO;
import com.caua.api_marketplace.DTO.Product.ProductDTO;
import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;

import com.caua.api_marketplace.Repository.User.UserProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductMapper {
    @Autowired
    UserProducerRepository userProducerRepository;
    public List<ProductDTO> listProductModelToListProductDTO(List<ProductModel> productModelList) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (ProductModel productModel : productModelList) {
            productDTOList.add(productModelToProductDTO(productModel));
        }
        return productDTOList;
    }
    public ProductModel createPorductDTOtoProductModel(CreateProductDTO createProductDTO) {
        ProductModel productModel = new ProductModel();
        productModel.setName(createProductDTO.getName());
        productModel.setPrice(createProductDTO.getPrice());
        productModel.setCategory(createProductDTO.getCategory());
        productModel.setQuantity(createProductDTO.getQuantity());
        productModel.setImage(createProductDTO.getImage());
        Optional<UserProducerModel> userProducerModel = userProducerRepository.findById(createProductDTO.getProducerId());
        if (userProducerModel.isPresent()) {
            UserProducerModel userProducer = userProducerModel.get();
            productModel.setProducer(userProducer);
            return productModel;
        }
        else{
            throw new RuntimeException();
        }
    }
    public ProductDTO productModelToProductDTO(ProductModel productModel) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productModel.getId());
        productDTO.setName(productModel.getName());
        productDTO.setPrice(productModel.getPrice());
        productDTO.setCategory(productModel.getCategory());
        productDTO.setQuantity(productModel.getQuantity());
        productDTO.setProducerId(productModel.getProducer().getId());
        productDTO.setImage(productModel.getImage());
        return productDTO;
    }
    public ProductModel productDTOToProductModel(ProductDTO productDTO) {
        ProductModel productModel = new ProductModel();
        productModel.setId(productDTO.getId());
        productModel.setName(productDTO.getName());
        productModel.setPrice(productDTO.getPrice());
        productModel.setCategory(productDTO.getCategory());
        productModel.setQuantity(productDTO.getQuantity());
        Optional<UserProducerModel> userProducerModel = userProducerRepository.findById(productDTO.getProducerId());
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
