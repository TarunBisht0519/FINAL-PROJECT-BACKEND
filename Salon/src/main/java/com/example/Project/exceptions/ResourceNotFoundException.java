package com.example.Project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ResourceNotFoundException(String resourseName, String fieldName, Long fieldValue) {
		super(String.format("%s not found with %s: %s", resourseName,fieldName,fieldValue));
		ResourseName = resourseName;
		FieldName = fieldName;
		FieldValue = fieldValue;
	}
	private String ResourseName;
	private String FieldName;
	private Long FieldValue;
	public String getFieldName() {
		return FieldName;
	}
	public String getResourseName() {
		return ResourseName;
	}
	public Long getFieldValue() {
		return FieldValue;
	}

}
