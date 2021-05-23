package kr.co.jie.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jie.dto.FileDTO;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public String form() {
		return "uploadForm";
	}
	
	@RequestMapping(value="/download", method=RequestMethod.GET)
	public String download() {
		return "download";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ModelAndView upload(@ModelAttribute("fileDto")FileDTO dto, HttpServletRequest req) {
		
		MultipartFile mf = dto.getFile();
		
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
		}
		
		return new ModelAndView("download", "fileName", f.getName());
	}
	
	// 웹애플리게이션의 모델층에서 리턴한 결과를 보통  jsp로 포워딩하여 출력
	// 이때 뷰페이지를 통하지 않고 바로 출력스트림으로 보내는 역할
	@RequestMapping(value="/download", method=RequestMethod.POST)
	@ResponseBody
	public byte[] down(HttpServletResponse resp, HttpServletRequest req, @RequestParam("fileName")String fileName) throws IOException {
		
		String filePath = 
				req.getSession()
				.getServletContext()
				.getRealPath("/WEB-INF/uploadPath");
		
		File f = new File(filePath+"/"+fileName);
		// 파일을 byte 형태로 변형 시키기
		
		byte[] b = FileCopyUtils.copyToByteArray(f);
		
		// 브라우저에게 지금보내는 내용을 이해할 수 있도록 헤더를 추가
		String fn = new String(f.getName().getBytes(), "iso_8859_1");
		
		resp.setHeader("Content-Disposition", "attachment; fileName=\""+fn+"\"");
		
		// 파일의 길이
		resp.setContentLength(b.length);
		
		// 파일의 종류
		resp.setContentType("image/jpeg");
		
		return b;
	}
}
