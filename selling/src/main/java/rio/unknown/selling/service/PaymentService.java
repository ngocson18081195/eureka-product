package rio.unknown.selling.service;

import rio.unknown.selling.dto.PaymentDTO;

public interface PaymentService {

    void pay(PaymentDTO paymentDTO);

    boolean checkPromotionCode(String promotionCode);
}
