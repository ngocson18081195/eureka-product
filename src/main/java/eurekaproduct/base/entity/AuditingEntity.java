package eurekaproduct.base.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class AuditingEntity extends BaseCommonEntity {

    @CreatedBy
    @Column(name = "CreatedBy")
    private String createdBy;

    @CreatedDate
    @Column(name = "CreatedDate")
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LastModifiedBy")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LastModifiedDate")
    private Date lastModifiedDate;
}
