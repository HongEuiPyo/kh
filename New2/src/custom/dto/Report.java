package custom.dto;

import custom.dao.CustomDaoImpl;

public class Report extends CustomDaoImpl {

	private int report_no; // NUMBER  primary key,
	private String report_link; // VARCHAR2(100),
	private String report_board_title; // VARCHAR2(100),
	private int report_board_done; // NUMBER,
	
	public int getReport_no() {
		return report_no;
	}

	public void setReport_no(int report_no) {
		this.report_no = report_no;
	}

	public String getReport_link() {
		return report_link;
	}

	public void setReport_link(String report_link) {
		this.report_link = report_link;
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

	@Override
	public String toString() {
		return "Report [report_no=" + report_no + ", report_link=" + report_link + ", report_board_title="
				+ report_board_title + ", report_board_done=" + report_board_done + "]";
	}
	
}
