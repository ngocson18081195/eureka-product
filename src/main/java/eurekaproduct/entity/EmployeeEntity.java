package eurekaproduct.entity;

import eurekaproduct.base.entity.BaseCommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Create by ngocson on 16/06/2019
 */
@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class EmployeeEntity extends BaseCommonEntity {

    @Column(name = "BrithDay", nullable = true)
    private Date brithDay;

    @Column(name = "Address", nullable = true)
    private String address;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orderEntityList;
}
