package com.jbk.SpringMVCDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
public class SpringMvcDemoApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringMvcDemoApplication.class, args);
	}

}
