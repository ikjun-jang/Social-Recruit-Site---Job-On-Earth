package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.ResumeDTO;
import kr.co.jie.dto.ResumeListDTO;

public interface ResumeDAO {
	public List<ResumeListDTO> selectAll(int start, int end);
	public ResumeDTO selectResume(int resumeNo);
	public void deleteByNo(int resumeNo);
	public void insertOne(ResumeDTO dto);
	public int getTotal();
}
