package kr.co.jie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.jie.dao.CompanyDAO;
import kr.co.jie.dao.FriendlistDAO;
import kr.co.jie.dao.JobseekerDAO;
import kr.co.jie.dto.CompanyDTO;
import kr.co.jie.dto.FriendlistDTO;
import kr.co.jie.dto.JobseekerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FriendlistController {
	@Autowired
	JobseekerDAO jobseekerDao;
	
	@Autowired
	CompanyDAO companyDao;
	
	@Autowired
	FriendlistDAO frdao;
	
	// 친구 프로필 페이지로 이동하기
	@RequestMapping(value="jobseekerProfile")
	public String friendProfile(Model model, @RequestParam(value="jobseeker_no")int jobseeker_no) {
		model.addAttribute("dto", jobseekerDao.selectByNo(jobseeker_no));
		
		return "/jobinearth/friendlist/friendProfile";
	}
	
		
	// 친구 목록 첫 페이지
	@RequestMapping(value="friendlist")
	public String searchFriend(Model model, 
			@RequestParam(value="currentPage", defaultValue="1")int currentPage,
			@RequestParam(value="countPerPage", defaultValue="5")int countPerPage,
			@RequestParam(value="searchKeyword", defaultValue="**********")String keyword,
			HttpSession hs) {
		List<JobseekerDTO> jobseekerList = null;
		List<CompanyDTO> companyList = null;
		List<FriendlistDTO> friendList;
		
		int jobseekerTotal = jobseekerDao.getTotal(keyword);
		int companyTotal = companyDao.getTotal(keyword);
		
		model.addAttribute("jobseekerTotal", jobseekerTotal);
		model.addAttribute("companyTotal", companyTotal);
		
		int start = (currentPage - 1) * countPerPage + 1;
		int end = currentPage * countPerPage;
		
		int jobseekerTotalPage = (int)Math.ceil(jobseekerTotal/1.0/countPerPage);
		int companyTotalPage = (int)Math.ceil(companyTotal/1.0/countPerPage);
		
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("countPerPage", countPerPage);
		
		model.addAttribute("jobseekerTotalPage", jobseekerTotalPage);
		model.addAttribute("companyTotalPage", companyTotalPage);
		
		int job_no = (int)hs.getAttribute("job_no");
		
		jobseekerList = jobseekerDao.selectAll(start, end, keyword);
		companyList = companyDao.selectAll(start, end, keyword);
		friendList = frdao.viewAllFriend(job_no);
		
		model.addAttribute("jobseekerList", jobseekerList);
		model.addAttribute("companyList", companyList);
		model.addAttribute("friendlist", friendList);
		
		return "/jobinearth/friendlist/friendlist";
		
		/*@RequestMapping(value="manageFriend") 
		public String friendList() {
			
			return "/jobinearth/friendlist/manageFriend";
		}*/
	}
	
//	친구 추가
	@RequestMapping(value="/addFriend")
	public String addFriend(@RequestParam("friendlist_subno") int friendlist_subno,
							@RequestParam("friendlist_name") String friendlist_name,
							@RequestParam(value="friendlist_email", defaultValue="a@a.a") String friendlist_email,
							HttpSession hs){
		System.out.println(friendlist_subno);
		
		JobseekerDTO jobdto = (JobseekerDTO)hs.getAttribute("jobSession");
		
		System.out.println(jobdto.getJobseeker_no());
		
		FriendlistDTO dto = new FriendlistDTO();
		dto.setJobseeker_no(jobdto.getJobseeker_no());
		dto.setFriendlist_subno(friendlist_subno);
		dto.setFriendlist_name(friendlist_name);
		dto.setFriendlist_email(friendlist_email);
		
		frdao.addFriend(dto);
		
		return "redirect:/friendlist";
	}
	
//	친구 삭제
	@RequestMapping(value="/deleteFriend")
	public String deleteFriend(@RequestParam(value="friendlist_subno") int friendlist_subno) {
		System.out.println("aaaaaaaaaaaaaaaaaaaaaa : " + friendlist_subno);
		frdao.deleteFriend(friendlist_subno);
		System.out.println("bbbbbbbbbbbbbbbbbbbbbb");
		
		return "redirect:/friendlist";
	}
	
	
}
