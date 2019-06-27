package eurekaproduct.dto;

import eurekaproduct.base.dto.BaseCommonDTO;
import lombok.Data;

@Data
public class ProductDTO extends BaseCommonDTO {

    private String imageUrl;
    private String code;
    private Double price;
    private Double weightKg;
    private Integer quantity;
}
