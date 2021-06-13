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
	 * Input  : 콜드브루 which in products db, 레드벨벳케익 which does not in products db
	 * Expected : 
	 * 콜드브루 -> return 콜드브루 product 
	 * 레드벨벳케익 -> return null 
	 * */
	@Test
	public void testsetBtnProductRemove() {
		fail("Not yet implemented");
	}

}
