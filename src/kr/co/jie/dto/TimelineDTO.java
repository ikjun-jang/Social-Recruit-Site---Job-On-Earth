package kr.co.jie.dto;

public class TimelineDTO {
	private int timeline_no;
	private int jobseeker_no;
	private String timeline_writer;
	private String timeline_content;
	private String timeline_date;
	private String timeline_image;
	private String timeline_authority;
	private int timeline_recommend;
	private int hireboard_no;
	private int timeline_comment_no;
	
	public TimelineDTO(){}
	
	
	public int getTimeline_no() {
		return timeline_no;
	}
	public void setTimeline_no(int timeline_no) {
		this.timeline_no = timeline_no;
	}
	public int getJobseeker_no() {
		return jobseeker_no;
	}
	public void setJobseeker_no(int jobseeker_no) {
		this.jobseeker_no = jobseeker_no;
	}
	public String getTimeline_writer() {
		return timeline_writer;
	}
	public void setTimeline_writer(String timeline_writer) {
		this.timeline_writer = timeline_writer;
	}
	public String getTimeline_content() {
		return timeline_content;
	}
	public void setTimeline_content(String timeline_content) {
		this.timeline_content = timeline_content;
	}
	public String getTimeline_date() {
		return timeline_date;
	}
	public void setTimeline_date(String timeline_date) {
		this.timeline_date = timeline_date;
	}
	public String getTimeline_image() {
		return timeline_image;
	}
	public void setTimeline_image(String timeline_image) {
		this.timeline_image = timeline_image;
	}
	public String getTimeline_authority() {
		return timeline_authority;
	}
	public void setTimeline_authority(String timeline_authority) {
		this.timeline_authority = timeline_authority;
	}
	public int getTimeline_recommend() {
		return timeline_recommend;
	}
	public void setTimeline_recommend(int timeline_recommend) {
		this.timeline_recommend = timeline_recommend;
	}
	public int getHireboard_no() {
		return hireboard_no;
	}
	public void setHireboard_no(int hireboard_no) {
		this.hireboard_no = hireboard_no;
	}
	public int getTimeline_comment_no() {
		return timeline_comment_no;
	}
	public void setTimeline_comment_no(int timeline_comment_no) {
		this.timeline_comment_no = timeline_comment_no;
	}
	
	
}
