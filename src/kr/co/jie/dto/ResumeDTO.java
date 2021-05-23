package kr.co.jie.dto;

public class ResumeDTO {
	private int resume_no;
	private String resume_title;
	private String jobseeker_name;
	private String jobseeker_gender;
	private String jobseeker_bday;
	private String jobseeker_tel;
	private String jobseeker_cell;
	//private String jobseeker_email;
	private String jobseeker_addr;
	private String jobseeker_interested;
	private String jobseeker_wanted;
	private String jobseeker_image;
	private String resume_career_companyname;
	private String resume_career_jobcontent;
	private String resume_career_period;
	private String resume_edu_name;	
	private String resume_edu_period;	
	private String resume_edu_major;	
	private String resume_edu_graduation;	
	private String resume_edu_score;
	private String resume_cv_title1;
	private String resume_cv_title2;
	private String resume_cv_title3;
	private String resume_cv_title4;
	private String resume_cv_title5;
	private String resume_cv_content1;
	private String resume_cv_content2;
	private String resume_cv_content3;
	private String resume_cv_content4;
	private String resume_cv_content5;
	private String resume_career_status;
//	private String current_email;
	
	public ResumeDTO () {
		
	}

	public ResumeDTO(int resume_no, String resume_title, String jobseeker_name,
			String jobseeker_gender, String jobseeker_bday,
			String jobseeker_tel, String jobseeker_cell,
			/*String jobseeker_email,*/ String jobseeker_addr,
			String jobseeker_interested, String jobseeker_wanted,
			String jobseeker_image, String resume_career_companyname,
			String resume_career_jobcontent, String resume_edu_name,
			String resume_edu_period, String resume_edu_major,
			String resume_edu_graduation, String resume_edu_score,
			String resume_cv_title1, String resume_cv_title2,
			String resume_cv_title3, String resume_cv_title4,
			String resume_cv_title5, String resume_cv_content1,
			String resume_cv_content2, String resume_cv_content3,
			String resume_cv_content4, String resume_cv_content5,
			String resume_career_status, String resume_career_period) {
		super();
		this.resume_no = resume_no;
		this.resume_title = resume_title;
		this.jobseeker_name = jobseeker_name;
		this.jobseeker_gender = jobseeker_gender;
		this.jobseeker_bday = jobseeker_bday;
		this.jobseeker_tel = jobseeker_tel;
		this.jobseeker_cell = jobseeker_cell;
		//this.jobseeker_email = jobseeker_email;
		this.jobseeker_addr = jobseeker_addr;
		this.jobseeker_interested = jobseeker_interested;
		this.jobseeker_wanted = jobseeker_wanted;
		this.jobseeker_image = jobseeker_image;
		this.resume_career_companyname = resume_career_companyname;
		this.resume_career_jobcontent = resume_career_jobcontent;
		this.resume_edu_name = resume_edu_name;
		this.resume_edu_period = resume_edu_period;
		this.resume_edu_major = resume_edu_major;
		this.resume_edu_graduation = resume_edu_graduation;
		this.resume_edu_score = resume_edu_score;
		this.resume_cv_title1 = resume_cv_title1;
		this.resume_cv_title2 = resume_cv_title2;
		this.resume_cv_title3 = resume_cv_title3;
		this.resume_cv_title4 = resume_cv_title4;
		this.resume_cv_title5 = resume_cv_title5;
		this.resume_cv_content1 = resume_cv_content1;
		this.resume_cv_content2 = resume_cv_content2;
		this.resume_cv_content3 = resume_cv_content3;
		this.resume_cv_content4 = resume_cv_content4;
		this.resume_cv_content5 = resume_cv_content5;
		this.resume_career_status = resume_career_status;
		this.resume_career_period = resume_career_period;
		//this.current_email = current_email;
	}

	public String getResume_career_period() {
		return resume_career_period;
	}

