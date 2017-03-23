package com.crowdfund.project.service;

import com.crowdfund.common.exception.SystemException;
import com.crowdfund.common.page.Page;
import java.math.BigDecimal;
import java.util.*;
import com.crowdfund.project.entity.ProjectMessage;

public interface ProjectMessageService {
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
	int insert(ProjectMessage record) throws SystemException;

	/**
	 * 添加接口
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	int insertSelective(ProjectMessage record)throws SystemException;

	/**
	 * 主键查询接口
	 * @param id
	 * @return
	 * @throws SystemException
	 */
	ProjectMessage selectByPrimaryKey(Long id)throws SystemException;

	/**
	 * 修改接口
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	int updateByPrimaryKeySelective(ProjectMessage record)throws SystemException;

	/**
	 * 主键修改接口
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	int updateByPrimaryKey(ProjectMessage record)throws SystemException;

	/**
	 * 分页查询接口
	 * @param example
	 * @param page
	 * @return
	 * @throws SystemException
	 */
	Map<String,Object> selectPagedByExample(Page page, ProjectMessage example)throws SystemException;

}