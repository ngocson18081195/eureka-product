package rio.unknown.management.entity;

import rio.unknown.base.entity.AuditingEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import lombok.Data;

/**
 * Create by ngocson on 18/05/2019
 */
@Entity
@Table(name = "product")
@Data
public class ProductEntity extends AuditingEntity {

    @Column(name = "ProductCode", unique = true, nullable = false)
    private String code;

    @Column(name = "Price", nullable = false)
    private Double price;

    @Column(name = "ImageUrl")
    private String imageUrl;

    @Column(name = "WeightKg", nullable = false)
    private Double weightKg;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetailEntities;
}
