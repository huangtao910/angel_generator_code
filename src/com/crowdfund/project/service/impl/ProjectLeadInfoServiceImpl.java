package com.crowdfund.project.service.impl;

import com.crowdfund.common.exception.SystemException;
import com.crowdfund.common.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;
import com.crowdfund.project.entity.ProjectLeadInfo;
import com.crowdfund.project.logic.ProjectLeadInfoLogic;
import com.crowdfund.project.service.ProjectLeadInfoService;

@Service("projectLeadInfoService")
public class ProjectLeadInfoServiceImpl implements ProjectLeadInfoService {
	@Autowired
	private ProjectLeadInfoLogic projectLeadInfoLogic;

	/**
	 * 删除业务实现类
	 * @param id
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int deleteByPrimaryKey(Long id) throws SystemException{
		try {
			return projectLeadInfoLogic.deleteByPrimaryKey(id);
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
	public int insert(ProjectLeadInfo record) throws SystemException{
		try {
			return projectLeadInfoLogic.insert(record);
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
	public int insertSelective(ProjectLeadInfo record) throws SystemException{
		try {
			return projectLeadInfoLogic.insertSelective(record);
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
	public ProjectLeadInfo selectByPrimaryKey(Long id) throws SystemException{
		try {
			return projectLeadInfoLogic.selectByPrimaryKey(id);
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
	public int updateByPrimaryKeySelective(ProjectLeadInfo record) throws SystemException{
		try {
			return projectLeadInfoLogic.updateByPrimaryKeySelective(record);
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
	public Map<String,Object> selectPagedByExample(Page page, ProjectLeadInfo record) throws SystemException {
		try {
			return projectLeadInfoLogic.selectPagedByExample(page,record);
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
	public int updateByPrimaryKey(ProjectLeadInfo record) throws SystemException{
		try {
			return projectLeadInfoLogic.updateByPrimaryKey(record);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

}