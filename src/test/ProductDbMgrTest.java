package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import data.Product;
import data.db.ProductDBMgr;

public class ProductDbMgrTest {
	private static ProductDBMgr PdMgr ;
	private int id ;
	private Product pd;

	@BeforeClass
	public static void Setup() {
		PdMgr = new ProductDBMgr();
		
	}
	/*
	 * Purpose: get Product in Products db table  by pdname parameter
	 * Input  : 콜드브루 which in products db, 레드벨벳케익 which does not in products db
 	* Expected : 
 	* 콜드브루 -> return 콜드브루 product 
 	* 레드벨벳케익 -> return null 
 	* */
	@Test
	public void testGetOneProduct() {
		Product pd = PdMgr.getOneProduct("콜드브루");
		assertNotNull(pd);
		pd = PdMgr.getOneProduct("레드벨벳케익");
		assertNull(pd);
	}
	/*
	 * Purpose: get all Products in Products db table 
	 * Input  : 
	 * Expected : 
	 * get all products in Products db table
	 * */
	@Test
	public void testGetAllProducts() {
		ArrayList<Product> pdlist = PdMgr.getAllProducts();
		for(Product pd:pdlist) {
			System.out.println(pd.getId()+pd.getName()+pd.getCategory()+pd.getImagePath()+pd.getPrice()+pd.getHot()+pd.getRegDay());
		}
	}
	/*
	 * Purpose: add product in Products db table 
	 * Input  : ("아이스카페모카","coffee","C:\\Users\\pozxc\\Documents\\git\\starbucks\\starbucks\\images\\menu\\아이스카페모카.jpg",6000,1);
	 * Expected : True
	 * 
	 * */
	@Test
	public void testAddNewOneProduct() {
		pd = new Product("아이스카페모카","coffee","C:\\Users\\pozxc\\Documents\\git\\starbucks\\starbucks\\images\\menu\\아이스카페모카.jpg",6000,1);
		id = pd.getId();
		boolean boolForTest = PdMgr.addNewOneProduct(pd);
		assertTrue(boolForTest);
	}
	/*
	 * Purpose: add product in Products db table 
	 * Input  : ("아이스카페모카","coffee","C:\\Users\\pozxc\\Documents\\git\\starbucks\\starbucks\\images\\menu\\아이스카페모카.jpg",6000,1);
	 * Expected : True
	 * */
	@Test
	public void testEditOneProduct() {
		pd.setPrice(6600);
		boolean boolForTest = PdMgr.editOneProduct(pd);
		assertTrue(boolForTest);
	}
	/*
	 * Purpose: delete product in Products db table by product id and name.
	 * Input  : (2,"콜드브루")
	 *  Expected : True
	 * */
	@Test
	public void testDeleteOneProdcut() {
		int intforTest = PdMgr.deleteOneProdcut(1, "아이스카페모카");
		assertEquals(intforTest,1);
	}
	/*
	 * Purpose: get all products. products format is category, product. category is {coffee,desert...}
	 * Input  : 
	 *  Expected :
	 * */
	@Test
	public void testGetProductsByType() {
		HashMap<Integer, ArrayList<Product>> Hmap = PdMgr.getProductsByType();
		Hmap.forEach((key, pdlist)->{
			for(Product pd: pdlist)
				System.out.println(pd.getId()+pd.getName()+pd.getCategory()+pd.getImagePath()+pd.getPrice()+pd.getHot()+pd.getRegDay());
		});
	}
	

}
