package com.crowdfund.project.dao;

import com.crowdfund.project.entity.ProjectLeadInfo;
import com.crowdfund.project.entity.ProjectLeadInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectLeadInfoMapper {
    int countByExample(ProjectLeadInfoExample example);

    int deleteByExample(ProjectLeadInfoExample example);

    int deleteByPrimaryKey(Long leadId);

    int insert(ProjectLeadInfo record);

    int insertSelective(ProjectLeadInfo record);

    List<ProjectLeadInfo> selectByExample(ProjectLeadInfoExample example);

    ProjectLeadInfo selectByPrimaryKey(Long leadId);

    int updateByExampleSelective(@Param("record") ProjectLeadInfo record, @Param("example") ProjectLeadInfoExample example);

    int updateByExample(@Param("record") ProjectLeadInfo record, @Param("example") ProjectLeadInfoExample example);

    int updateByPrimaryKeySelective(ProjectLeadInfo record);

    int updateByPrimaryKey(ProjectLeadInfo record);
}