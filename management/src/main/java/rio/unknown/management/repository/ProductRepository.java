package rio.unknown.management.repository;

import rio.unknown.management.entity.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Create by ngocson on 18/05/2019
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    boolean existsByCode(String code);
}
