package com.caua.api_marketplace.Controllers;

import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.DTO.Product.CreateProductDTO;
import com.caua.api_marketplace.DTO.Product.ProductDTO;

import com.caua.api_marketplace.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<List<ProductDTO>> getAll(){
        return this.productService.getAll();
    }
    @GetMapping(value ="/getAllByCategory/{category}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<List<ProductDTO>> getAllByCategory(@PathVariable String category){
        return this.productService.getAllByCategory(category);
    }
    @GetMapping(value = "/getAllByProducer/{producerId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<List<ProductDTO>> getAllByProducer(@PathVariable Long producerId){
        return this.productService.getAllByProducer(producerId);
    }
    @GetMapping(value = "/getAllByProducerAndCategory/{producerId}/{category}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<List<ProductDTO>> getAllByProducerAndCategory(@PathVariable Long producerId,@PathVariable String category){
        return this.productService.getAllByProducerAndCategory(producerId,category);
    }
    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<ProductDTO> createProduct(@RequestBody CreateProductDTO createProductDTO) {
        return this.productService.createProduct(createProductDTO);
    }
    @PutMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.updateProduct(productDTO);
    }
    @DeleteMapping(value = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseDTO<ProductDTO> deleteProduct(@PathVariable("id") int id) {
        return this.productService.deleteProduct(id);
    }
}
