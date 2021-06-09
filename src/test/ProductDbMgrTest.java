package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import data.Product;
import data.db.ProductDBMgr;

public class ProductDbMgrTest {
	private static ProductDBMgr PdMgr ;

	@BeforeClass
	public static void Setup() {
		PdMgr = new ProductDBMgr();
	}
/*
 * Purpose: get Product in Products db table  by pdname parameter
 * Input  : �ݵ��� which in products db, ���座������ which does not in products db
 * Expected : 
 * �ݵ��� -> return �ݵ��� product 
 * ���座������ -> return null 
 * */
	@Test
	public void testGetOneProduct() {
		Product pd = PdMgr.getOneProduct("�ݵ���");
		assertNotNull(pd);
		pd = PdMgr.getOneProduct("���座������");
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

	@Test
	public void testAddNewOneProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditOneProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOneProdcut() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProductsByType() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
