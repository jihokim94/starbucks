package ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		JButton btnCustomer = new JButton("\uD68C\uC6D0\uC815\uBCF4 \uBC0F \uAD00\uB9AC");
		btnCustomer.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnCustomer.setBackground(new Color(0,121,51));
		btnCustomer.setForeground(new Color(255, 255, 255));
		btnCustomer.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerInfo CInfo = new CustomerInfo();
				CInfo.setVisible(true);
			}
		});
		return btnCustomer;
	}

	private JButton setBtnOrder() {
		JButton btnOrderList = new JButton("\uC8FC\uBB38\uAD00\uB9AC");
		btnOrderList.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnOrderList.setBackground(new Color(0,121,51));
		btnOrderList.setForeground(new Color(255, 255, 255));
		btnOrderList.setFont(new Font("Dialog", Font.BOLD, 15));
		btnOrderList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderInfo Oinfo= new OrderInfo();
				Oinfo.setVisible(true);
			}
		});
		return btnOrderList;
	}

	private JButton setBtnProduct() {
		JButton btnNewButton = new JButton("\uC0C1\uD488\uAD00\uB9AC");
		btnNewButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton.setBackground(new Color(0,121,51));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductInfo pdInfo = new ProductInfo();
				pdInfo.setVisible(true);
			}
		});
		return btnNewButton;
	}
	

}
