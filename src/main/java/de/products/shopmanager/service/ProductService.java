package de.products.shopmanager.service;

import de.products.shopmanager.model.Product;
import de.products.shopmanager.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

// whenever this Service is constructed the repo is inside of it
@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        product.setProductCode((UUID.randomUUID().toString())); // random UUID for every Product
        return productRepo.save((product));
    }
}

