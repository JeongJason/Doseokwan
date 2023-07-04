package Domain.Common.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.Common.Dto.MemberDto;

public class MemberDao {
	private String id;
	private String pw;
	private String url;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static MemberDao instance;
	public static MemberDao getInstance() {
		if(instance == null)  //instance가 없다면 
			instance=new MemberDao(); //instance를 생성
		return instance; //객체를 가지는 return
	}
	
	private MemberDao() {
		id="root";
		pw="1234";
		url="jdbc:mysql://localhost:3306/doseokkwan";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,id,pw);	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 입력
	public int insert(MemberDto dto) throws Exception{
		
		pstmt=conn.prepareStatement("insert into tbl_member values(?,?,?,?,?,?)");
		pstmt.setString(1, dto.getId());
		pstmt.setString(2, dto.getPw());
		pstmt.setString(4, dto.getHp());
		pstmt.setString(5, dto.getAddr());
		pstmt.setString(6, dto.getRole());
		int result=pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
		
	}
	
	// password제외한 전체 조회
	public List<MemberDto> select() throws Exception{
		List<MemberDto> list = new ArrayList();
		MemberDto dto=null;
		pstmt=conn.prepareStatement("select * from tbl_member");
		rs=pstmt.executeQuery();
		if(rs!=null) {
			while(rs.next()) {
				dto=new MemberDto(); //강한결합
				dto.setId(rs.getString("id"));
				dto.setPw(null);
				dto.setHp(rs.getString("hp"));
				dto.setAddr(rs.getString("addr"));
				dto.setRole(rs.getString("role"));
				list.add(dto);
				
			}
			rs.close();
		}
		pstmt.close();
		return list;
	}
	// 아이디 적용했을 때의 조회
	public MemberDto select(String id) throws Exception{
		MemberDto dto=null;
		pstmt=conn.prepareStatement("select * from tbl_member where id=?");
		pstmt.setString(1, id);
		
		rs=pstmt.executeQuery();
		
		try {
		if(rs!=null&&rs.isBeforeFirst())
		{
			rs.next();
			dto=new MemberDto();
			dto.setId(rs.getString("id"));
			dto.setPw(rs.getString("pw"));
			dto.setHp(rs.getString("hp"));
			dto.setAddr(rs.getString("addr"));
			dto.setRole(rs.getString("role"));
			rs.close();
					
		}
		}catch(Exception e) {
			throw new Exception("없음");
		}
		pstmt.close();
		return dto;
		
	}
	// 아이디를 선택하여 회원 수정
	public int update(MemberDto dto) throws Exception{
		pstmt=conn.prepareStatement("update tbl_member set pw=?,hp=?,addr=?,role=? where id=?");
		pstmt.setString(1, dto.getPw());
		pstmt.setString(2, dto.getHp());
		pstmt.setString(3, dto.getAddr());
		pstmt.setString(4, dto.getRole());
		int result=pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}
	
	public int delete(String id) throws Exception{
		pstmt=conn.prepareStatement("delete from tbl_member where id=?");
		pstmt.setString(1, id);
		int result=pstmt.executeUpdate();
		pstmt.close();
		
		return result;
	}
}
