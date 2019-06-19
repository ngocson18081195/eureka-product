package eurekaproduct.entity;

import eurekaproduct.base.entity.AuditingEntity;

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

    @Column(name = "ProductCode")
    private String code;

    @Column(name = "Price")
    private Double price;

    @Column(name = "ImageUrl")
    private String imageUrl;

    @Column(name = "WeightKg")
    private Double weightKg;

    @Column(name = "Quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetailEntities;
}
