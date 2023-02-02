package member.dto;

public class Report {
	
	int report_no;
	String report_board_link;
	String report_board_title;
	int report_board_done;
	
	
	
	@Override
	public String toString() {
		return "Report [report_no=" + report_no + ", report_board_link=" + report_board_link + ", report_board_title="
				+ report_board_title + ", report_board_done=" + report_board_done + "]";
	}
	public int getReport_no() {
		return report_no;
	}
	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}
	public String getReport_board_link() {
		return report_board_link;
	}
	public void setReport_board_link(String report_board_link) {
		this.report_board_link = report_board_link;
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
