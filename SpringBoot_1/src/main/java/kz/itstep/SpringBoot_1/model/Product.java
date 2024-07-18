package kz.itstep.SpringBoot_1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "product_name", nullable = false, length = 50, unique = true)
    @NotNull(message = "Product name cannot be null")
    @NotEmpty(message = "Product name cannot be empty")
    @Size(min = 4, max = 50)
    private String product_name;

    @Column(name = "product_description")
    private String product_description;

    @Column(name = "product_price", nullable = false)
    @NotNull(message = "Product price cannot be null")
    @NotEmpty(message = "Product price cannot be empty")
    private Integer product_price;
}
