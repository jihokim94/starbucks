package ui.payment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import data.db.OrderDBMgr;
import menu.basket.BasketPanel;
import menu.main.MainMenuFrame;
import menu.main.components.BasketContainer;
import ui.main.MainFrame;
import ui.payment.dialog.AgreementDlg;

//import dialog.AgreementDlg;
//import util.Display;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class Money2 extends JFrame {

	private JPanel contentPane;
	Money2 frm;
	JRadioButton rdbtn1;
	JRadioButton rdbtn2;
	JRadioButton rdbtn3;
	JPanel pnMain;
	MainFrame Mainfrm;
	MainMenuFrame menufrm;
	BasketContainer bc;
	private JTable table;
	JSplitPane splitPane;
	
	public static void main(String[] args) {
		System.out.println(MainFrame.Login);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Money2 frame = new Money2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**  
	 * Create the frame.
	 */
	public Money2() {
		this.bc = new BasketContainer(menufrm);

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2020\\java_ws\\TProject\\images\\icon_card.jpg"));
		setTitle("NICE \uD398\uC774");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 684, 461);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.6);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		setMainPanel();
		
		setAllAgreeRadioBtn();
		
		setRadioBtn();
		
		setSucPayBtn();
		
		setAgreeBtn();
		
		setTotalPricePanel();
		
		showorderList();

	}

	private void setMainPanel() {
		pnMain = new JPanel();
		splitPane.setLeftComponent(pnMain);
		pnMain.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NICEPAY");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\TProject\\images\\nicePay.png"));
		lblNewLabel.setBounds(12, 10, 100, 40);
		pnMain.add(lblNewLabel);
	}

	private void setAllAgreeRadioBtn() {
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, null, Color.LIGHT_GRAY, null));
		panel.setBounds(22, 47, 224, 50);
		pnMain.add(panel);
		
		JRadioButton radioButton = new JRadioButton("\uC804\uCCB4 \uC57D\uAD00 \uB3D9\uC758");
		radioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if ( radioButton.isSelected() ) {
					rdbtn1.setSelected(true);
					rdbtn2.setSelected(true);
					rdbtn3.setSelected(true);
				} else {
					rdbtn1.setSelected(false);
					rdbtn2.setSelected(false);
					rdbtn3.setSelected(false);
				}
			}
		});
		radioButton.setHorizontalAlignment(SwingConstants.CENTER);
		radioButton.setFont(new Font("굴림", Font.BOLD, 20));
		panel.add(radioButton);
	}

	private void setSucPayBtn() {
		JButton btnSucPay = new JButton("\uACB0\uC81C\uC644\uB8CC");
		btnSucPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn1.isSelected() || rdbtn2.isSelected() || rdbtn3.isSelected()) {
					btnSucPay.setEnabled(true);
					pnMain.add(btnSucPay);
					System.out.println("결제완료");
					
					OrderDBMgr mgr = new OrderDBMgr();
					String memberLogin = MainFrame.Login;
					String orderNumber = getRandomNumber();
					 ArrayList<BasketPanel> odList = BasketContainer.bkList;
					 boolean b = false;
					for (int j = 0; j < odList.size(); j++) {
						BasketPanel bp =BasketContainer.bkList.get(j);
						 b =mgr.addOneOrder(bp, orderNumber, memberLogin);
						if(b) {
							
							System.out.println("주문 추가 성공 ");
						}else {
							System.out.println("주문 추가 실패");
						}
					}
					MoneyComplete mc = new MoneyComplete();
					mc.setVisible(true);
				
					dispose();
				} else {
					btnSucPay.setEnabled(false);
					pnMain.add(btnSucPay);
					System.out.println("결제실패");
					
				}
			}

			private String getRandomNumber() {
				final String  datas= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String pdNumber = "SB"; // family cafe.
				for (int i = 0; i < 8; i++) {
					char a = datas.charAt(
							(int)(Math.random()*datas.length()) // 0~ z까지
							); // 8번 돌아서 sb에 붙이기 
					pdNumber += a;
				} 
				return pdNumber;
				
				
			}
		});
		btnSucPay.setBounds(127, 360, 97, 23);
		pnMain.add(btnSucPay);
	}

	private void setAgreeBtn() {
		JButton btnShow1 = new JButton("[\uC790\uC138\uD788\uBCF4\uAE30]");
		btnShow1.setHorizontalAlignment(SwingConstants.LEADING);
		btnShow1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgreementDlg aDlg = new AgreementDlg();
				aDlg.setVisible(true);
			}
		});
		btnShow1.setBounds(252, 153, 109, 23);
		pnMain.add(btnShow1);
		
		JButton btnShow2 = new JButton("[\uC790\uC138\uD788\uBCF4\uAE30]");
		btnShow2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						AgreementDlg aDlg = new AgreementDlg();
						aDlg.setVisible(true);
			}
		});
		btnShow2.setHorizontalAlignment(SwingConstants.LEADING);
		btnShow2.setBounds(252, 230, 109, 23);
		pnMain.add(btnShow2);
		
		JButton btnShow3 = new JButton("[\uC790\uC138\uD788\uBCF4\uAE30]");
		btnShow3.setMnemonic('0');
		btnShow3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgreementDlg aDlg = new AgreementDlg();
				aDlg.setVisible(true);
			}
		});
		btnShow3.setHorizontalAlignment(SwingConstants.LEADING);
		btnShow3.setBounds(252, 312, 109, 23);
		pnMain.add(btnShow3);
	}

	private void setTotalPricePanel() {
		JPanel pnSub = new JPanel();
		splitPane.setRightComponent(pnSub);
		pnSub.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 305, 224, 82);
		pnSub.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JLabel lbTotalPrice = new JLabel("\uCD1D \uACB0\uC81C\uAE08\uC561");
		lbTotalPrice.setFont(new Font("굴림", Font.BOLD, 15));
		lbTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lbTotalPrice);
		
		JLabel lbPrice = new JLabel("");
		lbPrice.setHorizontalAlignment(SwingConstants.CENTER);
		

		int totalPrice = 0;
		ArrayList<BasketPanel>odList = BasketContainer.bkList;
		for (int i = 0; i < odList.size(); i++) {
			int OnePdtotalCount =Integer.parseInt(odList.get(i).pnOC.txtVal.getText());
			int productPrice = odList.get(i).product.getPrice();
			int onePdtotalPrice =productPrice *OnePdtotalCount;

			
			 totalPrice += onePdtotalPrice;
		}
		lbPrice.setText(String.valueOf(totalPrice) +"원");	
		
		panel_1.add(lbPrice);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(25, 32, 224, 263);
		pnSub.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	private void setRadioBtn() {
		rdbtn1 = new JRadioButton("\uC804\uC790 \uAE08\uC735\uAC70\uB798 \uC774\uC6A9\uC57D\uAD00");
		rdbtn1.setBounds(22, 144, 167, 32);
		pnMain.add(rdbtn1);
		
		rdbtn2 = new JRadioButton("\uAC1C\uC778 \uC815\uBCF4 \uC218\uC9D1 \uBC0F \uC774\uC6A9\uC5D0 \uB300\uD55C \uB3D9\uC758");
		rdbtn2.setBounds(23, 221, 166, 32);
		pnMain.add(rdbtn2);
		
		rdbtn3 = new JRadioButton("\uAC1C\uC778\uC815\uBCF4 \uC81C 3\uC790 \uC774\uC6A9\uC57D\uAD00 \uB3D9\uC758");
		rdbtn3.setBounds(22, 303, 167, 32);
		pnMain.add(rdbtn3);
	}
	
	
	public void showorderList() {
		ArrayList<BasketPanel> odList =BasketContainer.bkList;
		String [] columnNames = {"주문 상품", "주문 상품 수량"};
		
		Object [][] data = new Object[odList.size()][columnNames.length];
		for (int i = 0; i < odList.size(); i++) {
			BasketPanel bp =odList.get(i);
			data[i][0] =bp.product.getName();
			data[i][1] = bp.pnOC.txtVal.getText();
		}

		
		DefaultTableModel dm = new DefaultTableModel(data, columnNames);
		table.setModel(dm);
		
		
	}

}
	
