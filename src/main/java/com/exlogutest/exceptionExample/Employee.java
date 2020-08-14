package com.exlogutest.exceptionExample;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.ToString;

@Data @ToString
@Entity

public class Employee 
{
	@Id
	Integer id;
	String name;
	Integer age;
	String role;
}
