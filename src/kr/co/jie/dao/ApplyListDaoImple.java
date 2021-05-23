
package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.ApplyListDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplyListDaoImple implements ApplyListDAO{

	@Autowired
	SqlSession ss;

	@Override
	public List<ApplyListDTO> selectAll(int start, int end, int job_no) {
		StartEnd se = new StartEnd(start, end, job_no);
		return ss.selectList("kr.co.jie.applyListSelectAll", se);
	}

	@Override
	public void deleteByNo(int applyNo) {
		
		ss.delete("kr.co.jie.deleteApply", applyNo);
	}

	@Override
	public int getTotal() {
		return ss.selectOne("kr.co.jie.getApplyTotal");
	}

	@Override
	public void insertApplyListOne(ApplyListDTO dto) {
		ss.insert("kr.co.jie.applyListInsertOne", dto);
	}

}
