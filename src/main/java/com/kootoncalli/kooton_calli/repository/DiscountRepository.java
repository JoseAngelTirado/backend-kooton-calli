package com.kootoncalli.kooton_calli.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.kootoncalli.kooton_calli.model.Discount;


public interface DiscountRepository extends CrudRepository<Discount, Integer> {
     Optional <Discount> findByDiscountName(String discountName);
     boolean existsByDiscountName(String discountName);
}
