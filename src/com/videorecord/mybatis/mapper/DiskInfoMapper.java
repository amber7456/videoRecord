package com.videorecord.mybatis.mapper;

import com.videorecord.mybatis.pojo.DiskInfo;
import com.videorecord.mybatis.pojo.DiskInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiskInfoMapper {
    int countByExample(DiskInfoExample example);

    int deleteByExample(DiskInfoExample example);

    int deleteByPrimaryKey(String disk_id);

    int insert(DiskInfo record);

    int insertSelective(DiskInfo record);

    List<DiskInfo> selectByExample(DiskInfoExample example);

    DiskInfo selectByPrimaryKey(String disk_id);

    int updateByExampleSelective(@Param("record") DiskInfo record, @Param("example") DiskInfoExample example);

    int updateByExample(@Param("record") DiskInfo record, @Param("example") DiskInfoExample example);

    int updateByPrimaryKeySelective(DiskInfo record);

    int updateByPrimaryKey(DiskInfo record);
}