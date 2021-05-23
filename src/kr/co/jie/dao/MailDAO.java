package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.MailDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class MailDAO {
	@Autowired
	SqlSession ss;
	
	public List<MailDTO> showAllMail(MailDTO dto){
		System.out.println(dto.getMailbox_receiver_email());
		List<MailDTO> list = ss.selectList("kr.co.jie.Mail.showAllMail",dto);
		System.out.println("22222222222222222");
		return list;
	}
	
	public void sendMail(MailDTO dto){
		ss.insert("kr.co.jie.Mail.sendMail",dto);
	}
}
