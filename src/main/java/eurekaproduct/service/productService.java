package eurekaproduct.service;

import eurekaproduct.Base.BaseEntity.BaseEntity;
import eurekaproduct.Base.BaseService.BaseService;
import eurekaproduct.Base.BaseDTO.BaseCommonDTO;
import eurekaproduct.entity.ProductEntity;
import org.springframework.stereotype.Service;

/**
 * Create by ngocson on 16/06/2019
 */
@Service
public class productService extends BaseService {


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
