package com.mastery.java.task.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;


public enum Gender implements Serializable {
    MALE,
    FEMALE,
	@JsonEnumDefaultValue 
	UNKNOWN; 
	
}


