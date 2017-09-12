package com.doubletree.test.filters;

import com.doubletree.test.tools.CommUtil;

/**
 * 传入的分页信息
 * 
 * @author ifeng
 *
 */
public class PageReq
{
	private Integer pageSize;
	private Integer pageNum;
	private String orderColumns;
	private String desc;

	public PageReq(Integer pageSize, Integer pageNum, String orderColumns, String desc)
	{
		this.pageSize = pageSize == null ? 10 : pageSize;
		this.pageNum = pageNum == null ? 1 : pageNum;
		this.orderColumns = orderColumns;
		this.desc = desc;
	}

	public PageReq()
	{
	}

	public Integer getPageSize()
	{
		return pageSize == null ? 10 : pageSize;
	}

	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
	}

	public Integer getPageNum()
	{
		return pageNum == null ? 1 : pageNum;
	}

	public void setPageNum(Integer pageNum)
	{
		this.pageNum = pageNum;
	}

	public String getOrderColumns()
	{
		return orderColumns;
	}

	public void setOrderColumns(String orderColumns)
	{
		this.orderColumns = orderColumns;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public String getOrderStr()
	{
		if (CommUtil.isNotNull(orderColumns))
		{
			if (CommUtil.isNotNull(desc))
			{
				return orderColumns + " " + desc;
			} else
			{
				return orderColumns;
			}
		} else
		{
			return null;
		}
	}

}
