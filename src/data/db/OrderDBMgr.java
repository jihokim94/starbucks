package data.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import data.Product;
import data.order;
import menu.basket.BasketPanel;
import menu.main.components.BasketContainer;
import util.db.OracleDBUtil;

public class OrderDBMgr {
	
	Connection conn;
	ProductDBMgr mgr ;
	
	
	public OrderDBMgr() {
		this.mgr=new ProductDBMgr();;
		this.conn = OracleDBUtil.getConn();
	}

	
	public boolean addOneOrder(BasketPanel basketPanel ,String orderNumber,String memberLogin) { 
		BasketPanel bp = basketPanel;
		String pdName = bp.product.getName();
		int pdPrice = bp.product.getPrice();
		int quantity = Integer.parseInt(bp.pnOC.txtVal.getText());
		int totalPrice = pdPrice * quantity;
		if(conn!= null) {
//			String sql = "insert into orders values(ORDERS_SEQ.nextval, SB13123A12,'kj941225','에스프레소',1,4000,SYSDATE )";
			String sql = "insert into orders values(ORDERS_SEQ.nextval,?,?,?,?,?,sysdate,1)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, orderNumber);
				pstmt.setString(2, memberLogin);
				pstmt.setString(3, pdName);
				pstmt.setInt(4, quantity);
				pstmt.setInt(5, totalPrice);
				
				int r = pstmt.executeUpdate();
				if(r==1) {
					System.out.println("주문 db저장 성공");
					return true;
				}else {
					System.out.println("db 저장 실패");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else {
			System.out.println("드라이버 확인필요");
		}
			
		return false;
	
		
	}
	public ArrayList<order> getSelectedOrders(String orderNumber){
		if(conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from orders where order_number = '"+orderNumber+"'";
				ResultSet rs = stmt.executeQuery(sql);
				ArrayList<order> odList = new ArrayList<order>();
				while(rs.next()) {
					 int id =rs.getInt("id");
					 String memberLogin = rs.getString("member_login");
					 String productName = rs.getString("product_name") ;
					 int quantity = rs.getInt("quantity");
					 int totalPrice =rs.getInt("total_price");
					 Date orderedTime= rs.getDate("ordered_time");
					 int orderStatus = rs.getInt("order_status");
					 
					 order od = new order(id, orderNumber, memberLogin, productName, quantity, totalPrice, orderedTime, orderStatus);
					 odList.add(od);
				}
				return odList;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else {
			System.out.println("드라이버 커넥션확인");
		}
		
		return null;
		
	}
	public ArrayList<order> getAllOrders(){// 김지호
		if(conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from orders order by ordered_time desc";
				ResultSet rs = stmt.executeQuery(sql);
				ArrayList<order> odList = new ArrayList<order>();
				while(rs.next()) {
					 int id =rs.getInt("id");
					 String orderNumber =rs.getString("order_number");
					 String memberLogin = rs.getString("member_login");
					 String productName = rs.getString("product_name") ;
					 int quantity = rs.getInt("quantity");
					 int totalPrice =rs.getInt("total_price");
					 Date orderedTime= rs.getDate("ordered_time");
					 int orderStatus = rs.getInt("order_status");
					 
					 order od = new order(id, orderNumber, memberLogin, productName, quantity, totalPrice, orderedTime, orderStatus);
					 odList.add(od);
				}
				return odList;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}else {
			System.out.println("드라이버 커넥션확인");
		}
		
		return null;
		
	}
	//주문번호로 주문상태 수정
	public boolean editOrderStatus(String orderNumber ,int statusNumber) {
		if(conn != null) {
			try {
				String sql = "update orders set order_status =? where order_number= ?";
							
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, statusNumber);
				pstmt.setString(2, orderNumber);
				
				int r =pstmt.executeUpdate();
				if(r >=1) { // 주문이 여러개일 수도 있으니 r은 1이상 리턴받을수있음
					System.out.println("주문 받기 성공 ");
					return true;
				}else {
					System.out.println(r);
					System.out.println("주문 받기 실패 ");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("드라이버 연결 확인필요");
		}
		
		return false;
		
	}

	
}
