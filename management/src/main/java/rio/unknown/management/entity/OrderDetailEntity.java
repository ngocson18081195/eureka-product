package rio.unknown.management.entity;

import rio.unknown.base.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

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
