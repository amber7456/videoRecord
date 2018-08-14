package com.videorecord.bean.batchupload;

import org.springframework.web.multipart.MultipartFile;

public class UploadReqBean {

	private MultipartFile file;

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "UploadReqBean [file=" + file + "]";
	}

}
