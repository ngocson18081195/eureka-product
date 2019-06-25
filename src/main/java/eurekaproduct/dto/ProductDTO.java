package eurekaproduct.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String code;
    private String imageUrl;
    private Double price;
    private Double weightKg;
    private Integer quantity;
}
