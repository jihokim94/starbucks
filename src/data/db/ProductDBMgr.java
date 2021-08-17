package data.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import data.Member;
import data.Product;

import util.db.OracleDBUtil;


public class ProductDBMgr {
	
	Connection conn ; 
	
	public ProductDBMgr() {
		this.conn = OracleDBUtil.getConn();
		
	}
	 
	public Product getOneProduct(String pdname){
		Product pd = new Product();
		if( pdname == null || pdname.isEmpty() ) {
			System.out.println("pdname �Է��� ����!");
			return null;
		}
		if(conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from products where name = '"+pdname+"'";
				ResultSet rs  = stmt.executeQuery(sql);
				
				while(rs.next()) {
					 int id = rs.getInt("id");
					 String name =rs.getString("name");
					 String category =rs.getString("category");
					 String imagePath =rs.getString("image_Path");
					 int price= rs.getInt("price");
					 int hot = rs.getInt("hot");
					 Date regDay=rs.getDate("reg_Day");
					 pd = new Product(id, name, category, imagePath, price, hot, regDay);
					
				}
				return pd;
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		}else {
			System.out.println("��ſ��� !! ");
		}
		return null;
		
		
	}
	
	//��ü ��ǰ���� ����� �� �ִ�
	public ArrayList<Product> getAllProducts(){
		ArrayList<Product> pdList = new ArrayList<>();
		
		if(conn != null) {
			try {
				Statement stmt = conn.createStatement();
				String sql = "select * from products";
				ResultSet rs  = stmt.executeQuery(sql);
				
				while(rs.next()) {
					 int id = rs.getInt("id");
					 String name =rs.getString("name");
					 String category =rs.getString("category");
					 String imagePath =rs.getString("image_Path");
					 int price= rs.getInt("price");
					 int hot = rs.getInt("hot");
					 Date regDay=rs.getDate("reg_Day");
					 Product pd = new Product(id, name, category, imagePath, price, hot, regDay);
					 pdList.add(pd);
				}
				return pdList;
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		}else {
			System.out.println("��ſ��� !! ");
		}
		return null;
		
		
	}
	
	//��ǰ �ϳ��� �߰� �� �� �ִ�.
	// ����/������ �ű� �����ϳ��� �߰��� �� �ִ�.
		public boolean addNewOneProduct(Product pd) {		
			if( conn != null && pd != null ) {
				String sql = "insert into products values("
						+ "PRODUCTS_SEQ.nextval, "
						+ "?,?,?,?,?, sysdate)";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, pd.getName());
					pstmt.setString(2, pd.getCategory());
					pstmt.setString(3, pd.getImagePath());
					pstmt.setInt(4, pd.getPrice());
					pstmt.setInt(5, pd.getHot());
					
				
					int r = pstmt.executeUpdate();
					if( r == 1 ) {
						System.out.println(pd.getName()+" ���ο� �޴� DB �߰� ����");
						return true;
					} else {
						System.out.println(pd.getName()+"���ο� �޴� DB �߰� ����");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
			return false;
		}
		
	
	// ȸ�� ���� �� �� �ִ�
	
	//   ��ǰ�� ���� �� �� �ִ�.  id �º��� �Ұ�, ����������!! 
		public boolean editOneProduct(Product pd) {
			if(conn != null) {
				try {
					String sql = "update products set name= ?, category= ?"+ ", image_path =?, price = ?, hot = ?" 
								+"  where id = ?";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,  pd.getName());
					pstmt.setString(2,  pd.getCategory());
					pstmt.setString(3,  pd.getImagePath());
					pstmt.setInt(4,  pd.getPrice());
					pstmt.setInt(5,  pd.getHot());
					pstmt.setInt(6,  pd.getId());
					
					
					int r =pstmt.executeUpdate();
					if(r == 1) {
						System.out.println("ȸ�� ���� ���� ");
						return true;
					}else {
						System.out.println("ȸ�� ���� ����");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				System.out.println("����̹� ���� ����");
			}
			
			return false;
			
		}
	
	
	
	
		public int deleteOneProdcut(int id, String name) {
			
			if(conn !=null) {
				String sql ="delete from products where id = ? and  name =? ";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, id);
					pstmt.setString(2, name);
				int r=	pstmt.executeUpdate();
				if(r == 1) {
					System.out.println(name + "��ǰ ���� ���� ");
					return r;
				}else {
					System.out.println(name + "��ǰ ���� ����");
				}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				System.out.println("��Ż��� �ҷ�");
			}
			return 0;
			
		}

		// Ÿ���� key, List<�ش� Ÿ�� pr �� value��
		public HashMap<Integer, ArrayList<Product>> getProductsByType()
		{
			HashMap<Integer, ArrayList<Product>> prMap = new HashMap<>();

			if (conn != null)
			{	
				try
				{
					for (int i = 0; i < Product.CATEGORY.length; i++)
					{
						ArrayList<Product> tempList = new ArrayList<>();
						String category = Product.CATEGORY[i];
						String sql = "select * from products where category = '"+ category +"'";
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(sql);
						
						
						while (rs.next())
						{
							int id = rs.getInt("ID");
							String name = rs.getString("NAME");
							String imagePath = rs.getString("IMAGE_PATH");
							int price = rs.getInt("PRICE");
							int hot = rs.getInt("HOT");
							Date regDay = rs.getDate("reg_day");
							
							Product pr = new Product(id, name, category, imagePath, price, hot, regDay);
							tempList.add(pr);
						}
						prMap.put(i, tempList);
					}
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			return prMap;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	


	

	

}
