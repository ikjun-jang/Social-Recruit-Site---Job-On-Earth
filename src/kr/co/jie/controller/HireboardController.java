package kr.co.jie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.jie.dao.HireboardDAO;
import kr.co.jie.dto.HireboardDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.SessionScope;

@Controller
public class HireboardController {
	@Autowired
	HireboardDAO dao;

	// 디테일에서 삭제버튼 클릭했을 때
	@RequestMapping(value="/delete")
	public String deleteDetail(@RequestParam("hireboard_no")int hireboard_no) {
		dao.deleteOne(hireboard_no);
		
		return "redirect:/recruitListJob";
	}
	
	// 디테일에서 수정버튼 클릭했을 때
	@RequestMapping(value="/modify")
	public String modifyDetail(@ModelAttribute("dto") HireboardDTO dto, @RequestParam(value="hireboard_no")int hireboard_no, Model model) {
		model.addAttribute("dto", dao.selectByNo(hireboard_no));
		
		return "/jobinearth/hireboard/recruit-modify-list";
	}
	
	// 수정이 ok 되는 부분
	@RequestMapping(value="/modifyOk", method=RequestMethod.POST)
	public String modifyDetailOk(@ModelAttribute("dto") HireboardDTO dto) {
		dao.updateOne(dto);
		
		return "redirect:/recruitListJob";
	}
	
	// 디테일 페이지로 넘어가는 부분
	@RequestMapping(value="/view")
	public String viewDetail(@RequestParam(value="hireboard_no")int hireboard_no, Model model) {
		model.addAttribute("dto", dao.selectByNo(hireboard_no));
		
		return "/jobinearth/hireboard/recruit-list-detail";
	}
	
	// 리스트로 가기
	@RequestMapping(value="/recruitListJob")
	public String list(Model model, 
			@RequestParam(value="currentPage", defaultValue="1")int currentPage,
			@RequestParam(value="countPerPage", defaultValue="4")int countPerPage,
			@RequestParam(value="searchKeyword", defaultValue="")String keyword) {
		
		List<HireboardDTO> list = null;
		
		int total = dao.getTotal(keyword);
		model.addAttribute("total", total);

		// 현재 페이지의 시작번호, 끝번호 구하기
		int start = (currentPage - 1)*countPerPage + 1;
		int end = currentPage * countPerPage;
		
		int totalPage = (int)Math.ceil(total/1.0/countPerPage);
		
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("countPerPage", countPerPage);
		
		model.addAttribute("totalPage", totalPage);
		
		list = dao.selectAll(start, end, keyword);
		
		model.addAttribute("list", list);
		
		// 1번부터 끝까지 다 보여주는게 아니라 앞뒤로 몇개 보여주도록 하기 위해
		// 시작페이지 번호, 끝페이지 번호
		int startPage = currentPage - 5 <= 0 ? 1 : currentPage-5;
		int endPage = startPage + 10 >= totalPage ? totalPage : startPage + 10;
		
		// 이전페이지
		boolean prev = currentPage > 5 ? true : false;
		// 다음페이지
		boolean next = currentPage + 5 > totalPage ? false : true;
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		return "/jobinearth/hireboard/recruit-list-job";
	}
	
	// 채용 공고 글쓰기
	@RequestMapping(value = "/recruitAddList", method=RequestMethod.GET)
	public String addList() {
		
		System.out.println("dao : " + dao);
		return "/jobinearth/hireboard/recruit-add-list";
	}
	
	// 글 쓰고 리스트로 돌아가기 
	@RequestMapping(value="/recruitAddList", method=RequestMethod.POST)
	public String addListOk(@ModelAttribute("dto") HireboardDTO dto, HttpSession session){
		
		System.out.println(session.getAttribute("company_no"));
		
		dto.setCompany_no(Integer.parseInt(session.getAttribute("company_no").toString()));
		
		dao.insertOne(dto);
		return "redirect:/recruitListJob"; 
	}
}
