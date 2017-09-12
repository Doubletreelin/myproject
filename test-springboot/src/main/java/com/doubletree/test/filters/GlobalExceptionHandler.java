package com.doubletree.test.filters;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.doubletree.test.entites.enumf.ERespCode;
import com.doubletree.test.entites.resp.ResponseHeader;
import com.doubletree.test.entites.resp.ResponseMessage;
import com.doubletree.test.exceptions.MyException;



@RestControllerAdvice
public class GlobalExceptionHandler
{

	@ExceptionHandler(value =
	{ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseMessage unknownException(Exception ex, HttpServletRequest request)
	{
		ex.getSuppressed();
		return new ResponseMessage(new ResponseHeader(request, 500, ex.getMessage()));
	}

	/**
	 * 自定义异常捕获
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value =
	{ MyException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseMessage unknownException(MyException ex, HttpServletRequest request)
	{
		return new ResponseMessage(new ResponseHeader(request, ex.getCode(), ex.getMessage()));
	}

	@ExceptionHandler(value =
	{ NoHandlerFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseMessage unknownIOException(NoHandlerFoundException ex, HttpServletRequest request)
	{
		return new ResponseMessage(new ResponseHeader(request, 404, ex.getMessage()));
	}

	@ExceptionHandler(value =
	{ IllegalArgumentException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseMessage IllegalArgumentException(IllegalArgumentException ex, HttpServletRequest request)
	{
		return new ResponseMessage(new ResponseHeader(request, 400, ex.getMessage()));
	}

	/**
	 * 传参验证异常捕获
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value =
	{ BindException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseMessage BindExceptionException(BindException ex, HttpServletRequest request)
	{
		String message = "";
		List<FieldError> error = ex.getFieldErrors();
		for (int i = 0; i < error.size(); i++)
		{
			FieldError e = error.get(i);
			message = message + e.getField() + e.getDefaultMessage() + ",";
		}
		message = message.substring(0, message.length() - 1);
		return new ResponseMessage(new ResponseHeader(request, ERespCode.ParamNull, message));
	}

}
