package test;

import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

import ui.admin.ProductInfo;

public class productinfoTest {
	@BeforeClass
	public static void Setup() {
		ProductInfo pdInfo = new ProductInfo();
		pdInfo.setVisible(true);
		
	}
	/*
	 * Purpose: get Product in Products db table  by pdname parameter
	 * Input  : �ݵ��� which in products db, ���座������ which does not in products db
	 * Expected : 
	 * �ݵ��� -> return �ݵ��� product 
	 * ���座������ -> return null 
	 * */
	@Test
	public void testsetBtnProductRemove() {
		fail("Not yet implemented");
	}

}
