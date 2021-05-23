package kr.co.jie.dto;

public class MailDTO {
	private int mailbox_no;
	private String mailbox_receiver_name;
	private String mailbox_receiver_email;
	private String mailbox_sender_name;
	private String mailbox_sender_email;
	private String mailbox_title;
	private String mailbox_content;
	private String mailbox_file;
	private String mailbox_logtime;
	private int jobseeker_no;
	private int company_no;
	
	public MailDTO(){}

	public int getMailbox_no() {
		return mailbox_no;
	}

	public void setMailbox_no(int mailbox_no) {
		this.mailbox_no = mailbox_no;
	}

	public String getMailbox_receiver_name() {
		return mailbox_receiver_name;
	}

	public void setMailbox_receiver_name(String mailbox_receiver_name) {
		this.mailbox_receiver_name = mailbox_receiver_name;
	}

	public String getMailbox_sender_name() {
		return mailbox_sender_name;
	}

	public void setMailbox_sender_name(String mailbox_sender_name) {
		this.mailbox_sender_name = mailbox_sender_name;
	}

	public String getMailbox_receiver_email() {
		return mailbox_receiver_email;
	}

	public void setMailbox_receiver_email(String mailbox_receiver_email) {
		this.mailbox_receiver_email = mailbox_receiver_email;
	}

	public String getMailbox_sender_email() {
		return mailbox_sender_email;
	}

	public void setMailbox_sender_email(String mailbox_sender_email) {
		this.mailbox_sender_email = mailbox_sender_email;
	}

	public String getMailbox_title() {
		return mailbox_title;
	}

	public void setMailbox_title(String mailbox_title) {
		this.mailbox_title = mailbox_title;
	}

	public String getMailbox_content() {
		return mailbox_content;
	}

	public void setMailbox_content(String mailbox_content) {
		this.mailbox_content = mailbox_content;
	}

	public String getMailbox_file() {
		return mailbox_file;
	}

	public void setMailbox_file(String mailbox_file) {
		this.mailbox_file = mailbox_file;
	}

	public String getMailbox_logtime() {
		return mailbox_logtime;
	}

	public void setMailbox_logtime(String mailbox_logtime) {
		this.mailbox_logtime = mailbox_logtime;
	}

	public int getJobseeker_no() {
		return jobseeker_no;
	}

	public void setJobseeker_no(int jobseeker_no) {
		this.jobseeker_no = jobseeker_no;
	}

	public int getCompany_no() {
		return company_no;
	}

	public void setCompany_no(int company_no) {
		this.company_no = company_no;
	}
	
	
	
	
}
