//package com.intern.pentafox.employee;
//
//import com.intern.pentafox.employee.entity.Product;
//import com.intern.pentafox.employee.repository.ProductRepository;
//import com.intern.pentafox.employee.service.ProductService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//class ProductServiceTest {
//
//    @Mock
//    private ProductRepository repository;
//
//    @InjectMocks
//    private ProductService service;
//
//    private Product product1;
//    private Product product2;
//    private Product product3;
//    private Product product4;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        product1 = new Product(1, "Product1", 1, 100);
//        product2 = new Product(2, "Product2", 2, 200);
//        product3 = new Product(3, "Product3", 1, 100);
//        product4 = new Product(4, "Product4", 2, 200);
//    }
//
//    @Test
//    void testSaveProduct() {
//        when(repository.save(any(Product.class))).thenReturn(product1);
//        Product savedProduct = service.saveProduct(product1);
//        assertNotNull(savedProduct);
//        assertEquals(product1.getId(), savedProduct.getId());
//    }
//
//    @Test
//    void testSaveProducts() {
//        List<Product> productList = Arrays.asList(product1, product2,product3,product4);
//        when(repository.saveAll(anyList())).thenReturn(productList);
//        List<Product> savedProducts = service.saveProducts(productList);
//        assertNotNull(savedProducts);
//        assertEquals(4, savedProducts.size());
//    }
//
//    @Test
//    void testGetProducts() {
//        List<Product> productList = Arrays.asList(product1, product2,product3,product4);
//        when(repository.findAll()).thenReturn(productList);
//        List<Product> products = service.getProducts();
//        assertNotNull(products);
//        assertEquals(4, products.size());
//    }
//
//    @Test
//    void testGetProductById() {
//        when(repository.findById(1)).thenReturn(Optional.of(product1));
//        Product product = service.getProductById(1);
//        assertNotNull(product);
//        assertEquals(product1.getId(), product.getId());
//    }
//
//    @Test
//    void testGetProductByName() {
//        when(repository.findByName("Product1")).thenReturn(Optional.of(product1));
//        Product product = service.getProductByName("Product1");
//        assertNotNull(product);
//        assertEquals(product1.getName(), product.getName());
//    }
//
//    @Test
//    void testUpdateProduct() {
//        when(repository.findById(product1.getId())).thenReturn(Optional.of(product1));
//        when(repository.save(any(Product.class))).thenReturn(product1);
//        Product updatedProduct = service.updateProduct(product1);
//        assertNotNull(updatedProduct);
//        assertEquals(product1.getName(), updatedProduct.getName());
//    }
//
//    @Test
//    void testDeleteProduct() {
//        when(repository.existsById(product1.getId())).thenReturn(true);
//        doNothing().when(repository).deleteById(product1.getId());
//        String result = service.deleteProduct(product1.getId());
//        assertEquals("Successfully deleted: " + product1.getId(), result);
//    }
//}
package com.intern.pentafox.employee;

import com.intern.pentafox.employee.entity.Product;
import com.intern.pentafox.employee.repository.ProductRepository;
import com.intern.pentafox.employee.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product1 = new Product(1, "Product1", 1, 100);
        product2 = new Product(2, "Product2", 2, 200);
        product3 = new Product(3, "Product3", 1, 100);
        product4 = new Product(4, "Product4", 2, 200);
    }

    @Test
    void testSaveProduct() {
        when(repository.save(any(Product.class))).thenReturn(product1);
        Product savedProduct = service.saveProduct(product1);
        assertNotNull(savedProduct);
        assertEquals(product1.getId(), savedProduct.getId());
    }

    @Test
    void testSaveProduct_ExceptionThrown() {
        Product product = new Product();
        when(repository.save(any(Product.class))).thenThrow(new RuntimeException("Database error"));
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.saveProduct(product)
        );
        assertEquals("Error saving product: Database error", exception.getMessage());
    }

@Test
    void testSaveProducts() {
        List<Product> productList = Arrays.asList(product1, product2, product3, product4);
        when(repository.saveAll(anyList())).thenReturn(productList);
        List<Product> savedProducts = service.saveProducts(productList);
        assertNotNull(savedProducts);
        assertEquals(4, savedProducts.size());
    }

@Test
void testSaveProducts_ExceptionThrown() {
    List<Product> productList = Arrays.asList(product1, product2, product3, product4);
    when(repository.saveAll(anyList())).thenThrow(new RuntimeException("Generic error"));
    RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> service.saveProducts(productList)
    );

    assertEquals("Error saving products: Generic error", exception.getMessage());
}
@Test
    void testGetProducts() {
        List<Product> productList = Arrays.asList(product1, product2, product3, product4);
        when(repository.findAll()).thenReturn(productList);
        List<Product> products = service.getProducts();
        assertNotNull(products);
        assertEquals(4, products.size());
    }
    @Test
    void testGetProducts_ExceptionThrown() {
        when(repository.findAll()).thenThrow(new RuntimeException("Database error"));
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.getProducts()
        );
        assertEquals("Error fetching products: Database error", exception.getMessage());
    }
    @Test
    void testGetProductById() {
        when(repository.findById(1)).thenReturn(Optional.of(product1));
        Product product = service.getProductById(1);
        assertNotNull(product);
        assertEquals(product1.getId(), product.getId());
    }
    @Test
    void testGetProductById_NotFound() {
        when(repository.findById(1)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.getProductById(1)
        );

        assertEquals("Error fetching product by ID: Product not found with ID: 1", exception.getMessage());
    }

    @Test
    void testGetProductByName() {
        when(repository.findByName("Product1")).thenReturn(Optional.of(product1));
        Product product = service.getProductByName("Product1");
        assertNotNull(product);
        assertEquals(product1.getName(), product.getName());
    }
    @Test
    void testGetProductByName_ExceptionThrown() {
        String productName = "Product1";

        when(repository.findByName(productName)).thenThrow(new RuntimeException("NameNotFoundException"));
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.getProductByName(productName)
        );

        assertEquals("Error fetching product by name: NameNotFoundException", exception.getMessage());
    }


    @Test
    void testUpdateProduct() {
        when(repository.findById(product1.getId())).thenReturn(Optional.of(product1));
        when(repository.save(any(Product.class))).thenReturn(product1);
        Product updatedProduct = service.updateProduct(product1);
        assertNotNull(updatedProduct);
        assertEquals(product1.getName(), updatedProduct.getName());
    }
    @Test
    void testUpdateProduct_ProductNotFound() {
        when(repository.findById(product1.getId())).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.updateProduct(product1)
        );

        assertEquals("Product not found with ID: " + product1.getId(), exception.getMessage());
    }

    @Test
    void testUpdateProduct_ExceptionThrown() {
        when(repository.findById(product1.getId())).thenReturn(Optional.of(product1));
        when(repository.save(any(Product.class))).thenThrow(new RuntimeException("Error updating product:Database error"));

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.updateProduct(product1)
        );

        assertEquals("Error updating product:Database error", exception.getMessage());
    }


    @Test
    void testDeleteProduct() {
        when(repository.existsById(product1.getId())).thenReturn(true);
        doNothing().when(repository).deleteById(product1.getId());

        // Call the method under test
        String result = service.deleteProduct(product1.getId());
        assertEquals("Successfully deleted: " + product1.getId(), result);
    }

    @Test
    void testDeleteProduct_ProductNotFound() {
        when(repository.existsById(product1.getId())).thenReturn(false);
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.deleteProduct(product1.getId())
        );

        assertEquals("Product not found with ID: " + product1.getId(), exception.getMessage());
    }

}
