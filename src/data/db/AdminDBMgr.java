package data.db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import data.Admin;
import util.db.OracleDBUtil;

public class AdminDBMgr {
	
	public Connection conn ; 
	
	


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
			System.out.println("����̹� ���� ����");
		}
		return null;
		
	}
	
	// ȸ���� ������ �� �ִ�. (�α��� ������, �н����� - ���ȣȭ)
		public int loginProcess(String login, String pw) {
		      if (login == null || pw == null || login.isEmpty() || pw.isEmpty()) {
		         System.out.println("�α��� ���� �Է� ����!");
		         return MemberDBMgr.LOGIN_ERROR;
		      }
		      if (conn != null) {
		         Admin ad = getAdminByLogin(login); // <<UQ>>
		         if (ad != null) { // found
		            if (pw.equals(ad.getPw())) {
		               System.out.println("�α��� ��������");
		               return MemberDBMgr.LOGIN_SUCCESS;
		            } else {
		               System.out.println("�н����� ����ġ");
		               return MemberDBMgr.LOGIN_PW_MISMATCH;
		            }
		         } else {
		            System.out.println("�α����� �̸��� Ʋ���ų� �̰���ȸ���Դϴ�.");
		            return MemberDBMgr.LOGIN_NOT_FOUND;
		         }

		      } else {
		         System.out.println("DB ��� ����");
		      }
		      return MemberDBMgr.LOGIN_ERROR;
		   }
}
