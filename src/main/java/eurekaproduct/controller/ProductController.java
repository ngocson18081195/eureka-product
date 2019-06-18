package eurekaproduct.controller;

import eurekaproduct.annotation.Logging;
import eurekaproduct.base.controller.BaseController;
import eurekaproduct.common.Response;
import eurekaproduct.dto.ProductDTO;
import eurekaproduct.entity.ProductEntity;
import eurekaproduct.repository.ProductRepository;
import eurekaproduct.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * Create by ngocson on 29/04/2019
 */
@RestController
@RequestMapping(value = "/products")
@Slf4j
public class ProductController extends BaseController {

    @Value("${app.service-name}")
    private String serviceName;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

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
        return "Service name: [" + this.serviceName + "]";
    }

    @GetMapping
    @Logging
    public Response getAll() {
        //        List<ProductInfo> productInfoList = this.productService.getAll();
        List<ProductEntity> all = this.productRepository.findAll();
        return Response.Builder.buildSuccess(all);
    }

    @PostMapping
    @Logging
    public Response save(@RequestBody ProductDTO productDTO) {
        ProductDTO result = this.productService.save(productDTO);
        return Response.Builder.buildSuccess(result);
    }

    @GetMapping("/{id}")
    @Logging
    public Response getOne(@PathVariable(value = "id") Long id) {
        ProductDTO productDto = this.productService.getOne(id);
        return Response.Builder.buildSuccess(productDto);
    }

    @DeleteMapping("/{id}")
    @Logging
    public Response delete(@PathVariable(value = "id") Long id) {
        boolean success = this.productService.delete(id);
        return Response.Builder.buildSuccess(success);
    }
}
