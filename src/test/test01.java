
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import data.order;
import data.db.OrderDBMgr;

class test01 {
	OrderDBMgr mgr = new OrderDBMgr();
	Connection conn;
	
	int ORDER_REQUEST = 1;
	int ORDER_PREPARE = 2;
	int ORDER_FINISHED = 3;
	int id_1 = 0; // ������ȣ <pk>
	String orderNumber_1 = "SB13123A12"; //  �ֹ� ��ȣ  ���Ƿ� �ຸ��~
	String memberLogin_1 = "kj941225"; // �ֹ���  <pk> -> <fk>
	String productName_1 = "latte"; // �ֹ� ��ǰ �̸�  <pk> -> <fk>
	int quantity_1 = 1; // ����
	int totalPrice_1 = 4000; // �Ѱ���
	Date orderedTime_1; // �ֹ� �ð�
	int orderStatus_1 = 1;// �ֹ�����
	int id_2 = 1;
	String orderNumber_2 = "SB12345678";
	String memberLogin_2 = "hw123456";
	String productName_2 = "coffee";
	int quantity_2 = 2;
	int totalPrice_2 = 7000;
	Date orderedTime_2;
	int orderStatus_2 = 1;
	
	
	public void beginConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "STARBUCKS";
		String password = "1234";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("����̹� ���� ����!! ");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ���� ����!! ");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB ���� ���� �Ǵ� ��� ����");

			e.printStackTrace();
		}

	}


	public void addOneOrder_1() { 
		if(conn!= null) {
			String sql = "insert into STARBUCKS.orders values(ORDERS_SEQ.nextval, 'SB13123A12','kj941225','latte', 1, 4000, '2021-06-09', 1)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);			
				int r = pstmt.executeUpdate();
				if(r==1) {
					System.out.println("�ֹ� db���� ����");
				}else {
					System.out.println("db ���� ����");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("����̹� Ȯ���ʿ�");
		}
	}
	
	public void addOneOrder_2() { 
		if(conn!= null) {
			String sql = "insert into STARBUCKS.orders values(ORDERS_SEQ.nextval, 'SB12345678','hw123456','coffee', 2, 7000, sysdate, 1 )";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);			
				int r = pstmt.executeUpdate();
				if(r==1) {
					System.out.println("�ֹ� db���� ����");
				}else {
					System.out.println("db ���� ����");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			System.out.println("����̹� Ȯ���ʿ�");
		}
	}
	
//	private String grn() {
//		final String  datas= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		String pdNumber = "SB"; // family cafe.
//		for (int i = 0; i < 8; i++) {
//			char a = datas.charAt(
//					(int)(Math.random()*datas.length())); // 0~z���� 8�� ���Ƽ� sb�� ���̱� 
//			pdNumber += a;
//		} 
//		return pdNumber;
//	}

	@Test
	void testGetSelectedOrders(){
		beginConnection();
		addOneOrder_1();
		addOneOrder_2();      
		String what = "2021-06-09";
	    orderedTime_1 = Date.valueOf(what);
	    orderedTime_2 = Date.valueOf(what);
		ArrayList<order> odList_1 = new ArrayList<order>();
		order od = new order(id_1, orderNumber_1, memberLogin_1, productName_1, quantity_1, totalPrice_1, orderedTime_1, orderStatus_1);
		odList_1.add(od);
		ArrayList<order> list_1 = mgr.getSelectedOrders(orderNumber_1);
		assertSame(odList_1, list_1);
    }
	
	@Test
	void testGetAllOrders() {
		ArrayList<order> odList_2 = new ArrayList<order>();
		order od_1 = new order(id_1, orderNumber_1, memberLogin_1, productName_1, quantity_1, totalPrice_1, orderedTime_1, orderStatus_1);
		order od_2 = new order(id_2, orderNumber_2, memberLogin_2, productName_2, quantity_2, totalPrice_2, orderedTime_2, orderStatus_2);
		odList_2.add(od_1);
		odList_2.add(od_2);
		ArrayList<order> list_2 = mgr.getAllOrders();
		assertSame(odList_2, list_2);
	}
	
	@Test
	void testEditOrderStatus() {
        boolean b = mgr.editOrderStatus(orderNumber_1 ,ORDER_FINISHED);
        assertTrue(b);
	}
}
