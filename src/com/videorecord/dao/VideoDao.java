package com.videorecord.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.videorecord.bean.video.req.VideoSearchReqBean;
import com.videorecord.bean.video.req.VideoReqBean;
import com.videorecord.mybatis.mapper.VideoInfoMapper;
import com.videorecord.mybatis.pojo.VideoInfo;
import com.videorecord.mybatis.pojo.VideoInfoExample;
import com.videorecord.mybatis.pojo.VideoInfoExample.Criteria;
import com.videorecord.mybatis.pojo.VideoSearch;
import com.videorecord.util.CommonUtils;

@Repository
public class VideoDao {

	@Autowired
	private VideoInfoMapper videoInfoMapper;

	/**
	 * 视频资源列表
	 * 
	 * @param videoReqBean
	 * @return
	 */
	public List<VideoInfo> getVideoList(VideoReqBean videoReqBean) {
		VideoInfoExample example = new VideoInfoExample();
		Criteria criteria = example.createCriteria();
		if (CommonUtils.isNotEmpty(videoReqBean.getVideoName())) {
			criteria.andVideo_nameLike("%" + videoReqBean.getVideoName() + "%");
		}
		if (CommonUtils.isNotEmpty(videoReqBean.getYear())) {
			criteria.andVideo_broadcast_timeBetween(
					CommonUtils.stringToDate(videoReqBean.getYear() + "-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"),
					CommonUtils.stringToDate(videoReqBean.getYear() + "-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss"));
		}
		if (CommonUtils.isNotEmpty(videoReqBean.getVideoType())) {
			criteria.andVideo_typeLike(videoReqBean.getVideoType() + "%");
		}
		example.setOrderByClause("video_broadcast_time");
		List<VideoInfo> list = videoInfoMapper.selectByExample(example);
		return list;
	}

	public List<VideoInfo> searchVideo(VideoSearchReqBean req) {
		VideoSearch vs = new VideoSearch();

		vs.setVideoType(req.getVideoType());// 视频类型
		// 视频名称搜索的优先级最高，如果有视频名称测不考虑其他搜索条件
		if (CommonUtils.isNotEmpty(req.getVideoName())) {
			vs.setVideoName(req.getVideoName().trim());
		} else {
			// 时间范围 是共有查询条件
			String begin = req.getYearRange().split("-")[0].trim();
			String end = req.getYearRange().split("-")[1].trim();
			vs.setYearBegin(begin);
			vs.setYearEnd(end);
			// 地址 是共有查询条件
			if (isNotEmptyNotAll(req.getAddress())) {
				vs.setAddress(req.getAddress());
			}
			// 格式 是共有查询条件
			if (isNotEmptyNotAll(req.getFormat())) {
				vs.setFormat(req.getFormat());
			}
			// 分辨率 是共有查询条件
			if (isNotEmptyNotAll(req.getResolution())) {
				vs.setResolution(req.getResolution());
			}
			String[] searchCondition = null;
			switch (req.getVideoType()) {
			case "动画":
				searchCondition = new String[] { "animationSeason", "serializeTime", "resourceType", "subType" };
				vs = getVideoSearch(Arrays.asList(searchCondition), vs, req);
				break;
			case "番剧":
				// <!-- 番剧检索条件 国别 季度 格式 分辨率 -->
				searchCondition = new String[] { "country", "dramaSeason", "subType" };
				vs = getVideoSearch(Arrays.asList(searchCondition), vs, req);
				break;
			case "电影":
				// <!-- 电影搜索条件 国别 -->
				searchCondition = new String[] { "country" };
				vs = getVideoSearch(Arrays.asList(searchCondition), vs, req);
				break;
			case "记录片":
				// <!-- 记录片搜索条件 国别 -->
				searchCondition = new String[] { "country" };
				vs = getVideoSearch(Arrays.asList(searchCondition), vs, req);
				break;
			case "网络视频":
				// <!-- 网络视频搜索条件 -->
				break;
			default:
				break;
			}
		}
		List<VideoInfo> list = videoInfoMapper.searchVideo(vs);
		return list;
	}

	private VideoSearch getVideoSearch(List<String> searchTypeList, VideoSearch vs, VideoSearchReqBean req) {
		// 动画 播出季
		if (searchTypeList.contains("animationSeason")) {
			if (isNotEmptyNotAll(req.getAnimationSeason())) {
				vs.setAnimationSeason(req.getAnimationSeason());
			}
		}
		// 番剧 播出季
		if (searchTypeList.contains("dramaSeason")) {
			if (isNotEmptyNotAll(req.getDramaSeason())) {
				vs.setDramaSeason(req.getDramaSeason());
			}
		}
		// 国别
		if (searchTypeList.contains("country")) {
			if (isNotEmptyNotAll(req.getCountry())) {
				vs.setCountry(req.getCountry());
			}
		}
		// 连载时长
		if (searchTypeList.contains("serializeTime")) {
			if (isNotEmptyNotAll(req.getSerializeTime())) {
				if (req.getSerializeTime().equals("1")) {
					vs.setEpisodeBegin("1");
					vs.setEpisodeEnd("19");
				} else if (req.getSerializeTime().equals("2")) {
					vs.setEpisodeBegin("20");
					vs.setEpisodeEnd("30");
				} else if (req.getSerializeTime().equals("3")) {
					vs.setEpisodeBegin("40");
					vs.setEpisodeEnd("70");
				} else if (req.getSerializeTime().equals("4")) {
					vs.setEpisodeBegin("71");
					vs.setEpisodeEnd("99999");
				}
			}
		}
		// 资源类型
		if (searchTypeList.contains("resourceType")) {
			if (isNotEmptyNotAll(req.getResourceType())) {
				vs.setResourceType(req.getResourceType());
			}
		}
		// 字幕类型
		if (searchTypeList.contains("subType")) {
			if (isNotEmptyNotAll(req.getSubType())) {
				vs.setSubType(req.getSubType());
			}
		}
		return vs;
	}

	private boolean isNotEmptyNotAll(String str) {
		if (CommonUtils.isNotEmpty(str) && !str.equals("ALL")) {
			return true;
		} else {
			return false;
		}
	}

	public VideoInfo getVideoDetail(String video_id) {
		return videoInfoMapper.selectByPrimaryKey(video_id);
	}

	public int addAnimation(VideoInfo videoInfo) {
		return videoInfoMapper.insertSelective(videoInfo);
	}

	public int editVideo(VideoInfo videoInfo) {
		return videoInfoMapper.updateByPrimaryKeyWithBLOBs(videoInfo);
	}

	public int delVideo(String video_id) {
		return videoInfoMapper.deleteByPrimaryKey(video_id);
	}

	public List<VideoInfo> getChatrData(VideoSearchReqBean req) {
		VideoSearch vs = new VideoSearch();
		// 时间范围 是共有查询条件
		vs.setVideoType(req.getVideoType());
		String begin = req.getYearRange().split("-")[0].trim();
		String end = req.getYearRange().split("-")[1].trim();
		vs.setYearBegin(begin);
		vs.setYearEnd(end);
		return videoInfoMapper.getChatrData(vs);
	}

}
