package com.crowdfund.project.service.impl;

import com.crowdfund.common.exception.SystemException;
import com.crowdfund.common.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;
import com.crowdfund.project.entity.ProjectMessage;
import com.crowdfund.project.logic.ProjectMessageLogic;
import com.crowdfund.project.service.ProjectMessageService;

@Service("projectMessageService")
public class ProjectMessageServiceImpl implements ProjectMessageService {
	@Autowired
	private ProjectMessageLogic projectMessageLogic;

	/**
	 * 删除业务实现类
	 * @param id
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int deleteByPrimaryKey(Long id) throws SystemException{
		try {
			return projectMessageLogic.deleteByPrimaryKey(id);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

	/**
	 * 添加接口业务实现
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int insert(ProjectMessage record) throws SystemException{
		try {
			return projectMessageLogic.insert(record);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

	/**
	 * 添加接口业务接口实现
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int insertSelective(ProjectMessage record) throws SystemException{
		try {
			return projectMessageLogic.insertSelective(record);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

	/**
	 * 主键查询接口业务实现
	 * @param id
	 * @return
	 * @throws SystemException
	 */
	@Override
	public ProjectMessage selectByPrimaryKey(Long id) throws SystemException{
		try {
			return projectMessageLogic.selectByPrimaryKey(id);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

	/**
	 * 修改接口业务实现
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int updateByPrimaryKeySelective(ProjectMessage record) throws SystemException{
		try {
			return projectMessageLogic.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

	/**
	 * 分页查询接口业务实现
	 * @param record
	 * @param page
	 * @return
	 * @throws SystemException
	 */
	@Override
	public Map<String,Object> selectPagedByExample(Page page, ProjectMessage record) throws SystemException {
		try {
			return projectMessageLogic.selectPagedByExample(page,record);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

	/**
	 * 主键修改接口业务实现
	 * @param record
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int updateByPrimaryKey(ProjectMessage record) throws SystemException{
		try {
			return projectMessageLogic.updateByPrimaryKey(record);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

}