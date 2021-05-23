package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.ResumeDTO;
import kr.co.jie.dto.ResumeListDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;



public class ResumeDaoImple implements ResumeDAO {

	@Autowired
	SqlSession ss;
	
	@Override
	public List<ResumeListDTO> selectAll(int start, int end) {
		StartEnd se = new StartEnd(start, end);
		return ss.selectList("kr.co.jie.resumeSelectAll", se);
	}

	@Override
	public void deleteByNo(int resumeNo) {
		ss.delete("kr.co.jie.deleteResume", resumeNo);
		
	}

	@Override
	public int getTotal() {
		return ss.selectOne("kr.co.jie.getResumeTotal");
	}

	@Override
	public ResumeDTO selectResume(int resumeNo) {
		return ss.selectOne("kr.co.jie.selectResume", resumeNo);
	}

	@Override
	public void insertOne(ResumeDTO dto) {
		ss.insert("resumeInsertOne1", dto);
		ss.insert("resumeInsertOne2", dto);
		ss.insert("resumeInsertOne3", dto);
		ss.insert("resumeInsertOne4", dto);
		ss.update("jobseekerUpdate", dto);
	}

}
