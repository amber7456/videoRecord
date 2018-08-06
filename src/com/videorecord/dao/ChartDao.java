package com.videorecord.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.videorecord.bean.video.req.VideoSearchReqBean;
import com.videorecord.bean.video.req.VideoReqBean;
import com.videorecord.mybatis.mapper.VideoInfoMapper;
import com.videorecord.mybatis.pojo.VideoInfo;
import com.videorecord.mybatis.pojo.VideoInfoExample;
import com.videorecord.mybatis.pojo.VideoInfoExample.Criteria;
import com.videorecord.util.CommonUtils;

@Repository
public class ChartDao {

	@Autowired
	private VideoInfoMapper videoInfoMapper;

	public List<VideoInfo> getVideoList(VideoReqBean videoReqBean) {
		VideoInfoExample example = new VideoInfoExample();
		Criteria criteria = example.createCriteria();
		if (CommonUtils.isNotEmpty(videoReqBean.getVideo_name())) {
			criteria.andVideo_nameLike("%" + videoReqBean.getVideo_name() + "%");
		}
		if (CommonUtils.isNotEmpty(videoReqBean.getYear())) {
			criteria.andVideo_broadcast_timeBetween(
					CommonUtils.stringToDate(videoReqBean.getYear() + "-01-01", "yyyy-MM-dd"),
					CommonUtils.stringToDate(videoReqBean.getYear() + "-12-31", "yyyy-MM-dd"));
		}
		if (CommonUtils.isNotEmpty(videoReqBean.getVideo_type())) {
			criteria.andVideo_typeLike(videoReqBean.getVideo_type() + "%");
		}
		example.setOrderByClause("video_broadcast_time");
		List<VideoInfo> list = videoInfoMapper.selectByExample(example);
		return list;
	}

	public List<VideoInfo> advSearchAnimation(VideoReqBean videoReqBean) {

		VideoSearchReqBean bean = new VideoSearchReqBean();

		if (CommonUtils.isNotEmpty(videoReqBean.getYearRange())) {
			String begin = videoReqBean.getYearRange().split("-")[0].trim();
			String end = videoReqBean.getYearRange().split("-")[1].trim();
			bean.setYearBegin(begin);
			bean.setYearEnd(end);
		}

//		if (CommonUtils.isNotEmpty(videoReqBean.getVideo_type()) && !videoReqBean.getVideo_type().equals("ALL")) {
//			bean.setVideo_type(videoReqBean.getVideo_type());
//		}
//
//		if (CommonUtils.isNotEmpty(videoReqBean.getSerializeTime()) && !videoReqBean.getSerializeTime().equals("ALL")) {
//			if (videoReqBean.getSerializeTime().equals("1")) {
//				bean.setEpisodeBegin("1");
//				bean.setEpisodeEnd("19");
//			} else if (videoReqBean.getSerializeTime().equals("2")) {
//				bean.setEpisodeBegin("20");
//				bean.setEpisodeEnd("30");
//			} else if (videoReqBean.getSerializeTime().equals("3")) {
//				bean.setEpisodeBegin("40");
//				bean.setEpisodeEnd("70");
//			} else if (videoReqBean.getSerializeTime().equals("4")) {
//				bean.setEpisodeBegin("71");
//				bean.setEpisodeEnd("99999");
//			}
//		}

//		if (CommonUtils.isNotEmpty(videoReqBean.getResource_record_address())
//				&& !videoReqBean.getResource_record_address().equals("ALL")) {
//			bean.setResource_record_address(videoReqBean.getResource_record_address());
//		}
//
//		if (CommonUtils.isNotEmpty(videoReqBean.getResource_type()) && !videoReqBean.getResource_type().equals("ALL")) {
//			bean.setResource_type(videoReqBean.getResource_type());
//		}
//
//		if (CommonUtils.isNotEmpty(videoReqBean.getResource_format())
//				&& !videoReqBean.getResource_format().equals("ALL")) {
//			bean.setResource_format(videoReqBean.getResource_format());
//		}
//
//		if (CommonUtils.isNotEmpty(videoReqBean.getResource_resolution())
//				&& !videoReqBean.getResource_resolution().equals("ALL")) {
//			bean.setResource_resolution(videoReqBean.getResource_resolution());
//		}
//
//		if (CommonUtils.isNotEmpty(videoReqBean.getResource_sub_type())
//				&& !videoReqBean.getResource_sub_type().equals("ALL")) {
//			bean.setResource_sub_type(videoReqBean.getResource_sub_type());
//		}
//
//		if (CommonUtils.isNotEmpty(videoReqBean.getVideo_name())) {
//			bean.setVideo_name("%" + videoReqBean.getVideo_name() + "%");
//		}

		List<VideoInfo> list = videoInfoMapper.selectByAdv(bean);
		return list;
	}

	public VideoInfo getAnimationDetail(String video_id) {
		return videoInfoMapper.selectByPrimaryKey(video_id);
	}

	public int addAnimation(VideoInfo videoInfo) {
		return videoInfoMapper.insertSelective(videoInfo);
	}

	public int editAnimation(VideoInfo videoInfo) {
		return videoInfoMapper.updateByPrimaryKeyWithBLOBs(videoInfo);
	}

	public int delVideo(String video_id) {
		return videoInfoMapper.deleteByPrimaryKey(video_id);
	}

}
