package eurekaproduct.service;

import eurekaproduct.base.service.BaseServiceCommon;
import eurekaproduct.dto.ProductDTO;
import eurekaproduct.info.ProductInfo;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ProductService extends BaseServiceCommon<ProductInfo, ProductDTO> {

    ProductDTO update(MultipartFile img, Map<String, String> data);

    ProductDTO create(MultipartFile img, Map<String, String> data);
}
