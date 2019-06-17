package eurekaproduct.base.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Create by ngocson on 15/06/2019
 */
@MappedSuperclass
@Data
public class BaseCommonEntity extends BaseEntity {

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "status", nullable = true)
    private String status;

}
