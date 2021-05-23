package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.CommunityDTO;
import kr.co.jie.dto.JobseekerDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class CommunityDAO {
	@Autowired
	SqlSession ss;
	
// 전체 목록 보기
	public List<CommunityDTO> selectAll(int start, int end, String keyword){
		StartEnd se = new StartEnd(start, end, keyword);
		return ss.selectList("kr.co.jie.community.selectCommunity",se);
	}
		
	public int getTotal(String keyword) {
		
		return ss.selectOne("kr.co.jie.community.getTotal", keyword);
	}
	
	// 목록 삭제
	public void deleteOne(String cafe_name){
		ss.delete("kr.co.jie.community.communityDeleteOne", cafe_name);
	}
	
}
