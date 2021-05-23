package kr.co.jie.dto;

public class ScrapDTO {
	private int scrap_no;
	private String company_name;
	private String hireboard_title;
	private String hireboard_deadline;
	
	private int hireboard_no;
	private int jobseeker_no;
	
	public ScrapDTO() {
		
	}

	public ScrapDTO(int scrap_no, String company_name, String hireboard_title,
			String hireboard_deadline, int hireboard_no, int jobseeker_no) {
		this.scrap_no = scrap_no;
		this.company_name = company_name;
		this.hireboard_title = hireboard_title;
		this.hireboard_deadline = hireboard_deadline;
		this.hireboard_no = hireboard_no;
		this.jobseeker_no = jobseeker_no;
	}

	public int getScrap_no() {
		return scrap_no;
	}

	public void setScrap_no(int scrap_no) {
		this.scrap_no = scrap_no;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getHireboard_title() {
		return hireboard_title;
	}

	public void setHireboard_title(String hireboard_title) {
		this.hireboard_title = hireboard_title;
	}

	public String getHireboard_deadline() {
		return hireboard_deadline;
	}

	public void setHireboard_deadline(String hireboard_deadline) {
		this.hireboard_deadline = hireboard_deadline;
	}

	public int getHireboard_no() {
		return hireboard_no;
	}

	public void setHireboard_no(int hireboard_no) {
		this.hireboard_no = hireboard_no;
	}

	public int getJobseeker_no() {
		return jobseeker_no;
	}

	public void setJobseeker_no(int jobseeker_no) {
		this.jobseeker_no = jobseeker_no;
	}

	
}
