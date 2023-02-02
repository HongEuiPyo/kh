package official.dto;

import official.dao.OfficialDaoImpl;

import java.util.Date;

public class OfficialComment extends OfficialDaoImpl {

	private int official_reply_no; // NUMBER  primary key,
	private int official_board_no; // NUMBER,
	private int user_no; // NUMBER,
	private String user_nickname; // 조인으로불러올 정보
	private String board_type; // varchar2(2),
	private String official_reply_content; // varchar2(200),
	private Date official_reply_date; // DATE,
	
	public int getOfficial_reply_no() {
		return official_reply_no;
	}

	public void setOfficial_reply_no(int official_reply_no) {
		this.official_reply_no = official_reply_no;
	}

	public int getOfficial_board_no() {
		return official_board_no;
	}

	public void setOfficial_board_no(int official_board_no) {
		this.official_board_no = official_board_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public String getBoard_type() {
		return board_type;
	}

	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}

	public String getOfficial_reply_content() {
		return official_reply_content;
	}

	public void setOfficial_reply_content(String official_reply_content) {
		this.official_reply_content = official_reply_content;
	}

	public Date getOfficial_reply_date() {
		return official_reply_date;
	}

	public void setOfficial_reply_date(Date official_reply_date) {
		this.official_reply_date = official_reply_date;
	}

	@Override
	public String toString() {
		return "OfficialComment [official_reply_no=" + official_reply_no + ", official_board_no=" + official_board_no
				+ ", user_no=" + user_no + ", user_nickname=" + user_nickname + ", board_type=" + board_type
				+ ", official_reply_content=" + official_reply_content + ", official_reply_date=" + official_reply_date
				+ "]";
	}
	
	
}
