package util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class OracleDBUtil {
	
	public static Connection conn = null;

	//
	public static final String URL 
		= "jdbc:oracle:thin:@localhost:1521:xe";
			// 오라클 서버 통신 접속 주소
	public static final String USER = "STARBUCKS";
	public static final String PW = "1234";
	
	public static final String DB_DRIVER  
		= "oracle.jdbc.driver.OracleDriver";
	
	// 연결된 널이 아닌 conn이 기존에 있으면 바로 사용하고, 
	// 아니면 신규 conn을 생성하여 리턴하는 함수
	public static Connection getConn() {
		if( conn != null ) return conn;
		else {
			boolean c = connectDB();
			return c ? conn: null;
		}
	}
	
	public static boolean connectDB() {
		try {
			Class.forName(DB_DRIVER);
			
			conn = DriverManager
			.getConnection(URL, USER, PW);
			
			System.out.println("DB 접속 성공! - " + new Date());
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("DB 드라이버 로딩 에러");
//			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 통신 혹은 인증 등 SQL 에러");
//			e.printStackTrace();
		}
		return false;
	}
	
	public static void closeDB() {
		if( conn != null ) {
			try {
				conn.close();
				System.out.println("DB 종료 성공.");
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		} else {
			System.out.println("통신 에러!");
		}
	}
	
	public static void main(String[] args) {
		//conn = new C
		connectDB();
		closeDB();
	}

}
