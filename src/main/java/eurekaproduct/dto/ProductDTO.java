package eurekaproduct.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String imageUrl;
    private String code;
    private Double price;
    private Double weightKg;
    private Integer quantity;
}
