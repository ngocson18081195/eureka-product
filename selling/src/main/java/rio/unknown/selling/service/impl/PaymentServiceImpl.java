package rio.unknown.selling.service.impl;

import rio.unknown.dto.PromotionDTO;
import rio.unknown.selling.dto.PaymentDTO;
import rio.unknown.selling.service.ExecuteExternalService;
import rio.unknown.selling.service.PaymentService;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private ExecuteExternalService executeExternalService;

    @Override
    public void pay(PaymentDTO paymentDTO) {

    }

    @Override
    public boolean checkPromotionCode(String promotionCode) {
        // fixme --- temporary
        String host = "http://localhost:8081";
        String url = "/promotions";
        PromotionDTO promotionDTO = this.executeExternalService
            .getOneOrNull(host, url, promotionCode, PromotionDTO.class);
        if (Objects.nonNull(promotionDTO)) {
            return promotionDTO.isValid();
        }
        return false;
    }
}
