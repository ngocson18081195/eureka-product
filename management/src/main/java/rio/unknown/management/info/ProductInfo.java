package rio.unknown.management.info;

import rio.unknown.base.dto.BaseCommonDTO;

import lombok.Data;

@Data
public class ProductInfo extends BaseCommonDTO {

    private String code;
    private Double price;
    private String imageUrl;
}
