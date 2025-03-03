package com.caua.api_marketplace.Services;

import com.caua.api_marketplace.DTO.Generic.ResponseDTO;
import com.caua.api_marketplace.DTO.Product.CreateProductDTO;
import com.caua.api_marketplace.DTO.Product.ProductDTO;
import com.caua.api_marketplace.Mappers.ProductMapper;
import com.caua.api_marketplace.Models.Product.ProductModel;
import com.caua.api_marketplace.Models.User.UserProducerModel;
import com.caua.api_marketplace.Repository.Product.ProductRepository;
import com.caua.api_marketplace.Repository.User.UserProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserProducerRepository userProducerRepository;

    public ResponseDTO<List<ProductDTO>> getAll(){
        List<ProductModel> productModelList = productRepository.findAll();
        List<ProductDTO> productDTOList = productMapper.listProductModelToListProductDTO(productModelList);
        return new ResponseDTO<>("Lista de todos os produtos retornada com sucesso",false,productDTOList);
    }
    public ResponseDTO<List<ProductDTO>> getAllByCategory(String category){
        List<ProductModel> productModelList = productRepository.findByCategory(category);
        List<ProductDTO> productDTOList = productMapper.listProductModelToListProductDTO(productModelList);
        return new ResponseDTO<>("Lista de todos produtos por categoria retornada com sucesso",false,productDTOList);
    }
    public ResponseDTO<List<ProductDTO>> getAllByProducer(Long id){
        UserProducerModel userProducerModel = userProducerRepository.findById(id).orElse(null);
        if(userProducerModel == null) return new ResponseDTO<>("Producer id incorreto",true,null);
        List<ProductModel> productModelList = productRepository.findByProducer(userProducerModel);
        List<ProductDTO> productDTOList = productMapper.listProductModelToListProductDTO(productModelList);
        return new ResponseDTO<>("Lista de todos os produtos por id do produtor retornada com sucesso",false,productDTOList);
    }
    public ResponseDTO<List<ProductDTO>> getAllByProducerAndCategory(Long producerId,String category){
        UserProducerModel userProducerModel = userProducerRepository.findById(producerId).orElse(null);
        if(userProducerModel == null) return new ResponseDTO<>("Producer id incorreto",true,null);
        List<ProductModel> productModelList = productRepository.findByProducer(userProducerModel);
        List<ProductModel> listProductModelByProducerAndCategory = new ArrayList<>();
        for(ProductModel productModel : productModelList){
            if(productModel.getCategory().equals(category)) listProductModelByProducerAndCategory.add(productModel);
        }
        List<ProductDTO> listProductDTOByProducerAndCategory = productMapper.listProductModelToListProductDTO(listProductModelByProducerAndCategory);
        return new ResponseDTO<>("Lista de todos os produtos por id do produtor e categoria retornada com sucesso",false,listProductDTOByProducerAndCategory);
    }
    public ResponseDTO<ProductDTO> createProduct(CreateProductDTO createProductDTO) {
        ProductModel productModel = productRepository.save(productMapper.createPorductDTOtoProductModel(createProductDTO));
        ProductDTO product = productMapper.productModelToProductDTO(productModel);
        return new ResponseDTO<>("Produto criado com sucesso",false,product);
    }
    public ResponseDTO<ProductDTO> updateProduct(ProductDTO productDTO) {
        ProductModel productModel = productRepository.findById(productDTO.getId()).orElse(null);
        if(productModel == null) return new ResponseDTO<>("product id incorreto",true,null);
        productModel.setName(productDTO.getName());
        productModel.setImage(productModel.getImage());
        productModel.setQuantity(productDTO.getQuantity());
        productModel.setPrice(productDTO.getPrice());
        productModel.setCategory(productDTO.getCategory());
        ProductModel  productModelModed = productRepository.save(productModel);
        ProductDTO productDTOModed = productMapper.productModelToProductDTO(productModelModed);
        return new ResponseDTO<>("Produto modificado com sucesso",false,productDTOModed);
    }
    public ResponseDTO<ProductDTO> deleteProduct(Long id){
        ProductModel productModel = productRepository.findById(id).orElse(null);
        if(productModel == null) return new ResponseDTO<>("product id incorreto",true,null);
        productRepository.delete(productModel);
        ProductDTO productDTO = productMapper.productModelToProductDTO(productModel);
        return new ResponseDTO<>("Produto removido com sucesso",false,productDTO);
    }
}
