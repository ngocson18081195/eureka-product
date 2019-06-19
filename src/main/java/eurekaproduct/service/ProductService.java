package eurekaproduct.service;

import eurekaproduct.dto.ProductDTO;
import eurekaproduct.info.ProductInfo;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

    List<ProductInfo> getAll();

    ProductDTO getOne(Long id);

    boolean delete(Long id);

    ProductDTO update(MultipartFile img, Map<String, String> data);

    ProductDTO create(MultipartFile img, Map<String, String> data);
}
