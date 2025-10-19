// package com.kootoncalli.kooton_calli.util;

// import java.math.BigDecimal;
// import java.time.LocalDate;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Profile;
// import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;

// import com.kootoncalli.kooton_calli.model.Discount;
// import com.kootoncalli.kooton_calli.model.Product;
// import com.kootoncalli.kooton_calli.repository.DiscountRepository;


// @Component
// @Order(4)
// @Profile("dev")
// public class DiscountDataLoader implements CommandLineRunner{

//     private final DiscountRepository discountRepository;
//     //private final ProductRepository productRepository;

    
    
//     public DiscountDataLoader(DiscountRepository discountRepository, ProductRepository productRepository) {
//         this.discountRepository = discountRepository;
//         //this.productRepository = productRepository;
//     }



//     @Override
//     public void run(String... args) throws Exception {

//         Product pantalonProduct = productRepository.findByProductName("pantalon")
//         .orElseThrow(() -> new IllegalStateException("Role 'pantalon' not found"));

//         Discount summer = new Discount();
//         summer.setDiscountName("Descuento de Verano");
//         summer.setDiscountAmount(BigDecimal.valueOf(15.00));
//         summer.setDiscountStartDate(LocalDate.of(2025,02,26));
//         summer.setDiscountEndDate(LocalDate.of(2025,05,11));


//         summer.setProduct(pantalonProduct);

//         discountRepository.save(summer);
//     }

// }
