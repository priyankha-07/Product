////package com.intern.pentafox.employee.controller;
////
////import com.intern.pentafox.employee.entity.Product;
////import com.intern.pentafox.employee.service.ProductService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////@RestController
////public class ProductController {
////    @Autowired
////    private ProductService service;
////
////    @PostMapping("/addProduct")
////    public Product addProduct(@RequestBody Product product){
////        return service.saveProduct(product);
////    }
////   @PostMapping("/addProducts")
////   public List<Product> addProducts(@RequestBody List<Product >products){
////        return service. saveProducts(products);
////    }
////   @GetMapping("/products")
////   public List<Product> findAllProducts()
////     {
////         return service.getProducts();
////     }
////     @GetMapping("/product{id}")
////     public Product findProductById(@PathVariable int id){
////        return service.getProductById(id);
////     }
////    @GetMapping("/product{name}")
////    public Product findProductByName(@PathVariable String name){
////        return service.getProductByName(name);
////     }
////     @PutMapping("/update")
////    public Product updateProduct(@RequestBody Product products){
////        return service.updateProduct(products);
////     }
////     @DeleteMapping("/delete{id}")
////    public String deleteProduct(@PathVariable int id)
////     {
////           service.deleteProduct(id);
////          return "Successfully deleted:"+id;
////     }
////}
////package com.intern.pentafox.employee.controller;
////
////import com.intern.pentafox.employee.entity.Product;
////import com.intern.pentafox.employee.service.ProductService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////@RestController
////@RequestMapping("/employee")
////public class ProductController {
////    @Autowired
////    private ProductService service;
////
////    @PostMapping("/addProduct")
////    public Product addProduct(@RequestBody Product product){
////        return service.saveProduct(product);
////    }
////
////    @PostMapping("/addProducts")
////    public List<Product> addProducts(@RequestBody List<Product> products){
////        return service.saveProducts(products);
////    }
////
////    @GetMapping("/products")
////    public List<Product> findAllProducts() {
////        return service.getProducts();
////    }
////
////    @GetMapping("/productById/{id}")
////    public Product findProductById(@PathVariable int id) {
////        return service.getProductById(id);
////    }
////
////    @GetMapping("/productByName/{name}")
////    public Product findProductByName(@PathVariable String name) {
////        return service.getProductByName(name);
////    }
////
////    @PutMapping("/update")
////    public Product updateProduct(@RequestBody Product product) {
////        return service.updateProduct(product);
////    }
////
////    @DeleteMapping("/delete/{id}")
////    public String deleteProduct(@PathVariable int id) {
////        service.deleteProduct(id);
////        return "Successfully deleted: " + id;
////    }
////}
////package com.intern.pentafox.employee.controller;
////
////import com.intern.pentafox.employee.entity.Product;
////import com.intern.pentafox.employee.service.ProductService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////@RestController
////@RequestMapping("/employee")
////public class ProductController {
////
////    @Autowired
////    private ProductService service;
////
////    @PostMapping("/addProduct")
////    @ResponseStatus(HttpStatus.CREATED)
////    public Product addProduct(@RequestBody Product product) {
////        try {
////            return service.saveProduct(product);
////        } catch (RuntimeException ex) {
////            throw new RuntimeException("Error saving product: " + ex.getMessage(), ex);
////        }
////    }
////
////    @PostMapping("/addProducts")
////    @ResponseStatus(HttpStatus.CREATED)
////    public List<Product> addProducts(@RequestBody List<Product> products) {
////        try {
////            return service.saveProducts(products);
////        } catch (RuntimeException ex) {
////            throw new RuntimeException("Error saving products: " + ex.getMessage(), ex);
////        }
////    }
////
////    @GetMapping("/products")
////    public List<Product> findAllProducts() {
////        try {
////            return service.getProducts();
////        } catch (RuntimeException ex) {
////            throw new RuntimeException("Error fetching products: " + ex.getMessage(), ex);
////        }
////    }
////
////    @GetMapping("/productById/{id}")
////    public Product findProductById(@PathVariable int id) {
////        try {
////            return service.getProductById(id);
////        } catch (RuntimeException ex) {
////            throw new RuntimeException("Product not found with ID: " + id);
////        } catch (RuntimeException ex) {
////            throw new RuntimeException("Error fetching product by ID: " + ex.getMessage(), ex);
////        }
////    }
////
////    @GetMapping("/productByName/{name}")
////    public Product findProductByName(@PathVariable String name) {
////        try {
////            return service.getProductByName(name);
////        } catch (ProductNotFoundException ex) {
////            throw new ProductNotFoundException("Product not found with name: " + name);
////        } catch (RuntimeException ex) {
////            throw new RuntimeException("Error fetching product by name: " + ex.getMessage(), ex);
////        }
////    }
////
////    @PutMapping("/update")
////    public Product updateProduct(@RequestBody Product product) {
////        try {
////            return service.updateProduct(product);
////        } catch (ProductNotFoundException ex) {
////            throw new ProductNotFoundException("Product not found with ID: " + product.getId());
////        } catch (RuntimeException ex) {
////            throw new RuntimeException("Error updating product: " + ex.getMessage(), ex);
////        }
////    }
////
////    @DeleteMapping("/delete/{id}")
////    @ResponseStatus(HttpStatus.OK)
////    public String deleteProduct(@PathVariable int id) {
////        try {
////            service.deleteProduct(id);
////            return "Successfully deleted: " + id;
////        } catch (ProductNotFoundException ex) {
////            throw new ProductNotFoundException("Product not found with ID: " + id);
////        } catch (RuntimeException ex) {
////            throw new RuntimeException("Error deleting product: " + ex.getMessage(), ex);
////        }
////    }
////}
////
////
//package com.intern.pentafox.employee.controller;
//
//import com.intern.pentafox.employee.entity.Product;
//import com.intern.pentafox.employee.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employee")
//public class ProductController {
//
//    @Autowired
//    private ProductService service;
//
//    @PostMapping("/addProduct")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Product addProduct(@RequestBody Product product) {
//        return service.saveProduct(product);
//    }
//
//    @PostMapping("/addProducts")
//    @ResponseStatus(HttpStatus.CREATED)
//    public List<Product> addProducts(@RequestBody List<Product> products) {
//        return service.saveProducts(products);
//    }
//
//    @GetMapping("/products")
//    public List<Product> findAllProducts() {
//        return service.getProducts();
//    }
//
//    @GetMapping("/productById/{id}")
//    public Product findProductById(@PathVariable int id) {
//        return service.getProductById(id);
//    }
//
//    @GetMapping("/productByName/{name}")
//    public Product findProductByName(@PathVariable String name) {
//        return service.getProductByName(name);
//    }
//
//    @PutMapping("/update")
//    public Product updateProduct(@RequestBody Product product) {
//        return service.updateProduct(product);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public String deleteProduct(@PathVariable int id) {
//        return service.deleteProduct(id);
//    }
//}
//
package com.intern.pentafox.employee.controller;

import com.intern.pentafox.employee.entity.Product;
import com.intern.pentafox.employee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleRuntimeException(RuntimeException ex) {
        return ex.getMessage();
    }
}
