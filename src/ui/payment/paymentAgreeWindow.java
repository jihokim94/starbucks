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
import ui.payment.Factory.JButtonCreator;
import ui.payment.Factory.JLabelCreator;
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

public class paymentAgreeWindow extends JFrame {

	private JPanel contentPane;
	private JLabelCreator labelCreator;
	private JButtonCreator btnCreator;
	paymentAgreeWindow frm;
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
					paymentAgreeWindow frame = new paymentAgreeWindow();
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
	public paymentAgreeWindow() {
		this.bc = new BasketContainer(menufrm);
		labelCreator = new JLabelCreator();
		btnCreator = new JButtonCreator();

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
		
		showOrderList();

	}

	private void setMainPanel() {
		pnMain = new JPanel();
		splitPane.setLeftComponent(pnMain);
		pnMain.setLayout(null);
		
		JLabel lblNewLabel = (JLabel) labelCreator.createWithIcon("NICEPAY"
				, "C:\\dev2020\\java_ws\\TProject\\images\\nicePay.png"
				, 12, 10, 100, 40);
		lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
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
		radioButton.setFont(new Font("����", Font.BOLD, 20));
		panel.add(radioButton);
	}

	private void setSucPayBtn() {
		JButton btnSucPay = new JButton("\uACB0\uC81C\uC644\uB8CC");
		btnSucPay.setBounds(127, 360, 97, 23);
		btnSucPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtn1.isSelected() || rdbtn2.isSelected() || rdbtn3.isSelected()) {
					btnSucPay.setEnabled(true);
					pnMain.add(btnSucPay);
					System.out.println("�����Ϸ�");
					
					OrderDBMgr mgr = new OrderDBMgr();
					String memberLogin = MainFrame.Login;
					String orderNumber = getRandomNumber();
					 ArrayList<BasketPanel> odList = BasketContainer.bkList;
					 boolean b = false;
					for (int j = 0; j < odList.size(); j++) {
						BasketPanel bp =BasketContainer.bkList.get(j);
						 b =mgr.addOneOrder(bp, orderNumber, memberLogin);
						if(b) {
							
							System.out.println("�ֹ� �߰� ���� ");
						}else {
							System.out.println("�ֹ� �߰� ����");
						}
					}
					completePayment mc = new completePayment();
					mc.setVisible(true);
				
					dispose();
				} else {
					btnSucPay.setEnabled(false);
					pnMain.add(btnSucPay);
					System.out.println("��������");
					
				}
			}

			private String getRandomNumber() {
				final String  datas= "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
				String pdNumber = "SB"; // family cafe.
				for (int i = 0; i < 8; i++) {
					char a = datas.charAt(
							(int)(Math.random()*datas.length()) // 0~ z����
							); // 8�� ���Ƽ� sb�� ���̱� 
					pdNumber += a;
				} 
				return pdNumber;
				
				
			}
		});
		
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
		
		JLabel lbTotalPrice = (JLabel) labelCreator.createWithHorizontal("\uCD1D \uACB0\uC81C\uAE08\uC561", "����", -1, -1, -1, -1, 15);
		panel_1.add(lbTotalPrice);
		
		JLabel lbPrice = (JLabel) labelCreator.createWithHorizontal("", null, -1,-1,-1,-1, -1);
	
		int totalPrice = 0;
		ArrayList<BasketPanel>odList = BasketContainer.bkList;
		for (int i = 0; i < odList.size(); i++) {
			int OnePdtotalCount =Integer.parseInt(odList.get(i).pnOC.txtVal.getText());
			int productPrice = odList.get(i).product.getPrice();
			int onePdtotalPrice =productPrice *OnePdtotalCount;

			
			 totalPrice += onePdtotalPrice;
		}
		lbPrice.setText(String.valueOf(totalPrice) +"��");	
		
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
	
	
	public void showOrderList() {
		ArrayList<BasketPanel> odList =BasketContainer.bkList;
		String [] columnNames = {"�ֹ� ��ǰ", "�ֹ� ��ǰ ����"};
		
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
	
