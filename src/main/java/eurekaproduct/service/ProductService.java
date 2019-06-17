package eurekaproduct.service;

import eurekaproduct.base.entity.BaseEntity;
import eurekaproduct.base.service.BaseService;
import eurekaproduct.base.dto.BaseCommonDTO;
import eurekaproduct.entity.ProductEntity;
import org.springframework.stereotype.Service;

/**
 * Create by ngocson on 16/06/2019
 */
@Service
public class ProductService extends BaseService {


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
}
