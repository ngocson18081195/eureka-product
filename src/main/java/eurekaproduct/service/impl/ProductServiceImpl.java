package eurekaproduct.service.impl;

import eurekaproduct.base.entity.BaseEntity;
import eurekaproduct.base.service.BaseService;
import eurekaproduct.base.dto.BaseCommonDTO;
import eurekaproduct.dto.ProductDTO;
import eurekaproduct.entity.ProductEntity;
import eurekaproduct.info.ProductInfo;
import eurekaproduct.service.ProductService;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Create by ngocson on 16/06/2019
 */
@Service
public class ProductServiceImpl extends BaseService implements ProductService {


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
        return null;
    }

    @Override
    public ProductDTO getOne(Long id) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public ProductDTO save(ProductDTO productDto) {
        return null;
    }
}
