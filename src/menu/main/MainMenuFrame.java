package menu.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import data.Basket;
import data.Product;
import data.order;
import menu.main.components.BasketContainer;
import menu.main.components.CategoryPanel;
import menu.main.components.MenuPanel;
import ui.admin.OrderSheetDialog;
import ui.payment.paymentWindow;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class MainMenuFrame extends JFrame
{
	private JPanel contentPane;

	public JPanel pnCategory;
	public MenuPanel pnMenu;
	public BasketContainer pnBasket;
	public JPanel pnLogo;
	public JPanel pnBtn;
	public JLabel lbTotalMoney;
	public JLabel lbTitle;
	public JLabel lbLeft;
	public JLabel lbRight;
	public CategoryPanel pnType;

//	public Basket bk;
	private JPanel pnGroup1;
	private JPanel pnGroup2;
	private JPanel pnPayment;
	private JButton btnPay;
	private JPanel panel;
	private JLabel lbDummy;

	MainMenuFrame frm;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					MainMenuFrame frame = new MainMenuFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenuFrame()
	{
		frm = this;

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(20, 20, 630, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		pnGroup1 = new JPanel();
		pnGroup1.setLayout(new BorderLayout(0, 0));

		pnCategory = new JPanel();
		pnCategory.setBackground(Color.ORANGE);
		pnCategory.setPreferredSize(new Dimension(630, 150));

		pnGroup1.add(pnCategory, BorderLayout.NORTH);
		pnCategory.setLayout(new BorderLayout(0, 0));

		pnLogo = new JPanel();
		pnLogo.setPreferredSize(new Dimension(630, 80));
		pnLogo.setBackground(data.Product.STARBUCKS_GREEN);
		pnCategory.add(pnLogo, BorderLayout.NORTH);

		ImageIcon icon = new ImageIcon("C:\\dev2020\\java_ws\\MyProjectPart\\images\\logo\\\uB85C\uACE0(\uACE0\uD574\uC0C1\uB3C4).png");
		Image sca = icon.getImage().getScaledInstance(75, 75, Image.SCALE_FAST);
		icon.setImage(sca);
		pnLogo.setLayout(new BorderLayout(0, 0));

		lbTitle = new JLabel("Starbucks");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Arial", Font.BOLD, 40));
		pnLogo.add(lbTitle);

		pnBtn = new JPanel();
		pnCategory.add(pnBtn, BorderLayout.CENTER);
		pnBtn.setLayout(new BorderLayout(0, 0));

//		lbLeft = new JLabel("<<<");
//		lbLeft.addMouseListener(new MouseAdapter()
//		{
//			@Override
//			public void mouseClicked(MouseEvent e)
//			{
//				lbLeft.addMouseListener(cm);
////				frm.pnBtn;
//			}
//		});
//		lbLeft.setOpaque(true);
//		lbLeft.setHorizontalAlignment(SwingConstants.CENTER);
//		lbLeft.setPreferredSize(new Dimension(72, 70));
//		lbLeft.setForeground(Color.white);
//		lbLeft.setBackground(data.Product.STARBUCKS_GREEN);
//		pnBtn.add(lbLeft, BorderLayout.WEST);

		pnType = new CategoryPanel(this);
//		pnType.setPreferredSize(new Dimension(400, 75));
		pnBtn.add(pnType, BorderLayout.CENTER);

//		lbRight = new JLabel(">>>");
//		lbRight.addMouseListener(new MouseAdapter()
//		{
//			@Override
//			public void mouseClicked(MouseEvent e)
//			{
//				lbRight.addMouseListener(cm);
//			}
//		});
//		lbRight.setOpaque(true);
//		lbRight.setHorizontalAlignment(SwingConstants.CENTER);
//		lbRight.setPreferredSize(new Dimension(72, 70));
//		lbRight.setForeground(Color.white);
//		lbRight.setBackground(data.Product.STARBUCKS_GREEN);
//		pnBtn.add(lbRight, BorderLayout.EAST);

		pnMenu = new MenuPanel(this);
		pnMenu.setPreferredSize(new Dimension(630, 500));
		pnMenu.setBackground(Color.WHITE);
		pnGroup1.add(pnMenu, BorderLayout.CENTER);

		contentPane.add(pnGroup1, BorderLayout.NORTH);

		pnGroup2 = new JPanel();
		pnGroup2.setLayout(new BorderLayout(0, 0));

		pnBasket = new BasketContainer(this);
		pnBasket.setBackground(Color.WHITE);
		pnBasket.setPreferredSize(new Dimension(630, 250));
		pnGroup2.add(pnBasket, BorderLayout.NORTH);

		contentPane.add(pnGroup2, BorderLayout.CENTER);

		pnPayment = new JPanel();
		pnPayment.setPreferredSize(new Dimension(630, 70));
		pnGroup2.add(pnPayment, BorderLayout.SOUTH);
		pnPayment.setLayout(new BorderLayout(0, 0));

		btnPay = new JButton("     \uACB0\uC81C");
		btnPay.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				paymentWindow m = new paymentWindow();
				m.setVisible(true);
			}
		});

		btnPay.setFont(new Font("±¼¸²", Font.BOLD, 15));
		ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\MyProjectPart\\images\\logo\\credit_card.png");

		Image scaled = ic.getImage().getScaledInstance(25, 25, Image.SCALE_FAST);
		ic.setImage(scaled);
		btnPay.setIcon(ic);
		btnPay.setForeground(Color.WHITE);
		btnPay.setBackground(Product.STARBUCKS_GREEN);
		btnPay.setPreferredSize(new Dimension(150, 75));
		pnPayment.add(btnPay, BorderLayout.EAST);

		panel = new JPanel();
		pnPayment.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(1, 2, 0, 0));
		

		lbDummy = new JLabel("\uCD1D \uACB0\uC81C \uAE08\uC561");
		lbDummy.setOpaque(true);
		lbDummy.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lbDummy.setHorizontalAlignment(SwingConstants.CENTER);
		lbDummy.setForeground(Color.WHITE);
		lbDummy.setBackground(Product.STARBUCKS_GREEN);
		panel.add(lbDummy);

		lbTotalMoney = new JLabel("0");
		lbTotalMoney.setForeground(Color.WHITE);
		lbTotalMoney.setOpaque(true);
		lbTotalMoney.setBackground(Product.STARBUCKS_GREEN);
		lbTotalMoney.setFont(new Font("±¼¸²", Font.BOLD, 25));
		lbTotalMoney.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbTotalMoney);

	}

}