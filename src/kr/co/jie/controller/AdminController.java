package kr.co.jie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.co.jie.dao.CommunityDAO;
import kr.co.jie.dao.HireboardDAO;
import kr.co.jie.dao.JobseekerDAO;
import kr.co.jie.dto.CommunityDTO;
import kr.co.jie.dto.HireboardDTO;
import kr.co.jie.dto.JobseekerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	@Autowired
	CommunityDAO cmdao;
	
	@Autowired
	HireboardDAO hbdao;
	
	@Autowired
	JobseekerDAO jsdao;
	
	@RequestMapping(value="/admin")
	public String admin(){
		return "/jobinearth/admin/admin";
	}
	
//	채용공고 전체 출력
	
	@RequestMapping(value="/manageHireboard")
	public String manageHireboard(Model m,  @RequestParam(value="currentPage", defaultValue="1")int currentPage
			, @RequestParam(value="countPerPage", defaultValue="10")int countPerPage, 
			@RequestParam(value="searchKeyword",defaultValue="")String keyword){
		List<HireboardDTO> list=null;
		int total = hbdao.getTotal(keyword);
		m.addAttribute("total",total);
		
		int start = (currentPage - 1)*countPerPage + 1;
		int end = currentPage * countPerPage;
		int totalPage = (int)Math.ceil(total/1.0/countPerPage);
		m.addAttribute("start", start);
		m.addAttribute("end", end);
		m.addAttribute("countPerPage", countPerPage);
		m.addAttribute("totalPage", totalPage);

		list=hbdao.selectAll(start, end, keyword);
		m.addAttribute("hireboardList",list);
		
		// 1번부터 끝까지 다 보여주는게 아니라 앞뒤로 몇개 보여주도록 하기 위해
		// 시작페이지 번호, 끝페이지 번호
		int startPage = currentPage - 5 <= 0 ? 1 : currentPage-5;
		int endPage = startPage + 10 >= totalPage ? totalPage : startPage + 10;
				
		// 이전페이지
		boolean prev = currentPage > 5 ? true : false;
		// 다음페이지
		boolean next = currentPage + 5 > totalPage ? false : true;
			
		m.addAttribute("startPage", startPage);
		m.addAttribute("endPage", endPage);
		m.addAttribute("currentPage", currentPage);
		m.addAttribute("prev", prev);
		m.addAttribute("next", next);
		
		return "/jobinearth/admin/manageHireboard";
	}
	
//	채용공고 삭제
	@RequestMapping(value="/deleteHireboard")
	public String deleteHireboard(HttpServletRequest req) {
		String[] check = req.getParameterValues("selected");
		int[] checked = new int[check.length];
		for(int i=0;i<check.length;i++){
			checked[i] = Integer.parseInt(check[i]);
			hbdao.deleteOne(checked[i]);
		}
		
		return "redirect:/manageHireboard";
	}


//	Jobseeker 전체 출력
	
	@RequestMapping(value="/manageJobseeker")
	public String manageJobseeker(Model m,  @RequestParam(value="currentPage", defaultValue="1")int currentPage
			, @RequestParam(value="countPerPage", defaultValue="10")int countPerPage, 
			@RequestParam(value="searchKeyword",defaultValue="")String keyword){
		List<JobseekerDTO> list=null;
		int total = jsdao.getTotalJobseeker(keyword);
		m.addAttribute("total",total);
		
		int start = (currentPage - 1)*countPerPage + 1;
		int end = currentPage * countPerPage;
		int totalPage = (int)Math.ceil(total/1.0/countPerPage);
		m.addAttribute("start", start);
		m.addAttribute("end", end);
		m.addAttribute("countPerPage", countPerPage);
		m.addAttribute("totalPage", totalPage);

		list=jsdao.selectAllJobseeker(start, end, keyword);
		m.addAttribute("jobseekerList",list);
		
		// 1번부터 끝까지 다 보여주는게 아니라 앞뒤로 몇개 보여주도록 하기 위해
		// 시작페이지 번호, 끝페이지 번호
		int startPage = currentPage - 5 <= 0 ? 1 : currentPage-5;
		int endPage = startPage + 10 >= totalPage ? totalPage : startPage + 10;
				
		// 이전페이지
		boolean prev = currentPage > 5 ? true : false;
		// 다음페이지
		boolean next = currentPage + 5 > totalPage ? false : true;
			
		m.addAttribute("startPage", startPage);
		m.addAttribute("endPage", endPage);
		m.addAttribute("currentPage", currentPage);
		m.addAttribute("prev", prev);
		m.addAttribute("next", next);
		
		return "/jobinearth/admin/manageJobseeker";
	}
	
//	Jobseeker 삭제
	@RequestMapping(value="/deleteJobseeker")
	public String deleteJobseeker(HttpServletRequest req) {
		String[] check = req.getParameterValues("selected");
		int[] checked = new int[check.length];
		for(int i=0;i<check.length;i++){
			checked[i] = Integer.parseInt(check[i]);
			jsdao.deleteOne(checked[i]);
		}
		
		return "redirect:/manageJobseeker";
	}

	
//	Community 전체 출력
	
	@RequestMapping(value="/manageCommunity")
	public String manageCommunity(Model m,  @RequestParam(value="currentPage", defaultValue="1")int currentPage
			, @RequestParam(value="countPerPage", defaultValue="10")int countPerPage, 
			@RequestParam(value="searchKeyword",defaultValue="")String keyword){
		List<CommunityDTO> list=null;
		int total = cmdao.getTotal(keyword);
		m.addAttribute("total",total);
		
		int start = (currentPage - 1)*countPerPage + 1;
		int end = currentPage * countPerPage;
		int totalPage = (int)Math.ceil(total/1.0/countPerPage);
		m.addAttribute("start", start);
		m.addAttribute("end", end);
		m.addAttribute("countPerPage", countPerPage);
		m.addAttribute("totalPage", totalPage);

		list=cmdao.selectAll(start, end, keyword);
		m.addAttribute("communityList",list);
		
		// 1번부터 끝까지 다 보여주는게 아니라 앞뒤로 몇개 보여주도록 하기 위해
		// 시작페이지 번호, 끝페이지 번호
		int startPage = currentPage - 5 <= 0 ? 1 : currentPage-5;
		int endPage = startPage + 10 >= totalPage ? totalPage : startPage + 10;
				
		// 이전페이지
		boolean prev = currentPage > 5 ? true : false;
		// 다음페이지
		boolean next = currentPage + 5 > totalPage ? false : true;
			
		m.addAttribute("startPage", startPage);
		m.addAttribute("endPage", endPage);
		m.addAttribute("currentPage", currentPage);
		m.addAttribute("prev", prev);
		m.addAttribute("next", next);
		
		return "/jobinearth/admin/manageCommunity";
	}
	
//	Community 삭제
	@RequestMapping(value="/deleteCommunity")
	public String deleteCommunity(HttpServletRequest req) {
		String[] check = req.getParameterValues("selected");
		for(int i=0;i<check.length;i++){
			cmdao.deleteOne(check[i]);
		}
		
		return "redirect:/manageCommunity";
	}
	
		
}
