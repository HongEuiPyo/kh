package mypage.dto;

import mypage.dao.impl.MypageDaoImpl;

public class TypeOfBoard extends MypageDaoImpl {

	
	
	private String board_type;
	private String board_name;
	
	@Override
	public String toString() {
		return "TypeOfBoard [board_type=" + board_type + ", board_name=" + board_name + "]";
	}

	public String getBoard_type() {
		return board_type;
	}

	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}
	
	
	
}
