package com.videorecord.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videorecord.dao.PosterDao;

@Service
public class PosterService {

	@Autowired
	private PosterDao posterDao;

	public byte[] getPosterById(String video_id) {
		return posterDao.getPosterById(video_id);
	}

}
