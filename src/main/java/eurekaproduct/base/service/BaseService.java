package eurekaproduct.base.service;

import eurekaproduct.base.entity.BaseEntity;
import eurekaproduct.base.dto.BaseCommonDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * Create by ngocson on 16/06/2019
 */
@Slf4j
public abstract class BaseService<O extends BaseCommonDTO, E extends BaseEntity> {


    private O create(O dto) {
        log.info("Event create object {} - START", dto);
        E foundEntity = this.findByName(dto.getName());

        E newEntity = this.createNewEntity();

        O createDto = this.convertToDTO(newEntity);
        log.info("Event create object {} - END", createDto);
        return createDto;
    }

    private O edit(O dto) {
        return null;
    }

    private boolean delete(Long id) {
        return true;
    }

    protected abstract E createNewEntity();

    protected abstract E findByName(String name);

    protected abstract O convertToDTO(E newEntity);
}
