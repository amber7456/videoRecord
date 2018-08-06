package com.videorecord.mybatis.pojo;

import java.util.Date;

public class VideoPoster {
    private String video_id;

    private Date upload_time;

    private byte[] video_poster;

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id == null ? null : video_id.trim();
    }

    public Date getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(Date upload_time) {
        this.upload_time = upload_time;
    }

    public byte[] getVideo_poster() {
        return video_poster;
    }

    public void setVideo_poster(byte[] video_poster) {
        this.video_poster = video_poster;
    }
}