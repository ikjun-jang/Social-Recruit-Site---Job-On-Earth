package kr.co.jie.controller;




import javax.servlet.http.HttpSession;

import kr.co.jie.dao.CommunityOracleDAO;
import kr.co.jie.dto.Cafe_BoardDTO;
import kr.co.jie.dto.Cafe_MemberDTO;
import kr.co.jie.dto.CommunityDTO;
import kr.co.jie.dto.JobseekerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Com_MainController {
	@Autowired
	CommunityOracleDAO dao;
	@Autowired
	CommunityDTO dto;
	@Autowired
	Cafe_MemberDTO dto3;

	@RequestMapping(value = "/com_mainPage")
	public String mainPage(CommunityDTO dto, Model model ,Cafe_MemberDTO dto3, JobseekerDTO dto4, HttpSession session) {
		model.addAttribute("list", dao.selectAll_CafeList(dto));
		/*System.out.println("카페회원수 :"+dao.memberCount(dto3));*/ //삭제함 예정
		/*	model.addAttribute("member" , dao.memberCount(dto3));*/
		
		JobseekerDTO jdto = (JobseekerDTO)session.getAttribute("jobSession");
		String email = jdto.getJobseeker_email();
		model.addAttribute("jemail",email);
		
		model.addAttribute("dto", dao.showID(dto4));
		return "/jobinearth/community/com_cafe_list";
	}

	@RequestMapping(value = "/cafe_guest")
	public String cafe_Sub_Page(
			@RequestParam("cafe_name") String cafe_name,
			Cafe_BoardDTO dto2,
			Model model,
			@RequestParam(value = "cafe_b_no", defaultValue = "0") int cafe_b_no,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "countPerPage", defaultValue = "10") int countPerPage) {
		model.addAttribute("dto2", dto2);
		model.addAttribute("list", dao.selectAll2(dto2));
		/* model.addAttribute("cafe_b_no", cafe_b_no); */
		// model.addAttribute("cafe_name", dto2.getCafe_name());
	
		int allTotal = dao.allTotal();
		model.addAttribute("total", dao.allTotal());
		int oneTotal = dao.oneTotal(dto2);
		model.addAttribute("oneTotal", dao.oneTotal(dto2));
		int start = (currentPage - 1) * countPerPage + 1;
		int end = currentPage * countPerPage;
		int totalPage = (int) Math.ceil(allTotal / 1.0 / countPerPage);
		// 현재 페이지의 시작번호, 끝번호구하기
		/* Math.ceil(3.3)==>4 반올림 */
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("countPerPage", countPerPage);
		model.addAttribute("totalPage", totalPage);
		System.out.println("list_메서드 작동중..");
		// 이전페이지
		boolean prev = currentPage > 5 ? true : false;
		// 다음페이지
		boolean next = currentPage + 5 >= totalPage ? false : true;
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		// 시작 페이지 번호
		int startPage = currentPage - 5 <= 0 ? 1 : currentPage - 5;
		// 끝 페이지 번호
		int endPage = startPage + 10 >= totalPage ? totalPage : startPage + 10;
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("currentPage", currentPage);

		return "/jobinearth/community/com_guest_cafe_Main_board";
	}
	
	@RequestMapping(value="/com_applyMember")
	public String applyMember(@ModelAttribute("dto2") Cafe_BoardDTO dto2, Model model,
							  @RequestParam("cafe_b_no") int cafe_b_no ,
							  Cafe_MemberDTO dto3){
		System.out.println("가입자수 :"+dao.memberCount(dto3));
		model.addAttribute("count", dao.memberCount(dto3)); 
		
		
		int oneTotal = dao.oneTotal(dto2);
		model.addAttribute("oneTotal",dao.oneTotal(dto2));
		model.addAttribute("dto2",dto2);
		
		
		
		return "/jobinearth/community/com_applyForCafeFrom";
	}
	
	@RequestMapping(value="/com_memberOk")
	public String applyMemberOk(Cafe_MemberDTO dto3 , Model model , CommunityDTO dto1,
			@RequestParam("member_count") int member_count){ 
		
		//맴버등록
		dao.insertMember(dto3);
		dto1.setMember_count(dao.memberCount(dto3));    
		
		dao.updateMemberCount(dto1);
		 
		
		
		model.addAttribute("cafe_name", dto3.getCafe_name());
		return "redirect:/cafe";
	}



}
