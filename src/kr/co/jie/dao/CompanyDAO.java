package kr.co.jie.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import kr.co.jie.dto.CompanyDTO;
import kr.co.jie.dto.JobseekerDTO;

public class CompanyDAO {
	@Autowired
	SqlSession ss;
	
	public CompanyDTO comLoginOk(CompanyDTO dto) {
		CompanyDTO cdto = ss.selectOne("kr.co.jie.comLoginOk",dto);		
		System.out.println("com login Ok");
		return cdto;
	}

	public void comSignUp(CompanyDTO dto) {
		ss.insert("kr.co.jie.comSignUp",dto);
		System.out.println("com signup ok");
	}
	
	public CompanyDTO selectByNo(int company_no) {
		
		return ss.selectOne("kr.co.jie.company.companySelectByNo", company_no);
	}
	
	// 태영 파트
	public List<CompanyDTO> selectAll(int start, int end, String keyword) {
		StartEnd se = new StartEnd(start, end, keyword);
		
		return ss.selectList("kr.co.jie.company.companySelectByKeyword", se);
	}
	
	public int getTotal(String keyword) {
		
		return ss.selectOne("kr.co.jie.company.getTotal", keyword);
	}
	// 태영 파트
}
