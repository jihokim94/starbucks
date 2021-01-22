package menu.basket;

import javax.swing.JPanel;

import data.Product;
import menu.basket.components.OrderCount;
import menu.main.MainMenuFrame;
import menu.main.components.BasketContainer;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasketPanel extends JPanel
{
	public MainMenuFrame frm;
	public Product product;
	public OrderCount pnOC;

	public JLabel lbPrice;
	JLabel lbCancle;
	BasketPanel bkPn;

	/**
	 * Create the panel.
	 */
	public BasketPanel(MainMenuFrame frm, Product pr, int amount)
	{
		bkPn = this;
		this.frm = frm;
		
		BevelBorder b4 = new BevelBorder(BevelBorder.RAISED);
		setBorder(b4);
		
		this.product = pr;
		setSize(600, 80);
		setLayout(new BorderLayout(0, 0));
		
		setOpaque(true);
		setBackground(Color.white);
		

		JLabel lbPrName = new JLabel();
		lbPrName.setHorizontalAlignment(SwingConstants.CENTER);
		lbPrName.setPreferredSize(new Dimension(200, 80));
		lbPrName.setText(product.getName());
		add(lbPrName, BorderLayout.WEST);

		pnOC = new OrderCount(frm, pr);
		pnOC.setBackground(Color.WHITE);
		pnOC.txtVal.setText("" + amount);

		pnOC.setMaximumSize(new Dimension(200, 80));
		pnOC.setPreferredSize(new Dimension(200, 80));
		add(pnOC, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(true);
		panel_1.setBackground(Color.white);
		panel_1.setPreferredSize(new Dimension(200, 80));
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));

		lbPrice = new JLabel();
		lbPrice.setBackground(Color.WHITE);
		lbPrice.setText("" + pr.getPrice() * amount + "원");

		lbPrice.setMaximumSize(new Dimension(120, 80));
		lbPrice.setMinimumSize(new Dimension(120, 80));
		lbPrice.setSize(new Dimension(120, 80));
		lbPrice.setSize(100, 80);
		lbPrice.setFont(new Font("HY강M", Font.BOLD, 16));
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbPrice, BorderLayout.CENTER);

		lbCancle = new JLabel("x\r\n");
		lbCancle.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				boolean b = BasketContainer.removeOneProduct(frm, pr);
				if (b == false)
					System.out.println("삭제 실패");
				BasketContainer.updateTotalPrice(frm);
			}
		});
		lbCancle.setSize(new Dimension(80, 80));
		lbCancle.setPreferredSize(new Dimension(80, 80));
		lbCancle.setFont(new Font("굴림", Font.BOLD, 50));
		lbCancle.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbCancle, BorderLayout.EAST);
	}

}