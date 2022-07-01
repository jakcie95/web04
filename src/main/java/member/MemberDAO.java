package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBPKG.DBConnect;

public class MemberDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public MemberDAO() {
		try {
		con = DBConnect.getConnection();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	public ArrayList<MemberDTO> getNewSt() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		System.out.println("getNewSt연결 성공");
		String sql = " select * from newst";
		/*
		 1.드라이브 로드(오라클 기능을 사용할 수 있게 해줌)
		 2.오라클과 자바와 연결(Connection)
		 3.명령어 전송하는 객체 얻어오기(PreparedStatment)
		 4.결과값 받는 객체 생성()
		 	- select를 통해서 많은 정보를 얻어올때 ResultSet사용
		 	- select를 제외한 나머지는 int로 받는다.
		 */
		//명령어 전송객체 얻어옴
		try {
			ps = con.prepareStatement(sql);
			/*
			 select = executeQuery
			 select제외한 나머지는 = executeUpdate
			 executeQuery
			 -결과값을  ResultSet으로 가져온다.
			 executeUpdate
			 - 결과 값을 int 형태로 가져온다.
			 */
			rs = ps.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				
				list.add(dto);
				
				System.out.println("id : "+rs.getString("id"));
				System.out.println("name : "+rs.getString("name"));
				System.out.println("age : "+rs.getInt("age"));
				System.out.println("--------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public MemberDTO getUser(String id) {
		System.out.println("id : "+id);
		String sql = "select * from newst where id=?";
		MemberDTO dto = new MemberDTO();
		
		try {
			ps= con.prepareStatement(sql);
			//"select * from newst where id =111"
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("age"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}






