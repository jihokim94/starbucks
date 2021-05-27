package ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import adminFactory_jy.JButtonCreator;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;

public class adminMain extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminMain frame = new adminMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 * 
	 */
	public adminMain() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(50x50).jpg"));
		setTitle("\uAD00\uB9AC\uC790\uD398\uC774\uC9C0");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 468, 489);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\uC0AC\uC9C4");
		lblNewLabel.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uC2A4\uD0C0\uBC85\uC2A4 \uBA54\uB274 \uC774\uBBF8\uC9C0 1111111.jpg"));
		panel.add(lblNewLabel);
		
		JPanel pnAdminList = new JPanel();
		contentPane.add(pnAdminList, BorderLayout.CENTER);
		pnAdminList.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnCustomer = setBtnCustomer();
		pnAdminList.add(btnCustomer);
		
		JButton btnOrderList = setBtnOrder();
		
		JButton btnNewButton = setBtnProduct();
		pnAdminList.add(btnNewButton);
		pnAdminList.add(btnOrderList);
	}

	private JButton setBtnCustomer() {
		JButtonCreator btncreator = new JButtonCreator();
		JButton btnCustomer = (JButton) btncreator.createWithAlignment("\uD68C\uC6D0\uC815\uBCF4 \uBC0F \uAD00\uB9AC");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerInfo CInfo = new CustomerInfo();
				CInfo.setVisible(true);
			}
		});
		return btnCustomer;
	}

	private JButton setBtnOrder() {

		JButtonCreator btncreator = new JButtonCreator();
		JButton btnOrderList = (JButton) btncreator.createWithAlignment("\uC8FC\uBB38\uAD00\uB9AC");
		
		btnOrderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderInfo Oinfo= new OrderInfo();
				Oinfo.setVisible(true);
			}
		});
		return btnOrderList;
	}

	private JButton setBtnProduct() {
		JButtonCreator btncreator = new JButtonCreator();
		JButton btnNewButton = (JButton) btncreator.createWithAlignment("\uC0C1\uD488\uAD00\uB9AC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductInfo pdInfo = new ProductInfo();
				pdInfo.setVisible(true);
			}
		});
		return btnNewButton;
	}
	

}
