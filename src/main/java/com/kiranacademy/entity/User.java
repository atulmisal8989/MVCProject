package com.kiranacademy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class User 
{
	@Id
	public String username;
	public String password;
	public long mobno;
	public String emailid;	
	public String imagepath;  //Saving name 0f image
    public transient MultipartFile images;//MultipartFile object has uploaded image
	
	
	public String getImagepath() 
	{
		return imagepath;
	}
	public void setImagepath(String imagepath) 
	{
		this.imagepath = imagepath;
	}
	public MultipartFile getImages() 
	{
		return images;
	}
	public void setImages(MultipartFile images) 
	{
		this.images = images;
	}
	
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username) 
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public long getMobno() 
	{
		return mobno;
	}
	public void setMobno(long mobno) 
	{
		this.mobno = mobno;
	}
	public String getEmailid()
	{
		return emailid;
	}
	public void setEmailid(String emailid) 
	{
		this.emailid = emailid;
	}
	
	@Override
	public String toString() 
	 {
		return "User [username=" + username + ", password=" + password + ", mobno=" + mobno + ", emailid=" + emailid
				+ "]";
	}
	
	
	
}
