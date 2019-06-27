package rio.unknown.management.entity;

import rio.unknown.management.base.entity.BaseCommonEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Create by ngocson on 16/06/2019
 */
@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity extends BaseCommonEntity {

    @Column(name = "BrithDay", nullable = true)
    private Date brithDay;

    @Column(name = "Address", nullable = true)
    private String address;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orderEntityList;
}
