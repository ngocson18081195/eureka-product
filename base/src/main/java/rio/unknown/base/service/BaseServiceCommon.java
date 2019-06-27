package rio.unknown.base.service;

import rio.unknown.base.dto.BaseCommonDTO;

import java.util.List;

/**
 * Create by ngocson on 23/06/2019
 */
public interface BaseServiceCommon<I extends BaseCommonDTO, O extends BaseCommonDTO> {

    List<I> getAll(String condition);

    O getOne(Long id);

    boolean delete(Long id);
}
