package rio.unknown.management.entity;

import rio.unknown.base.entity.BaseCommonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Create by ngocson on 16/06/2019
 */
@Entity
@Table(name = "supplier")
public class SupplierEntity extends BaseCommonEntity {

    @Column(name = "Company", nullable = true)
    private String company;

    @Column(name = "Addess", nullable = true)
    private String address;

    @Column(name = "City", nullable = true)
    private String City;

    @Column(name = "Phone", nullable = true)
    private String phone;

}
