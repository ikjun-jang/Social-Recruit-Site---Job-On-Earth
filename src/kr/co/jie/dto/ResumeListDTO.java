package kr.co.jie.dto;

public class ResumeListDTO {
	private int resume_no;
	private String resume_title;
	private String jobseeker_interested;
	private String jobseeker_wanted;
	
	public ResumeListDTO () {
		
	}

	public ResumeListDTO(int resume_no, String resume_title, String jobseeker_interested,
			String jobseeker_wanted) {
		super();
		this.resume_no = resume_no;
		this.resume_title = resume_title;
		this.jobseeker_interested = jobseeker_interested;
		this.jobseeker_wanted = jobseeker_wanted;
	}
	
	public int getResume_no() {
		return resume_no;
	}

	public void setResume_no(int resume_no) {
		this.resume_no = resume_no;
	}

	public String getResume_title() {
		return resume_title;
	}

	public void setResume_title(String resume_title) {
		this.resume_title = resume_title;
	}

	public String getJobseeker_interested() {
		return jobseeker_interested;
	}

	public void setJobseeker_interested(String jobseeker_interested) {
		this.jobseeker_interested = jobseeker_interested;
	}

	public String getJobseeker_wanted() {
		return jobseeker_wanted;
	}

	public void setJobseeker_wanted(String jobseeker_wanted) {
		this.jobseeker_wanted = jobseeker_wanted;
	}
	
}
