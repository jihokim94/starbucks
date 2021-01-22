package menu.main.components;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

import data.Product;
import menu.basket.BasketPanel;
import menu.main.MainMenuFrame;

import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class BasketContainer extends JPanel
{
	public MainMenuFrame frm;
	public JPanel pnVP;
	public JScrollPane scrollPane;
	
	
	public static HashMap<Product, Integer> bkMap = new HashMap<>(); // 상품, 수량
	public static ArrayList<BasketPanel> bkList = new ArrayList<>(); 
	
	/**
	 * Create the panel.
	 */
	
	public BasketContainer(MainMenuFrame frm)
	{
		
		this.frm = frm;
		setSize(600, 250);
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		add(scrollPane, BorderLayout.CENTER);

		pnVP = new JPanel();
		pnVP.setOpaque(true);
		pnVP.setBackground(Color.white);
		pnVP.setMaximumSize(new Dimension(600, 32767));
		scrollPane.setViewportView(pnVP);
		FlowLayout fl_pnVP = new FlowLayout();
		fl_pnVP.setVgap(0);
		fl_pnVP.setHgap(0);
		pnVP.setLayout(fl_pnVP);
		
		
	}
	// 총가격 업데이트
	public static void updateTotalPrice(MainMenuFrame frm)
	{
		int tPrice = 0;
		
		Iterator<Product> products =  bkMap.keySet().iterator();
		
		while (products.hasNext())
		{
			Product pr = products.next();
			int p = pr.getPrice();
			int a = bkMap.get(pr);
			tPrice += p * a;

			for (BasketPanel bk : bkList)
			{
				if (bk.product.equals(pr))
				{
					bk.lbPrice.setText(pr.getPrice() * Integer.valueOf(bk.pnOC.txtVal.getText()) + "원");
				}
			}
		}
		frm.lbTotalMoney.setText(tPrice + "원");
	}
	
	// 해당 basketPanel 삭제후 다시 추가
	public static boolean removeOneProduct(MainMenuFrame frm, Product product)
	{
		
		Component[] pnList = frm.pnBasket.pnVP.getComponents();
		int vert = bkMap.size() - 1; 
		
		for (Component c : pnList)
		{
			BasketPanel pn = (BasketPanel) c;
			
			if (pn.product.equals(product))
			{
				frm.pnBasket.pnVP.remove(pn);
				bkMap.remove(product);
				bkList.remove(pn);
				frm.pnBasket.pnVP.setPreferredSize(new Dimension(600, 100 * vert));
				frm.pnBasket.pnVP.repaint();
				frm.pnBasket.pnVP.revalidate();
				return true;
			}
		}
		return false;
	}
	
	// 장바구니에 추가
	public boolean addProductToBasket(Product pr, int amount)
	{
		if (pr == null)
			return false;
		
		JPanel pn = frm.pnBasket.pnVP;
		Product key = pr;
		int value = amount;
		int vert = bkMap.size() + 1;  
		
		if (bkMap.containsKey(key))
		{
			for (BasketPanel pnBasket : bkList)
			{
				if (pnBasket.product.equals(pr))
					pnBasket.pnOC.txtVal.setText("" + value );
			}
			bkMap.replace(key, value);
			return true;
		}
		if (bkMap.containsKey(key) == false)
		{
			BasketPanel pnBk = new BasketPanel(frm, pr, amount);
			pn.add(pnBk);
			pn.setPreferredSize(new Dimension(600, 100 * vert));
			pn.revalidate();
			bkMap.put(key, value);
			bkList.add(pnBk);
			return true;
		}
		return false;
	}
	
	
	
		

	
}