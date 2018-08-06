package com.videorecord.mybatis.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DiskInfo {
    private String disk_id;

    private String disk_name;

    private String disk_capacity;

    private String disk_state;

    private String is_full;

    private Date create_time;

    private String video_type;

    private String remark;

    public String getDisk_id() {
        return disk_id;
    }

    public void setDisk_id(String disk_id) {
        this.disk_id = disk_id == null ? null : disk_id.trim();
    }

    public String getDisk_name() {
        return disk_name;
    }

    public void setDisk_name(String disk_name) {
        this.disk_name = disk_name == null ? null : disk_name.trim();
    }

    public String getDisk_capacity() {
        return disk_capacity;
    }

    public void setDisk_capacity(String disk_capacity) {
        this.disk_capacity = disk_capacity == null ? null : disk_capacity.trim();
    }

    public String getDisk_state() {
        return disk_state;
    }

    public void setDisk_state(String disk_state) {
        this.disk_state = disk_state == null ? null : disk_state.trim();
    }

    public String getIs_full() {
        return is_full;
    }

    public void setIs_full(String is_full) {
        this.is_full = is_full == null ? null : is_full.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public Date getCreate_time() {
        return create_time;
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getVideo_type() {
        return video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type == null ? null : video_type.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "DiskInfo [disk_id=" + disk_id + ", disk_name=" + disk_name + ", disk_capacity=" + disk_capacity
				+ ", disk_state=" + disk_state + ", is_full=" + is_full + ", create_time=" + create_time
				+ ", video_type=" + video_type + ", remark=" + remark + "]";
	}
    
    
}