package com.videorecord.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.chart.DataList;
import com.videorecord.bean.chart.TrendBean;
import com.videorecord.bean.video.req.VideoReqBean;
import com.videorecord.dao.VideoDao;
import com.videorecord.mybatis.pojo.VideoInfo;

@Service
@Transactional
public class ChartService {

	@Autowired
	private VideoDao videoDao;

	public ResponseBean<TrendBean> getTrend(VideoReqBean videoReqBean) {
		ResponseBean<TrendBean> resp = new ResponseBean<TrendBean>();
		List<VideoInfo> list = videoDao.advSearchAnimation(videoReqBean);
		resp.setData(geTrendDate(videoReqBean, list));
		return resp;
	}

	private TrendBean geTrendDate(VideoReqBean videoReqBean, List<VideoInfo> list) {
		TrendBean trendBean = new TrendBean();
		List<DataList> dataList = new ArrayList<DataList>();

		Integer begin = Integer.valueOf(videoReqBean.getYearRange().split("-")[0].trim());
		Integer end = Integer.valueOf(videoReqBean.getYearRange().split("-")[1].trim());

		Integer arrLength = (end - begin) + 1;
		DataList year = new DataList();
		year.setKey("yearArr");
		DataList fuyu = new DataList();
		fuyu.setKey("fuyuArr");
		DataList haru = new DataList();
		haru.setKey("haruArr");
		DataList natsu = new DataList();
		natsu.setKey("natsuArr");
		DataList aki = new DataList();
		aki.setKey("akiArr");
		DataList ova = new DataList();
		ova.setKey("ovaArr");
		DataList ega = new DataList();
		ega.setKey("egaArr");
		DataList other = new DataList();
		other.setKey("otherArr");
		DataList total = new DataList();
		total.setKey("totalArr");
		DataList base = new DataList();
		base.setKey("baseArr");

		Integer[] yearArr = new Integer[arrLength];
		Integer[] fuyuArr = new Integer[arrLength];
		Integer[] haruArr = new Integer[arrLength];
		Integer[] natsuArr = new Integer[arrLength];
		Integer[] akiArr = new Integer[arrLength];
		Integer[] ovaArr = new Integer[arrLength];
		Integer[] egaArr = new Integer[arrLength];
		Integer[] otherArr = new Integer[arrLength];
		Integer[] totalArr = new Integer[arrLength];
		Integer[] baseArr = new Integer[arrLength];

		Calendar c = Calendar.getInstance();
		List<VideoInfo> yearVideoList = null;
		for (int i = begin; i <= end; i++) {
			yearArr[i - begin] = i;

			yearVideoList = new ArrayList<VideoInfo>();
			for (int j = 0, lenJ = list.size(); j < lenJ; j++) {
				c.setTime(list.get(j).getVideo_broadcast_time());
				if (i == c.get(Calendar.YEAR)) {
					yearVideoList.add(list.get(j));
				}
			}

			// 按类型将年列表分组
			String[] type = new String[] { "冬番", "春番", "夏番", "秋番", "OVA/OAD", "映画", "其他" };

			Integer fuyuCount = 0;
			Integer haruCount = 0;
			Integer natsuCount = 0;
			Integer akiCount = 0;
			Integer ovaCount = 0;
			Integer egaCount = 0;
			Integer otherCount = 0;
			for (String str : type) {
				for (int j = 0, lenJ = yearVideoList.size(); j < lenJ; j++) {
					if ((yearVideoList.get(j).getVideo_type().split(";").length < 2 && str.equals("其他"))
							|| (str.equals("其他") && str.equals(yearVideoList.get(j).getVideo_type().split(";")[1]))) {
						otherCount++;
					} else if (yearVideoList.get(j).getVideo_type().split(";").length > 1
							&& str.equals(yearVideoList.get(j).getVideo_type().split(";")[1]) && str.equals("冬番")) {
						fuyuCount++;
					} else if (yearVideoList.get(j).getVideo_type().split(";").length > 1
							&& str.equals(yearVideoList.get(j).getVideo_type().split(";")[1]) && str.equals("春番")) {
						haruCount++;
					} else if (yearVideoList.get(j).getVideo_type().split(";").length > 1
							&& str.equals(yearVideoList.get(j).getVideo_type().split(";")[1]) && str.equals("夏番")) {
						natsuCount++;
					} else if (yearVideoList.get(j).getVideo_type().split(";").length > 1
							&& str.equals(yearVideoList.get(j).getVideo_type().split(";")[1]) && str.equals("秋番")) {
						akiCount++;
					} else if (yearVideoList.get(j).getVideo_type().split(";").length > 1
							&& str.equals(yearVideoList.get(j).getVideo_type().split(";")[1])
							&& str.equals("OVA/OAD")) {
						ovaCount++;
					} else if (yearVideoList.get(j).getVideo_type().split(";").length > 1
							&& str.equals(yearVideoList.get(j).getVideo_type().split(";")[1]) && str.equals("映画")) {
						egaCount++;
					}
				}
			}

			yearArr[i - begin] = i;
			fuyuArr[i - begin] = fuyuCount;
			haruArr[i - begin] = haruCount;
			natsuArr[i - begin] = natsuCount;
			akiArr[i - begin] = akiCount;
			ovaArr[i - begin] = ovaCount;
			egaArr[i - begin] = egaCount;
			otherArr[i - begin] = otherCount;
			totalArr[i - begin] = fuyuCount + haruCount + natsuCount + akiCount + ovaCount + egaCount + otherCount;
			baseArr[i - begin] = fuyuCount + haruCount + natsuCount + akiCount ;

		}
		year.setArr(yearArr);
		fuyu.setArr(fuyuArr);
		haru.setArr(haruArr);
		natsu.setArr(natsuArr);
		aki.setArr(akiArr);
		ova.setArr(ovaArr);
		ega.setArr(egaArr);
		other.setArr(otherArr);
		total.setArr(totalArr);
		base.setArr(baseArr);

		dataList.add(year);
		dataList.add(fuyu);
		dataList.add(haru);
		dataList.add(natsu);
		dataList.add(aki);
		dataList.add(ova);
		dataList.add(ega);
		dataList.add(other);
		dataList.add(total);
		dataList.add(base);

		trendBean.setDataList(dataList);
		return trendBean;
	}

}
