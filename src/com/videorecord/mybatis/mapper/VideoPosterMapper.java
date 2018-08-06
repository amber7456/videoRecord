package com.videorecord.mybatis.mapper;

import com.videorecord.mybatis.pojo.VideoPoster;
import com.videorecord.mybatis.pojo.VideoPosterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoPosterMapper {
    int countByExample(VideoPosterExample example);

    int deleteByExample(VideoPosterExample example);

    int deleteByPrimaryKey(String video_id);

    int insert(VideoPoster record);

    int insertSelective(VideoPoster record);

    List<VideoPoster> selectByExampleWithBLOBs(VideoPosterExample example);

    List<VideoPoster> selectByExample(VideoPosterExample example);

    VideoPoster selectByPrimaryKey(String video_id);

    int updateByExampleSelective(@Param("record") VideoPoster record, @Param("example") VideoPosterExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoPoster record, @Param("example") VideoPosterExample example);

    int updateByExample(@Param("record") VideoPoster record, @Param("example") VideoPosterExample example);

    int updateByPrimaryKeySelective(VideoPoster record);

    int updateByPrimaryKeyWithBLOBs(VideoPoster record);

    int updateByPrimaryKey(VideoPoster record);
}