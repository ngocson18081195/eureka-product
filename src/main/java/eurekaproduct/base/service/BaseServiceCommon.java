package eurekaproduct.base.service;

import eurekaproduct.base.dto.BaseCommonDTO;

import java.util.List;

/**
 * Create by ngocson on 23/06/2019
 */
public interface BaseServiceCommon<I extends BaseCommonDTO> {

    List<I> getAll(String condition);

}
