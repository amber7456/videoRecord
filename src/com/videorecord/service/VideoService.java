package com.videorecord.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.video.req.VideoAddReqBean;
import com.videorecord.bean.video.req.VideoReqBean;
import com.videorecord.bean.video.req.VideoSearchReqBean;
import com.videorecord.bean.video.resp.VideoListBean;
import com.videorecord.bean.video.resp.SeasonBean;
import com.videorecord.bean.video.resp.YearData;
import com.videorecord.dao.PosterDao;
import com.videorecord.dao.VideoDao;
import com.videorecord.dao.VideoResourceDao;
import com.videorecord.mybatis.pojo.VideoInfo;
import com.videorecord.mybatis.pojo.VideoPoster;
import com.videorecord.mybatis.pojo.VideoResourceInfo;
import com.videorecord.util.CommonUtils;

@Service
@Transactional
public class VideoService {

	@Autowired
	private VideoDao videoDao;
	@Autowired
	private VideoResourceDao videoResourceDao;
	@Autowired
	private PosterDao posterDao;

	public ResponseBean<VideoListBean> getVideoList(VideoReqBean req) {
		ResponseBean<VideoListBean> resp = new ResponseBean<VideoListBean>();
		List<VideoInfo> list = videoDao.getVideoList(req);
		VideoListBean videoList = reseVideoList(req.getVideoType(), list);
		resp.setData(videoList);
		resp.setCount(videoList.getYearData().size());
		return resp;
	}

	public ResponseBean<VideoListBean> searchVideo(VideoSearchReqBean req) {
		ResponseBean<VideoListBean> resp = new ResponseBean<VideoListBean>();
		List<VideoInfo> list = videoDao.searchVideo(req);
		VideoListBean videoList = reseVideoList(req.getVideoType(), list);
		resp.setData(videoList);
		resp.setCount(videoList.getYearData().size());
		return resp;
	}

	private VideoListBean reseVideoList(String videoType, List<VideoInfo> list) {
		VideoListBean videoList = new VideoListBean();

		Set<String> yearSet = new HashSet<String>();// 查询结果的年集合
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < list.size(); i++) {
			c.setTime(list.get(i).getVideo_broadcast_time());
			yearSet.add(String.valueOf(c.get(Calendar.YEAR)));
		}

		List<YearData> yearDataList = new ArrayList<YearData>();
		YearData yearData = null;
		List<SeasonBean> season = null;
		List<VideoInfo> yearVideoList = null;// 每年的资源
		for (String year : yearSet) {
			yearData = new YearData();
			season = new ArrayList<SeasonBean>();
			// 按年份获取每年的列表
			yearVideoList = new ArrayList<VideoInfo>();
			for (int i = 0, lenI = list.size(); i < lenI; i++) {
				c.setTime(list.get(i).getVideo_broadcast_time());
				if (year.equals(String.valueOf(c.get(Calendar.YEAR)))) {
					yearVideoList.add(list.get(i));
				}
			}

			season = sortByTypeAndSeason(year, videoType, yearVideoList);
			String countMsg = getCountMsg(season);
			yearData.setSeason(season);
			yearData.setYear(year);
			yearData.setCountMsg("收录" + year + "年资源" + yearVideoList.size() + "部。" + countMsg);
			yearDataList.add(yearData);
		}

		Collections.sort(yearDataList, new Comparator<YearData>() {
			public int compare(YearData y1, YearData y2) {
				return Integer.valueOf(y1.getYear()) - Integer.valueOf(y2.getYear());
			}
		});

