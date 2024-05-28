////package com.intern.pentafox.employee.service;
////
////
////import com.intern.pentafox.employee.entity.Product;
////import com.intern.pentafox.employee.repository.ProductRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////
////@Service
////public class ProductService {
////    @Autowired
////    private ProductRepository repository;
////
////    public Product saveProduct (Product product) {
////        return repository.save(product);
////    }
////
////    public List<Product> saveProducts(List<Product> products) {
////        return repository.saveAll(products);
////
////    }
////
////    public List<Product> getProducts() {
////        return repository.findAll();
////    }
////
////    public Product getProductById(int id) {
////        return repository.findById(id).orElse(null);
////    }
////
////    public Product getProductByName(String name) {
////        return repository.getByName(name);
////    }
////
////    public String deleteProduct(int id) {
////        repository.deleteById(id);
////        return "deleted";
////    }
////
////    public Product updateProduct(Product product) {
////        Product exixtingProduct = repository.findById(product.getId()).orElse(null);
////        exixtingProduct.setName(product.getName());
////        exixtingProduct.setPrice(product.getPrice());
////        exixtingProduct.setQuantity(product.getQuantity());
////        return repository.save(exixtingProduct);
////
////    }
////}
//package com.intern.pentafox.employee.service;
//
//import com.intern.pentafox.employee.entity.Product;
//import com.intern.pentafox.employee.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class ProductService {
//
//    @Autowired
//    private ProductRepository repository;
//
////    public Product saveProduct(Product product) {
////        return repository.save(product);
////    }
//
//public Product saveProduct(Product product) {
//    try {
//        return repository.save(product);
//    } catch (Exception ex) {
//        throw new RuntimeException("Error saving product: " + ex.getMessage(), ex);
//    }
//}
//
//
////    public List<Product> saveProducts(List<Product> products) {
////        return repository.saveAll(products);
////    }
//
//    public List<Product> saveProducts(List<Product> products){
//    try {
//        return repository.saveAll(products);
//    }
//    catch (Exception e){
//        throw  new RuntimeException("Error saving product :"+ e.getMessage(),e);
//
//    }
//    }
//
////    public List<Product> getProducts() {
////        return repository.findAll();
////    }
//
//public List<Product> getProducts() {
//    try{
//        return repository.findAll();
//    }
//    catch (Exception e){
//        throw new RuntimeException("Error getting product:"+e.getMessage(),e);
//    }
//}
//
//
////    public Product getProductById(int id) {
////
////        return repository.findById(id)
////                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
////    }
//
//    public Product getProductById(int id) {
//        try {
//            Product product = repository.findById(id).orElse(null);
//            if (product != null) {
//                return product;
//            } else {
//                throw new RuntimeException("Product not found with ID: " + id);
//            }
//        } catch (Exception ex) {
//            throw new RuntimeException("Error fetching product by ID: " + ex.getMessage(), ex);
//        }
//    }
//
//
////    public Product getProductByName(String name) {
////        return repository.findByName(name).orElseThrow(() -> new ProductNotFoundException("Product not found with name: " + name));
////    }
//
//public Product getProductByName(String name) {
//    try {
//        Product  product = repository.findByName(name).orElse(null);
//        if (product != null) {
//            return product;
//        } else {
//            throw new RuntimeException("Product not found with name: " + name);
//        }
//    } catch (Exception ex) {
//        throw new RuntimeException("Error fetching product by Name: " + ex.getMessage(), ex);
//    }
//}
//
////    public Product updateProduct(Product product) {
////        Product existingProduct = repository.findById(product.getId())
////                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + product.getId()));
////        existingProduct.setName(product.getName());
////        existingProduct.setPrice(product.getPrice());
////        existingProduct.setQuantity(product.getQuantity());
////        return repository.save(existingProduct);
////    }
//public Product updateProduct(Product product) {
//    try {
//        Product existingProduct = repository.findById(product.getId()).orElse(null);
//        if (existingProduct == null) {
//            throw new RuntimeException("Product not found with ID: " + product.getId());
//        }
//        existingProduct.setName(product.getName());
//        existingProduct.setPrice(product.getPrice());
//        existingProduct.setQuantity(product.getQuantity());
//        return repository.save(existingProduct);
//    } catch (Exception ex) {
//        throw new RuntimeException("Error updating product: " + ex.getMessage(), ex);
//    }
//}
//
//    public String deleteProduct(int id) {
//        if (!repository.existsById(id)) {
//            throw new RuntimeException("Product not found with ID: " + id);
//        }
//        repository.deleteById(id);
//        return "deleted";
//
//    }
//}
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

    public Product saveProduct(Product product) {
        try {
            return repository.save(product);
        } catch (Exception ex) {
            throw new RuntimeException("Error saving product: " + ex.getMessage());
        }
    }

    public List<Product> saveProducts(List<Product> products) {
        try {
            return repository.saveAll(products);
        } catch (Exception ex) {
            throw new RuntimeException("Error saving products: " + ex.getMessage());
        }
    }

    public List<Product> getProducts() {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching products: " + ex.getMessage());
        }
    }

    public Product getProductById(int id) {
        try {
            Product product = repository.findById(id).orElse(null);
            if (product != null) {
                return product;
            } else {
                throw new RuntimeException("Product not found with ID: " + id);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching product by ID: " + ex.getMessage());
        }
    }

    public Product getProductByName(String name) {
        try {
            Product product = repository.findByName(name).orElse(null);
            if (product != null) {
                return product;
            } else {
                throw new RuntimeException("Product not found with name: " + name);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching product by name: " + ex.getMessage());
        }
    }

    public Product updateProduct(Product product) {
        try {
            Product existingProduct = repository.findById(product.getId()).orElse(null);
            if (existingProduct != null) {
                existingProduct.setName(product.getName());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setQuantity(product.getQuantity());
                return repository.save(existingProduct);
            } else {
                throw new RuntimeException("Product not found with ID: " + product.getId());
            }
        } catch (Exception ex) {
            throw new RuntimeException( ex.getMessage());
        }
    }

    public String deleteProduct(int id) {
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return "Successfully deleted: " + id;
            } else {
                throw new RuntimeException("Product not found with ID: " + id);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
