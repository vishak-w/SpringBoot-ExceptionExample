package com.exlogutest.exceptionExample;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data 
public class Error 
{
	String message;
	List<String> details=new ArrayList<String>();
	public Error(String message,List<String> details)
	{
		this.message=message;
		this.details=details;
	}	
}
