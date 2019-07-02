package rio.unknown.selling.dto;

import rio.unknown.info.ProductInfo;

import java.util.List;

import lombok.Data;

@Data
public class PaymentDTO {

    private CustomerDTO customer;
    private List<ProductInfo> productInfoes;
    private List<String> promotionCodes;
}
