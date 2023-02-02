package free.dto;

public class Member {
	private int user_no;
	private String user_email;
	private String user_password;
	private String user_nickname;
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	@Override
	public String toString() {
		return "User [user_no=" + user_no + ", user_email=" + user_email + ", user_password=" + user_password
				+ ", user_nickname=" + user_nickname + "]";
	}
}
