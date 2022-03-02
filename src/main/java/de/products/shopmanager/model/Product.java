package de.products.shopmanager.model; // wie bei DJango: in Model werden die Datenbankattribute festgelegt

import javax.persistence.*;
import java.io.Serializable; // helps transform this Java Class into different types of streams e.g. JSON

@Entity //makes sure this Class is mapped to Database we configured
public class Product implements Serializable {
    @Id // set primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // how to generate DB info
    @Column(nullable = false, updatable = false) // null not allowed, not updateable ! (DB)
    private Long id; // Produkt ID
    private String title; // Produkt Titel
    private float price; // Preis des Produkts
    private int quantity; // Lagermenge des Produkts
    private String imageUrl; // Product Image
    @Column(nullable = false, updatable = false) // null not allowed, not updateable ! (DB)
    private String productCode;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", imageUrl='" + imageUrl + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Product(Long id, String title, float price, int quantity, String imageUrl, String productCode) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.productCode = productCode;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getProductCode() {
        return productCode;
    }
}
