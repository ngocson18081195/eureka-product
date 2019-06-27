package rio.unknown.management.base.service;

import rio.unknown.management.base.dto.BaseCommonDTO;
import rio.unknown.management.base.entity.BaseEntity;
import rio.unknown.management.exception.UnknownException;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

/**
 * Create by ngocson on 16/06/2019
 */
@Slf4j
public abstract class BaseService<O extends BaseCommonDTO, E extends BaseEntity,
        I extends BaseCommonDTO> implements BaseServiceCommon<I, O> {

    @Override
    public List<I> getAll(String condition) {
        log.info("Search list - START, search condition=[{}]", condition);
        List<I> searchResult = Lists.newLinkedList();
        searchResult = this.findAll(condition);
        log.info("Search list - END, search condition=[{}]", condition);
        return searchResult;
    }

    @Override
    public O getOne(Long id) {
        Optional<E> opEntity = this.findOneObject(id);
        if (opEntity.isPresent()) {
            E entity = opEntity.get();
            O dto = this.convertToDTO(entity);
            return dto;
        }
        String messageNotFound = String.format("Not found item with id [%s].", id);
        throw new UnknownException(messageNotFound);
    }

    @Override
    public boolean delete(Long id) {
        Optional<E> opEntity = this.findOneObject(id);
        if (opEntity.isPresent()) {
            E entity = opEntity.get();
            this.deleteEntity(entity);
            return true;
        }
        return false;
    }

    public O create(O dto) {
        log.info("Event create object {} - START", dto);
        E foundEntity = this.findByName(dto.getName());

        E newEntity = this.createNewEntity();

        O createDto = this.convertToDTO(newEntity);
        log.info("Event create object {} - END", createDto);
        return createDto;
    }

    protected abstract void deleteEntity(E entity);

    protected abstract O createNewDto();

    protected abstract Optional<E> findOneObject(Long id);

    protected abstract List<I> findAll(String condition);

    private O edit(O dto) {
        return null;
    }

    protected abstract E createNewEntity();

    protected abstract E findByName(String name);

    protected abstract O convertToDTO(E newEntity);
}
