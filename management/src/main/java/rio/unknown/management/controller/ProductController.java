package rio.unknown.management.controller;

import rio.unknown.annotation.Logging;
import rio.unknown.base.controller.BaseController;
import rio.unknown.common.Response;
import rio.unknown.management.dto.ProductDTO;
import rio.unknown.management.entity.ProductEntity;
import rio.unknown.info.ProductInfo;
import rio.unknown.management.repository.ProductRepository;
import rio.unknown.management.service.ProductService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping("/service")
    public String getServiceName() {
        return "Service name: [" + this.serviceName + "]";
    }

    @GetMapping
    @Logging
    public Response getAll(@RequestParam(required = false) String condition) {
        List<ProductInfo> productInfoList = this.productService.getAll(condition);
        return Response.Builder.buildSuccess(productInfoList);
    }

    @PostMapping
    @Logging
    public Response create(@RequestParam(value = "img", required = false) MultipartFile img, @RequestParam Map<String, String> data) {
        ProductDTO result = this.productService.create(img, data);
        return Response.Builder.buildSuccess(result);
    }

    @PutMapping
    @Logging
    public Response update(@RequestParam(value = "img", required = false) MultipartFile img, @RequestParam Map<String, String> data) {
        ProductDTO result = this.productService.update(img, data);
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
