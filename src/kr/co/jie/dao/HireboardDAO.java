package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.HireboardDTO;
import kr.co.jie.dao.StartEnd;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class HireboardDAO {
	@Autowired
	SqlSession ss;
	
	// 전체 몇 개인지
	public int getTotal() {
		return ss.selectOne("kr.co.jie.hireboard.getTotal");
	}
	
	// 전체 목록 보기
	public List<HireboardDTO> selectAll(int start, int end){
		StartEnd se = new StartEnd(start, end);
		
		System.out.println("시작 : " + se.getStart());
		System.out.println("끝 : " + se.getEnd());
		return ss.selectList("kr.co.jie.hireboard.hireboardSelectAll", se);
	}
	
	// 한 개 가져오기
	public HireboardDTO selectByNo(int hireboard_no) {
		
		return ss.selectOne("kr.co.jie.hireboard.hireboardSelectByNo", hireboard_no);
	}
	
	// 등록
	public void insertOne(HireboardDTO dto){
		ss.insert("kr.co.jie.hireboard.hireboardInsertOne", dto);
	}
	
	// 수정
	public void updateOne(HireboardDTO dto){
		ss.update("kr.co.jie.hireboard.hireboardUpdateOne",dto);
	}
	
	// 성진 파트
	// 전체 목록 보기
	public List<HireboardDTO> selectAll(int start, int end, String keyword){
		StartEnd se = new StartEnd(start, end, keyword);
		return ss.selectList("kr.co.jie.hireboard.selectBoard",se);
	}
		
	public int getTotal(String keyword) {
		
		return ss.selectOne("kr.co.jie.hireboard.getTotalHireboard", keyword);
	}
	
	// 목록 삭제
	public void deleteOne(int hireboard_no){
		ss.delete("kr.co.jie.hireboard.hireboardDeleteOne", hireboard_no);
	}



	// 밑에는 아직 미사용
	
	
	public List<HireboardDTO> searchByKeyword(){
		return ss.selectList("hireboardSearchByKeyword");
	}

		
	
}
