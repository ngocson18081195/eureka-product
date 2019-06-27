package rio.unknown.management.entity;

import rio.unknown.management.base.entity.BaseCommonEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Create by ngocson on 15/06/2019
 */
@Entity
@Table(name = "Order")
@Data
public class OrderEntity extends BaseCommonEntity {

    @Column(name = "OrderDate", nullable = true)
    private Date orderDate;

    @Column(name = "ShipperDate", nullable = true)
    private Date shipperDate;

    @Column(name = "TotalMoney", nullable = true)
    private double totalMoney;

    @Column(name = "orderNo")
    private Integer orderNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeObjectRef")
    private EmployeeEntity employeeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerObjectRef")
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "orderEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetailEntities;
}
