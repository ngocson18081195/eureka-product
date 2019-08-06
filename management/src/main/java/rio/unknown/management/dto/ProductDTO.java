package rio.unknown.management.dto;

import org.springframework.web.multipart.MultipartFile;
import rio.unknown.base.dto.BaseCommonDTO;

import lombok.Data;

@Data
public class ProductDTO extends BaseCommonDTO {

    private String code;
    private String imageUrl;
    private Double price;
    private Double weightKg;
    private Integer quantity;
    private MultipartFile img;
}
