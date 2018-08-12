package com.videorecord.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.chart.ChartData;
import com.videorecord.bean.chart.ChartBean;
import com.videorecord.bean.video.req.VideoSearchReqBean;
import com.videorecord.dao.VideoDao;
import com.videorecord.mybatis.pojo.VideoInfo;

@Service
@Transactional
public class ChartService {

	@Autowired
	private VideoDao videoDao;

	public ResponseBean<ChartBean> getEchartsData(VideoSearchReqBean req) {
		ResponseBean<ChartBean> resp = new ResponseBean<ChartBean>();
		List<VideoInfo> videoList = videoDao.getChatrData(req);

		String videoType = req.getVideoType();
		int begin = Integer.valueOf(req.getYearRange().split("-")[0].trim());
		int end = Integer.valueOf(req.getYearRange().split("-")[1].trim());
		// 按类型将年列表分组
		String[] type = null;
		if (videoType.equals("动画")) {
			type = new String[] { "冬番", "春番", "夏番", "秋番", "OVA/OAD", "映画", "特别篇", "其他" };

		} else if (videoType.equals("番剧")) {
			type = new String[] { "冬季", "春季", "夏季", "秋季", "SP", "其他" };

		} else if (videoType.equals("电影") || videoType.equals("记录片")) {
			type = new String[] { "中国", "日本", "美国" };
			Set<String> c = new HashSet<String>();
			for (int i = 0; i < videoList.size(); i++) {
				if ((videoList.get(i).getVideo_country() != "中国" || videoList.get(i).getVideo_country() != "中国")
						&& videoList.get(i).getVideo_country() != "日本" && videoList.get(i).getVideo_country() != "美国") {
					c.add(videoList.get(i).getVideo_country());
				}
			}
			for (String str : c) {
				type = insertElement(type, str);
			}
		}

		ChartBean chartBean = new ChartBean();
		chartBean.setSeason(type);
		ChartData yearList = new ChartData();
		List<ChartData> dataList = new ArrayList<ChartData>();
		Integer[] arr = new Integer[end - begin + 1];
		for (String season : type) {
			ChartData c = new ChartData();
			c.setKey(season);
			Integer[] seasonArr = new Integer[end - begin + 1];
			for (int i = begin; i <= end; i++) {
				String year = String.valueOf(i);
				String count = null;
				for (int j = 0; j < videoList.size(); j++) {
					if (year.equals(videoList.get(j).getYear()) && season.equals(videoList.get(j).getVideo_season())) {
						count = videoList.get(j).getCount();
					}
				}
				if (count == null || count.length() <= 0) {
					count = "0";
				}
				seasonArr[i - begin] = Integer.valueOf(count);
				arr[i - begin] = i;
			}
			c.setArr(seasonArr);
			dataList.add(c);
		}
		yearList.setKey("year");
		yearList.setArr(arr);
		dataList.add(yearList);
		chartBean.setDataList(dataList);
		resp.setData(chartBean);
		return resp;
	} 

	private static String[] insertElement(String original[], String element) {
		int length = original.length;
		String destination[] = new String[length + 1];
		System.arraycopy(original, 0, destination, 0, length);
		destination[length] = element;
		return destination;
	}

}
