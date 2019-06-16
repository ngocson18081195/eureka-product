package eurekaproduct.controller;

import eurekaproduct.entity.ProductEntity;
import eurekaproduct.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Create by ngocson on 29/04/2019
 */
@RefreshScope
@RestController
@RequestMapping(value = "/")
public class productController {

    @Value("${app.service-name}")
    private String serviceName;

    @Autowired
    private productRepository productRepository;

    @GetMapping(value = "/list")
    public ResponseEntity getAllList() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping(value = "/create")
    public ResponseEntity createProduct() {
        ProductEntity productEntity = new ProductEntity();
//        productEntity.setId((long) 1);
        productEntity.setName("Son");
        return ResponseEntity.ok(productRepository.save(productEntity));
    }
//
//    @GetMapping(value = "/{productId}")
//    public ResponseEntity findProduct(@PathVariable Long productId) {
//        return ResponseEntity.ok(productDTOS.stream().filter(
//                ProductDTO -> ProductDTO.getId().equals(productId))
//        .findFirst().orElse(null));
//    }

    @GetMapping("/service")
    public String getServiceName() {
        return "Service name: ["+ this.serviceName +"]";
    }
}
