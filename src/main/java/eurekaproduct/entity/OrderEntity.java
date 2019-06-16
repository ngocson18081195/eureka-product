package eurekaproduct.entity;

import eurekaproduct.BaseEntity.BaseCommonEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Create by ngocson on 15/06/2019
 */
@Entity
@Table(name = "Order")
@Data
public class OrderEntity extends BaseCommonEntity {

}
