package com.videorecord.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.videorecord.mybatis.mapper.VideoResourceInfoMapper;
import com.videorecord.mybatis.pojo.VideoResourceInfo;
import com.videorecord.mybatis.pojo.VideoResourceInfoExample;
import com.videorecord.mybatis.pojo.VideoResourceInfoExample.Criteria;

@Repository
public class VideoResourceDao {

	@Autowired
	private VideoResourceInfoMapper videoResourceInfoMapper;

	public List<com.videorecord.mybatis.pojo.VideoResourceInfo> getVideoResourceInfo(String video_id) {
		VideoResourceInfoExample example = new VideoResourceInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andVideo_idEqualTo(video_id);
		List<VideoResourceInfo> videoResourceInfo = videoResourceInfoMapper.selectByExample(example);
		return videoResourceInfo;
	}

	public int addVideoResource(List<VideoResourceInfo> videoResourceInfo) {
		int result = 0;
		for (int i = 0; i < videoResourceInfo.size(); i++) {
			result = videoResourceInfoMapper.insertSelective(videoResourceInfo.get(i));
		}
		return result;
	}

	public int delVideoResource(String video_id) {
		VideoResourceInfoExample example = new VideoResourceInfoExample();
		Criteria criteria = example.createCriteria();
		criteria.andVideo_idEqualTo(video_id);
		return videoResourceInfoMapper.deleteByExample(example);
	}

}
