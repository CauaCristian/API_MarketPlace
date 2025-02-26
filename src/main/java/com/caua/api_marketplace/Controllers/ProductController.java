package com.caua.api_marketplace.Controllers;

import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.DTO.Product.ProductDTO;
import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

}
