package com.ifeng.bigtrade.core;

import com.ifeng.bigtrade.tools.SysConfig;

public class Main
{

	public static void main(String[] args)
	{
		String allproject = SysConfig.getInstance().getProperty("allproject");
		String package_save_url = SysConfig.getInstance().getProperty("package_save_url");
		String classpath = Main.class.getClassLoader().getResource("").getPath();
		classpath = classpath.substring(1, classpath.length());
		String[] all = allproject.split(",");
		Runtime runtime = Runtime.getRuntime();
		for (int i = 0; i < all.length; i++)
		{
			String url = SysConfig.getInstance().getProperty(all[i] + "_url");
			try
			{
				String cmd = "cmd /k start " + classpath + "package.bat " + all[i] + " " + url + " " + package_save_url
						+ " " + url.split(":")[0] + ":";
				runtime.exec(cmd);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
