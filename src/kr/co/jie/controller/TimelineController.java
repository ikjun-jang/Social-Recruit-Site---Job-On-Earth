package kr.co.jie.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.co.jie.dao.TimelineDAO;
import kr.co.jie.dto.JobseekerDTO;
import kr.co.jie.dto.TimelineDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TimelineController {
	@Autowired
	TimelineDAO dao;

	// myTimeline List
	@RequestMapping(value = "/myTimeline")
	public String showMyTimeline(HttpSession hs, Model model) {
		int job_no = (int) hs.getAttribute("job_no");
		TimelineDTO timedto = new TimelineDTO();
		timedto.setJobseeker_no(job_no);
		List<TimelineDTO> list = dao.timelineList(timedto);
		model.addAttribute("list", list);
		return "/jobinearth/timeline/myTimelineList";
	}

	// Timeline WriteOk
	@RequestMapping(value = "/timelineWriteOk")
	public String timelineWriteOk(@RequestParam("contents") String contents,
			HttpSession hs) {
		TimelineDTO timedto = new TimelineDTO();
		JobseekerDTO jobdto = (JobseekerDTO) hs.getAttribute("jobSession");

		timedto.setJobseeker_no(jobdto.getJobseeker_no());
		timedto.setTimeline_content(contents);
		timedto.setTimeline_writer(jobdto.getJobseeker_name());
		dao.timelineWriteOk(timedto);

		return "redirect:/myTimeline";
	}

	// Timeline Modify Form
	@RequestMapping(value = "/myTimelineModify")
	public String timelineModify(@RequestParam("timeline_no") int timeline_no,
			Model model, HttpSession hs) {

		model.addAttribute("timeline_no", timeline_no);
		int job_no = (int) hs.getAttribute("job_no");
		TimelineDTO timedto = new TimelineDTO();
		timedto.setJobseeker_no(job_no);
		List<TimelineDTO> list = dao.timelineList(timedto);
		model.addAttribute("list", list);
		return "/jobinearth/timeline/myTimelineModifyForm";
	}

	// Timeline ModifyOk
	@RequestMapping(value = "/myTimelineModifyOk")
	public String timelineModifyOk(
			@RequestParam("jobseeker_no") int jobseeker_no,
			@RequestParam("timeline_content") String content,
			@RequestParam("timeline_no") int timeline_no) {
		TimelineDTO timedto = new TimelineDTO();
		timedto.setTimeline_content(content);
		timedto.setTimeline_no(timeline_no);
		dao.timelineModifyOk(timedto);
		return "redirect:/myTimeline";
	}
	
	//timeline Delete
	@RequestMapping(value="/myTimelineDelete")
	public String myTimelineDelete(@RequestParam("timeline_no")int timeline_no){
		dao.timelineDelete(timeline_no);
		return "redirect:/myTimeline";
	}
}
