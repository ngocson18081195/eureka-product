package eurekaproduct.entity;

import eurekaproduct.base.entity.BaseCommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Create by ngocson on 16/06/2019
 */
@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories extends BaseCommonEntity {

    @Column(name = "Description", nullable = true)
    private String description;


}
