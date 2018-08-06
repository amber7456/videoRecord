package com.videorecord.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.videorecord.bean.ResponseBean;
import com.videorecord.bean.disk.DiskReqBean;
import com.videorecord.mybatis.pojo.DiskInfo;
import com.videorecord.service.DiskService;

@RestController
public class DiskController {

	@Autowired
	private DiskService diskService;

	@RequestMapping(value = "/getDiskList", method = RequestMethod.POST ,produces="application/json;charset=UTF-8") // , method = RequestMethod.POST
	public ResponseBean<List<DiskInfo>> getDiskList(DiskReqBean diskReqBean, HttpSession session) throws Exception {
		return diskService.getDiskList(diskReqBean);
	}

	@RequestMapping(value = "/getDiskDetail/{disk_id}", method = RequestMethod.GET)
	public ResponseBean<DiskInfo> getDiskDetail(@PathVariable String disk_id, HttpSession session) throws Exception {
		return diskService.getDiskDetail(disk_id);
	}

	@RequestMapping(value = "/diskEdit", method = RequestMethod.POST)
	public ResponseBean<Integer> diskEdit(@RequestBody DiskReqBean diskReqBean, HttpSession session) throws Exception {
		return diskService.diskEdit(diskReqBean);
	}

	@RequestMapping(value = "/diskDel/{disk_id}", method = RequestMethod.POST)
	public ResponseBean<Integer> diskDel(@PathVariable String disk_id, HttpSession session) throws Exception {
		return diskService.diskDel(disk_id);
	}
	
	@RequestMapping(value = "/diskAdd", method = RequestMethod.POST)
	public ResponseBean<Integer> diskAdd(@RequestBody DiskReqBean diskReqBean, HttpSession session) throws Exception {
		return diskService.diskAdd(diskReqBean);
	}
	
	@RequestMapping(value = "/getDiskListByVideoType", method = RequestMethod.POST ,produces="application/json;charset=UTF-8") // , method = RequestMethod.POST
	public ResponseBean<List<DiskInfo>> getDiskListByVideoType(String video_type, HttpSession session) throws Exception {
		return diskService.getDiskListByVideoType(video_type);
	}

}
