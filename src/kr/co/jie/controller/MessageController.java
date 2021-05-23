package kr.co.jie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.jie.dao.MailDAO;
import kr.co.jie.dto.CompanyDTO;
import kr.co.jie.dto.JobseekerDTO;
import kr.co.jie.dto.MailDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {
	@Autowired
	MailDAO dao;
	
	@RequestMapping(value="/mailList")
	public String mailList(HttpSession hs, Model model){
		JobseekerDTO jdto = (JobseekerDTO)hs.getAttribute("jobSession");
		CompanyDTO cdto = (CompanyDTO)hs.getAttribute("comSession");
		MailDTO dto = new MailDTO();
		if(jdto!=null){
			dto.setMailbox_receiver_email(jdto.getJobseeker_email());
			List<MailDTO> list = dao.showAllMail(dto);
			model.addAttribute("list",list);
			return "/jobinearth/message/mailList";
		}else if(cdto!=null){
			dto.setMailbox_receiver_email(cdto.getCompany_email());
			List<MailDTO> list = dao.showAllMail(dto);
			model.addAttribute("list",list);
			return "/jobinearth/message/mailList";
		}
		return "redirect:/main";
		
	}
	
	@RequestMapping(value="/writeMessage")
	public String writeMessage(){
		return "/jobinearth/message/messageForm";
	}
	
	@RequestMapping(value="/sendMail")
	public String sendMail(HttpSession hs, @RequestParam("mailbox_title")String title,
			@RequestParam("mailbox_receiver_email")String receiver_email, @RequestParam("mailbox_content")String content){
		JobseekerDTO jdto = (JobseekerDTO)hs.getAttribute("jobSession");
		MailDTO dto = new MailDTO();
		dto.setMailbox_content(content);
		dto.setMailbox_title(title);
		dto.setMailbox_receiver_email(receiver_email);
		dto.setMailbox_sender_name(jdto.getJobseeker_name());
		dto.setMailbox_sender_email(jdto.getJobseeker_email());
		dao.sendMail(dto);
		System.out.println("센드완료");
		return "redirect:/mailList";
	}
	
	
	@RequestMapping(value="/messageList")
	public String messageList(){
		return "/jobinearth/message/messageList";
	}
	
	
	
	
	@RequestMapping(value="/writeMail")
	public String writeMail(){
		return "/jobinearth/message/mailForm";
	}
	
	
	@RequestMapping(value="/sendMessage")
	public String sendMessage(){
		
		return "redirect:/messageList";
	}
	
	
	
}
