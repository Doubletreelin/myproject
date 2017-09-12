package com.doubletree.test.tools;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.doubletree.test.entites.enumf.ERespCode;
import com.doubletree.test.entites.resp.ResponseHeader;

/**
 * 常用工具类
 * 
 * @author doubletree
 *
 */
public class CommUtil {

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

	/**
	 * null返回int0
	 * 
	 * @param s
	 * @return
	 */
	public static int null2Int(Object s)
	{
		int v = 0;
		if (s != null)
			try
			{
				v = Integer.parseInt(s.toString());
			} catch (Exception localException)
			{
			}
		return v;
	}

	/**
	 * null返回0.0F
	 * 
	 * @param s
	 * @return
	 */
	public static float null2Float(Object s)
	{
		float v = 0.0F;
		if (s != null)
			try
			{
				v = Float.parseFloat(s.toString());
			} catch (Exception localException)
			{
			}
		return v;
	}

	/**
	 * null返回0.0D
	 * 
	 * @param s
	 * @return
	 */
	public static double null2Double(Object s)
	{
		double v = 0.0D;
		if (s != null)
			try
			{
				v = Double.parseDouble(null2String(s));
			} catch (Exception localException)
			{
			}
		return v;
	}

	/**
	 * null返回false
	 * 
	 * @param s
	 * @return
	 */
	public static boolean null2Boolean(Object s)
	{
		boolean v = false;
		if (s != null)
			try
			{
				v = Boolean.parseBoolean(s.toString());
			} catch (Exception localException)
			{
			}
		return v;
	}

	/**
	 * null返回空字符串
	 * 
	 * @param s
	 * @return
	 */
	public static String null2String(Object s)
	{
		return s == null ? "" : s.toString().trim();
	}

	/**
	 * null返回-1L
	 * 
	 * @param s
	 * @return
	 */
	public static Long null2Long(Object s)
	{
		Long v = Long.valueOf(-1L);
		if (s != null)
			try
			{
				v = Long.valueOf(Long.parseLong(s.toString()));
			} catch (Exception localException)
			{
			}
		return v;
	}

	/**
	 * 将long转成时间字符串
	 * 
	 * @param time
	 * @return
	 */
	public static String getTimeInfo(long time)
	{
		int hour = (int) time / 3600000;
		long balance = time - hour * 1000 * 60 * 60;
		int minute = (int) balance / 60000;
		balance -= minute * 1000 * 60;
		int seconds = (int) balance / 1000;
		String ret = "";
		if (hour > 0)
			ret = ret + hour + "小时";
		if (minute > 0)
			ret = ret + minute + "分";
		else if ((minute <= 0) && (seconds > 0))
			ret = ret + "零";
		if (seconds > 0)
			ret = ret + seconds + "秒";
		return ret;
	}

