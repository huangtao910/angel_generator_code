package com.crowdfund.project.service;

import com.crowdfund.common.exception.SystemException;
import com.crowdfund.common.page.Page;
import java.math.BigDecimal;
import java.util.*;
import com.crowdfund.project.entity.ProjectLeadInfo;

public interface ProjectLeadInfoService {
	/**
	 * 删除接口
	 * @param id
	 * @return
	 * @throws SystemException
	 */
	int deleteByPrimaryKey(Long id) throws SystemException;

	/**
	 * 添加接口
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	int insert(ProjectLeadInfo record) throws SystemException;

	/**
	 * 添加接口
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	int insertSelective(ProjectLeadInfo record)throws SystemException;

	/**
	 * 主键查询接口
	 * @param id
	 * @return
	 * @throws SystemException
	 */
	ProjectLeadInfo selectByPrimaryKey(Long id)throws SystemException;

	/**
	 * 修改接口
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	int updateByPrimaryKeySelective(ProjectLeadInfo record)throws SystemException;

	/**
	 * 主键修改接口
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	int updateByPrimaryKey(ProjectLeadInfo record)throws SystemException;

	/**
	 * 分页查询接口
	 * @param example
	 * @param page
	 * @return
	 * @throws SystemException
	 */
	Map<String,Object> selectPagedByExample(Page page, ProjectLeadInfo example)throws SystemException;

}