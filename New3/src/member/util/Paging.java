package member.util;

public class Paging {
	
	 private int curPage;		//현재 페이지 번호
	 private int totalCount;	//총 게시글 수
	 private int listCount;		//한 페이지 당 보여질 게시글의 수
	 private int totalPage;		//총 페이지의 수 
	 private int pageCount;		//한 화면에 출력될 페이지네이션의 개수
	 private int startPage;		//화면에 보이는 시작 페이지네이션 번호
	 private int endPage;		//화면에 보이는 끝 페이지네이션 번호
	 private int startNo;		//화면에 보이는 게시글의 시작 번호
	 private int endNo;			//화면에 보이는 게시글의 끝 번호
	 
	 //디폴트 생성자 - 페이징 계산이 완료되지 않는다
	 public Paging() {}
	 
	 //총 게시글 수를 입력하는 생성자
	 public Paging(int totalCount) {
		 setTotalCount(totalCount);
		 
		 makePaging();
	 }
	 
	 //총 게시글 수, 현재 페이지번호, 보여질 게시글 수를 입력하는 생성자
	 public Paging(int totalCount, int curPage) {
		 setTotalCount(totalCount);
		 setCurPage(curPage);
		 
		 makePaging();
	 }
	 
	 //총 게시글 수, 현재 페이지번호, 보여질 게시글 수, 입력하는 생성자
	 public Paging(int totalCount, int curPage, int listCount) {
		 setTotalCount(totalCount);
		 setCurPage(curPage);
		 setListCount(listCount);
		 
		 makePaging();
	 }
	 
	 //총 게시글 수, 현재 페이지번호, 보여질 게시글 수, 보여질 페이지 수를 입력하는 생성자
	 public Paging(int totalCount, int curPage, int listCount, int pageCount) {
		 setTotalCount(totalCount);
		 setCurPage(curPage);
		 setListCount(listCount);
		 setPageCount(pageCount);
		 
		 makePaging();
	 }
	 
	 
	 //페이징 정보를 생성하는 메소드
	 private void makePaging() {
		 if(totalCount == 0) return;	//게시글이 없는 경우 중단한다
		 
		 //기본값 설정
		 if(curPage == 0)	setCurPage(1);	//첫 페이지를 기본 페이지로 설정한다
		 if(listCount == 0)	setListCount(10);	//화면에 보여질 게시글 수를 기본 10개로 설정한다
		 if(pageCount == 0)	setPageCount(10);	//화면에 보여질 게시글 수를 기본 10개로 설정한다
		 
		 //총 페이지 수 계산
		 totalPage = totalCount / listCount;
			if( totalCount % listCount > 0 )	totalPage++;
			
		//현재 페이지값 보정
		if(curPage > totalPage) curPage = totalPage;
		
		//화면에 보여질 페이지네이션의 시작번호와 끝번호
		startPage = ( (curPage-1)/pageCount ) * pageCount + 1;
		endPage = startPage + pageCount - 1;
		
		//끝 페이지값 보정
		if(endPage > totalPage) endPage = totalPage;
		
		//화면에 보여질 게시글의 시작번호와 끝번호
		startNo = (curPage-1) * listCount + 1;
		endNo = curPage * listCount;
	 }
	 
	 
	@Override
	public String toString() {
		return "Paging [curPage=" + curPage + ", totalCount=" + totalCount + ", listCount=" + listCount + ", totalPage="
				+ totalPage + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", startNo=" + startNo + ", endNo=" + endNo + "]";
	}
	/**
	 * @return the curPage
	 */
	public int getCurPage() {
		return curPage;
	}
	/**
	 * @param curPage the curPage to set
	 */
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * @return the listCount
	 */
	public int getListCount() {
		return listCount;
	}
	/**
	 * @param listCount the listCount to set
	 */
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}
	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * @return the startPage
	 */
	public int getStartPage() {
		return startPage;
	}
	/**
	 * @param startPage the startPage to set
	 */
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	/**
	 * @return the endPage
	 */
	public int getEndPage() {
		return endPage;
	}
	/**
	 * @param endPage the endPage to set
	 */
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	/**
	 * @return the startNo
	 */
	public int getStartNo() {
		return startNo;
	}
	/**
	 * @param startNo the startNo to set
	 */
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	/**
	 * @return the endNo
	 */
	public int getEndNo() {
		return endNo;
	}
	/**
	 * @param endNp the endNo to set
	 */
	public void setEndNp(int endNo) {
		this.endNo = endNo;
	}

	 
	
}
