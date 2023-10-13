package com.jbk.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kiranacademy.entity.Answer;
import com.kiranacademy.entity.Question;

@Controller
public class QuestionController 
{
	@RequestMapping("next")
	public ModelAndView next(Answer answer,HttpServletRequest request)
	{
		
         HttpSession httpsession=request.getSession();
	
		
		if(request.getParameter("submittedAnswer")!=null)
		{
			HashMap<Integer, Answer> hashmap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
			
			hashmap.put(answer.getQno(), answer);
			
			System.out.println(hashmap);
		}

		Question question=null;
		
		ModelAndView modelAndView = new ModelAndView();
		
		HttpSession ss = request.getSession();
		
		List<Question> listofquestions = (List<Question>) ss.getAttribute("questions");
		
		
		if((Integer)ss.getAttribute("qno")<listofquestions.size()-1)
		{
			ss.setAttribute("qno",(Integer)ss.getAttribute("qno")+1 );
			question=listofquestions.get((Integer)ss.getAttribute("qno"));
			
		}
		
		else
		{
			modelAndView.addObject("message","questions over");
						
			question=listofquestions.get(listofquestions.size()-1);

		}
		

		// get next question answer of current question and display it on browser
		
		int qno=question.getQno();
		
		HashMap<Integer,Answer> hashmap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
		
		Answer answer2=hashmap.get(qno);
		
		
		String previousAnswer="";
		
		
		if(answer2!=null)
		{
			previousAnswer=answer2.getSubmittedAnswer();
			
		}
		
		
		modelAndView.addObject("question",question);
		modelAndView.addObject("previousAnswer",previousAnswer);
		
		
		modelAndView.setViewName("question");
		
	
		return modelAndView;
    	
    }
	
	@RequestMapping("previous")
	public ModelAndView previous(Answer answer,HttpServletRequest request)
	{
        HttpSession httpsession=request.getSession();
	
		
		if(request.getParameter("submittedAnswer")!=null)
		{
			HashMap<Integer, Answer> hashmap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
			
			hashmap.put(answer.getQno(), answer);
			
			System.out.println(hashmap);
		}
		

		Question question=null;
		
		ModelAndView modelAndView = new ModelAndView();
		
		HttpSession ss = request.getSession();
		List<Question> listofquestions = (List<Question>) ss.getAttribute("questions");
		
		if((Integer)ss.getAttribute("qno")>0)
		{
			ss.setAttribute("qno",(Integer)ss.getAttribute("qno")-1 );
			question=listofquestions.get((Integer)ss.getAttribute("qno"));		
		}
		
		else
		{
			question=listofquestions.get(0);
			
			modelAndView.addObject("message","questions over Click Next");
		}
		

		// get previous answer of current question and display it on browser
		
				int qno=question.getQno();
				
				HashMap<Integer,Answer> hashmap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
				
				Answer answer2=hashmap.get(qno);
				
				
				String previousAnswer="";
				
				
				if(answer2!=null)
				{
					previousAnswer=answer2.getSubmittedAnswer();
					
				}
				
				
				modelAndView.addObject("question",question);
				modelAndView.addObject("previousAnswer",previousAnswer);
				
				
				modelAndView.setViewName("question");
				
			
				return modelAndView;
    	
    }
	
	@RequestMapping("endexam")
	public ModelAndView endexam(Answer answer,HttpServletRequest request)
	{
		

		
		ModelAndView modelAndView = new ModelAndView();
		
		HttpSession httpsession=request.getSession();
		
		HashMap<Integer, Answer> hashmap=(HashMap<Integer, Answer>) httpsession.getAttribute("submittedDetails");
		
		if(hashmap==null)
		{

			modelAndView.setViewName("login");
			
			return modelAndView;
		}
		
		
		if(request.getParameter("submittedAnswer")!=null)
		{
			hashmap.put(answer.getQno(), answer);
			
			System.out.println(hashmap);
		}

		Collection<Answer> collection=hashmap.values();
		
		
		for (Answer ele : collection) 
		{
			if(ele.getOriginalAnswer().equals(ele.getSubmittedAnswer()))
			{
				httpsession.setAttribute("score",(Integer)httpsession.getAttribute("score") + 1);
			}
			
		}
		
		modelAndView.addObject("allanswers",collection);
		
		modelAndView.addObject("score",httpsession.getAttribute("score"));
		
		modelAndView.setViewName("score");
		
		httpsession.invalidate();// remove all attributs from session
			
		return modelAndView;
	
	}
}
