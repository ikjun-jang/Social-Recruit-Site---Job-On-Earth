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
		
		// /WEB-INF/uploadPath ���丮�� ������

		// ���� ��ü ������
		HttpSession hs = req.getSession();
		
		ServletContext app = hs.getServletContext();
		
		String filePath = app.getRealPath("/WEB-INF/uploadPath");
		
		System.out.println("������ ����� �������: " + filePath);
		
		String fileName = mf.getOriginalFilename();
		
		// ���� ������ ������ �����ϸ� ���� �̸� ����
		File f = new File(filePath + "/" + fileName);
		
		int count=0;
		
		if(f.exists()) {
			count++;
			// ���� �̸� ����
			// abc.jpg
			String[] filePiece = fileName.split("\\.");
			f = new File(filePath + "/" + filePiece[0] + "(" + count + ")" + "." + filePiece[1]);
		}
		
		// �ӽ� ����ҿ� �����Ǿ� �ִ� ������ �����ϰ��� �ϴ� ��η� ����
		
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
	
	// �����ø����̼��� �������� ������ ����� ����  jsp�� �������Ͽ� ���
	// �̶� ���������� ������ �ʰ� �ٷ� ��½�Ʈ������ ������ ����
	@RequestMapping(value="/download", method=RequestMethod.POST)
	@ResponseBody
	public byte[] down(HttpServletResponse resp, HttpServletRequest req, @RequestParam("fileName")String fileName) throws IOException {
		
		String filePath = 
				req.getSession()
				.getServletContext()
				.getRealPath("/WEB-INF/uploadPath");
		
		File f = new File(filePath+"/"+fileName);
		// ������ byte ���·� ���� ��Ű��
		
		byte[] b = FileCopyUtils.copyToByteArray(f);
		
		// ���������� ���ݺ����� ������ ������ �� �ֵ��� ����� �߰�
		String fn = new String(f.getName().getBytes(), "iso_8859_1");
		
		resp.setHeader("Content-Disposition", "attachment; fileName=\""+fn+"\"");
		
		// ������ ����
		resp.setContentLength(b.length);
		
		// ������ ����
		resp.setContentType("image/jpeg");
		
		return b;
	}
}
