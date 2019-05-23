package eurekaproduct.controller;

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
@RequestMapping(value = "/product")
public class productController {
//    private List<ProductDTO> productDTOS = Arrays.asList(
//            new ProductDTO(1L, "Dress"),
//            new ProductDTO(2L, "Clothes")
//    );

    @Value("${app.service-name}")
    private String serviceName;

//    @GetMapping(value = "/list")
//    public ResponseEntity getAllList() {
//        return ResponseEntity.ok(productDTOS);
//    }
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
