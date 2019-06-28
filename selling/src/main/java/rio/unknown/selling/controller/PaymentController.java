package rio.unknown.selling.controller;

import rio.unknown.annotation.Logging;
import rio.unknown.common.Response;
import rio.unknown.selling.dto.PaymentDTO;
import rio.unknown.selling.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @Logging
    public Response acceptPay(@RequestBody PaymentDTO paymentDTO) {
        paymentService.pay(paymentDTO);
        return Response.Builder.buildSuccess(null);
    }
}
