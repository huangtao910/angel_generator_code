package com.crowdfund.project.logic.impl;

import com.crowdfund.common.exception.SystemException;
import com.crowdfund.common.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;
import com.crowdfund.project.entity.ProjectMessage;
import org.springframework.stereotype.Component;
import com.crowdfund.project.dao.ProjectMessageMapper;
import org.apache.commons.lang3.StringUtils;
import com.crowdfund.project.entity.ProjectMessageExample;
import com.crowdfund.project.logic.ProjectMessageLogic;

@Component
public class ProjectMessageLogicImpl implements ProjectMessageLogic {
	@Autowired
	private ProjectMessageMapper projectMessageMapper;

	/**
	 * 删除业务实现类
	 * @param id
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int deleteByPrimaryKey(Long id) throws SystemException{
		try {
			return projectMessageMapper.deleteByPrimaryKey(id);
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
			return projectMessageMapper.insert(record);
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
			return projectMessageMapper.insertSelective(record);
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
			return projectMessageMapper.selectByPrimaryKey(id);
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
			return projectMessageMapper.updateByPrimaryKeySelective(record);
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
			Map<String,Object> map = new HashMap<>();
			ProjectMessageExample  example = new ProjectMessageExample();
			ProjectMessageExample.Criteria criteria = example.or();
			example.setOrderByClause("CREATE_TIME "+ Page.ORDER_DIRECTION_DESC);
			if(record != null){
				if(null != record.getMsgId()){
					criteria.andMsgIdEqualTo(record.getMsgId());
				}
				if(null != record.getProId()){
					criteria.andProIdEqualTo(record.getProId());
				}
				if(null != record.getInvestorId()){
					criteria.andInvestorIdEqualTo(record.getInvestorId());
				}
				if(null != record.getFinancierId()){
					criteria.andFinancierIdEqualTo(record.getFinancierId());
				}
				if(null != record.getMsgType()){
					criteria.andMsgTypeEqualTo(record.getMsgType());
				}
				if(StringUtils.isNotBlank(record.getMsgContent())){
					criteria.andMsgContentEqualTo(record.getMsgContent());
				}
				if(null != record.getCreateTime()){
					criteria.andCreateTimeEqualTo(record.getCreateTime());
				}
				if(null != record.getStatus()){
					criteria.andStatusEqualTo(record.getStatus());
				}
				if(null != record.getCheckTime()){
					criteria.andCheckTimeEqualTo(record.getCheckTime());
				}
				if(StringUtils.isNotBlank(record.getCheckUserName())){
					criteria.andCheckUserNameEqualTo(record.getCheckUserName());
				}
			}
			if(page != null){
				int count = projectMessageMapper.countByExample(example);
				page.setCount(count);
				example.setPage(page);
			}
			map.put("list", projectMessageMapper.selectByExample(example));
			map.put("page",page);
			return map;
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
			return projectMessageMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

}