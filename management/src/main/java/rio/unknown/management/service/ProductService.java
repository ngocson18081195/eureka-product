package rio.unknown.management.service;

import rio.unknown.base.service.BaseServiceCommon;
import rio.unknown.management.dto.ProductDTO;
import rio.unknown.info.ProductInfo;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface ProductService extends BaseServiceCommon<ProductInfo, ProductDTO> {

    ProductDTO update(MultipartFile img, Map<String, String> data);

    ProductDTO create(MultipartFile img, Map<String, String> data);

    boolean deleteAll(List<Long> ids);
}
