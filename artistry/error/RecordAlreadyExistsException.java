package com.artistry.error;

public class RecordAlreadyExistsException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  RecordAlreadyExistsException(String str) {
		super(str);
	}
}
