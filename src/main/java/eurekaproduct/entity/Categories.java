package eurekaproduct.entity;

import eurekaproduct.BaseEntity.BaseCommonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Create by ngocson on 16/06/2019
 */
@Entity
@Table(name = "categories")
public class Categories extends BaseCommonEntity {

    @Column(name = "Description", nullable = true)
    private String description;


}
