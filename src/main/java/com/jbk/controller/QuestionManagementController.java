package com.jbk.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kiranacademy.entity.Question;



@Controller
public class QuestionManagementController 
{

	@Autowired
	SessionFactory factory;

	@RequestMapping("addQuestion")
	public ModelAndView addQuestion(Question questions)
	{
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(questions);
		
		tx.commit(); // model-data which should be displayed on jsp page
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("questionmanagement");
		
		modelAndView.addObject("message","question addded");
		
		return modelAndView;
		
	}
	
	@RequestMapping("updateQuestion")
	public ModelAndView updateQuestion(Question questions)
	{
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query<Question> query=session.createQuery("update Question set op1=:op1,op2=:op2,op3=:op3,op4=:op4,answer=:answer where qno=:qno and subject=:subject");
		
		query.setParameter("qno",questions.getQno());
		query.setParameter("subject",questions.getSubject());
		query.setParameter("op1",questions.getOp1());
		query.setParameter("op2",questions.getOp2());
		query.setParameter("op3",questions.getOp3());
		query.setParameter("op4",questions.getOp4());
		query.setParameter("answer",questions.getAnswer());
		
		query.executeUpdate();
		
		tx.commit(); // model-data which should be displayed on jsp page
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("questionmanagement");
		
		modelAndView.addObject("message","question updated");
		
		return modelAndView;
		
	}
	
	@RequestMapping("viewQuestion")
	public ModelAndView viewQuestion(Integer qno,String subject)
	{
		Session session = factory.openSession();
		
		Query<Question> query=session.createQuery("from Question where qno=:qno and subject=:subject");
		query.setParameter("qno",qno);
		query.setParameter("subject",subject);
		
		List<Question> list=query.list();
		
		Question question=list.get(0);
		
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("questionmanagement");
		modelAndView.addObject("question",question);
		modelAndView.addObject("message","question view");
		
		return modelAndView;
	}
	
	
	
// delete from questions where qno=1 and subject='maths'
	
	@RequestMapping("deleteQuestion")
	public ModelAndView deleteQuestion(Question questions)
	{
		Session session = factory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query<Question> query=session.createQuery("delete from Question  where qno=:qno and subject=:subject");
		
		query.setParameter("qno",questions.getQno());
		query.setParameter("subject",questions.getSubject());
		
		query.executeUpdate();
		
		tx.commit();
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("questionmanagement");
		
		modelAndView.addObject("message","question deleted");
		
		return modelAndView;
		
		
	}
	
}
