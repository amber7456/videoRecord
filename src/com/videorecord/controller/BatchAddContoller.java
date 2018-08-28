package com.videorecord.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.batchupload.UploadReqBean;
import com.videorecord.mybatis.pojo.VideoInfo;
import com.videorecord.service.BatchAddService;
import com.videorecord.util.CommonUtils;

@RestController
public class BatchAddContoller {

	@Autowired
	private BatchAddService batchAddService;

	@RequestMapping(value = "/templateDownload", method = RequestMethod.POST)
	public void templateDownload(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		String path = session.getServletContext().getRealPath("/excel/模板.xlsx");
		String pathCpoy = session.getServletContext().getRealPath("/excel/模板_" + CommonUtils.getID() + ".xlsx");
		File fileCpoy = new File(pathCpoy);
		CommonUtils.fileCopy(path, pathCpoy);
		CommonUtils.downLoadFile(request, response, fileCpoy.getName(), fileCpoy);
	}

	public static void copyFile(String oldFile, String newFile) {
		FileInputStream fis = null;
		ByteArrayOutputStream baos = null;
		try {
			// 将源文件放入文件输入流中
			fis = new FileInputStream(new File(oldFile));
			baos = new ByteArrayOutputStream();
			byte[] bs = new byte[1024];
			int count = 0;
			while ((count = fis.read(bs)) != -1) {
				// 将源文件中的数据写入到运行内存
				baos.write(bs, 0, count);
				// 强制清空输出流中的数据，确保输出流中的数据全部写入到指定的文件中
				baos.flush();
			}
			// 将从运行内容中读取到的数据，写入到指定的文件中
			baos.toByteArray();
			baos.writeTo(new FileOutputStream(new File(newFile)));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流，释放资源
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

				if (baos != null) {
					try {
						baos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	@RequestMapping(value = "/parseExcel", method = RequestMethod.POST)
	public ResponseBean<List<VideoInfo>> getEchartsData(UploadReqBean req, HttpSession session) throws Exception {
		return batchAddService.parseExcel(req);
	}

	@RequestMapping(value = "/batchAdd", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseBean<Integer> batchAdd(String videoInfo, HttpSession session) throws Exception {
		return batchAddService.batchAdd(videoInfo);
	}

}
