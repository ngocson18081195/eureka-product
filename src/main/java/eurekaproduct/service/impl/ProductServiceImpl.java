package eurekaproduct.service.impl;

import eurekaproduct.base.entity.BaseEntity;
import eurekaproduct.base.service.BaseService;
import eurekaproduct.base.dto.BaseCommonDTO;
import eurekaproduct.converter.ProductConverter;
import eurekaproduct.dto.ProductDTO;
import eurekaproduct.entity.ProductEntity;
import eurekaproduct.exception.NotFoundException;
import eurekaproduct.info.ProductInfo;
import eurekaproduct.repository.ProductRepository;
import eurekaproduct.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by ngocson on 16/06/2019
 */
@Service
public class ProductServiceImpl extends BaseService implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

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
        String message = String.format("Not found product with id [%s].", id);
        throw new NotFoundException(message);
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
    public ProductDTO save(ProductDTO productDto) {
        ProductEntity productEntity = this.initialEntity();
        this.productConverter.convertProductEntity(productEntity, productDto);
        this.productRepository.save(productEntity);
        productDto.setId(productEntity.getId());
        return productDto;
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
