package com.web.board.model.dao;

import static com.web.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.web.board.model.vo.Board;
import com.web.board.model.vo.BoardComment;

public class BoardDao {
	
	private Properties sql = new Properties();
	
	public  BoardDao() {
		String path = BoardDao.class.getResource("/sql/board/boardsql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	private Board getBoard(ResultSet rs) throws SQLException {
		return Board.builder().boardContent(rs.getString("board_content")).boardDate(rs.getDate("board_date"))
				.boardNo(rs.getInt("board_no")).boardOriginalFilename(rs.getString("board_original_filename"))
				.boardReadcount(rs.getInt("board_readcount")).boardRenamedFilename(rs.getString("board_renamed_filename"))
				.boardTitle(rs.getString("board_title")).boardWriter(rs.getString("board_writer"))
				.build();
	}
	private BoardComment getBoardComment(ResultSet rs) throws SQLException{
		return BoardComment.builder()
				.boardCommentNo(rs.getInt("board_comment_no"))
				.level(rs.getInt("board_comment_level"))
				.boardCommentWriter(rs.getString("board_comment_writer"))
				.boardCommentContent(rs.getString("board_comment_content"))
				.boardCommentDate(rs.getDate("board_comment_date"))
				.boardCommentRef(rs.getInt("board_comment_ref"))
				.boardRef(rs.getInt("board_ref"))
				.build();
	}
	public List<Board> selectBoard(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBoard"));
			pstmt.setInt(1, (cPage - 1) * numPerpage + 1);
			pstmt.setInt(2, cPage * numPerpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(getBoard(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	public int selectBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBoardCount"));
			rs = pstmt.executeQuery();
			if (rs.next())
				result = rs.getInt("RN");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public Board selectBoardByNo(Connection conn, int no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board n = null;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("selectBoardByNo"));
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next())n=getBoard(rs);
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			close(rs);
			close(pstmt);
		}
		return n;
	}
	public List<BoardComment> selectBoardCommentByNo(Connection conn, int no) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<BoardComment> list = new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectBoardCommentByNo"));
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(getBoardComment(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
	
	
	
	public int updateBoardReadCount(Connection conn, int no) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateboardReadCount"));
			pstmt.setInt(1, no);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	public int insertBoard(Connection conn, Board n) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql.getProperty("insertBoard"));
			pstmt.setString(1, n.getBoardTitle());
			pstmt.setString(2, n.getBoardWriter());
			pstmt.setString(3, n.getBoardContent());
			pstmt.setString(4, n.getBoardRenamedFilename());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(pstmt);
		}
		return result;
	}
	public int insertBoardComment(Connection conn, BoardComment bc) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertBoardComment"));
			pstmt.setInt(1, bc.getLevel());
			pstmt.setString(2, bc.getBoardCommentWriter());
			pstmt.setString(3, bc.getBoardCommentContent());
			pstmt.setInt(4, bc.getBoardRef());
			pstmt.setString(5, bc.getBoardCommentRef()==0?null:String.valueOf(bc.getBoardCommentRef()));
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
