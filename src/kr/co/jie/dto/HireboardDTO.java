package kr.co.jie.dto;

public class HireboardDTO {
	private int hireboard_no;
	private int company_no;
	private String hireboard_title;
	private String hireboard_name;
	private String hireboard_homepage;
	private String hireboard_sort;
	private String hireboard_job;
	private String hireboard_email;
	private String hireboard_tel;
	private String hireboard_content;
	private String hireboard_deadline;
	private String hireboard_image;
	private String hireboard_wdate;
	private String hireboard_hits;
	
	public HireboardDTO() {
		
	}

	public int getHireboard_no() {
		return hireboard_no;
	}

	public void setHireboard_no(int hireboard_no) {
		this.hireboard_no = hireboard_no;
	}

	public int getCompany_no() {
		return company_no;
	}

	public void setCompany_no(int company_no) {
		this.company_no = company_no;
	}

	public String getHireboard_title() {
		return hireboard_title;
	}

	public void setHireboard_title(String hireboard_title) {
		this.hireboard_title = hireboard_title;
	}

	public String getHireboard_name() {
		return hireboard_name;
	}

	public void setHireboard_name(String hireboard_name) {
		this.hireboard_name = hireboard_name;
	}

	public String getHireboard_homepage() {
		return hireboard_homepage;
	}

	public void setHireboard_homepage(String hireboard_homepage) {
		this.hireboard_homepage = hireboard_homepage;
	}

	public String getHireboard_sort() {
		return hireboard_sort;
	}

	public void setHireboard_sort(String hireboard_sort) {
		this.hireboard_sort = hireboard_sort;
	}

	public String getHireboard_job() {
		return hireboard_job;
	}

	public void setHireboard_job(String hireboard_job) {
		this.hireboard_job = hireboard_job;
	}

	public String getHireboard_email() {
		return hireboard_email;
	}

	public void setHireboard_email(String hireboard_email) {
		this.hireboard_email = hireboard_email;
	}

	public String getHireboard_tel() {
		return hireboard_tel;
	}

	public void setHireboard_tel(String hireboard_tel) {
		this.hireboard_tel = hireboard_tel;
	}

	public String getHireboard_content() {
		return hireboard_content;
	}

	public void setHireboard_content(String hireboard_content) {
		this.hireboard_content = hireboard_content;
	}

	public String getHireboard_deadline() {
		return hireboard_deadline;
	}

	public void setHireboard_deadline(String hireboard_deadline) {
		this.hireboard_deadline = hireboard_deadline;
	}

	public String getHireboard_image() {
		return hireboard_image;
	}

	public void setHireboard_image(String hireboard_image) {
		this.hireboard_image = hireboard_image;
	}

	public String getHireboard_wdate() {
		return hireboard_wdate;
	}

	public void setHireboard_wdate(String hireboard_wdate) {
		this.hireboard_wdate = hireboard_wdate;
	}

	public String getHireboard_hits() {
		return hireboard_hits;
	}

	public void setHireboard_hits(String hireboard_hits) {
		this.hireboard_hits = hireboard_hits;
	}

	public HireboardDTO(int hireboard_no, int company_no,
			String hireboard_title, String hireboard_name,
			String hireboard_homepage, String hireboard_sort,
			String hireboard_job, String hireboard_email, String hireboard_tel,
			String hireboard_content, String hireboard_deadline,
			String hireboard_image, String hireboard_wdate,
			String hireboard_hits) {
		super();
		this.hireboard_no = hireboard_no;
		this.company_no = company_no;
		this.hireboard_title = hireboard_title;
		this.hireboard_name = hireboard_name;
		this.hireboard_homepage = hireboard_homepage;
		this.hireboard_sort = hireboard_sort;
		this.hireboard_job = hireboard_job;
		this.hireboard_email = hireboard_email;
		this.hireboard_tel = hireboard_tel;
		this.hireboard_content = hireboard_content;
		this.hireboard_deadline = hireboard_deadline;
		this.hireboard_image = hireboard_image;
		this.hireboard_wdate = hireboard_wdate;
		this.hireboard_hits = hireboard_hits;
	}
}
