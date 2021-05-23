package kr.co.jie.controller;

import javax.servlet.http.HttpSession;

import kr.co.jie.dao.ResumeDAO;
import kr.co.jie.dto.JobseekerDTO;
import kr.co.jie.dto.ResumeDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ResumeController {
	@Autowired
	ResumeDAO dao;
	
	@RequestMapping(value="/resumeList")
	public String resumeList(Model model,
			@RequestParam(value="currentPage", defaultValue="1")int currentPage,
			@RequestParam(value="countPerPage", defaultValue="10")int countPerPage
			) {
		
		int total = dao.getTotal();
		model.addAttribute("total", dao.getTotal());
		model.addAttribute("currentPage", currentPage);
		
		int start = (currentPage-1)*countPerPage+1;
		int end =  currentPage*countPerPage;
		
		int totalPage = (int)Math.ceil(total/1.0/countPerPage); 
		model.addAttribute("totalPage", totalPage);
		
		// 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙호
		int startPage = currentPage-5<=0?1:currentPage-5;
		int endPage = startPage + 10 >= totalPage?totalPage:startPage+10;
		
		boolean prev = currentPage>5?true:false;
		boolean next = currentPage+5>=totalPage?false:true;
		model.addAttribute("prev", prev);
		model.addAttribute("next", next);
		
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("list",  dao.selectAll(start, end));
		
		return "/jobinearth/resume/resumeList";
	}
	
	@RequestMapping(value="/resumeDeleteOk")
	public String resumeDeleteOk(@RequestParam("resumeNo1")int resumeNo1, @RequestParam("resumeNo2")int resumeNo2,
			@RequestParam("resumeNo3")int resumeNo3, @RequestParam("resumeNo4")int resumeNo4,
			@RequestParam("resumeNo5")int resumeNo5, @RequestParam("resumeNo6")int resumeNo6,
			@RequestParam("resumeNo7")int resumeNo7, @RequestParam("resumeNo8")int resumeNo8,
			@RequestParam("resumeNo9")int resumeNo9, @RequestParam("resumeNo10")int resumeNo10) {
		
			if(resumeNo1!=0) dao.deleteByNo(resumeNo1);
			if(resumeNo2!=0) dao.deleteByNo(resumeNo2);
			if(resumeNo3!=0) dao.deleteByNo(resumeNo3);
			if(resumeNo4!=0) dao.deleteByNo(resumeNo4);
			if(resumeNo5!=0) dao.deleteByNo(resumeNo5);
			if(resumeNo6!=0) dao.deleteByNo(resumeNo6);
			if(resumeNo7!=0) dao.deleteByNo(resumeNo7);
			if(resumeNo8!=0) dao.deleteByNo(resumeNo8);
			if(resumeNo9!=0) dao.deleteByNo(resumeNo9);
			if(resumeNo10!=0) dao.deleteByNo(resumeNo10);		
		
		return "redirect:/resumeList";
	}
	
	@RequestMapping(value="/resumeDetail")
	public String resumeDetail(Model model, @RequestParam("resume_no")int resumeNo) {
		
		model.addAttribute("resume", dao.selectResume(resumeNo));
		return "/jobinearth/resume/resumeDetail";
	}
	
	@RequestMapping(value="/resumeWrite")
	public String resumeWrite() {
		return "/jobinearth/resume/resumeWrite";
	}
	
	@RequestMapping(value="/resumeWriteOk", method=RequestMethod.POST)
	public String resumeWriteOk(/*@ModelAttribute("fileDto")FileDTO dto, HttpServletRequest req,*/
			@RequestParam("rNo")int rNo, @RequestParam("rTitle")String rTitle, @RequestParam("jInterested")String jInterested,
			@RequestParam("jWanted")String jWanted, @RequestParam("jName")String jName,
			@RequestParam("rCompanyName")String rCompanyName, @RequestParam("jGender")String jGender,
			@RequestParam("jBday")String jBday, @RequestParam("jTel")String jTel, /*@RequestParam("jImg")MultipartFile multi,*/
			@RequestParam("jCell")String jCell, @RequestParam("jAddr")String jAddr,
			/*@RequestParam("jEmail")String jEmail, */@RequestParam("jStatus")String jStatus,
			@RequestParam("rEduName")String rEduName, @RequestParam("rEduMajor")String rEduMajor,
			@RequestParam("rEduPeriod")String rEduPeriod, @RequestParam("rEduGrad")String rEduGrad,
			@RequestParam("rEduScore")String rEduScore, @RequestParam(value="rCareerName", required=false)String rCareerName,
			@RequestParam("rJobContent")String rJobContent, @RequestParam("rCareerPeriod")String rCareerPeriod,
			@RequestParam("rCvTitle1")String rCvTitle1, @RequestParam("rCvContent1")String rCvContent1,
			@RequestParam("rCvTitle2")String rCvTitle2, @RequestParam("rCvContent2")String rCvContent2,
			@RequestParam("rCvTitle3")String rCvTitle3, @RequestParam("rCvContent3")String rCvContent3,
			@RequestParam("rCvTitle4")String rCvTitle4, @RequestParam("rCvContent4")String rCvContent4,
			@RequestParam("rCvTitle5")String rCvTitle5, @RequestParam("rCvContent5")String rCvContent5
		/*	, HttpSession hs*/) {
		
/*		MultipartFile mf = dto.getFile();
		System.out.println("mf : " + mf);
		// /WEB-INF/uploadPath 디렉토리의 절대경로

		// 세션 객체 얻어오기
		HttpSession hs = req.getSession();
		
		ServletContext app = hs.getServletContext();
		
		String filePath = app.getRealPath("/WEB-INF/uploadPath");
		
		System.out.println("파일이 저장될 실제경로: " + filePath);
		
		String fileName = mf.getOriginalFilename();
		
		// 만약 동일한 파일이 존재하면 파일 이름 변경
		File f = new File(filePath + "/" + fileName);
		
		int count=0;
		
		if(f.exists()) {
			count++;
			// 파일 이름 변경
			// abc.jpg
			String[] filePiece = fileName.split("\\.");
			f = new File(filePath + "/" + filePiece[0] + "(" + count + ")" + "." + filePiece[1]);
		}
		
		// 임시 저장소에 보관되어 있는 파일을 저장하고자 하는 경로로 복사
		
		try {
			mf.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}*/
		//JobseekerDTO jdto = (JobseekerDTO)hs.getAttribute("jobSession");
		//String jemail = jdto.getJobseeker_email();
		ResumeDTO rdto = new ResumeDTO(rNo, rTitle, jName, jGender, jBday, jTel, jCell, jAddr,
				jInterested, jWanted,	"", rCompanyName,	rJobContent, rEduName,	rEduPeriod, rEduMajor,
				rEduGrad, rEduScore,rCvTitle1, rCvTitle2,rCvTitle3, rCvTitle4,	rCvTitle5, rCvContent1,
				rCvContent2, rCvContent3,rCvContent4, rCvContent5,jStatus, rCareerPeriod);
		
		dao.insertOne(rdto);
		
		//return new ModelAndView("download", "fileName", f.getName());
		
		return "redirect:/resumeList";
	}
}
