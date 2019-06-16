package eurekaproduct.entity;

import eurekaproduct.BaseEntity.BaseCommonEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @Column(name = "order")
    private Integer order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeObjectRef")
    private EmployeeEntity employeeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerObjectRef")
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "orderEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetailEntity> orderDetailEntities;
}
