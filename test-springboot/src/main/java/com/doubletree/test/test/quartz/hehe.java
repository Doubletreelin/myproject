package com.doubletree.test.test.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class hehe implements Job
{

	@SuppressWarnings("deprecation")
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		System.out.println("你笨不笨啊！！！");
	}

}
