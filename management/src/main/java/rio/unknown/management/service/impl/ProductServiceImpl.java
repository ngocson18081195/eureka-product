package rio.unknown.management.service.impl;

import org.apache.commons.lang.BooleanUtils;
import rio.unknown.base.service.BaseService;
import rio.unknown.exception.UnknownException;
import rio.unknown.handler.FileHandler;
import rio.unknown.info.ProductInfo;
import rio.unknown.management.converter.ProductConverter;
import rio.unknown.management.dto.ProductDTO;
import rio.unknown.management.entity.ProductEntity;
import rio.unknown.management.repository.ProductRepository;
import rio.unknown.management.service.ProductService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Create by ngocson on 16/06/2019
 */
@Service
public class ProductServiceImpl extends BaseService<ProductDTO, ProductEntity, ProductInfo> implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FileHandler fileHandler;

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
        return this.productRepository.findAll().stream().map(ele -> {
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
        ProductDTO productDTO = this.initialDto();
        this.productConverter.convertProductDto(productDTO, newEntity);
        return productDTO;
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
            String imgUrl = this.fileHandler.saveImage(img, "product");
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
        if (Objects.nonNull(dto.getId())) {
            String message = "New object mustn't include id";
            throw new UnknownException(message);
        }
        if (this.productRepository.existsByCode(dto.getCode())) {
            String message = String.format("Product's code [%s] must be unique.", dto.getCode());
            throw new UnknownException(message);
        }
        // Handle file
        String imgUrl = this.fileHandler.saveImage(img, "product");
        dto.setImageUrl(imgUrl);
        // Handle entity
        ProductEntity entity = this.createNewEntity();
        this.productConverter.convertProductEntity(entity, dto);
        this.productRepository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    @Override
    public boolean deleteAll(List<Long> ids) {
        return ids.stream().map(this::delete).allMatch(BooleanUtils::isTrue);
    }

    private ProductInfo initialInfo() {
        return new ProductInfo();
    }

    private ProductDTO initialDto() {
        return new ProductDTO();
    }
}
