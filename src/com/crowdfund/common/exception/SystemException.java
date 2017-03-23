package com.crowdfund.common.exception;

public class SystemException extends Exception{

	private Throwable cause;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6297082434380560995L;

	public SystemException() {};

	public SystemException(String msg){
		super(msg);
	}
	
	public SystemException(Exception e){
		super(e);
	}
	
	public SystemException(Throwable ex){
		this.cause = ex;
	}
}
