package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.BoardDto;

public class BoardDao {
	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static BoardDao instance;
	public static BoardDao getInstance() {
		if(instance==null)
			instance=new BoardDao();
		return instance;
	}
	
	public BoardDao() {
		id="root";
		pw="1234";
		url="jdbc:mysql://localhost:3306/doseokwan";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,id,pw);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int insert(BoardDto dto) throws Exception{
		pstmt=conn.prepareStatement("insert into board_tbl values(?,?,?,?,curdate(),curdate(),curdate())");
		pstmt.setInt(1, dto.getBoard_id());
		pstmt.setString(2, dto.getWriter());
		pstmt.setString(3, dto.getTitle());
		pstmt.setString(4, dto.getContent());
		//pstmt.setDate(5, (Date) dto.getDate());
		//pstmt.setDate(6, (Date) dto.getUpdatedate());
		pstmt.setDate(7, (Date) dto.getDeletedate());
		int result = pstmt.executeUpdate();
		return result;
		
	}
	
	public List<BoardDto> select() throws Exception{
		List<BoardDto> list = new ArrayList();
		BoardDto dto = null;
		pstmt=conn.prepareStatement("select * from board_tbl");
		rs=pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next()) {
				dto=new BoardDto();
				dto.setBoard_id(rs.getInt("board_id"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getDate("_date"));
				dto.setUpdatedate(rs.getDate("_updatedate"));
				dto.setDeletedate(rs.getDate("deletedate"));
			}
			rs.close();
		}
		pstmt.close();
		
		return list;
		
		
		
	}
	public int update(BoardDto dto) throws Exception{
		pstmt=conn.prepareStatement("update board_tbl set writer=?, title=?, content=?, _date=curdate(), _updatedate=curdate(), _deletedate=curdate() where board_id=?");
		pstmt.setString(1,dto.getWriter());
		pstmt.setString(2, dto.getTitle());
		pstmt.setString(3,dto.getContent());
		//pstmt.setDate(4, (Date) dto.getDate());
		//pstmt.setDate(5, (Date) dto.getUpdatedate());
		//pstmt.setDate(6, (Date) dto.getDeletedate());
		pstmt.setInt(4,dto.getBoard_id());
		int result=pstmt.executeUpdate();
		
		pstmt.close();
		return result;
	}
	
	public int delete(int board_id) throws Exception{
		pstmt=conn.prepareStatement("delete from board_tbl where board_id=?");
		pstmt.setInt(1, board_id);
		int result=pstmt.executeUpdate();
		pstmt.close();
		return result;
	}

}
