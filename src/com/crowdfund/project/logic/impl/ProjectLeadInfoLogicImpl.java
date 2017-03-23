package com.crowdfund.project.logic.impl;

import com.crowdfund.common.exception.SystemException;
import com.crowdfund.common.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;
import com.crowdfund.project.entity.ProjectLeadInfo;
import org.springframework.stereotype.Component;
import com.crowdfund.project.dao.ProjectLeadInfoMapper;
import org.apache.commons.lang3.StringUtils;
import com.crowdfund.project.entity.ProjectLeadInfoExample;
import com.crowdfund.project.logic.ProjectLeadInfoLogic;

@Component
public class ProjectLeadInfoLogicImpl implements ProjectLeadInfoLogic {
	@Autowired
	private ProjectLeadInfoMapper projectLeadInfoMapper;

	/**
	 * 删除业务实现类
	 * @param id
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int deleteByPrimaryKey(Long id) throws SystemException{
		try {
			return projectLeadInfoMapper.deleteByPrimaryKey(id);
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
			return projectLeadInfoMapper.insert(record);
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
			return projectLeadInfoMapper.insertSelective(record);
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
			return projectLeadInfoMapper.selectByPrimaryKey(id);
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
			return projectLeadInfoMapper.updateByPrimaryKeySelective(record);
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
			Map<String,Object> map = new HashMap<>();
			ProjectLeadInfoExample  example = new ProjectLeadInfoExample();
			ProjectLeadInfoExample.Criteria criteria = example.or();
			example.setOrderByClause("CREATE_TIME "+ Page.ORDER_DIRECTION_DESC);
			if(record != null){
				if(null != record.getLeadId()){
					criteria.andLeadIdEqualTo(record.getLeadId());
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
				if(null != record.getLeadAmount()){
					criteria.andLeadAmountEqualTo(record.getLeadAmount());
				}
				if(null != record.getPaymentTime()){
					criteria.andPaymentTimeEqualTo(record.getPaymentTime());
				}
				if(StringUtils.isNotBlank(record.getLeadIntroduce())){
					criteria.andLeadIntroduceEqualTo(record.getLeadIntroduce());
				}
			}
			if(page != null){
				int count = projectLeadInfoMapper.countByExample(example);
				page.setCount(count);
				example.setPage(page);
			}
			map.put("list", projectLeadInfoMapper.selectByExample(example));
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
	public int updateByPrimaryKey(ProjectLeadInfo record) throws SystemException{
		try {
			return projectLeadInfoMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			throw new SystemException(e.getMessage());
		}
	}

}