package eurekaproduct.entity;

import eurekaproduct.Base.BaseEntity.BaseCommonEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Create by ngocson on 16/06/2019
 */
@Entity
@Table(name = "CustomerEntity")
@Data
public class CustomerEntity extends BaseCommonEntity {

    @Column(name = "Address", nullable = true)
    private String address;

    @Column(name = "Phone", nullable = true)
    private int phone;

    @OneToMany(mappedBy = "customerEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orderEntityList;
}
