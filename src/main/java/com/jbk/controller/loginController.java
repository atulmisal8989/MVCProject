package com.jbk.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kiranacademy.dao.QuestionDAO;
import com.kiranacademy.entity.Answer;
import com.kiranacademy.entity.Question;
import com.kiranacademy.entity.User;

@Controller
public class loginController 
{
	@Autowired
	SessionFactory factory;
	
	@Autowired
	QuestionDAO dao;

	@RequestMapping("/")
	public String login()
	{
		return "login";  // here login is login.jsp web page
	}

	@RequestMapping("register")
	public String register()
	{
		return "register";  

	}
	
	@RequestMapping("admin")
	public String admin()
	{
		return "questionmanagement"; 
	}

	
	@RequestMapping("saveToDB")
	public ModelAndView saveToDB(User user,HttpServletRequest request) throws Exception, IOException
	{
		Session ss=factory.openSession();
		
		Transaction tx=ss.beginTransaction();
		
		MultipartFile fieldData=user.getImages();
		String filename=fieldData.getOriginalFilename();
		user.setImagepath(filename);  // To set file name path
		// or (for above 3 lines use below one line) //
		//user.setImagepath(user.getImages().getOriginalFilename());
		
		ss.save(user);
		tx.commit();
		
		//To add images into images folder
		File file=new File(request.getServletContext().getRealPath("/images"),filename);
		fieldData.transferTo(file);
		
		ModelAndView mav = new ModelAndView();		
		mav.setViewName("login");	// After registration go back to login page	
		mav.addObject("message","registration successful");	//To see mes on login page	
		return mav;	
	}
	
	@RequestMapping("validate")
	public ModelAndView validate(String username,String password,String subject,HttpServletRequest request)
	{

		ModelAndView modelAndView = new ModelAndView();

		//System.out.println(request.getMethod());

		//System.out.println(username + " " + password);// nikita abc

		Session session=factory.openSession();

		User userFromDB=session.get(User.class,username);

		//userFromDB==> [ username='nikita' password='xyz' emailid='d@jk.com' ] Employee class's object having data from database

		if(userFromDB==null)  //Execute if username is wrong
		{
			modelAndView.setViewName("login");

			modelAndView.addObject("message","username wrong");			
		}

		else
		{
			//execute when both are correct
			if(password.equals(userFromDB.getPassword()))
			{
				modelAndView.setViewName("question");

				modelAndView.addObject("username",username);

				modelAndView.addObject("imagepath",userFromDB.getImagepath());

				modelAndView.addObject("message","login successful");
				
				List<Question> list = dao.getAllQuestions(subject);
				
				Question question = list.get(0);
				
				modelAndView.addObject("question",question);
				
				HttpSession ss = request.getSession();
				
				ss.setAttribute("question", question);
				ss.setAttribute("questions", list);
				ss.setAttribute("username",username);
				ss.setAttribute("imagepath",userFromDB.getImagepath());
				ss.setAttribute("message","login successful");
				ss.setAttribute("qno",0);
				ss.setAttribute("score",0);
				
                HashMap<Integer,Answer>  hashmap=new HashMap<Integer, Answer>();
				
                ss.setAttribute("submittedDetails",hashmap);

			}
			
			
			// execute when password is wrong
			else
			{
				modelAndView.setViewName("login");

				modelAndView.addObject("message","password wrong");	
			}

		}
		return modelAndView;

	}

	
	
}
