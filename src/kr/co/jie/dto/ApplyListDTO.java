package kr.co.jie.dto;

public class ApplyListDTO {
	private int applylist_no;
	private int company_no;
	private int jobseeker_no;
	private int hireboard_no;
	private int applylist_type;
	private String apply_date;
	
	private String jobseeker_name;
	private String company_name;
	private String hireboard_title;
	
	
	public ApplyListDTO () {
		
	}


	public ApplyListDTO(int applylist_no, int company_no, int jobseeker_no,
			int hireboard_no, int applylist_type, String apply_date) {
		super();
		this.applylist_no = applylist_no;
		this.company_no = company_no;
		this.jobseeker_no = jobseeker_no;
		this.hireboard_no = hireboard_no;
		this.applylist_type = applylist_type;
		this.apply_date = apply_date;
	}


	public ApplyListDTO(int applylist_no, int company_no, int jobseeker_no,
			int hireboard_no, int applylist_type, String apply_date,
			String jobseeker_name, String company_name, String hireboard_title) {
		super();
		this.applylist_no = applylist_no;
		this.company_no = company_no;
		this.jobseeker_no = jobseeker_no;
		this.hireboard_no = hireboard_no;
		this.applylist_type = applylist_type;
		this.apply_date = apply_date;
		this.jobseeker_name = jobseeker_name;
		this.company_name = company_name;
		this.hireboard_title = hireboard_title;
	}


	public int getApplylist_no() {
		return applylist_no;
	}


	public void setApplylist_no(int applylist_no) {
		this.applylist_no = applylist_no;
	}


	public int getCompany_no() {
		return company_no;
	}


	public void setCompany_no(int company_no) {
		this.company_no = company_no;
	}


	public int getJobseeker_no() {
		return jobseeker_no;
	}


	public void setJobseeker_no(int jobseeker_no) {
		this.jobseeker_no = jobseeker_no;
	}


	public int getHireboard_no() {
		return hireboard_no;
	}


	public void setHireboard_no(int hireboard_no) {
		this.hireboard_no = hireboard_no;
	}


	public int getApplylist_type() {
		return applylist_type;
	}


	public void setApplylist_type(int applylist_type) {
		this.applylist_type = applylist_type;
	}


	public String getApply_date() {
		return apply_date;
	}


	public void setApply_date(String apply_date) {
		this.apply_date = apply_date;
	}


	public String getJobseeker_name() {
		return jobseeker_name;
	}


	public void setJobseeker_name(String jobseeker_name) {
		this.jobseeker_name = jobseeker_name;
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

	
	
}
