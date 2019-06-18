package eurekaproduct.service;

import eurekaproduct.dto.ProductDTO;
import eurekaproduct.info.ProductInfo;

import java.util.List;

public interface ProductService {

    List<ProductInfo> getAll();

    ProductDTO getOne(Long id);

    boolean delete(Long id);

    ProductDTO save(ProductDTO productDto);
}
