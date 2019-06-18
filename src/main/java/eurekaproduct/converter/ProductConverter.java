package eurekaproduct.converter;

import eurekaproduct.dto.ProductDTO;
import eurekaproduct.entity.ProductEntity;
import eurekaproduct.info.ProductInfo;

import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public void convertProductInfo(ProductInfo destination, ProductEntity source) {
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setPrice(source.getPrice());
        destination.setImageUrl(source.getImageUrl());
    }

    public void convertProductDto(ProductDTO destination, ProductEntity source) {
        // todo
    }
}
