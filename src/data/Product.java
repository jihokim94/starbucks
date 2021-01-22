package data;

import java.awt.Color;
import java.util.Date;

public class Product {
	
	private int id; // 관리번호 <<PK>>
	private String name;// 이름  <<UQ>>
	private String category;// 카테고리  coffee/beverage/salad/dessert
	private String imagePath;// 사진파일경로
	private int price;// 가격
	private int hot; // hot/ice
	private Date regDay;// 출시일

	public static final String DEF_NAME = "NOT AVAILABLE";
	public static final int DEF_PRICE = 0;
	public static final String DEF_IMAGE = "sample.png";
	public static final int NO_TEMPERATURE_SELECT = 3;
	
	public static final String[] CATEGORY = {"Coffee", "Beverage", "Salad", "Dessert"};
	public static final Color STARBUCKS_GREEN = new Color(0, 122, 74);
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(String name, String category, String imagePath, int price, int hot) {
		this(0, name, category, imagePath, price, hot, new Date());
	}


	public Product(int id, String name, String category, String imagePath, int price, int hot, Date regDay) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.imagePath = imagePath;
		this.price = price;
		this.hot = hot;
		this.regDay = regDay;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getHot() {
		return hot;
	}


	public void setHot(int hot) {
		this.hot = hot;
	}


	public Date getRegDay() {
		return regDay;
	}


	public void setRegDay(Date regDay) {
		this.regDay = regDay;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", imagePath=" + imagePath
				+ ", price=" + price + ", hot=" + hot + ", regDay=" + regDay + "]";
	}


	
	
}
