package eurekaproduct.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import eurekaproduct.base.service.BaseService;
import eurekaproduct.common.FileUtils;
import eurekaproduct.converter.ProductConverter;
import eurekaproduct.dto.ProductDTO;
import eurekaproduct.entity.ProductEntity;
import eurekaproduct.exception.UnknownException;
import eurekaproduct.info.ProductInfo;
import eurekaproduct.repository.ProductRepository;
import eurekaproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Create by ngocson on 16/06/2019
 */
@Service
public class ProductServiceImpl extends BaseService<ProductDTO, ProductEntity,
        ProductInfo> implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FileUtils fileUtils;

    @Override
    protected ProductDTO createNewDto() {
        return new ProductDTO();
    }

    @Override
    protected Optional<ProductEntity> findOneObject(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    protected List<ProductInfo> findAll(String condition) {
        return this.productRepository.findAll().stream()
                .map(ele -> {
                    ProductInfo productInfo = this.initialInfo();
                    this.productConverter.convertProductInfo(productInfo, ele);
                    return productInfo;
                }).collect(Collectors.toList());
    }

    @Override
    protected void deleteEntity(ProductEntity productEntity) {
        this.productRepository.delete(productEntity);
    }

    @Override
    protected ProductEntity createNewEntity() {
        ProductEntity productEntity = new ProductEntity();
        // Implement
        return productEntity;
    }

    @Override
    protected ProductEntity findByName(String name) {
        return null;
    }

    @Override
    protected ProductDTO convertToDTO(ProductEntity newEntity) {
        return null;
    }

    @Override
    public ProductDTO update(MultipartFile img, Map<String, String> data) {
        ProductDTO dto = this.objectMapper.convertValue(data, ProductDTO.class);
        // Verification
        Long id = dto.getId();
        if (Objects.isNull(id)) {
            String message = "Object's id is undefined";
            throw new UnknownException(message);
        }
        // Handle entity
        Optional<ProductEntity> optEntity = this.productRepository.findById(id);
        if (optEntity.isPresent()) {
            ProductEntity entity = optEntity.get();
            // handle file
            String imgUrl = this.fileUtils.saveImage(img, "product");
            dto.setImageUrl(imgUrl);
            // update
            this.productConverter.convertProductEntity(entity, dto);
            this.productRepository.save(entity);
            return dto;
        }
        String messageNotFound = String.format("Not found product with id [%s].", id);
        throw new UnknownException(messageNotFound);
    }

    @Override
    public ProductDTO create(MultipartFile img, Map<String, String> data) {
        ProductDTO dto = this.objectMapper.convertValue(data, ProductDTO.class);
        // Verification
        if (Objects.nonNull(dto.getId())) {
            String message = "New object mustn't include id";
            throw new UnknownException(message);
        }
        if (this.productRepository.existsByCode(dto.getCode())) {
            String message = String.format("Product's code [%s] must be unique.", dto.getCode());
            throw new UnknownException(message);
        }
        // Handle file
        String imgUrl = this.fileUtils.saveImage(img, "product");
        dto.setImageUrl(imgUrl);
        // Handle entity
        ProductEntity entity = this.createNewEntity();
        this.productConverter.convertProductEntity(entity, dto);
        this.productRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    private ProductInfo initialInfo() {
        return new ProductInfo();
    }

    private ProductDTO initialDto() {
        return new ProductDTO();
    }

}
