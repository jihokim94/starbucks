package data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Member;

public class MemberDBMgr {

	Connection conn;

	public MemberDBMgr() {
		beginConnection();

	}

	public void beginConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "STARBUCKS";
		String password = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("드라이버 접속 성공!! ");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 접속 실패!! ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패 또는 통신 오류");

			e.printStackTrace();
		}

	}

	public void endConnection() {
		try {
			conn.close();
			System.out.println("DB 종료 성공 ");
		} catch (SQLException e) {
			System.out.println("DB 종료 실패 ");
			e.printStackTrace();
		}
	}

	// 회원 목록을 전체 출력할수 있다
	public ArrayList<Member> getAllMembers() {
		ArrayList<Member> mbList = new ArrayList<>();

		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from members";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String login = rs.getString("login");
					String pw = rs.getString("pw");
					int gender = rs.getInt("gender");
					String email = rs.getString("email");
					String birth = rs.getString("birth");
					String phone = rs.getString("phone");
					Member mb = new Member(id, name, login, pw, gender, birth, email, phone);
					mbList.add(mb);
				}
				return mbList;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("통신에러 !! ");
		}

		return null;

	}

	// 회원 한명을 추가 할수 있다
	public boolean AddOneMember(Member mb) {
		if (conn != null && mb != null) {
			String sql = "insert into members values (" + "MEMBERS_SEQ.nextval,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mb.getLogin());
				pstmt.setString(2, mb.getPw());
				pstmt.setString(3, mb.getName());
				pstmt.setInt(4, mb.getGender());
				pstmt.setString(5, mb.getBirth());
				pstmt.setString(6, mb.getPhone());
				pstmt.setString(7, mb.getEmail());
				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("회원가입 성공");
					return true;
				} else {
					System.out.println("회원가입 실패");
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신에러 ! ");

		}
		return false;

	}// AddOneMember

	// 회원 삭제 할 수 있다

	// 회원 정보를 수정 할 수 있다 단! 관리번호는 바꾸면 안됨! 는 바꾸지 못함
	public boolean editOneMember(Member mb) {
		if (conn != null) {
			try {
//				String sql = "update members set name= "+mb.getName()+", login=,"+mb.getLogin()+""
//						+ " pw ="+mb.getPw()+", email = "+mb.getEmail()+", phone = "+mb.getPhone()+
//						" , birth ="+mb.getBirth()+" , gender =  where id = "+mb.getId()+"";
				String sql = "update members set name= ?, login= ?" + ", pw =?, email = ?, phone = ?"
						+ " , birth = ? , gender = ?  where id = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mb.getName());
				pstmt.setString(2, mb.getLogin());
				pstmt.setString(3, mb.getPw());
				pstmt.setString(4, mb.getEmail());
				pstmt.setString(5, mb.getPhone());
				pstmt.setString(6, mb.getBirth());
				pstmt.setInt(7, mb.getGender());
				pstmt.setInt(8, mb.getId());

				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("회원 수정 성공 ");
					return true;
				} else {
					System.out.println("회원 수정 실패");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("드라이버 연결 ㄴㄴ");
		}

		return false;

	}

	public boolean insertOneMember(Member mb) {
		if (conn != null && mb != null) {
			try {
//				String sql = "insert into members values(" + "MEMBER_SEQ.nextval, ?, ?, ?, ?, ?,  1000, sysdate)";
				String sql = "INSERT INTO MEMBERS VALUES (MEMBERS_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
				;
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mb.getLogin()); // 첫번째 물음표 = id
				pstmt.setString(2, mb.getPw()); // 두번째 물음표 = pw
				pstmt.setString(3, mb.getName()); // 세번쨰 물음표 = name
				pstmt.setInt(4, mb.getGender()); // 네번째 물음표 = gender
				pstmt.setString(5, mb.getBirth()); // 다섯번째 물음표 = birth
				pstmt.setString(6, mb.getPhone()); // 다섯번째 물음표 = phone
				pstmt.setString(7, mb.getEmail()); // 다섯번째 물음표 = email

				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("pstmt 회원 가입 성공: " + mb.getLogin());
					return true;
				} else {
					System.out.println("pstmt 회원 가입 실패: " + mb.getLogin());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!");
		}
		return false;
	}

	public boolean insertOneMember1(Member mb) {
		if (conn != null && mb != null) {
			try {
				String sql = "INSERT INTO MEMBERS VALUES (MEMBERS_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?)";
				;
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mb.getLogin()); // 첫번째 물음표 = id
				pstmt.setString(2, mb.getPw()); // 두번째 물음표 = pw
				pstmt.setString(3, mb.getName()); // 세번쨰 물음표 = name
				pstmt.setInt(4, mb.getGender()); // 네번째 물음표 = gender
				pstmt.setString(5, mb.getBirth()); // 다섯번째 물음표 = birth
				pstmt.setString(6, mb.getPhone()); // 다섯번째 물음표 = phone
				pstmt.setString(7, mb.getEmail()); // 다섯번째 물음표 = email

				int r = pstmt.executeUpdate();
				if (r == 1) {
					System.out.println("pstmt 회원 가입 성공: " + mb.getLogin());
					return true;
				} else {
					System.out.println("pstmt 회원 가입 실패: " + mb.getLogin());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!");
		}
		return false;
	}
	// 기존 회원을 id와 login으로 삭제 할 수 있다
	public boolean deleteOneMember(int id , String login) {
		if(conn != null) {
			String sql ="delete from members where id =? and login =?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				pstmt.setString(2, login);
				
				int r = pstmt.executeUpdate();
				if(r == 1) {
					System.out.println( login+"회원 삭제 성공");
					return true;
				}else {
					System.out.println( login+"회원 삭제 실패");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("통신상태 확인 필요");
		}
		
		return false;
		
	}

	// 신규 회원 한명을 추가할 수 있다.
	public boolean insertOneMember(String login, String pw, String name, int gender, String birth, String phone,
			String email) {
		if (conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "INSERT INTO MEMBERS VALUES (MEMBERS_SEQ.nextval, '" + login + "', '" + pw + "', '" + name
						+ "','" + gender + "', '" + birth + "', '" + phone + "','" + email + "')";
				int r = stmt.executeUpdate(sql);
				if (r == 1) {
					System.out.println("회원 가입 성공: " + login);
					return true;
				} else {
					System.out.println("회원 가입 실패: " + login);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("DB 통신 에러!");
		}

		return false;
	}

	// 회원 한명 데이터를 관리번호로 조회할 수 있다.
	// id => 키 기준 조회 (유니크 하거나 <<PK>>)
	public Member getOneMemberById(int id) {
		if (this.conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from members where id = " + id;
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) { // 레코드의 1개만
					String login = rs.getString("login");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					String birth = rs.getString("birth");
					int gender = rs.getInt("gender");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					// 회원레코드 하나가 회원 객체로 생성되며 맵핑 mapping
					Member mb = new Member(id, name, login, pw, gender, birth, email, phone);
					return mb;
				} else { // 0
					System.out.println(id + "번호의 회원 레코드가  없음!");
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!");
		}
		return null;
	}

	// 회원 한명 데이터를 계정명으로 조회할 수 있다.
	// login => 컬럼 기준 조회 (unique key) <<UQ>>
	public Member getOneMemberByLogin(String login) {
		if (login == null || login.isEmpty()) {
			System.out.println("login 입력이 오류!");
			return null;
		}
		if (this.conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from members where " + "	login = '" + login + "'";

				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) { // 레코드의 1개만
					int id = rs.getInt("id");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					String birth = rs.getString("birth");
					int gender = rs.getInt("gender");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					// 회원레코드 하나가 회원 객체로 생성되며 맵핑 mapping
					Member mb = new Member(id, name, login, pw, gender, birth, email, phone);
					return mb;
				} else { // 0
					System.out.println(login + "계정명의 회원 레코드가  없음!");
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!");
		}
		return null;
	}

	// 특정 회원의 데이터를 이름으로 조회 할 수 있다.
	public Member getOneMemberFindId(String name) {
		if (name == null || name.isEmpty()) {
			System.out.println("아이디 찾기 입력이 오류");
			return null;
		}
		if (this.conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from members ID WHERE NAME = '" + name + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) { // 레코드의 1개만
					int id = rs.getInt("id");
					String login = rs.getString("login");
					String pw = rs.getString("pw");
					int gender = rs.getInt("gender");
					String birth = rs.getString("birth");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					// 회원레코드 하나가 회원 객체로 생성되며 맵핑 mapping
					Member mb = new Member(id, name, login, pw, gender, birth, email, phone);
					System.out.println(name + "님의 아이디가  있음!");
					return mb;

				} else { // 0
					System.out.println(name + "님의 아이디가  없음!");
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!");
		}
		return null;
	}

	// 특정 회원의 데이터를 이름으로 조회 할 수 있다.
	public Member getOneMemberFindPw(String login) {
		if (login == null || login.isEmpty()) {
			System.out.println("아이디 찾기 입력이 오류");
			return null;
		}
		if (this.conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from members ID WHERE LOGIN = '" + login + "'";
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) { // 레코드의 1개만
					int id = rs.getInt("id");
//					String login = rs.getString("login");
					String pw = rs.getString("pw");
					String name = rs.getString("name");
					int gender = rs.getInt("gender");
					String birth = rs.getString("birth");
					String phone = rs.getString("phone");
					String email = rs.getString("email");
					// 회원레코드 하나가 회원 객체로 생성되며 맵핑 mapping
					Member mb = new Member(id, name, login, pw, gender, birth, email, phone);
					System.out.println(login + "님의 비밀번호가  있음!");
					return mb;

				} else { // 0
					System.out.println(login + "님의 비밀번호가  없음!");
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("DB 통신 에러!");
		}
		return null;
	}

	public static final int LOGIN_SUCCESS = 1;
	public static final int LOGIN_NOT_FOUND = 2;
	public static final int LOGIN_PW_MISMATCH = 3;
	public static final int LOGIN_ERROR = 4;

	// 회원을 인증할 수 있다. (로그인 계정명, 패스워드 - 비암호화)
	public int loginProcess(String login, String pw) {
	      if (login == null || pw == null || login.isEmpty() || pw.isEmpty()) {
	         System.out.println("로그인 인증 입력 에러!");
	         return LOGIN_ERROR;
	      }
	      if (conn != null) {
	         Member mb = getOneMemberByLogin(login); // <<UQ>>
	         if (mb != null) { // found
	            if (pw.equals(mb.getPw())) {
	               System.out.println("로그인 인증성공");
	               return LOGIN_SUCCESS;
	            } else {
	               System.out.println("패스워드 불일치");
	               return LOGIN_PW_MISMATCH;
	            }
	         } else {
	            System.out.println("로그인이 이름이 틀리거나 미가입회원입니다.");
	            return LOGIN_NOT_FOUND;
	         }

	      } else {
	         System.out.println("DB 통신 에러");
	      }
	      return LOGIN_ERROR;
	   }

}
