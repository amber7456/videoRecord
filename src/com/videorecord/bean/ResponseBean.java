package com.videorecord.bean;

import java.io.Serializable;

public class ResponseBean<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final int SUCCESS = 0;
	public static final int FAIL = -1;
	private long code = SUCCESS;
	public String msg = "success";
	public Integer count;
	private T data;

	public ResponseBean() {
		super();
	}

	public ResponseBean(T data) {
		super();
		this.data = data;
	}

	public ResponseBean(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = FAIL;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ResponseBean [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
	}

}
