package com.intern.pentafox.employee.service;


import com.intern.pentafox.employee.entity.Product;
import com.intern.pentafox.employee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct (Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);

    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.getByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "deleted";
    }

    public Product updateProduct(Product product) {
        Product exixtingProduct = repository.findById(product.getId()).orElse(null);
        exixtingProduct.setName(product.getName());
        exixtingProduct.setPrice(product.getPrice());
        exixtingProduct.setQuantity(product.getQuantity());
        return repository.save(exixtingProduct);

    }
}
