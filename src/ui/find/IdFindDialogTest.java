/**
 * 
 */
package ui.find;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ui.main.MainFrame;


class IdFindDialogTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private IdFindDialog testIdFindDialog;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testIdFindDialog = new IdFindDialog();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		testIdFindDialog = null;
	}

	/**
	 * Test method for {@link ui.find.IdFindDialog#IdFindDialog()}.
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchFieldException 
	 */
	/**
	 * Purpose: Create btnIdFindFunction
	 * Input: btnIdFindFunction get ID from MEMBER TABLE USING NAME , PHONE
	 * Expected:
	 * 		GOT I Find your ID correspond your name! MEssage
	 */
	@Test
	void testbtnIdFindFunction_Success() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		JButton btnIdFind = new JButton();
		
		Field field = testIdFindDialog.getClass().getDeclaredField("txtName");
		field.setAccessible(true);
		JTextField txtName = (JTextField)field.get(testIdFindDialog);
		txtName.setText("권선근");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPhone");
		field.setAccessible(true);
		JTextField txtPhone = (JTextField)field.get(testIdFindDialog);
		txtPhone.setText("5501");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPhone2");
		field.setAccessible(true);
		JTextField txtPhone2 = (JTextField)field.get(testIdFindDialog);
		txtPhone2.setText("4037");
		
		Method method = testIdFindDialog.getClass().getDeclaredMethod("btnIdFindFunction",JButton.class);
		method.setAccessible(true);
		method.invoke(testIdFindDialog,btnIdFind);
		
		System.setOut(new PrintStream(outputStreamCaptor));
		btnIdFind.doClick();
		assertEquals(outputStreamCaptor.toString(),"회원가입 DB 통신...\r\n" + 
				"입력하신 이름은 권선근\r\n" + 
				"권선근님의 아이디가  있음!\r\n" + 
				"");
	}
	/**
	 * Purpose: Create btnIdFindFunction
	 * Input: btnIdFindFunction get ID from MEMBER TABLE USING WRONG NAME , PHONE
	 * Expected:
	 * 		GOT I CANT Find your ID correspond your name! MEssage
	 */
	@Test
	void testbtnIdFindFunction_fail() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		JButton btnIdFind = new JButton();
		
		Field field = testIdFindDialog.getClass().getDeclaredField("txtName");
		field.setAccessible(true);
		JTextField txtName = (JTextField)field.get(testIdFindDialog);
		txtName.setText("failure");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPhone");
		field.setAccessible(true);
		JTextField txtPhone = (JTextField)field.get(testIdFindDialog);
		txtPhone.setText("5501");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPhone2");
		field.setAccessible(true);
		JTextField txtPhone2 = (JTextField)field.get(testIdFindDialog);
		txtPhone2.setText("4037");
		
		Method method = testIdFindDialog.getClass().getDeclaredMethod("btnIdFindFunction",JButton.class);
		method.setAccessible(true);
		method.invoke(testIdFindDialog,btnIdFind);
		
		System.setOut(new PrintStream(outputStreamCaptor));
		btnIdFind.doClick();
		assertEquals(outputStreamCaptor.toString(),"회원가입 DB 통신...\r\n" + 
				"입력하신 이름은 failure\r\n" + 
				"failure님의 아이디가  없음!\r\n" + 
				"");
	}
	
	/**
	 * Purpose: Create btnPwFindFunction
	 * Input: btnPwFindFunction get PW from MEMBER TABLE USING ID , PHONE
	 * Expected:
	 * 		GOT I Find your PW correspond your ID! MEssage
	 */
	@Test
	void testbtnPwFindFunction_Success() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		JButton btnPwFind = new JButton();
		
		Field field = testIdFindDialog.getClass().getDeclaredField("txtId");
		field.setAccessible(true);
		JTextField txtId = (JTextField)field.get(testIdFindDialog);
		txtId.setText("sgg");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPwPhone2");
		field.setAccessible(true);
		JTextField txtPwPhone2 = (JTextField)field.get(testIdFindDialog);
		txtPwPhone2.setText("5501");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPwPhone3");
		field.setAccessible(true);
		JTextField txtPwPhone3 = (JTextField)field.get(testIdFindDialog);
		txtPwPhone3.setText("4037");
		
		Method method = testIdFindDialog.getClass().getDeclaredMethod("btnPwFindFunction",JButton.class);
		method.setAccessible(true);
		method.invoke(testIdFindDialog, btnPwFind);
		
		System.setOut(new PrintStream(outputStreamCaptor));
		 btnPwFind.doClick();
		assertEquals(outputStreamCaptor.toString(),"입력하신 이름은 sgg\r\n" + 
				"sgg님의 비밀번호가  있음!\r\n" + 
				"");
	}
	/**
	 * Purpose: Create btnPwFindFunction
	 * Input: btnPwFindFunction get PW from MEMBER TABLE USING ID , PHONE
	 * Expected:
	 * 		GOT I Couldnt Find your PW correspond your ID! MEssage then
	 * 		GOT ENTER INPUT DATA PLEASE MEssage
	 */
	@Test
	void testbtnPwFindFunction_fail() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		JButton btnPwFind = new JButton();
		
		Field field = testIdFindDialog.getClass().getDeclaredField("txtId");
		field.setAccessible(true);
		JTextField txtId = (JTextField)field.get(testIdFindDialog);
		txtId.setText("failure");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPwPhone2");
		field.setAccessible(true);
		JTextField txtPwPhone2 = (JTextField)field.get(testIdFindDialog);
		txtPwPhone2.setText("5501");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPwPhone3");
		field.setAccessible(true);
		JTextField txtPwPhone3 = (JTextField)field.get(testIdFindDialog);
		txtPwPhone3.setText("4037");
		
		Method method = testIdFindDialog.getClass().getDeclaredMethod("btnPwFindFunction",JButton.class);
		method.setAccessible(true);
		method.invoke(testIdFindDialog, btnPwFind);
		
		System.setOut(new PrintStream(outputStreamCaptor));
		 btnPwFind.doClick();
		assertEquals(outputStreamCaptor.toString(),"입력하신 이름은 failure\r\n" + 
				"failure님의 비밀번호가  없음!\r\n" + 
				"");
		
		txtId.setText(null);
		outputStreamCaptor.reset();
		System.setOut(new PrintStream(outputStreamCaptor));
		 btnPwFind.doClick();
		assertEquals(outputStreamCaptor.toString(),"입력하신 이름은 \r\n" + 
				"아이디 찾기 입력이 오류\r\n" + 
				"");
	}
	
	/**
	 * Purpose: Create btnCodeFunction
	 * Input: btnCodeFunction SHOW Random number IF name and Phone is not EMPTY
	 * Expected:
	 * 		GOT Random generated Numbers

	@Test
	void testbtnCodeFunction_Success() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		JButton btnCode = new JButton();
		
		Field field = testIdFindDialog.getClass().getDeclaredField("txtName");
		field.setAccessible(true);
		JTextField txtName = (JTextField)field.get(testIdFindDialog);
		txtName.setText(null);
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPhone");
		field.setAccessible(true);
		JTextField txtPhone = (JTextField)field.get(testIdFindDialog);
		txtPhone.setText("5501");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPhone2");
		field.setAccessible(true);
		JTextField txtPhone2 = (JTextField)field.get(testIdFindDialog);
		txtPhone2.setText("4037");
		
		Method method = testIdFindDialog.getClass().getDeclaredMethod("btnCodeFunction",JButton.class);
		method.setAccessible(true);
		method.invoke(testIdFindDialog,btnCode);
		
		System.setOut(new PrintStream(outputStreamCaptor));
		btnCode.doClick();
		assertEquals(outputStreamCaptor.toString(),"회원가입 DB 통신...\r\n" + 
				"입력하신 이름은 failure\r\n" + 
				"failure님의 아이디가  없음!\r\n" + 
				"");
	}
		 */
}
