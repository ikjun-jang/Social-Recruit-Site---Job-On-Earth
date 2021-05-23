package kr.co.jie.dto;

public class JobseekerDTO {
	private int jobseeker_no; 
	private String jobseeker_id;
	private String jobseeker_pw;
	private String jobseeker_name;
	private String jobseeker_gender;
	private String jobseeker_bday;
	private String jobseeker_tel;
	private String jobseeker_cell;
	private String jobseeker_email;
	private String jobseeker_addr;
	private String jobseeker_interested;
	private String jobseeker_wanted;
	private String jobseeker_image;
	private String member_type;
	private String jobseeker_repw;
	private String remember;
	
	

	public JobseekerDTO(int jobseeker_no, String jobseeker_name,
			String jobseeker_gender, String jobseeker_bday,
			String jobseeker_tel, String jobseeker_cell,
			String jobseeker_email, String jobseeker_addr,
			String jobseeker_interested, String jobseeker_wanted) {
		super();
		this.jobseeker_no = jobseeker_no;
		this.jobseeker_name = jobseeker_name;
		this.jobseeker_gender = jobseeker_gender;
		this.jobseeker_bday = jobseeker_bday;
		this.jobseeker_tel = jobseeker_tel;
		this.jobseeker_cell = jobseeker_cell;
		this.jobseeker_email = jobseeker_email;
		this.jobseeker_addr = jobseeker_addr;
		this.jobseeker_interested = jobseeker_interested;
		this.jobseeker_wanted = jobseeker_wanted;
	}



	public JobseekerDTO(){}



	public int getJobseeker_no() {
		return jobseeker_no;
	}



	public void setJobseeker_no(int jobseeker_no) {
		this.jobseeker_no = jobseeker_no;
	}



	public String getJobseeker_id() {
		return jobseeker_id;
	}



	public void setJobseeker_id(String jobseeker_id) {
		this.jobseeker_id = jobseeker_id;
	}



	public String getJobseeker_pw() {
		return jobseeker_pw;
	}



	public void setJobseeker_pw(String jobseeker_pw) {
		this.jobseeker_pw = jobseeker_pw;
	}



	public String getJobseeker_name() {
		return jobseeker_name;
	}



	public void setJobseeker_name(String jobseeker_name) {
		this.jobseeker_name = jobseeker_name;
	}



	public String getJobseeker_gender() {
		return jobseeker_gender;
	}



	public void setJobseeker_gender(String jobseeker_gender) {
		this.jobseeker_gender = jobseeker_gender;
	}



	public String getJobseeker_bday() {
		return jobseeker_bday;
	}



	public void setJobseeker_bday(String jobseeker_bday) {
		this.jobseeker_bday = jobseeker_bday;
	}



	public String getJobseeker_tel() {
		return jobseeker_tel;
	}



	public void setJobseeker_tel(String jobseeker_tel) {
		this.jobseeker_tel = jobseeker_tel;
	}



	public String getJobseeker_cell() {
		return jobseeker_cell;
	}



	public void setJobseeker_cell(String jobseeker_cell) {
		this.jobseeker_cell = jobseeker_cell;
	}



	public String getJobseeker_email() {
		return jobseeker_email;
	}



	public void setJobseeker_email(String jobseeker_email) {
		this.jobseeker_email = jobseeker_email;
	}



	public String getJobseeker_addr() {
		return jobseeker_addr;
	}



	public void setJobseeker_addr(String jobseeker_addr) {
		this.jobseeker_addr = jobseeker_addr;
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



	public String getJobseeker_image() {
		return jobseeker_image;
	}



	public void setJobseeker_image(String jobseeker_image) {
		this.jobseeker_image = jobseeker_image;
	}



	public String getMember_type() {
		return member_type;
	}



	public void setMember_type(String member_type) {
		this.member_type = member_type;
	}



	public String getJobseeker_repw() {
		return jobseeker_repw;
	}



	public void setJobseeker_repw(String jobseeker_repw) {
		this.jobseeker_repw = jobseeker_repw;
	}



	public String getRemember() {
		return remember;
	}



	public void setRemember(String remember) {
		this.remember = remember;
	}
	
	
}