	public static String getIpAddr(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip)))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip)))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip)))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 将数字转成0.00类型
	 * 
	 * @param money
	 * @return
	 * @author doubletree
	 */
	public static double formatMoney(Object money)
	{
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(money)).doubleValue();
	}

	/**
	 * 传入类别format数字
	 * 
	 * @param money
	 * @param type
	 * @return
	 * @author doubletree
	 */
	public static double formatMoneyByType(Object money, String type)
	{
		DecimalFormat df = new DecimalFormat(type);
		return Double.valueOf(df.format(money)).doubleValue();
	}

	public static boolean convertIntToBoolean(int intValue)
	{
		return intValue != 0;
	}

	public static String getURL(HttpServletRequest request)
	{

		String contextPath = request.getContextPath().equals("/") ? "" : request.getContextPath();

		String url = "http://" + request.getServerName();
		if (null2Int(Integer.valueOf(request.getServerPort())) != 80)
			url = url + ":" + null2Int(Integer.valueOf(request.getServerPort())) + contextPath;
		else
		{
			url = url + contextPath;
		}
		return url;

	}

	public static int parseDate(String type, Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		if (type.equals("y"))
		{
			return cal.get(1);
		}
		if (type.equals("M"))
		{
			return cal.get(2) + 1;
		}
		if (type.equals("d"))
		{
			return cal.get(5);
		}
		if (type.equals("H"))
		{
			return cal.get(11);
		}
		if (type.equals("m"))
		{
			return cal.get(12);
		}
		if (type.equals("s"))
		{
			return cal.get(13);
		}
		return 0;
	}

	/**
	 * 生成各种码No,前N位为用户id+时间戳，最后一位为校验码（根据前N位制作成）
	 * 
	 * @param userid
	 * @return
	 * @author doubletree
	 */
	public static String createNo(Long uid)
	{
		String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String seconds = new SimpleDateFormat("HHmmssSSS").format(new Date());
		String userid = String.format("%012d", uid);
		String result = userid + date + seconds;
		String barcode = Barcode.getBarcode(result);
		result += barcode;
		return result;
	}

	/**
	 * 整理时间
	 * 
	 * @param time
	 * @return
	 */
	public static Time convertTime(String time)
	{
		Time result = null;
		try
		{
			result = Time.valueOf(time);
		} catch (Exception localException)
		{
		}
		return result;
	}

	/**
	 * 转换成只有时间的格式
	 * 
	 * @param time
	 * @return
	 */
	public static String fmtOnlyTime(Timestamp time)
	{
		String result = "";
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			result = sdf.format(time);
		} catch (Exception localException)
		{
		}
		return result;
	}

	/**
	 * 格式化数字为千分位显示；
	 * 
	 * @param 要格式化的数字；
	 * @return
	 */
	public static String fmtMicrometer(String text)
	{
		DecimalFormat df = null;
		if (text.indexOf(".") > 0)
		{
			if (text.length() - text.indexOf(".") - 1 == 0)
			{
				df = new DecimalFormat("###,##0.");
			} else if (text.length() - text.indexOf(".") - 1 == 1)
			{
				df = new DecimalFormat("###,##0.0");
			} else
			{
				df = new DecimalFormat("###,##0.00");
			}
		} else
		{
			df = new DecimalFormat("###,##0");
		}
		double number = 0.0;
		try
		{
			number = Double.parseDouble(text);
		} catch (Exception e)
		{
			number = 0.0;
		}
		return df.format(number);
	}

	/**
	 * 除法 ，a除以b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double div(Object a, Object b)
	{
		double ret = 0.0D;
		if ((!null2String(a).equals("")) && (!null2String(b).equals("")))
		{
			BigDecimal e = new BigDecimal(null2String(a));
			BigDecimal f = new BigDecimal(null2String(b));
			if (null2Double(f) > 0.0D)
				ret = e.divide(f, 3, 1).doubleValue();
		}
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret)).doubleValue();
	}

	/**
	 * 减法 a-b
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double subtract(Object a, Object b)
	{
		double ret = 0.0D;
		BigDecimal e = new BigDecimal(null2Double(a));
		BigDecimal f = new BigDecimal(null2Double(b));
		ret = e.subtract(f).doubleValue();
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret)).doubleValue();
	}

	/**
	 * 加法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double add(Object a, Object b)
	{
		double ret = 0.0D;
		BigDecimal e = new BigDecimal(null2Double(a));
		BigDecimal f = new BigDecimal(null2Double(b));
		ret = e.add(f).doubleValue();
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret)).doubleValue();
	}

	/**
	 * 乘法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double mul(Object a, Object b)
	{
		BigDecimal e = new BigDecimal(null2Double(a));
		BigDecimal f = new BigDecimal(null2Double(b));
		double ret = e.multiply(f).doubleValue();
		DecimalFormat df = new DecimalFormat("0.00");
		return Double.valueOf(df.format(ret)).doubleValue();
	}

	/**
	 * 根据返回条数返回信息公用类
	 * 
	 * @param request
	 * @param count
	 *            条数
	 * @return 如果传入等于0条，则返回操作失败 如果传入大于0条，则返回操作成功+条数 此方法用于更新和增加
	 * @author doubletree
	 */
	public static ResponseHeader respByCount(HttpServletRequest request, int count)
	{
		if (count == 0)
		{
			return new ResponseHeader(request, ERespCode.Error.getId(), "操作失败");
		} else
		{
			return new ResponseHeader(request, ERespCode.Succ.getId(), "操作成功条数为" + count);
		}
	}

	/**
	 * 为时间补全（根据传来的字符串补全）
	 * 
	 * @param date
	 *            时间 长度等于10补空格Hms，等于11补Hms，大于11date截10位+空格Hms，否则根据当前时间去补充
	 * @param Hms
	 *            补全年月日时分秒
	 * @return
	 * @author doubletree
	 */
	public static String addHmsForDate(String date, String Hms)
	{
		if (date.length() == 10)
		{
			return date + " " + Hms;
		} else if (date.length() == 11)
		{
			return date + Hms;
		} else if (date.length() > 11)
		{
			return date.substring(0, 10) + " " + Hms;
		} else
		{
			String yMdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			return date + yMdHms.substring(date.length(), 11) + Hms;
		}
	}

	/**
	 * 为时间补全（根据当前时间补全）
	 * 
	 * @param date
	 *            传入的时间
	 * @return
	 * @author doubletree
	 */
	public static String addHmsForDate(String date)
	{
		String yMdHms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		return date + yMdHms.substring(date.length(), yMdHms.length());
	}

	/**
	 * 传入一个时间获取这一天的最初时间
	 * 
	 * @param date
	 * @return
	 * @author doubletree
	 */
	public static Date getStartTimeOfDay(Date date)
	{
		Calendar day = Calendar.getInstance();
		day.setTime(date);
		day.set(Calendar.HOUR_OF_DAY, 0);
		day.set(Calendar.MINUTE, 0);
		day.set(Calendar.SECOND, 0);
		day.set(Calendar.MILLISECOND, 0);
		return day.getTime();
	}

	/**
	 * 传入一个时间获取这一天的最末时间
	 * 
	 * @param date
	 * @return
	 * @author doubletree
	 */
	public static Date getEndTimeOfDay(Date date)
	{
		Calendar day = Calendar.getInstance();
		day.setTime(date);
		day.set(Calendar.HOUR_OF_DAY, 23);
		day.set(Calendar.MINUTE, 59);
		day.set(Calendar.SECOND, 59);
		day.set(Calendar.MILLISECOND, 999);
		return day.getTime();
	}

	public static void main(String[] args)
	{
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getEndTimeOfDay(new Date())));
	}
}
