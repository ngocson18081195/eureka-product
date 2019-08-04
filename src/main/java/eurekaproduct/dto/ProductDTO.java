package eurekaproduct.dto;

import eurekaproduct.base.dto.BaseCommonDTO;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductDTO extends BaseCommonDTO {

    private String code;
    private String imageUrl;
    private Double price;
    private Double weightKg;
    private Integer quantity;
}
