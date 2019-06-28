package rio.unknown.selling.controller;

import rio.unknown.annotation.Logging;
import rio.unknown.common.Response;
import rio.unknown.info.ProductInfo;
import rio.unknown.selling.dto.PaymentDTO;
import rio.unknown.selling.service.PaymentService;
import rio.unknown.selling.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;

    @Logging
    @GetMapping("/products")
    public Response getAll() {
        List<ProductInfo> productInfoList = this.productService.getAll();
        return Response.Builder.buildSuccess(productInfoList);
    }

    @Logging
    @PostMapping("/promotion")
    public Response checkPromotion(@RequestBody String promotionCode) {
        boolean isValid = this.paymentService.checkPromotionCode(promotionCode);
        return Response.Builder.buildSuccess(isValid);
    }

    @Logging
    @PostMapping("/payment")
    public Response acceptPay(@RequestBody PaymentDTO paymentDTO) {
        this.paymentService.pay(paymentDTO);
        return Response.Builder.buildSuccess(null);
    }
}
