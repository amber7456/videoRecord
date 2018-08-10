package com.videorecord.mybatis.mapper;

import com.videorecord.mybatis.pojo.VideoInfo;
import com.videorecord.mybatis.pojo.VideoInfoExample;
import com.videorecord.mybatis.pojo.VideoSearch;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoInfoMapper {
    int countByExample(VideoInfoExample example);

    int deleteByExample(VideoInfoExample example);

    int deleteByPrimaryKey(String video_id);

    int insert(VideoInfo record);

    int insertSelective(VideoInfo record);

    List<VideoInfo> selectByExampleWithBLOBs(VideoInfoExample example);

    List<VideoInfo> selectByExample(VideoInfoExample example);

    VideoInfo selectByPrimaryKey(String video_id);

    int updateByExampleSelective(@Param("record") VideoInfo record, @Param("example") VideoInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") VideoInfo record, @Param("example") VideoInfoExample example);

    int updateByExample(@Param("record") VideoInfo record, @Param("example") VideoInfoExample example);

    int updateByPrimaryKeySelective(VideoInfo record);

    int updateByPrimaryKeyWithBLOBs(VideoInfo record);

    int updateByPrimaryKey(VideoInfo record);

	List<VideoInfo> searchVideo(VideoSearch vs);

	List<VideoInfo> getChatrData(VideoSearch vs);
}