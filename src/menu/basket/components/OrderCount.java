package menu.basket.components;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import data.Product;
import menu.basket.BasketDialog;
import menu.basket.BasketPanel;
import menu.main.MainMenuFrame;
import menu.main.components.BasketContainer;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class OrderCount extends JPanel
{
	public JTextField txtVal;
	public JLabel lbPlus;
	public JLabel lbMinus;
	
	Product pr;
	
	OrderCount oc;

	/**
	 * Create the panel.
	 */
	public OrderCount(MainMenuFrame frm, Product pr)
	{
		this.pr = pr;
		oc = this;
		setSize(new Dimension(300, 80));
		setLayout(new GridLayout(0, 3, 0, 0));
		
		int p = pr.getPrice();
		
		lbMinus = new JLabel("-");
		lbMinus.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if (Integer.valueOf(txtVal.getText()) > 1)
				{
					txtVal.setText(""+ (Integer.valueOf(txtVal.getText()) - 1));
					int a = Integer.valueOf(txtVal.getText());
					int nPrice = p * a;
					
					ArrayList<BasketPanel> bkList = BasketContainer.bkList;
					for (BasketPanel bk : bkList)
					{
						if (bk.product.equals(pr))
						{
							bk.lbPrice.setText(""+nPrice+ "¿ø");
							BasketContainer.bkMap.replace(bk.product, a);
							break;
						}
					}
					BasketContainer.updateTotalPrice(frm);
				}
			}
		});
		lbMinus.setHorizontalAlignment(SwingConstants.CENTER);
		lbMinus.setFont(new Font("±¼¸²", Font.PLAIN, 50));
		add(lbMinus);

		txtVal = new JTextField();
		txtVal.setOpaque(true);
		txtVal.setBackground(Color.white);
			
		txtVal.setText("" + 1);
		txtVal.setHorizontalAlignment(SwingConstants.CENTER);
		txtVal.setFont(new Font("Arial", Font.PLAIN, 35));
		txtVal.setEditable(false);
		txtVal.setColumns(10);
		add(txtVal);
		
		lbPlus = new JLabel("+");
		lbPlus.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				txtVal.setText(""+ (Integer.valueOf(txtVal.getText()) + 1));
				int a = Integer.valueOf(txtVal.getText());
				int nPrice = p * a;
				
				ArrayList<BasketPanel> bkList = BasketContainer.bkList;
				for (BasketPanel bk : bkList)
				{
					if (bk.product.equals(pr))
					{
						bk.lbPrice.setText(""+nPrice+ "¿ø");
						BasketContainer.bkMap.replace(bk.product, a);
						break;
					}
				}
				BasketContainer.updateTotalPrice(frm);
			}
		});
		lbPlus.setHorizontalAlignment(SwingConstants.CENTER);
		lbPlus.setFont(new Font("±¼¸²", Font.PLAIN, 50));
		add(lbPlus);
	}

	
	
	

}