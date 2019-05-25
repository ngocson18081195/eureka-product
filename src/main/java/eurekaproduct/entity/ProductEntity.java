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
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
//    @SequenceGenerator(name = "product_seq_gen", sequenceName = "product_id_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "productname")
    private String productName;
}
