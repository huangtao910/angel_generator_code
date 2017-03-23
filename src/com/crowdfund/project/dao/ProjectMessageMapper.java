package com.crowdfund.project.dao;

import com.crowdfund.project.entity.ProjectMessage;
import com.crowdfund.project.entity.ProjectMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMessageMapper {
    int countByExample(ProjectMessageExample example);

    int deleteByExample(ProjectMessageExample example);

    int deleteByPrimaryKey(Long msgId);

    int insert(ProjectMessage record);

    int insertSelective(ProjectMessage record);

    List<ProjectMessage> selectByExample(ProjectMessageExample example);

    ProjectMessage selectByPrimaryKey(Long msgId);

    int updateByExampleSelective(@Param("record") ProjectMessage record, @Param("example") ProjectMessageExample example);

    int updateByExample(@Param("record") ProjectMessage record, @Param("example") ProjectMessageExample example);

    int updateByPrimaryKeySelective(ProjectMessage record);

    int updateByPrimaryKey(ProjectMessage record);
}