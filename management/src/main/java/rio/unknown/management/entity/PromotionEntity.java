package rio.unknown.management.entity;

import rio.unknown.base.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "promotion")
@Data
public class PromotionEntity extends BaseEntity {

}
