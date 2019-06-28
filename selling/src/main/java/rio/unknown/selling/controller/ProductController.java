package rio.unknown.selling.controller;

import rio.unknown.annotation.Logging;
import rio.unknown.common.Response;
import rio.unknown.info.ProductInfo;
import rio.unknown.selling.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Logging
    @GetMapping
    public Response getAll() {
        List<ProductInfo> productInfoList = this.productService.getAll();
        return Response.Builder.buildSuccess(productInfoList);
    }
}
