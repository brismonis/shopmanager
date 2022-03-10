package de.products.shopmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import de.products.shopmanager.model.Product;

import java.util.Optional;

// PART OF MODEL (INTERACTION)

// Repo is for class Product and foreign key Long id
// gives access to methods from JpaRepository like save, find, delete etc. (can be done manually but better to safe time)
public interface ProductRepo extends JpaRepository<Product, Long> {
    void deleteProductById(Long id);
    // if there is no Product: Optional for maybe empty object
    Optional<Product> findProductById(Long id);
}
