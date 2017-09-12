package com.doubletree.test.entites.enumf;

public enum ERespMessage
{
	Succ(200, "请求成功"), 
	Error(5001, "操作异常"), 
	UpdateError(5002, "更新失败"), 
	AddError(5003, "添加失败"), 
	DeleteError(5004,"删除失败"),
	ParaNotEnough(5005,"缺少参数"),
	selectError(5006,"查询失败")
	;

	private int Id;

	private String name;

	// 普通方法
	public static String getName(int key)
	{
		for (ERespMessage c : ERespMessage.values())
		{
			if (c.getId() == key)
			{
				return c.name;
			}
		}
		return null;
	}

	private ERespMessage(int Id, String name)
	{
		this.Id = Id;
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
