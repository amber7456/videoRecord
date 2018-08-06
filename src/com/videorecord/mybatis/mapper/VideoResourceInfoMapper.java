package com.videorecord.mybatis.mapper;

import com.videorecord.mybatis.pojo.VideoResourceInfo;
import com.videorecord.mybatis.pojo.VideoResourceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoResourceInfoMapper {
    int countByExample(VideoResourceInfoExample example);

    int deleteByExample(VideoResourceInfoExample example);

    int insert(VideoResourceInfo record);

    int insertSelective(VideoResourceInfo record);

    List<VideoResourceInfo> selectByExample(VideoResourceInfoExample example);

    int updateByExampleSelective(@Param("record") VideoResourceInfo record, @Param("example") VideoResourceInfoExample example);

    int updateByExample(@Param("record") VideoResourceInfo record, @Param("example") VideoResourceInfoExample example);
}