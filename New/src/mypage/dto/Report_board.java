package mypage.dto;

public class Report_board {

	
	private int report_no;
	private String admin_id;
	private int report_board_number;
	private String report_board_title;
	private int report_board_done;
	@Override
	public String toString() {
		return "Report_board [report_no=" + report_no + ", admin_id=" + admin_id + ", report_board_number="
				+ report_board_number + ", report_board_title=" + report_board_title + ", report_board_done="
				+ report_board_done + "]";
	}
	public int getReport_no() {
		return report_no;
	}
	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public int getReport_board_number() {
		return report_board_number;
	}
	public void setReport_board_number(int report_board_number) {
		this.report_board_number = report_board_number;
	}
	public String getReport_board_title() {
		return report_board_title;
	}
	public void setReport_board_title(String report_board_title) {
		this.report_board_title = report_board_title;
	}
	public int getReport_board_done() {
		return report_board_done;
	}
	public void setReport_board_done(int report_board_done) {
		this.report_board_done = report_board_done;
	}
	
	
	
	
}
