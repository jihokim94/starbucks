package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Admin;
import data.db.AdminDBMgr;
import data.db.MemberDBMgr;
import util.db.OracleDBUtil;

class AdminDBMgrTest {
	private AdminDBMgr testDBMgr;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		testDBMgr = new AdminDBMgr();
	}

	@AfterEach
	void tearDown() throws Exception {
		testDBMgr = null;
	}
	/**
	 * Purpose: Constructor  of AdminDBMgr class.
	 * Input: AdminDBMgr get util.db.OracleDBUtil.java's conn and assign it to AdminDBMgr's conn
	 * Expected:
	 * 		return PASS
	 * 		util.db.OracleDBUtil.java's conn = AdminDBMgr's conn
	 */
	@Test
	void testConstructor() {
		testDBMgr = new AdminDBMgr();
		assertEquals(testDBMgr.conn, OracleDBUtil.getConn());
	}
	/**
	 * Purpose: get Admin data from ADMINS Table Using LOGIN COLUMN DATA
	 * Input: getAdminByLogin return correspond Admin data using sql Query Login="sgg"
	 * Expected:
	 * 		return PASS
	 * 		Name = "adm"
	 * 		Pw = "1234"
	 * 		Login = "sgg"
	 * 		
	 */
	@Test
	void testGetAdminByLoginSucess() {
		Admin testAdmin = testDBMgr.getAdminByLogin("sgg");
		assertEquals(testAdmin.getName(),"adm");
		assertEquals(testAdmin.getPw(),"1234");
		assertEquals(testAdmin.getLogin(),"sgg");
	}
	/**
	 * Purpose: Request Non exist data of Table Admin
	 * Input: getAdminByLogin return correspond Admin data using sql Query Login="failure"
	 * Expected:
	 * 		return Data will be null
	 */
	@Test
	void testGetAdminByLogin_WrongLogin() {
		Admin testAdmin = testDBMgr.getAdminByLogin("failure");
		assertEquals(testAdmin , null);
	}
	/**
	 * Purpose: excute GetAdminByLogin when connection is null
	 * Input: getAdminByLogin return correspond Admin data using sql Query Login="sgg"
	 * Expected:
	 * 		return Data will be null
	 */
	@Test
	void testGetAdminByLogin_NullConn() {
		testDBMgr.conn = null;
		Admin testAdmin = testDBMgr.getAdminByLogin("sgg");
		assertEquals(testAdmin , null);
	}
	/**
	 * Purpose: using LOGIN , PW to verify member at MEMBERS table
	 * Input: LoginProcess Login Verify Member ID="sgg" , PW = "1234"
	 * Expected:
	 * 		return PASS
	 * 		return LOGIN_SUCESS MESSAGE
	 * 
	 */
	@Test
	void testLoginProcess_LOGIN_SUCESS() {
		assertEquals(testDBMgr.loginProcess("sgg", "1234"), MemberDBMgr.LOGIN_SUCCESS);
	}
	/**
	 * Purpose: using LOGIN , PW to verify member at MEMBERS table
	 * Input: LoginProcess Login Verify Member ID="sgg" , PW = "4321"
	 * Expected:
	 * 		return LOGIN_PW_MISMATCH
	 * 
	 */
	@Test
	void testLoginProcess_PW_MISMATCH() {
		assertEquals(testDBMgr.loginProcess("sgg", "4321"), MemberDBMgr.LOGIN_PW_MISMATCH);
	}
	/**
	 * Purpose: using LOGIN , PW to verify member at MEMBERS table
	 * Input: LoginProcess Login Verify Member ID="abc" , PW = "1234"
	 * Expected:
	 * 		return LOGIN_NOT_FOUND
	 * 
	 */
	@Test
	void testLoginProcess_LOGIN_NOT_FOUND() {
		assertEquals(testDBMgr.loginProcess("abc", "1234"), MemberDBMgr.LOGIN_NOT_FOUND);
	}
	/**
	 * Purpose: using LOGIN , PW to verify member at MEMBERS table
	 * Input: LoginProcess Login Verify Member Null or Empty DATA at LOGIN or PW or conn
	 * Expected:
	 * 		return LOGIN_ERROR
	 */
	@Test
	void testLoginProcess_LOGIN_ERROR() {
		assertEquals(testDBMgr.loginProcess("", "1234"), MemberDBMgr.LOGIN_ERROR);
		assertEquals(testDBMgr.loginProcess("sgg", ""), MemberDBMgr.LOGIN_ERROR);
		assertEquals(testDBMgr.loginProcess(null, "1234"), MemberDBMgr.LOGIN_ERROR);
		assertEquals(testDBMgr.loginProcess("sgg", null), MemberDBMgr.LOGIN_ERROR);
		testDBMgr.conn = null;
		assertEquals(testDBMgr.loginProcess("sgg", "1234"), MemberDBMgr.LOGIN_ERROR);
	}

}
