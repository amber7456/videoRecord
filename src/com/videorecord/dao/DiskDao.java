package com.videorecord.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.videorecord.bean.disk.DiskReqBean;
import com.videorecord.mybatis.mapper.DiskInfoMapper;
import com.videorecord.mybatis.pojo.DiskInfo;
import com.videorecord.mybatis.pojo.DiskInfoExample;
import com.videorecord.mybatis.pojo.DiskInfoExample.Criteria;
import com.videorecord.util.CommonUtils;

@Repository
public class DiskDao {

	@Autowired
	private DiskInfoMapper diskInfoMapper;

	public PageInfo<DiskInfo> getDiskList(DiskReqBean diskReqBean) {
		Integer pageNum = diskReqBean.getPage() != null ? diskReqBean.getPage() : 1;
		Integer pageSize = diskReqBean.getLimit() != null ? diskReqBean.getLimit() : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		DiskInfoExample example = new DiskInfoExample();
		Criteria criteria = example.createCriteria();
		if (CommonUtils.isNotEmpty(diskReqBean.getDisk_name())) {
			criteria.andDisk_nameLike("%" + diskReqBean.getDisk_name() + "%");
		}
		if (CommonUtils.isNotEmpty(diskReqBean.getVideo_type()) && !diskReqBean.getVideo_type().equals("ALL")) {
			criteria.andVideo_typeEqualTo(diskReqBean.getVideo_type());
		}
		if (CommonUtils.isNotEmpty(diskReqBean.getDisk_capacity()) && !diskReqBean.getDisk_capacity().equals("ALL")) {
			criteria.andDisk_capacityEqualTo(diskReqBean.getDisk_capacity());
		}
		if (CommonUtils.isNotEmpty(diskReqBean.getIs_full()) && !diskReqBean.getIs_full().equals("ALL")) {
			criteria.andIs_fullEqualTo(diskReqBean.getIs_full());
		}
		if (CommonUtils.isNotEmpty(diskReqBean.getDisk_state()) && !diskReqBean.getDisk_state().equals("ALL")) {
			criteria.andDisk_stateEqualTo(diskReqBean.getDisk_state());
		}
		List<DiskInfo> diskInfoList = diskInfoMapper.selectByExample(example);
		// 将查询结果使用pageInfo包装
		PageInfo<DiskInfo> page = new PageInfo<DiskInfo>(diskInfoList);
		return page;
	}

	public DiskInfo getDiskDetail(String disk_id) {
		return diskInfoMapper.selectByPrimaryKey(disk_id);
	}

	public int diskEdit(DiskReqBean diskReqBean) {
		DiskInfo diskInfo = diskReqBean;
		return diskInfoMapper.updateByPrimaryKeySelective(diskInfo);
	}

	public Integer diskDel(String disk_id) {
		return diskInfoMapper.deleteByPrimaryKey(disk_id);
	}

	public Integer diskAdd(DiskReqBean diskReqBean) {
		diskReqBean.setCreate_time(new Date());
		diskReqBean.setIs_full("未满");
		diskReqBean.setDisk_state("现役");
		return diskInfoMapper.insertSelective(diskReqBean);
	}

	public List<DiskInfo> getDiskListByVideoType(String video_type) {
		DiskInfoExample example = new DiskInfoExample();
		Criteria criteria = example.createCriteria();
		if (CommonUtils.isNotEmpty(video_type) && !video_type.equals("ALL")) {
			criteria.andVideo_typeEqualTo(video_type);
		}
		List<DiskInfo> diskInfoList = diskInfoMapper.selectByExample(example);
		return diskInfoList;
	}
}
