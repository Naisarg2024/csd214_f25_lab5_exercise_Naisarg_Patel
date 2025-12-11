package ca.saultcollege.lab5.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products") // Optional: specifies the table name in the database
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   // Single Table Inheritance
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING, length = 50)
@DiscriminatorValue("PRODUCT")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Optional: specifies that the 'name' column cannot be null
    private String name;

    @Column(name = "unit_price") // Optional: specifies the column name for the 'price' field
    private double price;

    public ProductEntity() {
    }

    public ProductEntity(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity productEntity = (ProductEntity) o;
        return Objects.equals(id, productEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}