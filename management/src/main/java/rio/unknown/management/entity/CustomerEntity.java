package rio.unknown.management.entity;

import rio.unknown.base.entity.BaseCommonEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import lombok.Data;

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
