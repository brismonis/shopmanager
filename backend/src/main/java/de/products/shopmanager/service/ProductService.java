package de.products.shopmanager.service;

import de.products.shopmanager.exception.UserNotFoundException;
import de.products.shopmanager.model.Product;
import de.products.shopmanager.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

// whenever this Service is constructed the repo is inside of it
// CONNECTED TO DATABASE (MODEL)
// PART OF MODEL (INTERACTION)

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // METHODS TO INTERACT WITH DATABASE, WILL BE CALLED WHEN CONTROLLER GETS CLIENT REQUESTS

    public Product addProduct(Product product) {
        product.setProductCode((UUID.randomUUID().toString())); // random UUID for every Product
        return productRepo.save((product));
    }

    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public Product updateProducts(Product product) {
        return productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.deleteProductById(id);
    }

    public Product findProductById(Long id) {
        return productRepo.findProductById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found."));
    }

}

