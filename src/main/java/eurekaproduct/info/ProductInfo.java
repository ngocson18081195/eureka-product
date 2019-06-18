package eurekaproduct.info;

import lombok.Data;

@Data
public class ProductInfo {

    private Long id;
    private String name;
    private Double price;
    private String imageUrl;
}