		videoList.setYearData(yearDataList);
		return videoList;
	}

	private String getCountMsg(List<SeasonBean> season) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < season.size(); i++) {
			sBuffer.append(season.get(i).getType() + season.get(i).getVideoInfo().size() + "部，");
		}
		String countMsg = sBuffer.toString();
		countMsg = countMsg.substring(0, countMsg.length() - 1);
		return countMsg;
	}

	private List<SeasonBean> sortByTypeAndSeason(String year, String videoType, List<VideoInfo> yearVideoList) {
		// 按类型将年列表分组
		String[] type = null;
		if (videoType.equals("动画")) {
			type = new String[] { "冬番", "春番", "夏番", "秋番", "OVA/OAD", "映画", "特别篇", "其他" };

		} else if (videoType.equals("番剧")) {
			type = new String[] { "冬季", "春季", "夏季", "秋季", "SP", "其他" };

		} else if (videoType.equals("电影") || videoType.equals("记录片")) {
			type = new String[] { "国产", "日本", "美国" };
			Set<String> c = new HashSet<String>();
			for (int i = 0; i < yearVideoList.size(); i++) {
				if ((yearVideoList.get(i).getVideo_country() != "国产" || yearVideoList.get(i).getVideo_country() != "中国")
						&& yearVideoList.get(i).getVideo_country() != "日本"
						&& yearVideoList.get(i).getVideo_country() != "美国") {
					c.add(yearVideoList.get(i).getVideo_country());
				}
			}
			for (String str : c) {
				type = insertElement(type, str);
			}
		} else {
			type = new String[] { year };
		}

		List<SeasonBean> seasonList = new ArrayList<SeasonBean>();

		for (String t : type) {
			SeasonBean seasonBean = new SeasonBean();
			List<VideoInfo> videoInfo = new ArrayList<VideoInfo>();
			for (int i = 0, lenI = yearVideoList.size(); i < lenI; i++) {
				if (videoType.equals("动画")) {
					if (yearVideoList.get(i).getVideo_season().equals(t)) {
						videoInfo.add(yearVideoList.get(i));
					}
				} else if (videoType.equals("番剧")) {
					if (yearVideoList.get(i).getVideo_season().equals(t)) {
						videoInfo.add(yearVideoList.get(i));
					}
					if ((!yearVideoList.get(i).getVideo_country().equals("日本"))) {
						videoInfo.add(yearVideoList.get(i));
					}
				} else if (videoType.equals("电影") || videoType.equals("记录片")) {
					if (yearVideoList.get(i).getVideo_country().equals(t)) {
						videoInfo.add(yearVideoList.get(i));
					}
				} else {
					videoInfo.add(yearVideoList.get(i));
				}

			}
			seasonBean.setType(t);
			seasonBean.setVideoInfo(videoInfo);
			seasonList.add(seasonBean);
		}

		return seasonList;
	}

	public ResponseBean<VideoInfo> getVideoDetail(String video_id) throws UnsupportedEncodingException {
		ResponseBean<VideoInfo> resp = new ResponseBean<VideoInfo>();
		VideoInfo videoInfo = videoDao.getVideoDetail(video_id);
		List<VideoResourceInfo> VideoResourceInfo = videoResourceDao.getVideoResourceInfo(video_id);
		videoInfo.setVideoResourceInfo(VideoResourceInfo);
		resp.setData(videoInfo);
		return resp;
	}

	public ResponseBean<Integer> addVideo(VideoAddReqBean videoAddBean) throws IOException {
		ResponseBean<Integer> resp = new ResponseBean<Integer>();
		videoAddBean.setVideo_id(CommonUtils.getID());
		VideoInfo videoInfo = getVideoInfo(videoAddBean);
		// 添加海报
		VideoPoster videoPoster = getVideoPoster(videoAddBean);
		int posterFlag = 1;
		if (videoAddBean.getVideo_poster() != null && !videoAddBean.getVideo_poster().isEmpty()) {
			posterFlag = posterDao.addPoster(videoPoster);
			videoInfo.setHave_poster("1");
		} else {
			videoInfo.setHave_poster("0");
		}
		// 添加资源信息
		int videoFlag = videoDao.addAnimation(videoInfo);
		// 添加收录信息
		int resourceFlag = 1;
		if (videoInfo.getVideoResourceInfo() != null && videoInfo.getVideoResourceInfo().size() > 0) {
			resourceFlag = videoResourceDao.addVideoResource(videoInfo.getVideoResourceInfo());
		}
		//
		if (videoFlag == 1 && resourceFlag == 1 && posterFlag == 1) {
			resp.setData(1);
		} else {
			resp.setData(0);
		}
		return resp;
	}

	// 编辑
	public ResponseBean<Integer> editVideo(VideoAddReqBean videoAddBean) throws IOException {
		ResponseBean<Integer> resp = new ResponseBean<Integer>();
		// 添加资源信息
		VideoInfo videoInfo = getVideoInfo(videoAddBean);

		// 添加收录信息
		int resourceFlag = 1;
		if (videoInfo.getVideoResourceInfo() != null && videoInfo.getVideoResourceInfo().size() > 0) {
			// 先删除
			resourceFlag = videoResourceDao.delVideoResource(videoInfo.getVideo_id());
			// 再添加
			resourceFlag = videoResourceDao.addVideoResource(videoInfo.getVideoResourceInfo());
		}
		// 添加海报
		VideoPoster videoPoster = getVideoPoster(videoAddBean);
		int posterFlag = 1;
		// 海报有变化。则执行更新操作
		if (videoAddBean.getPosterUpdateFlag().equals("1")) {
			// 先删除再判断更新
			posterFlag = posterDao.delPoster(videoInfo.getVideo_id());
			if (videoAddBean.getVideo_poster() != null && !videoAddBean.getVideo_poster().isEmpty()) {
				// 文件不为空则更新
				posterFlag = posterDao.addPoster(videoPoster);
				videoInfo.setHave_poster("1");
			} else {
				videoInfo.setHave_poster("0");
			}
		}

		int videoFlag = videoDao.editVideo(videoInfo);

		if (videoFlag == 1 && resourceFlag == 1 && posterFlag == 1) {
			resp.setData(1);
		} else {
			resp.setData(0);
		}
		return resp;
	}

	public ResponseBean<Integer> delVideo(String video_id) {
		ResponseBean<Integer> resp = new ResponseBean<Integer>();
		videoResourceDao.delVideoResource(video_id);
		posterDao.delPoster(video_id);
		int result = videoDao.delVideo(video_id);
		resp.setData(result);
		return resp;
	}

	private VideoPoster getVideoPoster(VideoAddReqBean videoAddBean) throws IOException {
		VideoPoster videoPoster = new VideoPoster();
		videoPoster.setUpload_time(new Date());
		videoPoster.setVideo_id(videoAddBean.getVideo_id());
		if (videoAddBean.getVideo_poster() != null) {
			videoPoster.setVideo_poster(videoAddBean.getVideo_poster().getBytes());
		}
		return videoPoster;
	}

	private VideoInfo getVideoInfo(VideoAddReqBean videoAddBean) {
		VideoInfo videoInfo = new VideoInfo();
		videoInfo.setVideo_id(videoAddBean.getVideo_id());
		videoInfo.setVideo_name(videoAddBean.getVideo_name());
		videoInfo.setVideo_episode(videoAddBean.getVideo_episode());
		videoInfo.setVideo_broadcast_time(videoAddBean.getVideo_broadcast_time());
		videoInfo.setVideo_type(videoAddBean.getVideo_type());
		videoInfo.setVideo_season(videoAddBean.getVideo_season());
		videoInfo.setVideo_country(videoAddBean.getVideo_country());
		videoInfo.setVideo_source(videoAddBean.getVideo_source());
		videoInfo.setVideo_detail_info(videoAddBean.getVideo_detail_info());
		videoInfo.setVideo_remark(videoAddBean.getVideo_remark());
		videoInfo.setHave_poster(videoAddBean.getHave_poster());
		videoInfo.setHave_bd_resource("0");

		if (videoAddBean.getCreate_time() != null) {
			videoInfo.setCreate_time(videoAddBean.getCreate_time());
		} else {
			videoInfo.setCreate_time(new Date());
		}
		videoInfo.setLast_update_time(new Date());

		if (videoAddBean.getResource_type() != null) {
			List<VideoResourceInfo> videoResourceList = new ArrayList<VideoResourceInfo>();
			VideoResourceInfo videoResource = null;
			for (int i = 0; i < videoAddBean.getResource_type().length; i++) {
				videoResource = new VideoResourceInfo();
				videoResource.setVideo_id(videoAddBean.getVideo_id());
				videoResource.setResource_type(videoAddBean.getResource_type()[i]);
				if (videoAddBean.getResource_type()[i].equals("BD")) {
					videoInfo.setHave_bd_resource("1");
				}
				videoResource.setResource_format(videoAddBean.getResource_format()[i]);
				videoResource.setResource_resolution(videoAddBean.getResource_resolution()[i]);
				videoResource.setResource_sub(videoAddBean.getResource_sub()[i]);
				videoResource.setResource_sub_type(videoAddBean.getResource_sub_type()[i]);
				videoResource.setResource_record_time(videoAddBean.getResource_record_time()[i]);
				videoResource.setResource_record_address(videoAddBean.getResource_record_address()[i]);

				if (videoAddBean.getResource_remark().length < 1) {
					videoResource.setResource_remark("");
				} else {
					videoResource.setResource_remark(videoAddBean.getResource_remark()[i]);
				}

				videoResourceList.add(videoResource);
			}
			videoInfo.setVideoResourceInfo(videoResourceList);
		} else {
			videoInfo.setHave_bd_resource("0");
		}

		return videoInfo;
	}

	private static String[] insertElement(String original[], String element) {
		int length = original.length;
		String destination[] = new String[length + 1];
		System.arraycopy(original, 0, destination, 0, length);
		destination[length] = element;
		return destination;
	}

}
