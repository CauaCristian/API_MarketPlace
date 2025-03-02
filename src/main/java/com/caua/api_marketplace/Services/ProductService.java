package com.caua.api_marketplace.Services;

import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.DTO.Product.CreateProductDTO;
import com.caua.api_marketplace.DTO.Product.ProductDTO;
import com.caua.api_marketplace.Mappers.ProductMapper;
import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Repository.Product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    public ResponseDTO<ProductDTO> createProduct(CreateProductDTO createProductDTO) {
        ProductModel productModel = productRepository.save(productMapper.createPorductDTOtoProductModel(createProductDTO));
        ProductDTO product = productMapper.ProductModelToProductDTO(productModel);
        return new ResponseDTO<ProductDTO>("Produto criado com sucesso",false,product);
    }
}
