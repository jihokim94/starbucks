package menu.main.components;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import data.Product;
import menu.main.MainMenuFrame;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategoryPanel extends JPanel
{	
	public final ButtonGroup btnGroup = new ButtonGroup();
	public JButton btn;
	
	MainMenuFrame frm;
	
	/**
	 * Create the panel.
	 */
	public CategoryPanel(MainMenuFrame frm)
	{
		this.frm = frm;
		setSize(630, 70);
		setLayout(new GridLayout(0, 4, 0, 0));
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		InvertColor ic = new InvertColor();
		changeCard cc = new changeCard();
		
		for (int i = 0; i < Product.CATEGORY.length; i++)
		{
			btn = new JButton(Product.CATEGORY[i]);
			btn.setBorder(emptyBorder);
			btn.setOpaque(true);
			btn.setForeground(Color.white);
			btn.setBackground(data.Product.STARBUCKS_GREEN);
			btn.setPreferredSize(new Dimension(630/4, 70));
			btn.setText(Product.CATEGORY[i]);
			btn.setHorizontalAlignment(SwingConstants.CENTER);
			btn.addFocusListener(ic);
			btn.addMouseListener(cc);
			btnGroup.add(btn);
			this.add(btn);
		}
	}
	
	
	public class InvertColor extends FocusAdapter
	{
		public InvertColor() {}

		@Override
		public void focusGained(FocusEvent e)
		{
			JButton btn = (JButton) e.getSource();
			btn.setForeground(data.Product.STARBUCKS_GREEN);
			btn.setBackground(Color.white);
		}

		@Override
		public void focusLost(FocusEvent e)
		{
			JButton btn = (JButton) e.getSource();
			btn.setForeground(Color.white);
			btn.setBackground(data.Product.STARBUCKS_GREEN);
		}
		
	}
	
	public class changeCard extends MouseAdapter
	{
		
		public changeCard() {}

		@Override
		public void mouseClicked(MouseEvent e)
		{
			CardLayout card = frm.pnMenu.card;
			JPanel pnCard = frm.pnMenu.pnCard;
			JButton btn = (JButton) e.getSource();
			String category = btn.getText();
			
			card.show(pnCard, category);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}