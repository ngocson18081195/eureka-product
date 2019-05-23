package eurekaproduct.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Create by ngocson on 18/05/2019
 */
@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class ProductEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;
}
