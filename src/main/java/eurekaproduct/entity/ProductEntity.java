package eurekaproduct.entity;

import eurekaproduct.BaseEntity.BaseCommonEntity;
import eurekaproduct.BaseEntity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Create by ngocson on 18/05/2019
 */
@Entity
@Table(name = "product")
@Data
public class ProductEntity extends BaseCommonEntity {

    @Column(name = "ProductCode")
    private String code;

    @Column(name = "Price")
    private double price;

    @Column(name = "ImageUrl")
    private String imageUrl;

    @Column(name = "WeightKg")
    private double weightKg;

    @Column(name = "Quantity")
    private int quantity;

    @Column(name = "CreatedDate")
    private Date createdDate;
}
