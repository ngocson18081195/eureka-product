package eurekaproduct.base.service;

import com.google.common.collect.Lists;
import eurekaproduct.base.entity.BaseEntity;
import eurekaproduct.base.dto.BaseCommonDTO;
import eurekaproduct.exception.UnknownException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

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

    public O createObjectWithImage(MultipartFile multipartFile, O dto) {
        log.info("Event create object {} - START", dto);
        boolean entity = this.checkExist(dto);
        Assert.isTrue(!entity, String.format("Entity existed [%s].", dto));
        E newEntity = this.createNewEntity();
        this.processConvert(multipartFile, newEntity, dto);
        O createDto = this.convertToDTO(newEntity);
        log.info("Even  t create object {} - END", createDto);
        return createDto;
    }

    protected abstract void processConvert(MultipartFile multipartFile, E entity, O dto);

    protected abstract boolean checkExist(O dto);

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
