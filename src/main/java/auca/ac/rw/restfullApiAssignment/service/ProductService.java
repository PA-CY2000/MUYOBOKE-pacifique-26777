package auca.ac.rw.restfullApiAssignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auca.ac.rw.restfullApiAssignment.modal.Product;
import auca.ac.rw.restfullApiAssignment.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository proRepository;

    public Product saveProduct(Product product){
        return proRepository.save(product);
    }

    public List<Product> getAllProducts(){
        return proRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return proRepository.findById(id);
    }

    public Product updateProduct(Long id, Product productDetails){
        Product product = proRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Product not found"));
        
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        product.setCategory(productDetails.getCategory());
        product.setStockQuantity(productDetails.getStockQuantity());
        product.setBrand(productDetails.getBrand());
        
        return proRepository.save(product);
    }

    public void deleteProduct(Long id){
        proRepository.deleteById(id);
    }
}
