package com.videorecord.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.disk.DiskReqBean;
import com.videorecord.bean.video.req.VideoSearchReqBean;
import com.videorecord.bean.video.resp.VideoListBean;
import com.videorecord.bean.video.resp.YearData;
import com.videorecord.mybatis.pojo.DiskInfo;
import com.videorecord.mybatis.pojo.VideoInfo;
import com.videorecord.mybatis.pojo.VideoResourceInfo;
import com.videorecord.service.DiskService;
import com.videorecord.service.VideoService;
import com.videorecord.util.CommonUtils;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import java.awt.Color;

import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;

@RestController
public class ExcelDownloadController {

	@Autowired
	private VideoService videoService;
	@Autowired
	private DiskService diskService;

	@RequestMapping(value = "/excelDownload", method = RequestMethod.POST)
	public void getDiskList(HttpServletRequest request, HttpServletResponse response, VideoSearchReqBean req,
			HttpSession session) throws Exception {
		ResponseBean<VideoListBean> videoList = videoService.searchVideo(req);
		File file = createAdvEXCEL(req, videoList);
		CommonUtils.downLoadFile(request, response, file.getName() + ".xls", file);
	}

	// 生成excel文件
	public File createAdvEXCEL(VideoSearchReqBean req, ResponseBean<VideoListBean> videoList) {

		ResponseBean<List<DiskInfo>> diskInfoList = diskService.getDiskList(new DiskReqBean());

		HashMap<String, String> diskMap = getDiskMap(diskInfoList.getData());

		StringBuffer nameStr = new StringBuffer("");

		if (CommonUtils.isNotEmpty(req.getYearRange())) {
			String begin = req.getYearRange().split("-")[0].trim();
			String end = req.getYearRange().split("-")[1].trim();
			nameStr.append(begin + "-" + end);
		}

		if (CommonUtils.isNotEmpty(req.getVideoType()) && !req.getVideoType().equals("ALL")) {
			nameStr.append("_" + req.getVideoType());
		}

		if (CommonUtils.isNotEmpty(req.getSerializeTime()) && !req.getSerializeTime().equals("ALL")) {
			if (req.getSerializeTime().equals("1")) {
				nameStr.append("_季番");
			} else if (req.getSerializeTime().equals("2")) {
				nameStr.append("_半年番");
			} else if (req.getSerializeTime().equals("3")) {
				nameStr.append("_年番");
			} else if (req.getSerializeTime().equals("4")) {
				nameStr.append("_长连载");
			}
		}

		if (CommonUtils.isNotEmpty(req.getAddress()) && !req.getAddress().equals("ALL")) {
			nameStr.append("_" + req.getAddress());
		}
		//
		if (CommonUtils.isNotEmpty(req.getResourceType()) && !req.getResourceType().equals("ALL")) {
			nameStr.append("_" + req.getResourceType());
		}
		//
		if (CommonUtils.isNotEmpty(req.getFormat()) && !req.getFormat().equals("ALL")) {
			nameStr.append("_" + req.getFormat());
		}

		if (CommonUtils.isNotEmpty(req.getResolution()) && !req.getResolution().equals("ALL")) {
			nameStr.append("_" + req.getResolution());
		}

		if (CommonUtils.isNotEmpty(req.getSubType()) && !req.getSubType().equals("ALL")) {
			nameStr.append("_" + req.getSubType());
		}

		if (CommonUtils.isNotEmpty(req.getVideoName())) {
			nameStr.append("_" + req.getVideoName());
		}

		File file = new File(nameStr.toString());

		// 创建excel
		WritableWorkbook workbook;
		try {
			workbook = Workbook.createWorkbook(file);
			WritableSheet sheet = workbook.createSheet("第一页", 0); // 添加第一个工作表

			// 设置列宽
			sheet.setColumnView(0, 15);
			sheet.setColumnView(1, 15);
			sheet.setColumnView(2, 40);
			sheet.setColumnView(3, 12);

			jxl.write.WritableCellFormat wcsB = new jxl.write.WritableCellFormat();
			// 设置边框
			wcsB.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			// 水平居中对齐
			wcsB.setAlignment(Alignment.CENTRE);
			// 竖直方向居中对齐
			wcsB.setVerticalAlignment(VerticalAlignment.CENTRE);

			wcsB.setWrap(true);

			jxl.write.WritableCellFormat wcsC = new jxl.write.WritableCellFormat();
			// 设置边框
			wcsC.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

			wcsC.setAlignment(Alignment.LEFT);
			// 竖直方向居中对齐
			wcsC.setVerticalAlignment(VerticalAlignment.CENTRE);

			// 设置自定义颜色，通过java.awt.Color中decode方法提取16进制颜色值
			Color color1 = Color.decode("#7bbfea"); // 自定义的颜色
			workbook.setColourRGB(Colour.BLUE, color1.getRed(), color1.getGreen(), color1.getBlue());
			WritableCellFormat wcf1 = new WritableCellFormat();// 单元格样式
			wcf1.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			wcf1.setBackground(Colour.BLUE);

			// 设置自定义颜色，通过java.awt.Color中decode方法提取16进制颜色值
			Color color2 = Color.decode("#9FEF4E"); // 自定义的颜色
			workbook.setColourRGB(Colour.GREEN, color2.getRed(), color2.getGreen(), color2.getBlue());
			WritableCellFormat wcf2 = new WritableCellFormat();// 单元格样式
			wcf2.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
			wcf2.setBackground(Colour.GREEN);

			// row是行号，循环添加内容用
			int row = 1;

			for (int i = 0; i < videoList.getData().getYearData().size(); i++) {
				YearData yearData = videoList.getData().getYearData().get(i);
				int count = 0;
				int fuyu = 0;
				int haru = 0;
				int natsu = 0;
				int aki = 0;
				int ova = 0;
				int movie = 0;
				int other = 0;
				for (int j = 0; j < yearData.getSeason().size(); j++) {
					count = count + yearData.getSeason().get(j).getVideoInfo().size();
					if (yearData.getSeason().get(j).getType().equals("冬番")) {
						fuyu = yearData.getSeason().get(j).getVideoInfo().size();
					} else if (yearData.getSeason().get(j).getType().equals("春番")) {
						haru = yearData.getSeason().get(j).getVideoInfo().size();
					} else if (yearData.getSeason().get(j).getType().equals("夏番")) {
						natsu = yearData.getSeason().get(j).getVideoInfo().size();
					} else if (yearData.getSeason().get(j).getType().equals("秋番")) {
						aki = yearData.getSeason().get(j).getVideoInfo().size();
					} else if (yearData.getSeason().get(j).getType().equals("OVA/OAD")) {
						ova = yearData.getSeason().get(j).getVideoInfo().size();
					} else if (yearData.getSeason().get(j).getType().equals("映画")) {
						movie = yearData.getSeason().get(j).getVideoInfo().size();
					} else if (yearData.getSeason().get(j).getType().equals("其他")) {
						other = yearData.getSeason().get(j).getVideoInfo().size();
					} else {
						other = yearData.getSeason().get(j).getVideoInfo().size();
					}
				}
				sheet.mergeCells(0, row, 0, (row + count - 1));

				if (count > 1) {
					sheet.addCell(new Label(0, row, yearData.getYear() + "年\r\n" + count + "部", wcsB));
				} else {
					sheet.addCell(new Label(0, row, yearData.getYear() + "年" + count + "部", wcsB));
				}

				int groupNum = 0;
				for (int j = 0; j < yearData.getSeason().size(); j++) {
					List<VideoInfo> videoInfo = yearData.getSeason().get(j).getVideoInfo();
					for (int k = 0; k < videoInfo.size(); k++) {

						int rowGroup = row + groupNum + k;

						sheet.addCell(new Label(1, rowGroup,
								yearData.getSeason().get(j).getType() + videoInfo.size() + "部", wcsB));
						sheet.addCell(new Label(2, rowGroup, videoInfo.get(k).getVideo_name(), wcsC));
						String broadcast_time = CommonUtils.DateToString(videoInfo.get(k).getVideo_broadcast_time(),
								"YYYY-MM-dd");
						sheet.addCell(new Label(3, rowGroup, broadcast_time, wcsB));
						sheet.addCell(new Label(4, rowGroup, videoInfo.get(k).getVideo_episode() + "话", wcsB));
						sheet.addCell(new Label(5, rowGroup, videoInfo.get(k).getVideo_source(), wcsB));

						int r = 0;
						for (int n = 0; n < videoInfo.get(k).getVideoResourceInfo().size(); n++) {
							VideoResourceInfo videoResourceInfo = videoInfo.get(k).getVideoResourceInfo().get(n);
							WritableCellFormat wcf = null;
							if (videoResourceInfo.getResource_type().equals("BD")) {
								wcf = wcf1;
							} else {
								wcf = wcf2;
							}

							sheet.setColumnView(6 + r, 10);
							if (videoResourceInfo.getResource_type().equals("NORMAL")) {
								sheet.addCell(new Label(6 + r, rowGroup, "普通资源", wcf));
							} else {
								sheet.addCell(new Label(6 + r, rowGroup, "BD资源", wcf));
							}
							r++;

							sheet.setColumnView(6 + r, 6);
							sheet.addCell(new Label(6 + r, rowGroup, videoResourceInfo.getResource_format(), wcf));
							r++;

							sheet.setColumnView(6 + r, 10);
							sheet.addCell(new Label(6 + r, rowGroup, videoResourceInfo.getResource_resolution(), wcf));
							r++;

							sheet.setColumnView(6 + r, 6);
							sheet.addCell(new Label(6 + r, rowGroup, videoResourceInfo.getResource_sub_type(), wcf));
							r++;

							sheet.setColumnView(6 + r, 20);
							sheet.addCell(new Label(6 + r, rowGroup,
									diskMap.get(videoResourceInfo.getResource_record_address()), wcf));
							r++;

						}

					}

					groupNum = groupNum + yearData.getSeason().get(j).getVideoInfo().size();
				}

				int rowNum = row + fuyu;
				if (fuyu > 1) {
					sheet.mergeCells(1, row, 1, (rowNum - 1));
					sheet.addCell(new Label(1, row, "冬番\r\n" + fuyu + "部", wcsB));
				}

				if (haru > 1) {
					sheet.mergeCells(1, rowNum, 1, (rowNum + haru - 1));
					sheet.addCell(new Label(1, rowNum, "春番\r\n" + haru + "部", wcsB));
				}
				if (natsu > 1) {
					rowNum = rowNum + haru;
					sheet.mergeCells(1, rowNum, 1, (rowNum + natsu - 1));
					sheet.addCell(new Label(1, rowNum, "夏番\r\n" + natsu + "部", wcsB));
				}
				if (aki > 1) {
					rowNum = rowNum + natsu;
					sheet.mergeCells(1, rowNum, 1, (rowNum + aki - 1));
					sheet.addCell(new Label(1, rowNum, "秋番\r\n" + aki + "部", wcsB));
				}
				if (ova > 1) {
					rowNum = rowNum + aki;
					sheet.mergeCells(1, rowNum, 1, (rowNum + ova - 1));
					sheet.addCell(new Label(1, rowNum, "OVA/OAD\r\n" + ova + "部", wcsB));
				}
				if (movie > 1) {
					rowNum = rowNum + ova;
					sheet.mergeCells(1, rowNum, 1, (rowNum + movie - 1));
					sheet.addCell(new Label(1, rowNum, "映画\r\n" + movie + "部", wcsB));
				}
				if (other > 1) {
					rowNum = rowNum + movie;
					sheet.mergeCells(1, rowNum, 1, (rowNum + other - 1));
					sheet.addCell(new Label(1, rowNum, "其他\r\n" + other + "部", wcsB));
				}

				row = row + count;

			}

			// System.out.println(workbook.getSheet(0).getColumns());
			// System.out.println(workbook.getSheet(0).getRows());

			for (int i = 0; i < workbook.getSheet(0).getColumns(); i++) {
				for (int j = 0; j < workbook.getSheet(0).getRows(); j++) {
					if (workbook.getSheet(0).getCell(i, j).getContents().length() == 0) {
						sheet.addCell(new Label(i, j, "", wcsB));
					}
				}
			}

			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}

	private HashMap<String, String> getDiskMap(List<DiskInfo> data) {
		HashMap<String, String> diskMap = new HashMap<String, String>();
		for (int i = 0; i < data.size(); i++) {
			diskMap.put(data.get(i).getDisk_id(), data.get(i).getDisk_name());
		}
		return diskMap;
	}

}
