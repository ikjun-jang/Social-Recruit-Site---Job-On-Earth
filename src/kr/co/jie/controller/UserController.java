package kr.co.jie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.jie.dao.ApplyListDAO;
import kr.co.jie.dao.CompanyDAO;
import kr.co.jie.dao.JobseekerDAO;
import kr.co.jie.dao.ScrapDAO;
import kr.co.jie.dto.ApplyListDTO;
import kr.co.jie.dto.CompanyDTO;
import kr.co.jie.dto.JobseekerDTO;
import kr.co.jie.dto.ScrapDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
	@Autowired
	ApplyListDAO aldao;

	@Autowired
	ScrapDAO scrapdao;

	@Autowired
	JobseekerDAO jobdao;
	@Autowired
	CompanyDAO comdao;

	// home menu
	@RequestMapping(value = "/home")
	public String home(HttpSession hs, HttpServletRequest req) {
		hs = req.getSession();
		if (hs.getAttribute("jobSession") != null) {
			return "redirect:/main";
		} else if (hs.getAttribute("conSession") != null) {
			return "redirect:/main";
		}
		return "redirect:/index";
	}

	// index
	@RequestMapping(value = "/index")
	public String showIndex() {
		return "/jobinearth/index";
	}

	@RequestMapping(value = "/main")
	public String showMain() {
		return "/jobinearth/main";
	}

	// sign-up(join)
	@RequestMapping(value = "/signUp")
	public String signUp() {
		return "/jobinearth/common/signUp";
	}

	// sign-up process
	@RequestMapping(value = "/signUpOk")
	public String signUpOk(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("repassword") String repassword,
			@RequestParam("name") String name,
			@RequestParam("member_type") String member_type) {

		if (email.equals("") || password.equals("") || repassword.equals("")
				|| name.equals("")) {
			return "redirect:/signUp";
		} else {
			if (member_type.equals("job")) {
				JobseekerDTO jdto = new JobseekerDTO();
				jdto.setJobseeker_email(email);
				jdto.setJobseeker_pw(password);
				jdto.setJobseeker_name(name);
				jdto.setMember_type(member_type);
				jobdao.signUpOk(jdto);
				return "redirect:/index";
			} else if (member_type.equals("com")) {
				CompanyDTO cdto = new CompanyDTO();
				cdto.setCompany_email(email);
				cdto.setCompany_pw(password);
				cdto.setCompany_name(name);
				cdto.setMember_type(member_type);
				comdao.comSignUp(cdto);
				return "redirect:/index";
			} else {
				return "redirect:/signUp";
			}
		}
	}

	// login -> main
	@RequestMapping(value = "/loginOk")
	public String mainPage(@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("member_type") String member_type,
			HttpServletRequest req) {

		HttpSession hs = req.getSession();

		if (email.equals("") || password.equals("")) {
			return "redirect:/index";
		} else {
			if (member_type.equals("job")) {
				JobseekerDTO jdto = new JobseekerDTO();
				jdto.setJobseeker_email(email);
				jdto.setJobseeker_pw(password);
				jdto.setMember_type(member_type);
				JobseekerDTO jdto1 = jobdao.loginOk(jdto);
				if (jdto1 != null) {
					System.out.println(jdto1.getMember_type());
					if (jdto1.getMember_type().equals("job")) {
						hs.setAttribute("job_no", jdto1.getJobseeker_no());
						hs.setAttribute("jobSession", jdto1);
						return "redirect:/main";
					} else if (jdto1.getMember_type().equals("admin")) {
						return "redirect:/admin";
					} else {
						return "redirect:/index";
					}
				} else {
				}
			} else if (member_type.equals("com")) {
				CompanyDTO cdto = new CompanyDTO();
				cdto.setCompany_email(email);
				cdto.setCompany_pw(password);
				System.out.println("?????????????");
				CompanyDTO cdto1 = comdao.comLoginOk(cdto);
				System.out.println("gggggggggggg");
				if (cdto1 != null) {
					hs.setAttribute("company_no", cdto1.getCompany_no());
					hs.setAttribute("comSession", cdto1);
					return "redirect:/main";
				} else {
					return "redirect:/index";
				}
			} else {
				return "redirect:/index";
			}
		}
		return "redirect:/index";
	}

	// logout
	@RequestMapping(value = "/logout")
	public String logout(HttpSession hs) {
		if (hs != null) {
			hs.invalidate();
			return "redirect:/index";
		} else {
			return "redirect:/index";
		}
	}

	//profile
	@RequestMapping(value = "/profile")
	public String profile(HttpSession hs, Model model) {
		JobseekerDTO jdto = (JobseekerDTO)hs.getAttribute("jobSession");
		CompanyDTO cdto = (CompanyDTO)hs.getAttribute("comSession");
		if(jdto!=null){
			JobseekerDTO jdto1 = jobdao.selectByNo(jdto.getJobseeker_no());
			model.addAttribute("jobInfo",jdto1);
			return "/jobinearth/jobseekerProfile";
		}else if(cdto!=null){
			CompanyDTO cdto1 = comdao.selectByNo(cdto.getCompany_no());
			model.addAttribute("comInfo",cdto1);
			return "/jobinearth/companyProfile";
		}
		return "redirect:/main";
	}
	
	//Jobseeker profile Modify
	@RequestMapping(value="/jobInfoModify")
	public String jobInfoModify(@RequestParam("name")String name, @RequestParam("gender")String gender,
			@RequestParam("bday")String bday, @RequestParam("tel")String tel, @RequestParam("cell")String cell,
			@RequestParam("email")String email, @RequestParam("addr")String addr, 
			@RequestParam("interested")String interested, @RequestParam("wanted")String wanted, HttpSession hs){
		
		JobseekerDTO jdto = new JobseekerDTO();
		jdto.setJobseeker_no((int)hs.getAttribute("job_no"));
		jdto.setJobseeker_name(name);
		jdto.setJobseeker_gender(gender);
		jdto.setJobseeker_bday(bday);
		jdto.setJobseeker_tel(tel);
		jdto.setJobseeker_cell(cell);
		jdto.setJobseeker_email(email);
		jdto.setJobseeker_addr(addr);
		jdto.setJobseeker_interested(interested);
		jdto.setJobseeker_wanted(wanted);
		System.out.println(jdto.getJobseeker_addr());
		
		jobdao.modifyJobInfo(jdto);
		
		return "redirect:/profile";
	}

	@RequestMapping(value = "/applyList")
	public String applyList(
			Model model,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "countPerPage", defaultValue = "10") int countPerPage,
			HttpSession session) {

		int total = aldao.getTotal();
		model.addAttribute("total", aldao.getTotal());
		model.addAttribute("currentPage", currentPage);

		int start = (currentPage - 1) * countPerPage + 1;
		int end = currentPage * countPerPage;

		int totalPage = (int) Math.ceil(total / 1.0 / countPerPage);
		model.addAttribute("totalPage", totalPage);

		// 시작 페이지 번호
		int startPage = currentPage - 5 <= 0 ? 1 : currentPage - 5;
		int endPage = startPage + 10 >= totalPage ? totalPage : startPage + 10;

		boolean prev = currentPage > 5 ? true : false;
		boolean next = currentPage + 5 >= totalPage ? false : true;
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		int job_no = (int)session.getAttribute("job_no");
		model.addAttribute("list", aldao.selectAll(start, end, job_no));

		return "/jobinearth/applyList/applyList";
	}

	@RequestMapping(value = "/applyDeleteOk")
	public String applyDeleteOk(@RequestParam("applyNo1") int applyNo1,
			@RequestParam("applyNo2") int applyNo2,
			@RequestParam("applyNo3") int applyNo3,
			@RequestParam("applyNo4") int applyNo4,
			@RequestParam("applyNo5") int applyNo5,
			@RequestParam("applyNo6") int applyNo6,
			@RequestParam("applyNo7") int applyNo7,
			@RequestParam("applyNo8") int applyNo8,
			@RequestParam("applyNo9") int applyNo9,
			@RequestParam("applyNo10") int applyNo10) {

		if (applyNo1 != 0)
			aldao.deleteByNo(applyNo1);
		if (applyNo2 != 0)
			aldao.deleteByNo(applyNo2);
		if (applyNo3 != 0)
			aldao.deleteByNo(applyNo3);
		if (applyNo4 != 0)
			aldao.deleteByNo(applyNo4);
		if (applyNo5 != 0)
			aldao.deleteByNo(applyNo5);
		if (applyNo6 != 0)
			aldao.deleteByNo(applyNo6);
		if (applyNo7 != 0)
			aldao.deleteByNo(applyNo7);
		if (applyNo8 != 0)
			aldao.deleteByNo(applyNo8);
		if (applyNo9 != 0)
			aldao.deleteByNo(applyNo9);
		if (applyNo10 != 0)
			aldao.deleteByNo(applyNo10);

		return "redirect:/applyList";
	}

	// 스크랩 부분
	@RequestMapping(value = "/scrapOk")
	public String scrapOk(@ModelAttribute("dto") ScrapDTO dto,
			@RequestParam(value = "hireboard_no") int hireboard_no,
			HttpSession session) {

		dto.setHireboard_no(hireboard_no);
		dto.setJobseeker_no(Integer.parseInt(session.getAttribute("job_no")
				.toString()));

		scrapdao.insertScrapOne(dto);

		return "redirect:/scrapPosition";
	}

	
	// 지원목록 부분
	@RequestMapping(value = "/applyOk")
	public String applyOk(
			@ModelAttribute("dt") ApplyListDTO dto,
			@RequestParam(value="hireboard_no")int hireboard_no,
			@RequestParam(value="company_no")int company_no,
			HttpSession session) {
		
		dto.setCompany_no(company_no);
		dto.setHireboard_no(hireboard_no);
		dto.setJobseeker_no(Integer.parseInt(session.getAttribute("job_no").toString()));
		
		aldao.insertApplyListOne(dto);
		
		return "redirect:/applyList";
	}
	
	@RequestMapping(value = "scrapPosition")
	public String scrapPosition(
			Model model,
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
			@RequestParam(value = "countPerPage", defaultValue = "10") int countPerPage,
			HttpSession session) {

		int total = scrapdao.getTotal();
		model.addAttribute("total", scrapdao.getTotal());
		model.addAttribute("currentPage", currentPage);

		int start = (currentPage - 1) * countPerPage + 1;
		int end = currentPage * countPerPage;

		int totalPage = (int) Math.ceil(total / 1.0 / countPerPage);
		model.addAttribute("totalPage", totalPage);

		// 시작 페이지 번호
		int startPage = currentPage - 5 <= 0 ? 1 : currentPage - 5;
		int endPage = startPage + 10 >= totalPage ? totalPage : startPage + 10;

		boolean prev = currentPage > 5 ? true : false;
		boolean next = currentPage + 5 >= totalPage ? false : true;
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		int job_no = (int)session.getAttribute("job_no");
		
		model.addAttribute("list", scrapdao.selectAll(start, end, job_no));

		return "/jobinearth/scrapPosition/scrapPosition";
	}

	@RequestMapping(value = "/scrapDeleteOk")
	public String scrapDeleteOk(@RequestParam("scrapNo1") int scrapNo1,
			@RequestParam("scrapNo2") int scrapNo2,
			@RequestParam("scrapNo3") int scrapNo3,
			@RequestParam("scrapNo4") int scrapNo4,
			@RequestParam("scrapNo5") int scrapNo5,
			@RequestParam("scrapNo6") int scrapNo6,
			@RequestParam("scrapNo7") int scrapNo7,
			@RequestParam("scrapNo8") int scrapNo8,
			@RequestParam("scrapNo9") int scrapNo9,
			@RequestParam("scrapNo10") int scrapNo10) {

		if (scrapNo1 != 0)
			scrapdao.deleteByNo(scrapNo1);
		if (scrapNo2 != 0)
			scrapdao.deleteByNo(scrapNo2);
		if (scrapNo3 != 0)
			scrapdao.deleteByNo(scrapNo3);
		if (scrapNo4 != 0)
			scrapdao.deleteByNo(scrapNo4);
		if (scrapNo5 != 0)
			scrapdao.deleteByNo(scrapNo5);
		if (scrapNo6 != 0)
			scrapdao.deleteByNo(scrapNo6);
		if (scrapNo7 != 0)
			scrapdao.deleteByNo(scrapNo7);
		if (scrapNo8 != 0)
			scrapdao.deleteByNo(scrapNo8);
		if (scrapNo9 != 0)
			scrapdao.deleteByNo(scrapNo9);
		if (scrapNo10 != 0)
			scrapdao.deleteByNo(scrapNo10);

		return "redirect:/scrapPosition";
	}

}
