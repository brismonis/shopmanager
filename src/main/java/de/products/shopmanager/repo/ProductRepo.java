package de.products.shopmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import de.products.shopmanager.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> { // Repo is for class Product and foreign key Long id
    // gives access to methods from JpaRepository like save, find, delete etc.

}
