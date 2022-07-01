package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBConnect;

public class MemberDAOQ {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public MemberDAOQ() {
		try {
			con = DBConnect.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<MemberDTOQ> getStudent() {
		ArrayList<MemberDTOQ> list = new ArrayList<MemberDTOQ>();
		System.out.println("getStudent연결 성공");
		String sql = "select * from student";
		try {
			ps =con.prepareStatement(sql);
			rs = ps.executeQuery();
		while(rs.next()) {
			MemberDTOQ dtoq = new MemberDTOQ();
			dtoq.setId(rs.getString("id"));
			dtoq.setName(rs.getString("name"));
			dtoq.setKor(rs.getInt("kor"));
			dtoq.setEng(rs.getInt("eng"));
			dtoq.setMath(rs.getInt("math"));
			
			list.add(dtoq);
			
			System.out.println("id : "+rs.getString("id"));
			System.out.println("id : "+rs.getString("name"));
			System.out.println("id : "+rs.getInt("kor"));
			System.out.println("id : "+rs.getInt("eng"));
			System.out.println("id : "+rs.getInt("math"));
			System.out.println("---------------------");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		public MemberDTOQ getStudent(String id) {
			System.out.println("id : "+id);
			String sql = "select * from student where id=?";
			MemberDTOQ dtoq = new MemberDTOQ();
			
			try {
				ps= con.prepareStatement(sql);
				ps.setString(1, id);
				
				rs = ps.executeQuery();
				if(rs.next()) {
					dtoq.setId(rs.getString("id"));
					dtoq.setName(rs.getString("name"));
					dtoq.setKor(rs.getInt("kor"));
					dtoq.setEng(rs.getInt("eng"));
					dtoq.setMath(rs.getInt("math"));
					System.out.println(rs.getString("id"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getInt("kor"));
					System.out.println(rs.getInt("eng"));
					System.out.println(rs.getInt("math"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dtoq;
	}
}
