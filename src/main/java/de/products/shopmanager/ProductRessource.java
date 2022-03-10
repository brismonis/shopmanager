package de.products.shopmanager;

import de.products.shopmanager.model.Product;
import de.products.shopmanager.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// THIS IS MY CONTROLLER (MVC) THAT CALLS MODEL (SERVICE) WHICH IS LINKED TO DATABASE

@RestController
@RequestMapping("/product")
public class ProductRessource {
    private final ProductService productService;

    public ProductRessource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all") // this adds to /product URL
    public ResponseEntity<List<Product>> getAllProducts () {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductById (@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct((product));
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Product> updateProducts(@RequestBody Product product) {
        Product updateProducts = productService.updateProducts(product);
        return new ResponseEntity<>(updateProducts, HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
