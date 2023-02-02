import java.sql.Date;

public class Test {

	private int number;
	private String writer;
	private String title;
	private String Content;
	private Date date;
	
	public Test() { }
	
	@Override
	public String toString() {
		return "Test [number=" + number + ", writer=" + writer + ", title=" + title + ", Content=" + Content + ", date="
				+ date + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
