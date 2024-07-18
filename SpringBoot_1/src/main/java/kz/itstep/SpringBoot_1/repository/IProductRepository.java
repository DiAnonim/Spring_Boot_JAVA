package kz.itstep.SpringBoot_1.repository;

import kz.itstep.SpringBoot_1.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.product_name = :name")
    Product findByName(String name);
}
