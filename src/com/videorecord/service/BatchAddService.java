package com.videorecord.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.batchupload.UploadReqBean;
import com.videorecord.mybatis.pojo.VideoInfo;
import com.videorecord.mybatis.pojo.VideoResourceInfo;
import com.videorecord.util.CommonUtils;

@Service
@Transactional
public class BatchAddService {

	public ResponseBean<List<VideoInfo>> parseExcel(UploadReqBean req) throws IllegalStateException, IOException {
		 
		// 获取文件名
		String fileName = req.getFile().getOriginalFilename();
		// 获取文件后缀
		String prefix = fileName.substring(fileName.lastIndexOf("."));
		File excelFile = File.createTempFile(fileName, prefix);
		// MultipartFile to File
		req.getFile().transferTo(excelFile);
		List<Map<String, String>> list = parseExcel(excelFile);
		List<VideoInfo> videoList = getVideoInfo(list);
		// 删除临时文件
		deleteFile(excelFile);
		return new ResponseBean<List<VideoInfo>>(videoList);
	}

	private List<VideoInfo> getVideoInfo(List<Map<String, String>> list) {
		List<VideoInfo> videoList = new ArrayList<VideoInfo>();
		String id = CommonUtils.getID();

		for (Map<String, String> map : list) {
			VideoInfo videoInfo = new VideoInfo();
			videoInfo.setVideo_id(id);
			videoInfo.setVideo_name(map.get("videoName"));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				videoInfo.setVideo_broadcast_time(sdf.parse(map.get("broadcastTime")));
			} catch (ParseException e) {
				videoInfo.setVideo_broadcast_time(new Date());
			}
			videoInfo.setVideo_episode(map.get("ep"));
			videoInfo.setVideo_type(map.get("videoType"));
			videoInfo.setVideo_season(map.get("season"));
			videoInfo.setVideo_country(map.get("country"));
			videoInfo.setVideo_source(map.get("source"));
			List<VideoResourceInfo> videoResourceInfo = new ArrayList<VideoResourceInfo>();
			videoResourceInfo = getVideoResourceInfo(id, map);
			videoInfo.setVideoResourceInfo(videoResourceInfo);
			videoList.add(videoInfo);
		}

		return videoList;
	}

	private List<VideoResourceInfo> getVideoResourceInfo(String id, Map<String, String> map) {
		List<VideoResourceInfo> resourceList = new ArrayList<VideoResourceInfo>();
		int rcount = (map.size() - 7) / 5;

		for (int i = 0; i < rcount; i++) {
			VideoResourceInfo vr = new VideoResourceInfo();
			vr.setVideo_id(id);
			int index = 5 * i;
			if (map.get("R" + (7 + index)).equals("普通资源") || map.get("R" + (7 + index)).equals("NORMAL")) {
				vr.setResource_type("NORMAL");
			}
			vr.setResource_format(map.get("R" + (8 + index)));
			vr.setResource_resolution(map.get("R" + (9 + index)));
			if (map.get("R" + (10 + index)).equals("无") || map.get("R" + (10 + index)).equals("无字幕")) {
				vr.setResource_sub("0");
			} else {
				vr.setResource_sub("1");
				vr.setResource_sub_type(map.get("R" + (10 + index)));
			}
			vr.setResource_record_address(map.get("R" + (11 + index)));
			vr.setResource_record_time(new Date());
			vr.setResource_remark("");

			resourceList.add(vr);
		}

		return resourceList;
	}

	public List<Map<String, String>> parseExcel(File file) {
		Workbook wb = null;
		Sheet sheet = null;
		Row row = null;
		List<Map<String, String>> list = null;
		String cellData = null;
		String columns[] = { "videoName", "broadcastTime", "ep", "videoType", "season", "country", "source" };
		wb = readExcel(file);
		if (wb != null) {
			// 用来存放表中数据
			list = new ArrayList<Map<String, String>>();
			// 获取第一个sheet
			sheet = wb.getSheetAt(0);
			// 获取最大行数
			int rownum = sheet.getPhysicalNumberOfRows();
			// 获取第一行
			row = sheet.getRow(0);
			for (int i = 1; i < rownum; i++) {
				Map<String, String> map = new LinkedHashMap<String, String>();
				row = sheet.getRow(i);
				// 获取最大列数
				int colnum = row.getPhysicalNumberOfCells();
				if (row != null) {
					for (int j = 0; j < colnum; j++) {
						cellData = (String) getCellFormatValue(row.getCell(j));
						if (j < columns.length) {
							map.put(columns[j], cellData);
						} else if (cellData != null && cellData.length() > 0) {
							map.put("R" + j, cellData);
						}
					}
				}
				list.add(map);
			}
		}
		// // 遍历解析出来的list
		// for (Map<String, String> map : list) {
		// for (Entry<String, String> entry : map.entrySet()) {
		// System.out.print(entry.getKey() + ":" + entry.getValue() + ",");
		// }
		// System.out.println();
		// }
		return list;

	}

	// 读取excel
	public static Workbook readExcel(File file) {
		Workbook wb = null;
		if (file == null) {
			return null;
		}
		String extString = file.getName().substring(file.getName().lastIndexOf("."));
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			if (".xls".equals(extString)) {
				return wb = new HSSFWorkbook(is);
			} else if (".xlsx".equals(extString)) {
				return wb = new XSSFWorkbook(is);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}

	public static Object getCellFormatValue(Cell cell) {
		Object cellValue = null;
		if (cell != null) {
			// 判断cell类型
			switch (cell.getCellTypeEnum()) {
			case NUMERIC: {
				// 此处需要取整
				cellValue = String.valueOf(Integer.valueOf((int) cell.getNumericCellValue()));
				break;
			}
			case FORMULA: {
				// 判断cell是否为日期格式
				if (DateUtil.isCellDateFormatted(cell)) {
					// 转换为日期格式YYYY-mm-dd
					cellValue = cell.getDateCellValue();
				} else {
					// 数字
					cellValue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case STRING: {
				cellValue = cell.getRichStringCellValue().getString();
				break;
			}
			default:
				cellValue = "";
			}
		} else {
			cellValue = "";
		}
		return cellValue;
	}

	/**
	 * 删除 @param files
	 */
	private void deleteFile(File... files) {
		for (File file : files) {
			if (file.exists()) {
				file.delete();
			}
		}
	}

}
