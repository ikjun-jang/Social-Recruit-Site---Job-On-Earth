package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.ScrapDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;



public class ScrapDAOImple implements ScrapDAO {
	@Autowired
	SqlSession ss;

	@Override
	public List<ScrapDTO> selectAll(int start, int end, int job_no) {
		StartEnd se = new StartEnd(start, end, job_no);
		return ss.selectList("kr.co.jie.scrapSelectAll", se);
	}

	@Override
	public void deleteByNo(int scrapNo) {
		ss.delete("kr.co.jie.deleteScrap", scrapNo);
		
	}

	@Override
	public int getTotal() {
		return ss.selectOne("kr.co.jie.getScrapTotal");
	}

	// 인서트
	@Override
	public void insertScrapOne(ScrapDTO dto) {
		ss.insert("kr.co.jie.scrapInsertOne", dto);
	}

}
