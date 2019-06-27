package rio.unknown.base.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

/**
 * Create by ngocson on 15/06/2019
 */
@MappedSuperclass
@Data
public class BaseCommonEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

}
