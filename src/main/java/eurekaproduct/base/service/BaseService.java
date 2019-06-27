package eurekaproduct.base.service;

import com.google.common.collect.Lists;
import eurekaproduct.base.entity.BaseEntity;
import eurekaproduct.base.dto.BaseCommonDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Create by ngocson on 16/06/2019
 */
@Slf4j
public abstract class BaseService<O extends BaseCommonDTO, E extends BaseEntity,
        I extends BaseCommonDTO> implements BaseServiceCommon<I> {

    @Override
    public List<I> getAll(String condition) {
        log.info("Search list - START, search condition=[{}]", condition);
        List<I> searchResult = Lists.newLinkedList();
        searchResult = this.findAll(condition);
        log.info("Search list - END, search condition=[{}]", condition);
        return searchResult;
    }

    public O create(O dto) {
        log.info("Event create object {} - START", dto);
        E foundEntity = this.findByName(dto.getName());

        E newEntity = this.createNewEntity();

        O createDto = this.convertToDTO(newEntity);
        log.info("Event create object {} - END", createDto);
        return createDto;
    }

    protected abstract List<I> findAll(String condition);

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
