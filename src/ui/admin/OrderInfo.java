package ui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import data.Member;
import data.order;
import data.db.OrderDBMgr;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderInfo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	OrderDBMgr mgr;
	private static String orderNumber =null;
	
	public static String getOrderNumber() {
		return orderNumber;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderInfo frame = new OrderInfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public OrderInfo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(50x50).jpg"));
		this.mgr = new OrderDBMgr();
		setTitle("\uC8FC\uBB38\uAD00\uB9AC");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 0));
		panel_1.setForeground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC8FC\uBB38 \uB0B4\uC5ED");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 10, 145, 50);
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		scrollPane.setBounds(12, 70, 563, 391);
		panel_1.add(scrollPane);
		
		table = new JTable();
//		showOrderTable();
		
		scrollPane.setViewportView(table);
		
		JButton btnAllOrder = new JButton("\uB9AC\uC2A4\uD2B8 \uB9AC\uC14B");
		btnAllOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showOrderTable();
			}
		});
		btnAllOrder.setBounds(428, 31, 124, 23);
		panel_1.add(btnAllOrder);
		
		JButton btnGetOrder = new JButton("\uC8FC\uBB38\uBC1B\uAE30");
		btnGetOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String memberLogin
				OrderSheetDialog dlg = new OrderSheetDialog();
				dlg.setVisible(true);
			
				
			}
		});
		btnGetOrder.setBounds(369, 486, 97, 23);
		panel_1.add(btnGetOrder);
		
		JButton btnfinsh = new JButton("\uC8FC\uBB38\uC644\uB8CC");
		btnfinsh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b =mgr.editOrderStatus(getOrderNumber(),  order.ORDER_FINISHED);
				if(b) {
					JOptionPane.showMessageDialog(null, "주문완료");
				}
			}
		});
		btnfinsh.setBounds(478, 486, 97, 23);
		panel_1.add(btnfinsh);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selrow = table.getSelectedRow();
				orderNumber=(String) table.getValueAt(selrow, 1);
				System.out.println(getOrderNumber());
//				memberLogin = (String) table.getValueAt(selrow, 2);
			}
		});
//		showOrderTable();
	}


	public void showOrderTable() {
		String [] columnNames = {"관리번호","주문번호","주문자아이디","상품명","수량","총금액","주문시간","주문상태"};
		ArrayList<order> odList =mgr.getAllOrders();
		Object [][] data = new Object[odList.size()][columnNames.length];
	
		for (int i = 0; i < odList.size(); i++) {
	         order mb = odList.get(i);
	         data[i][0] = mb.getId();
	         data[i][1] = mb.getOrderNumber();
	         data[i][2] = mb.getMemberLogin();
	         data[i][3] = mb.getProductName();
	         data[i][4] = mb.getQuantity() + "개";
	         data[i][5] = mb.getTotalPrice() +"원";
	         data[i][6] = mb.getOrderedTime();
//	         data[i][7] = mb.getOrderStatus();
	         int orderstatus =mb.getOrderStatus();
	         if(orderstatus == order.ORDER_REQUEST) {
	        	 data[i][7] = "주문대기중";
	         }else if(orderstatus == order.ORDER_PREPARE) {
	        	 data[i][7] = "주문준비중";
	        	 
	         }else if(orderstatus == order.ORDER_FINISHED) {
	        	 data[i][7] = "주문완료";
	         }else {
	        	 data[i][7] = "주문오류";
	         }
	         
	         
	         }
		
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		table.setModel(dtm);
		
//		table.setAlignmentX();
		
	}


	
}
