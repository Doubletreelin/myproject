package com.doubletree.test.entites.resp;

import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.doubletree.test.entites.enumf.ERespCode;
import com.doubletree.test.entites.enumf.ERespMessage;



public class ResponseHeader
{
	/**
	 * 请求的服务名称
	 */
	private String serviceName;
	/**
	 * 请求方
	 */
	private String sender;
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	/**
	 * 供应服务商
	 */
	private String provider = "bigtrade-finance";
	/**
	 * 状态码
	 */
	private Integer statusCode;
	/**
	 * 返回结果信息
	 */
	private String message;
	/**
	 * 消息ID
	 */
	private String id;

	public ResponseHeader()
	{
	}

	public ResponseHeader(HttpServletRequest request)
	{
		this.serviceName = request.getServletPath();
		this.sender = request.getParameter("sender") != null ? request.getParameter("sender") : null;
		this.createTime = new Timestamp(System.currentTimeMillis());
		this.id = UUID.randomUUID().toString();
	}

	public ResponseHeader(HttpServletRequest request, ERespCode statusCode, ERespMessage message)
	{
		this.serviceName = request.getServletPath();
		this.sender = request.getParameter("sender") != null ? request.getParameter("sender") : null;
		this.createTime = new Timestamp(System.currentTimeMillis());
		this.statusCode = statusCode.getId();
		this.message = message.getName();
		this.id = UUID.randomUUID().toString();
	}
	
	public ResponseHeader(HttpServletRequest request, ERespCode statusCode, String message)
	{
		this.serviceName = request.getServletPath();
		this.sender = request.getParameter("sender") != null ? request.getParameter("sender") : null;
		this.createTime = new Timestamp(System.currentTimeMillis());
		this.statusCode = statusCode.getId();
		this.message = message;
		this.id = UUID.randomUUID().toString();
	}
	
	public ResponseHeader(HttpServletRequest request, Integer statusCode, String message)
	{
		serviceName = request.getServletPath();
		sender = request.getParameter("sender") != null ? request.getParameter("sender") : null;
		this.createTime = new Timestamp(System.currentTimeMillis());
		this.statusCode = statusCode;
		this.message = message;
		this.id = UUID.randomUUID().toString();
	}

	public ResponseHeader(String serviceName, String sender, Timestamp createTime, String provider, Integer statusCode,
			String message, String id)
	{
		this.serviceName = serviceName;
		this.sender = sender;
		this.createTime = createTime;
		this.provider = provider;
		this.statusCode = statusCode;
		this.message = message;
		this.id = id;
	}

	public String getServiceName()
	{
		return serviceName;
	}

	public void setServiceName(String serviceName)
	{
		this.serviceName = serviceName;
	}

	public String getSender()
	{
		return sender;
	}

	public void setSender(String sender)
	{
		this.sender = sender;
	}

	public Timestamp getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	public String getProvider()
	{
		return provider;
	}

	public void setProvider(String provider)
	{
		this.provider = provider;
	}

	public Integer getStatusCode()
	{
		return statusCode;
	}

	public void setStatusCode(Integer statusCode)
	{
		this.statusCode = statusCode;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
}