package com.doubletree.test.entites.enumf;

public enum ERespCode
{
	Succ(2000, "操作成功"),
	ParamNull(4001, "必填参数为空"), 
	ObjectNull(4002, "操作对象不存在"), 
	ListNull(4003,"请求集合为空"),
	ParamError(4004,"请求参数不符合要求"),
	MyBatiesError(5001,"数据库错误"),
	Error(5002,"操作失败");

	private int Id;

	private String name;

	// 普通方法
	public static String getName(int key)
	{
		for (ERespCode c : ERespCode.values())
		{
			if (c.getId() == key)
			{
				return c.name;
			}
		}
		return null;
	}

	private ERespCode(int id, String name)
	{
		this.Id = id;
		this.name = name;
	}

	public int getId()
	{
		return Id;
	}

	public void setKey(int Id)
	{
		this.Id = Id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
