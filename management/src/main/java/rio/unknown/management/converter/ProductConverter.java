package rio.unknown.management.converter;

import rio.unknown.management.dto.ProductDTO;
import rio.unknown.management.entity.ProductEntity;
import rio.unknown.info.ProductInfo;

import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public void convertProductInfo(ProductInfo destination, ProductEntity source) {
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setCode(source.getCode());
        destination.setPrice(source.getPrice());
        destination.setImageUrl(source.getImageUrl());
    }

    public void convertProductDto(ProductDTO destination, ProductEntity source) {
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setCode(source.getCode());
        destination.setImageUrl(source.getImageUrl());
        destination.setPrice(source.getPrice());
        destination.setQuantity(source.getQuantity());
        destination.setWeightKg(source.getWeightKg());
    }

    public void convertProductEntity(ProductEntity destination, ProductDTO source) {
        destination.setId(source.getId());
        destination.setName(source.getName());
        destination.setCode(source.getCode());
        destination.setImageUrl(source.getImageUrl());
        destination.setPrice(source.getPrice());
        destination.setQuantity(source.getQuantity());
        destination.setWeightKg(source.getWeightKg());
    }
}
