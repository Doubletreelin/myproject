package com.doubletree.test.exceptions;

import com.doubletree.test.entites.enumf.ERespCode;
import com.doubletree.test.entites.enumf.ERespMessage;

/**
 * 自定义失败异常
 * 
 * @author GYP
 * 
 */
public class MyException extends Exception
{

    private static final long serialVersionUID = 1L;
    private String message;
    private Integer code;
    private String errorStr;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Integer getCode()
    {
        return code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public MyException(String message, Integer code,String errorStr)
    {
        super();
        this.message = message;
        this.code = code;
        this.errorStr = errorStr;
    }
    
    public MyException(ERespMessage message, ERespCode code,String errorStr)
    {
        super();
        this.message = message.getName();
        this.code = code.getId();
        this.errorStr = errorStr;
    }
    
    public MyException(ERespMessage message, ERespCode code)
    {
        super();
        this.message = message.getName();
        this.code = code.getId();
    }
    
    public MyException(String message, Integer code)
    {
        super();
        this.message = message;
        this.code = code;
    }
    
    public MyException(String message,ERespCode code)
    {
        super();
        this.message = message;
        this.code = code.getId();
    }

    public MyException()
    {
        super();
    }

	public String getErrorStr()
	{
		return errorStr;
	}

	public void setErrorStr(String errorStr)
	{
		this.errorStr = errorStr;
	}
    
    

}
