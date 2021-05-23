package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.ApplyListDTO;

public interface ApplyListDAO {
	public List<ApplyListDTO> selectAll(int start, int end, int job_no);

	public void deleteByNo(int applyNo);

	public int getTotal();
	
	public void insertApplyListOne(ApplyListDTO dto);
}
