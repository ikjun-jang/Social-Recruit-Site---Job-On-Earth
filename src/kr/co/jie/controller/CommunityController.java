package kr.co.jie.controller;




import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.co.jie.dao.CommunityOracleDAO;
import kr.co.jie.dto.Cafe_BoardDTO;
import kr.co.jie.dto.CommunityDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CommunityController {
	@Autowired
	CommunityOracleDAO dao;
	@Autowired
	Cafe_BoardDTO dto;
	
	//단순 페이지 이동
	@RequestMapping(value ="/community")
	public String buttonPage() { // 버튼 페이지로 이동
		return "button1";
	}
	//입력폼
	@RequestMapping(value = "/com_form")
	public String insertForm(Model model ,Cafe_BoardDTO dto2) {// 카페만들기 입력폼으로 이동
		model.addAttribute("cafe_name", dto2.getCafe_name());
		return "/jobinearth/community/com_apply_Form";
	}

	//게시판 사용구
	@RequestMapping(value = "/com_board", method=RequestMethod.POST)
	// 입력완료_했을때 이동 ==> 게시판으로
	public String makeCafe(CommunityDTO dto, Cafe_BoardDTO dto2,
			Model model,@RequestParam("cafe_name") String cafe_name, @RequestParam("cafe_main_img") MultipartFile cafe_main_img, HttpServletRequest req) { 
		//시작과 함께 값넣기(카페이름을 계속 물고 있어야하기때문에 리스트만 뽑아)
		//기본구문//
		
		System.out.println(cafe_main_img.getName());
		
		// ASDF Start
		MultipartFile mf = cafe_main_img;
		
		// /WEB-INF/uploadPath 디렉토리의 절대 경로
		
		// 현재 요청에서 세션 객체를 얻어오고.
		HttpSession hs = req.getSession();
		
		// 세션으로부터 지금 동작하고 있는 서블릿 환경 객체를 얻어옴. 
		ServletContext app = hs.getServletContext();
		
		// 서블릿 환경 객체로부터 직접 알고 있는 디렉토리 경로를 filePath로 얻어옴.
		String filePath = app.getRealPath("/uploadPath");
		
		// 경로가 잘 잡히는지 테스트
		System.out.println("파일이 저장될 실제 경로 : " + filePath);
		
		// 파일 이름 : 업로드할 때 주었던 파일 이름을 fileName으로 가져옴 
		String fileName = mf.getOriginalFilename();
		
		// 파일이 저장될 디렉토리 + / + 파일의 이름 => 파일의 절대 경로가 됨.
		File f = new File(filePath +"/"+fileName);
	    
		try {
			mf.transferTo(f);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ASDF End
		dto.setCafe_img("uploadPath/" + fileName);
		dao.insertCafe(dto);
		dao.insertCafe_first(dto2);
		model.addAttribute("cafe_name", dto2.getCafe_name());
		return "redirect:/cafe";
	}
	//**************카페 메인 페이지**************
		@RequestMapping(value="/cafe")
		public String cafe_MainPage( 
				@RequestParam("cafe_name") String cafe_name, 
				Cafe_BoardDTO dto2 , Model model,
				@RequestParam(value="cafe_b_no" ,defaultValue="0") int cafe_b_no,
				@RequestParam(value="currentPage",defaultValue="1" ) int currentPage,
				@RequestParam(value="countPerPage", defaultValue="10") int countPerPage){
			 
			
			
			model.addAttribute("dto2",dto2);
			model.addAttribute("list", dao.selectAll2(dto2));
			
			/*model.addAttribute("cafe_b_no", cafe_b_no);*/
			//model.addAttribute("cafe_name", dto2.getCafe_name());
			
		
			int allTotal = dao.allTotal();
			model.addAttribute("total",dao.allTotal());
			int oneTotal = dao.oneTotal(dto2);
			model.addAttribute("oneTotal",dao.oneTotal(dto2));

			int start= (currentPage-1)*countPerPage+1;
			int end= currentPage*countPerPage;
			int totalPage = (int)Math.ceil(allTotal/1.0/countPerPage);
			
			
			
			
		
			//현재 페이지의 시작번호, 끝번호구하기
			/*Math.ceil(3.3)==>4 반올림*/
			model.addAttribute("start", start);
			model.addAttribute("end", end);
			model.addAttribute("countPerPage", countPerPage);
			model.addAttribute("totalPage",totalPage);
			System.out.println("list_메서드 작동중..");
		
			//이전페이지
			boolean prev = currentPage>5?true:false;
			//다음페이지
			boolean next = currentPage+5>=totalPage?false:true;
			model.addAttribute("prev",prev);
			model.addAttribute("next",next); 
			//시작 페이지 번호
			int startPage = currentPage-5<=0?1:currentPage-5;
			//끝 페이지 번호
			int endPage = startPage+10>=totalPage?totalPage:startPage+10;
			model.addAttribute("startPage",startPage);
			model.addAttribute("endPage",endPage);
			model.addAttribute("currentPage",currentPage);
			
			
			
			
			return "/jobinearth/community/com_memer_cafe_Main_board";
		}
		//입력폼
		@RequestMapping(value = "/com_write")
		public String writeForm(
				@RequestParam("cafe_name") String cafe_name ,
				@RequestParam("cafe_b_no") int cafe_b_no,
				@ModelAttribute("dto2") Cafe_BoardDTO dto2, Model model) {
			
			
			
		
			int oneTotal = dao.oneTotal(dto2);
			model.addAttribute("oneTotal",dao.oneTotal(dto2));
			model.addAttribute("dto2",dto2);
			return "/jobinearth/community/com_writeForm";
		}
		//글쓰기==>다시 페이지
		@RequestMapping(value = "/com_writeOk")
		public String wirteOk(
				@RequestParam("cafe_name") String cafe_name ,
				@RequestParam("cafe_b_no") int cafe_b_no ,
				Cafe_BoardDTO dto2, Model model) {
			dao.insertOne(dto2);
			model.addAttribute("cafe_b_no", dto2.getCafe_b_no());
			model.addAttribute("cafe_name", dto2.getCafe_name());
			System.out.println("dto2.getCafe_name(): "+dto2.getCafe_name());
			return "redirect:/cafe";
		}
		
		
		@RequestMapping(value="/com_view")
		public String detail(@RequestParam("b_no") int bno, Cafe_BoardDTO dto2, Model model){
			model.addAttribute("dto2", dao.selectOne(bno));
			return "/jobinearth/community/com_detail";
		}
		
	/*	@RequestMapping(value="/list")
		public String list(Cafe_BoardDTO dto2, Model model ,@RequestParam("cafe_name") String cafe_name ) {
			model.addAttribute("dto2", dto2);
			model.addAttribute("list", dao.selectAll(dto2));
			return "cafe_Main_board";
		}*/
		
		@RequestMapping(value="/com_delete")
		public String delete(@RequestParam("b_no") int bno, Cafe_BoardDTO dto2, Model model ){
			dao.deleteOne(bno);
			model.addAttribute("cafe_name", dto2.getCafe_name());
			return "redirect:/cafe";
		}
		@RequestMapping(value="/com_modify")
		public String update(Cafe_BoardDTO dto2, Model model ,@RequestParam("b_no") int bno){
			model.addAttribute("dto2", dto2);
			model.addAttribute("dto2", dao.selectOne(bno));
			return "/jobinearth/community/com_modifying";
		}
		@RequestMapping(value="/com_modifyOk")
		public String updateOk(@RequestParam("cafe_name") String cafe_name , Cafe_BoardDTO dto2, Model model){
			dao.updateOne(dto2);
			model.addAttribute("cafe_name", dto2.getCafe_name());
			return "redirect:/cafe";
		}
		@RequestMapping(value="/com_raiseHit")
		public String updateRecom(@RequestParam("b_no") int bno,Cafe_BoardDTO dto2, Model model){
			dao.updateRecom(bno);
			model.addAttribute("cafe_name", dto2.getCafe_name());
			return "redirect:/cafe";
		}
	

}
