package data.db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Admin;
import data.Member;
import util.db.OracleDBUtil;

public class AdminDBMgr {
	
	Connection conn ; 
	
	


	public AdminDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
	public Admin getAdminByLogin(String login) {
		if(conn !=null) {
			String sql = "select * from admins where login = "
					+ "'"+login +"'";
			

				try {
					Statement stmt =conn.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
//						int id = rs.getInt("id");
						String login1 = rs.getString("login");
						String pw = rs.getString("pw");
						String name = rs.getString("name");
						Admin ad = new Admin(login1, pw, name);
						return ad;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
		}else {
			System.out.println("드라이버 연결 실패");
		}
		return null;
		
		
		
		
		
		
	}
	
	// 회원을 인증할 수 있다. (로그인 계정명, 패스워드 - 비암호화)
		public int loginProcess(String login, String pw) {
		      if (login == null || pw == null || login.isEmpty() || pw.isEmpty()) {
		         System.out.println("로그인 인증 입력 에러!");
		         return MemberDBMgr.LOGIN_ERROR;
		      }
		      if (conn != null) {
		         Admin ad = getAdminByLogin(login); // <<UQ>>
		         if (ad != null) { // found
		            if (pw.equals(ad.getPw())) {
		               System.out.println("로그인 인증성공");
		               return MemberDBMgr.LOGIN_SUCCESS;
		            } else {
		               System.out.println("패스워드 불일치");
		               return MemberDBMgr.LOGIN_PW_MISMATCH;
		            }
		         } else {
		            System.out.println("로그인이 이름이 틀리거나 미가입회원입니다.");
		            return MemberDBMgr.LOGIN_NOT_FOUND;
		         }

		      } else {
		         System.out.println("DB 통신 에러");
		      }
		      return MemberDBMgr.LOGIN_ERROR;
		   }
}
