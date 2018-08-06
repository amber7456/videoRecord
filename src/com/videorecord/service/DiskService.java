package com.videorecord.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.disk.DiskReqBean;
import com.videorecord.dao.DiskDao;
import com.videorecord.mybatis.pojo.DiskInfo;
import com.videorecord.util.CommonUtils;

@Service
public class DiskService {

	@Autowired
	private DiskDao diskDao;

	public ResponseBean<List<DiskInfo>> getDiskList(DiskReqBean diskReqBean) {
		ResponseBean<List<DiskInfo>> resp = new ResponseBean<List<DiskInfo>>();
		PageInfo<DiskInfo> page = diskDao.getDiskList(diskReqBean);
		resp.setData(page.getList());
		resp.setCount((int) page.getTotal());
		return resp;
	}

	public ResponseBean<DiskInfo> getDiskDetail(String disk_id) {
		ResponseBean<DiskInfo> resp = new ResponseBean<DiskInfo>();
		DiskInfo diskInfo = diskDao.getDiskDetail(disk_id);
		resp.setData(diskInfo);
		return resp;
	}

	public ResponseBean<Integer> diskEdit(DiskReqBean diskReqBean) {
		ResponseBean<Integer> resp = new ResponseBean<Integer>();
		resp.setData(diskDao.diskEdit(diskReqBean));
		return resp;
	}

	public ResponseBean<Integer> diskDel(String disk_id) {
		ResponseBean<Integer> resp = new ResponseBean<Integer>();
		resp.setData(diskDao.diskDel(disk_id));
		return resp;
	}

	public ResponseBean<Integer> diskAdd(DiskReqBean diskReqBean) {
		ResponseBean<Integer> resp = new ResponseBean<Integer>();
		diskReqBean.setDisk_id(CommonUtils.getID());
		resp.setData(diskDao.diskAdd(diskReqBean));
		return resp;
	}

	public ResponseBean<List<DiskInfo>> getDiskListByVideoType(String video_type) {
		ResponseBean<List<DiskInfo>> resp = new ResponseBean<List<DiskInfo>>();
		resp.setData(diskDao.getDiskListByVideoType(video_type));
		return resp;
	}

}
