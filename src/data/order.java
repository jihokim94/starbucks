package data;

import java.util.Date;

public class order {
	private int id; // 관리번호 <pk>
	private String orderNumber; //  주문 번호  임의로 줘보자~
	private String memberLogin; // 주문자  <pk> -> <fk>
	private String productName; // 주문 상품 이름  <pk> -> <fk>
	private int quantity; // 수량
	private int totalPrice; // 총가격
	private Date orderedTime; // 주문 시간
	private int orderStatus;// 주문상태
	
	public static final int ORDER_REQUEST =1;
	public static final int ORDER_PREPARE =2;
	public static final int ORDER_FINISHED =3;
	@Override
	public String toString() {
		return "order [id=" + id + ", orderNumber=" + orderNumber + ", memberLogin=" + memberLogin + ", productName="
				+ productName + ", quantity=" + quantity + ", totalPrice=" + totalPrice + ", orderedTime=" + orderedTime
				+ ", orderStatus=" + orderStatus + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getMemberLogin() {
		return memberLogin;
	}
	public void setMemberLogin(String memberLogin) {
		this.memberLogin = memberLogin;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getOrderedTime() {
		return orderedTime;
	}
	public void setOrderedTime(Date orderedTime) {
		this.orderedTime = orderedTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public order() {
		// TODO Auto-generated constructor stub
	}
	public order(int id, String orderNumber, String memberLogin, String productName, int quantity, int totalPrice,
			Date orderedTime, int orderStatus) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.memberLogin = memberLogin;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderedTime = orderedTime;
		this.orderStatus = orderStatus;
	}
	
	
	
	
	
	
	
	
}

	