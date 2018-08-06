package com.videorecord.exception;

public class ForegoneException extends Exception {

	private static final long serialVersionUID = -5941493669447219903L;

	private long errcode = 0;
	
    public ForegoneException(Exception e) {
        super(e);
    }
	public ForegoneException(String msg) {
		super(msg);
	}

	public ForegoneException(String msg, Throwable ex) {
		super(msg, ex);
	}

	public ForegoneException(String arg0, int errcode) {
		super(arg0);
		this.errcode = errcode;
	}

	public ForegoneException(String arg0, long errcode) {
		super(arg0);
		this.errcode = errcode;
	}

	public long getErrcode() {
		return errcode;
	}

	public void setErrcode(long errcode) {
		this.errcode = errcode;
	}

}
