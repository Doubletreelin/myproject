package com.ifeng.bigtrade.tools;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Properties;

public class SysConfig
{
	private Properties props = null;// config.properties
	private static volatile SysConfig conf;

	private SysConfig()
	{
		props = new Properties();
		loadConfigProps();
	}

	public static SysConfig getInstance()
	{
		if (conf == null)
		{
			synchronized (SysConfig.class)
			{
				if (conf == null)
				{
					conf = new SysConfig();
				}
			}
		}
		return conf;
	}

	public void loadConfigProps()
	{
		InputStream is = null;
		try
		{
			// is =
			// getClass().getResourceAsStream("/WEB-INF/classes/config.properties");
			is = getClass().getClassLoader().getResourceAsStream("/config.properties");
			if (is == null)
			{
				is = getClass().getResourceAsStream("/config.properties");
			}
			InputStreamReader reader = new InputStreamReader(is, "UTF-8");
			props.load(reader);
			Iterator<String> iter = props.stringPropertyNames().iterator();
			while (iter.hasNext())
			{
				String key = iter.next();
				props.setProperty(key, props.getProperty(key));
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (is != null)
			{
				try
				{
					is.close();
					is = null;
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public String getProperty(String key)
	{
		String tmp = props.getProperty(key);
		if (isNotNull(tmp))
		{
			return tmp.trim();
		}
		return tmp;
	}

	public String getProperty(String key, String defaultValue)
	{
		String tmp = props.getProperty(key, defaultValue);
		if (isNotNull(tmp))
		{
			return tmp.trim();
		}
		return tmp;
	}

	public int getPropertyInt(String key)
	{
		String tmp = props.getProperty(key);
		if (isNotNull(tmp))
		{
			return Integer.parseInt(tmp.trim());
		}
		return 0;

	}

	public int getPropertyInt(String key, int defaultValue)
	{
		String tmp = props.getProperty(key);
		if (isNotNull(tmp))
		{
			return Integer.parseInt(tmp.trim());
		}
		return defaultValue;
	}

	public long getPropertyLong(String key, long defaultValue)
	{
		String tmp = props.getProperty(key);
		if (isNotNull(tmp))
		{
			return Integer.parseInt(tmp.trim());
		}
		return defaultValue;
	}

	/**
	 * 判断是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotNull(Object obj)
	{
		return (obj != null) && (!obj.toString().equals(""));
	}

}
