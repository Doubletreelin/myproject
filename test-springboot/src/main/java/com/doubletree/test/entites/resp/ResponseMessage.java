package com.doubletree.test.entites.resp;

import java.util.HashMap;

public class ResponseMessage
{
	/**
	 * 返回消息头
	 */
	private ResponseHeader header  = new ResponseHeader();;
	/**
	 * 返回消息体
	 */
	private HashMap<String, Object> Body;

	public ResponseMessage()
	{
	}

	public ResponseMessage(ResponseHeader header, HashMap<String, Object> body)
	{
		super();
		this.header = header;
		Body = body;
	}

	public ResponseMessage(ResponseHeader header)
	{
		super();
		this.header = header;
	}

	public ResponseHeader getHeader()
	{
		return header;
	}

	public void setHeader(ResponseHeader header)
	{
		this.header = header;
	}

	public HashMap<String, Object> getBody()
	{
		return Body;
	}

	public void setBody(HashMap<String, Object> body)
	{
		Body = body;
	}

	public ResponseMessage(Integer code, String message)
	{
		super();
		this.header.setStatusCode(code);
		this.header.setMessage(message);
	}

}