	public void setResume_career_period(String resume_career_period) {
		this.resume_career_period = resume_career_period;
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

/*	public String getJobseeker_email() {
		return jobseeker_email;
	}

	public void setJobseeker_email(String jobseeker_email) {
		this.jobseeker_email = jobseeker_email;
	}*/

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

	public String getResume_career_companyname() {
		return resume_career_companyname;
	}

	public void setResume_career_companyname(String resume_career_companyname) {
		this.resume_career_companyname = resume_career_companyname;
	}

	public String getResume_career_jobcontent() {
		return resume_career_jobcontent;
	}

	public void setResume_career_jobcontent(String resume_career_jobcontent) {
		this.resume_career_jobcontent = resume_career_jobcontent;
	}

	public String getResume_edu_name() {
		return resume_edu_name;
	}

	public void setResume_edu_name(String resume_edu_name) {
		this.resume_edu_name = resume_edu_name;
	}

	public String getResume_edu_period() {
		return resume_edu_period;
	}

	public void setResume_edu_period(String resume_edu_period) {
		this.resume_edu_period = resume_edu_period;
	}

	public String getResume_edu_major() {
		return resume_edu_major;
	}

	public void setResume_edu_major(String resume_edu_major) {
		this.resume_edu_major = resume_edu_major;
	}

	public String getResume_edu_graduation() {
		return resume_edu_graduation;
	}

	public void setResume_edu_graduation(String resume_edu_graduation) {
		this.resume_edu_graduation = resume_edu_graduation;
	}

	public String getResume_edu_score() {
		return resume_edu_score;
	}

	public void setResume_edu_score(String resume_edu_score) {
		this.resume_edu_score = resume_edu_score;
	}

	public String getResume_cv_title1() {
		return resume_cv_title1;
	}

	public void setResume_cv_title1(String resume_cv_title1) {
		this.resume_cv_title1 = resume_cv_title1;
	}

	public String getResume_cv_title2() {
		return resume_cv_title2;
	}

	public void setResume_cv_title2(String resume_cv_title2) {
		this.resume_cv_title2 = resume_cv_title2;
	}

	public String getResume_cv_title3() {
		return resume_cv_title3;
	}

	public void setResume_cv_title3(String resume_cv_title3) {
		this.resume_cv_title3 = resume_cv_title3;
	}

	public String getResume_cv_title4() {
		return resume_cv_title4;
	}

	public void setResume_cv_title4(String resume_cv_title4) {
		this.resume_cv_title4 = resume_cv_title4;
	}

	public String getResume_cv_title5() {
		return resume_cv_title5;
	}

	public void setResume_cv_title5(String resume_cv_title5) {
		this.resume_cv_title5 = resume_cv_title5;
	}

	public String getResume_cv_content1() {
		return resume_cv_content1;
	}

	public void setResume_cv_content1(String resume_cv_content1) {
		this.resume_cv_content1 = resume_cv_content1;
	}

	public String getResume_cv_content2() {
		return resume_cv_content2;
	}

	public void setResume_cv_content2(String resume_cv_content2) {
		this.resume_cv_content2 = resume_cv_content2;
	}

	public String getResume_cv_content3() {
		return resume_cv_content3;
	}

	public void setResume_cv_content3(String resume_cv_content3) {
		this.resume_cv_content3 = resume_cv_content3;
	}

	public String getResume_cv_content4() {
		return resume_cv_content4;
	}

	public void setResume_cv_content4(String resume_cv_content4) {
		this.resume_cv_content4 = resume_cv_content4;
	}

	public String getResume_cv_content5() {
		return resume_cv_content5;
	}

	public void setResume_cv_content5(String resume_cv_content5) {
		this.resume_cv_content5 = resume_cv_content5;
	}

	public String getResume_career_status() {
		return resume_career_status;
	}

	public void setResume_career_status(String resume_career_status) {
		this.resume_career_status = resume_career_status;
	}

/*	public String getCurrent_email() {
		return current_email;
	}

	public void setCurrent_email(String current_email) {
		this.current_email = current_email;
	}*/
		
}
