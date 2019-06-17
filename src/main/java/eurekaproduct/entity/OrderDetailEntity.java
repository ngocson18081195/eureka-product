package eurekaproduct.entity;

import eurekaproduct.base.entity.BaseEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Create by ngocson on 16/06/2019
 */
@Entity
@Table(name = "orderDetail")
@Data
@ToString(callSuper = true, exclude = {"orderEntity", "productEntity"})
public class OrderDetailEntity extends BaseEntity {

    @Column(name = "UnitPrice", nullable = true)
    private double unitPrice;

    @Column(name = "Quanlity", nullable = true)
    private int quanlity;

    @Column(name = "Discount", nullable = true)
    private double discount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderObjectRef")
    private OrderEntity orderEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductObjectRef")
    private ProductEntity productEntity;
}
