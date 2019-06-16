package eurekaproduct.entity;

import eurekaproduct.BaseEntity.BaseCommonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Create by ngocson on 16/06/2019
 */
@Entity
@Table(name = "supplier")
public class SupplierEntity extends BaseCommonEntity {

    @Column(name = "Company")
    private String company;

    @Column(name = "Addess")
    private String address;
}
