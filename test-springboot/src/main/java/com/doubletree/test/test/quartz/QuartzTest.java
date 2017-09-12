package com.doubletree.test.test.quartz;

import com.doubletree.test.tools.QuartzManager;

/**
 * 定时器测试
 * 
 * @author shaolin
 * @time 下午2:33:25
 */
public class QuartzTest
{
	public static void main(String[] args)
	{
		System.out.println("/n【再次添加定时任务】开始(每10秒输出一次)...");  
		QuartzManager.addJob("1", hehe.class, "0 12 14 * * ?"); 
	}
}
