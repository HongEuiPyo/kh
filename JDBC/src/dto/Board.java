package dto;

public class Board {
	
	// 멤버필드
	private int NO;
	private String TITLE;
	private String CONTENT;
	private String WRITER;
	private String STATUS;
	private String CREATE_DATE;
	private String UPDATE_DATE;
	
	
	// toString
	@Override
	public String toString() {
		return "Board [NO=" + NO + ", TITLE=" + TITLE + ", CONTENT=" + CONTENT + ", WRITER=" + WRITER + ", STATUS="
				+ STATUS + ", CREATE_DATE=" + CREATE_DATE + ", UPDATE_DATE=" + UPDATE_DATE + "]";
	}
	
	// Getters, Setters
	public int getNO() {
		return NO;
	}
	public void setNO(int nO) {
		NO = nO;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getWRITER() {
		return WRITER;
	}
	public void setWRITER(String wRITER) {
		WRITER = wRITER;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(String cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	public String getUPDATE_DATE() {
		return UPDATE_DATE;
	}
	public void setUPDATE_DATE(String uPDATE_DATE) {
		UPDATE_DATE = uPDATE_DATE;
	}
	 
} // class end
