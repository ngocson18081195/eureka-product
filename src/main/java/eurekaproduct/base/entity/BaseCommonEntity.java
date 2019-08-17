package eurekaproduct.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Create by ngocson on 15/06/2019
 */
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseCommonEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

}
