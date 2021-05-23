package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.ScrapDTO;

public interface ScrapDAO {
	public List<ScrapDTO> selectAll(int start, int end, int job_no);

	public void deleteByNo(int scrapNo);

	public int getTotal();
	
	public void insertScrapOne(ScrapDTO dto);
}
