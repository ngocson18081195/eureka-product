package eurekaproduct.entity;

import eurekaproduct.base.entity.BaseCommonEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Create by ngocson on 18/05/2019
 */
@Entity
@Table(name = "product")
@Data
public class ProductEntity extends BaseCommonEntity {

    @Column(name = "ProductCode", nullable = true)
    private String code;

    @Column(name = "Price", nullable = true)
    private double price;

    @Column(name = "ImageUrl", nullable = true)
    private String imageUrl;

    @Column(name = "WeightKg", nullable = true)
    private double weightKg;

    @Column(name = "Quantity", nullable = true)
    private int quantity;

    @Column(name = "CreatedDate", nullable = true)
    private Date createdDate;

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetailEntities;
}
