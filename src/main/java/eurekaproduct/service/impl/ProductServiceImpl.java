package eurekaproduct.service.impl;

import eurekaproduct.base.entity.BaseEntity;
import eurekaproduct.base.service.BaseService;
import eurekaproduct.base.dto.BaseCommonDTO;
import eurekaproduct.common.FileUtils;
import eurekaproduct.converter.ProductConverter;
import eurekaproduct.dto.ProductDTO;
import eurekaproduct.entity.ProductEntity;
import eurekaproduct.exception.UnknownException;
import eurekaproduct.info.ProductInfo;
import eurekaproduct.repository.ProductRepository;
import eurekaproduct.service.ProductService;

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
public class ProductServiceImpl extends BaseService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FileUtils fileUtils;

    @Override
    protected BaseEntity createNewEntity() {
        ProductEntity newProductEntity = new ProductEntity();
        // TO-do implement
        return newProductEntity;
    }

    @Override
    protected BaseEntity findByName(String name) {
        return null;
    }

    @Override
    protected BaseCommonDTO convertToDTO(BaseEntity newEntity) {
        // TO-do
        return null;
    }

    @Override
    public List<ProductInfo> getAll() {
        return this.productRepository.findAll().stream()
            .map(ele -> {
                ProductInfo productInfo = this.initialInfo();
                this.productConverter.convertProductInfo(productInfo, ele);
                return productInfo;
            }).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getOne(Long id) {
        Optional<ProductEntity> optEntity = this.productRepository.findById(id);
        if (optEntity.isPresent()) {
            ProductEntity productEntity = optEntity.get();
            ProductDTO productDTO = this.initialDto();
            this.productConverter.convertProductDto(productDTO, productEntity);
            return productDTO;
        }
        String messageNotFound = String.format("Not found product with id [%s].", id);
        throw new UnknownException(messageNotFound);
    }

    @Override
    public boolean delete(Long id) {
        Optional<ProductEntity> optEntity = this.productRepository.findById(id);
        if (optEntity.isPresent()) {
            ProductEntity productEntity = optEntity.get();
            this.productRepository.delete(productEntity);
            return true;
        }
        return false;
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
        // Handle file
        String imgUrl = this.fileUtils.saveImage(img, "product");
        dto.setImageUrl(imgUrl);
        // Handle entity
        ProductEntity entity = this.initialEntity();
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

    private ProductEntity initialEntity() {
        return new ProductEntity();
    }
}
