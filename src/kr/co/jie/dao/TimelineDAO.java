package kr.co.jie.dao;

import java.util.List;

import kr.co.jie.dto.TimelineDTO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class TimelineDAO {
	@Autowired
	SqlSession ss;
	
		
	public List<TimelineDTO> timelineList(TimelineDTO dto){
		List<TimelineDTO> list = ss.selectList("kr.co.jie.timeline.myTimelineList",dto);
		return list;
	}
	
	public void timelineWriteOk(TimelineDTO dto){
		ss.insert("kr.co.jie.timeline.myTimelineWrite",dto);
	}
	
	public void timelineModifyOk(TimelineDTO dto){
		ss.update("kr.co.jie.timeline.myTimelineModifyOk",dto);
	}

	public void timelineDelete(int timeline_no) {
		ss.delete("kr.co.jie.timeline.timelineDelete",timeline_no);
	}
}
