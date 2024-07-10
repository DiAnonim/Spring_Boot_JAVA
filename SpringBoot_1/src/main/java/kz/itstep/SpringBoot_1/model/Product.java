package kz.itstep.SpringBoot_1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    private Integer product_id;
    private String product_name;
    private String product_description;
    private Integer product_price;
}
