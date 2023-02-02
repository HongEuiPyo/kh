package free.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import free.dao.face.BoardDao;
import free.dto.BoardFile;
import free.dto.FreeBoard;
import free.dto.FreeReply;
import free.util.Paging;


public class BoardDaoImpl implements BoardDao{

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) FROM free_board";
		
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
			
		
		return count;
	}
	


	@Override
	public List<FreeBoard> selectAll(Connection conn, Paging paging) {
		String sql = ""; 
		sql += "SELECT * FROM (";
		sql += " SELECT rownum rnum, FB.* FROM (";
		sql += "	SELECT fr.free_board_no, ui.user_no, ui.user_nickname,";
		sql += " 	 		fr.free_board_title, fr.free_board_content, fr.free_board_date, fr.free_board_hit, fr.free_board_vote";
		sql += " 	 	FROM free_board fr,";
		sql += " 	 	user_info ui";
		sql += " 	 	WHERE ui.user_no = fr.user_no";
		sql += " 	 	ORDER BY fr.free_board_no DESC";
		sql += "	) FB";
		sql += " ) FREEBOARD";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<FreeBoard> boardList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,  paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FreeBoard board = new FreeBoard();
				
				board.setFree_board_no(rs.getInt("free_board_no"));
				board.setFree_board_title(rs.getString("free_board_title"));
				board.setFree_board_content(rs.getString("free_board_content"));
				board.setFree_board_date(rs.getDate("free_board_date"));
				board.setFree_board_hit(rs.getInt("free_board_hit"));
				board.setFree_board_vote(rs.getInt("free_board_vote"));
				board.setUser_nickname(rs.getString("user_nickname"));
			
				boardList.add(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return boardList;
	}

	@Override
	public FreeBoard getFreeBoardByFreeBoardNo(Connection conn, FreeBoard board) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT fr.free_board_no, ui.user_no, ui.user_nickname,";
		sql += " 		fr.free_board_title, fr.free_board_content, fr.free_board_date, fr.free_board_hit, fr.free_board_vote";
		sql += " 	FROM free_board fr, user_info ui";
		sql += " 	WHERE fr.user_no = ui.user_no";
		sql += " ) WHERE free_board_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getFree_board_no());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				board.setFree_board_no(rs.getInt("free_board_no"));
				board.setFree_board_title(rs.getString("free_board_title"));
				board.setFree_board_content(rs.getString("free_board_content"));
				board.setFree_board_date(rs.getDate("free_board_date"));
				board.setUser_nickname(rs.getString("user_nickname"));
				board.setFree_board_hit(rs.getInt("free_board_hit"));
				board.setFree_board_vote(rs.getInt("free_board_vote"));
				board.setUser_no(rs.getInt("user_no"));
				
				System.out.println(board);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return board;
	}

	@Override
	public int SearchByBoardNo(Connection conn, FreeBoard board) {
		String sql = "";
		sql += "SELECT count(*) FROM free_board WHERE free_board_no = ?";

		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getFree_board_no());
			
			System.out.println("getFree_board_no() ="+board.getFree_board_no());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				res = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
			JDBCTemplate.close(rs);
		}
		
		
		return res;
	}

	@Override
	public void Hit(Connection conn, FreeBoard board) {
		String sql = "";
		sql += "UPDATE free_board";
		sql += " SET free_board_hit = free_board_hit + 1";
		sql += " WHERE free_board_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, board.getFree_board_no());
			
			int res = ps.executeUpdate();
			if(res<=0) {
				System.out.println("[ERROR] fail to update freeboardhit by freeboardno");
				JDBCTemplate.rollback(conn);
			}else{
				JDBCTemplate.commit(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}		
	}

	@Override
	public int selectNextFreeBoardno(Connection conn) {
		
		String sql = "";
		sql += "SELECT free_board_seq.nextval FROM dual";
		
		//결과 저장 변수
		int nextBoardno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				nextBoardno = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextBoardno;
	}
	
	@Override
	public int selectNextAttachno(Connection conn) {
		String sql = "";
		sql += "SELECT free_board_attachment_seq.nextval FROM dual";
		
		//결과 저장 변수
		int nextAttachno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				nextAttachno = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextAttachno;
		
	}

	
	@Override
	public int insertIntoFreeBoard(Connection conn, FreeBoard freeBoard) {
		String sql = "";
		sql += "INSERT INTO free_board(free_board_no, user_no,";
		sql += " free_board_title, free_board_content)";
		sql += " VALUES (?, ?, ?, ?)";
		
		int res = 0;
		
		try {
			
			System.out.println(freeBoard);
			
			//DB작업
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, freeBoard.getFree_board_no());
			ps.setInt(2, freeBoard.getUser_no());
			ps.setString(3, freeBoard.getFree_board_title());
			ps.setString(4, freeBoard.getFree_board_content());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int insertFile(Connection conn, BoardFile boardFile) {
		String sql = "";
		sql += "INSERT INTO free_board_attachment( attach_no, free_board_no,";
		sql += " original_file_name, stored_file_name, file_size)";
		sql += " VALUES (?, ?, ?, ? ,?)";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);

			ps.setInt(1, boardFile.getAttach_no());
			ps.setInt(2, boardFile.getFree_board_no());
			ps.setString(3, boardFile.getOriginal_file_name());
			ps.setString(4, boardFile.getStored_file_name());
			ps.setInt(5, boardFile.getFile_size());
			
			res = ps.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	
	@Override
	public BoardFile getAttachmentByAttachNo(Connection conn, BoardFile boardFile) {
		String sql = "";
		sql += "SELECT * FROM free_board_attachment";
		sql += " WHERE attach_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardFile.getAttach_no());
			System.out.println("boardFile.getAttach_no(): " + boardFile.getAttach_no());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				boardFile.setFree_board_no(rs.getInt("free_board_no"));
				boardFile.setFile_size(rs.getInt("file_size"));
				boardFile.setOriginal_file_name(rs.getString("original_file_name"));
				boardFile.setFile_date(rs.getDate("file_date"));
				boardFile.setStored_file_name(rs.getString("stored_file_name"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		
		return boardFile;
	}

	@Override
	public int updateFreeBoard(Connection conn, FreeBoard freeBoard) {
		String sql ="";
		sql += "UPDATE free_board";
		sql += " SET";
		sql += " free_board_title = ?,";
		sql += " free_board_content = ?";
		sql += " WHERE free_board_no = ?";
		
		int res = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, freeBoard.getFree_board_title());
			ps.setString(2, freeBoard.getFree_board_content());
			ps.setInt(3, freeBoard.getFree_board_no());
			
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}

	/*
	 * @Override public int getAttach_noByfree_board_no(Connection conn, int
	 * freeBoardno) { String sql = ""; sql +=
	 * "SELCT attach_no FROM free_board_attachment"; sql +=
	 * " WHERE free_board_no = ?";
	 * 
	 * int res=-1; try { ps = conn.prepareStatement(sql);
	 * 
	 * ps.setInt(1, freeBoardno);
	 * 
	 * rs = ps.executeQuery();
	 * 
	 * while(rs.next()) { res = rs.getInt("attach_no"); } } catch (SQLException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); }finally {
	 * JDBCTemplate.close(rs); JDBCTemplate.close(ps); }
	 * 
	 * return res; }
	 */

	@Override
	public int updateFile(Connection conn, BoardFile boardFile) {
		String sql = "";
		
		sql += "UPDATE free_board_attachment";
		sql += " SET";
		sql += " original_file_name = ?,";
		sql += " stored_file_name = ?,";
		sql += " file_size = ?,";
		sql += " file_date = sysdate";
		sql += " WHERE free_board_no = ?";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, boardFile.getOriginal_file_name());
			ps.setString(2, boardFile.getStored_file_name());
			ps.setInt(3, boardFile.getFile_size());
			ps.setInt(4, boardFile.getFree_board_no());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
		
		
		return res;
	}

	@Override
	public BoardFile getFreeboardAttachmentByFreeBoardNo(Connection conn, BoardFile boardFile) {
		String sql = "";
		sql += "SELECT * FROM free_board_attachment";
		sql += " WHERE free_board_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardFile.getFree_board_no());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				boardFile.setAttach_no(rs.getInt("attach_no"));
				boardFile.setOriginal_file_name(rs.getString("original_file_name"));
				boardFile.setStored_file_name(rs.getString("stored_file_name"));
				boardFile.setFile_date(rs.getDate("file_date"));
				boardFile.setFile_size(rs.getInt("file_size"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return boardFile;
	}

	@Override
	public int deleteFreeBoardByFreeBoardNo(Connection conn, FreeBoard freeBoard) {
		String sql = "";
		sql += "DELETE FROM free_board";
		sql += " WHERE free_board_no = ?";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, freeBoard.getFree_board_no());
			
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int deleteFreeBoardAttachment(Connection conn, BoardFile boardFile) {
		String sql = "";
		sql += "DELETE FROM free_board_attachment";
		sql += " WHERE attach_no = ?";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardFile.getAttach_no());
			
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int insertReply(Connection conn, FreeReply freeReply) {
		String sql = "";
		sql += "INSERT INTO free_board_reply";
		sql += " (free_reply_no, free_board_no, user_no, free_reply_content)";
		sql += " VALUES ( free_board_reply_seq.nextval, ?, ?, ?)";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, freeReply.getFree_board_no());
			ps.setInt(2, freeReply.getUser_no());
			ps.setString(3, freeReply.getFree_reply_content());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public List<FreeReply> selectAllReplyByFreeboardno(Connection conn, FreeReply freeReply) {
		
		List<FreeReply> freeReplyList = new ArrayList<>();
		
		String sql = "";
		sql += "SELECT R.free_reply_no, R.free_board_no, U.user_no, R.free_reply_content, R.free_reply_date, U.user_nickname";
		sql += " FROM free_board_reply R";
		sql += " JOIN user_info U ON R.user_no = U.user_no";
		sql += " WHERE 1=1";
		sql += " 	AND free_board_no = ?";
		sql += " ORDER BY R.free_reply_no ASC";
		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, freeReply.getFree_board_no());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				FreeReply tmpReply = new FreeReply();

				tmpReply.setFree_reply_no(rs.getInt("free_reply_no"));
				tmpReply.setFree_board_no(rs.getInt("free_board_no"));
				tmpReply.setUser_no(rs.getInt("user_no"));
				tmpReply.setFree_reply_content(rs.getString("free_reply_content"));
				tmpReply.setFree_reply_date(rs.getDate("free_reply_date"));
				tmpReply.setUser_nickname(rs.getString("user_nickname"));
				
				freeReplyList.add(tmpReply);
				
				System.out.println(tmpReply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return freeReplyList;
	}

	@Override
	public int deleteFreeReplyByNo(Connection conn, FreeReply freeReply) {
		
		String sql = "";
		sql += "DELETE FROM free_board_reply";
		sql += " WHERE free_reply_no = ?";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, freeReply.getFree_reply_no());
			
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}

	@Override
	public int PlusLike(Connection conn, FreeBoard freeBoard) {
		String sql = "";
		sql += "UPDATE free_board";
		sql += " SET free_board_hit = free_board_hit + 1";
		sql += " WHERE free_board_no = ?";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, freeBoard.getFree_board_no());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		
		return res;
	}

	@Override
	public int MinusLike(Connection conn, FreeBoard freeBoard) {
		String sql = "";
		sql += "UPDATE free_board";
		sql += " SET free_board_hit = free_board_hit - 1";
		sql += " WHERE free_board_no = ?";
		
		int res = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, freeBoard.getFree_board_no());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}

	@Override
	public FreeBoard getLike(Connection conn, FreeBoard freeBoard) {
		String sql = "";
		sql += "SELECT free_board_vote";
		sql += " WHERE free_board_no = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, freeBoard.getFree_board_no());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				freeBoard.setFree_board_vote(rs.getInt("free_board_vote"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
	
		return freeBoard;
	}



	







	

}
