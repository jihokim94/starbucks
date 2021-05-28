package ui.payment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Member;
import data.Product;
import data.db.MemberDBMgr;
import data.db.ProductDBMgr;
import menu.basket.BasketPanel;
import menu.main.MainMenuFrame;
import menu.main.components.BasketContainer;
import ui.main.MainFrame;
import ui.payment.Factory.JButtonCreator;
import ui.payment.Factory.JLabelCreator;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class paymentWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstCardNo;
	private JPasswordField pfSecond;
	private JPasswordField pfThird;
	private JTextField txtLast;
	private JLabelCreator labelCreator;
	private JButtonCreator btnCreator;
	JLabel lbCardImage;
	JPanel mainPanel;
	JPanel subPanel;
	JPanel craditCardPaenl;
	JLabel lbReturn;
	JButton btnAccept;
	MainFrame fr ;
	MemberDBMgr mgr;
	Member member;

	// Branch Test
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paymentWindow frame = new paymentWindow();
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
	public paymentWindow() {
		this.mgr = new MemberDBMgr();
		this.fr= new MainFrame();
		member =mgr.getOneMemberByLogin(MainFrame.Login);
		member = new Member("name", "login", "password", 1, "birth", "email", "Phone");
		labelCreator = new JLabelCreator();
		btnCreator = new JButtonCreator();

		setTitle("\uC2E0\uC6A9\uCE74\uB4DC \uACB0\uC81C\uD654\uBA74"); //����ī�� ����ȭ��
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2020\\java_ws\\TProject\\images\\icon_card.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		setMainPaymentPanel();

		setSubPaymentPanel();

		Facade facadeForClientInfo = new Facade(mainPanel, subPanel, member);

		facadeForClientInfo.viewClientInfo();

		addTotalPriceLabel();

		inputCreditCard();

		setButton();
	}

	private void setButton() {
		btnAccept = (JButton) btnCreator.createWithIcon("\uACB0\uC81C\uC694\uCCAD"
				, "C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"
				, 143, 451, 120, 23);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( !member.getName().isEmpty() && !txtFirstCardNo.getText().isEmpty() && !txtLast.getText().isEmpty()
						&& !member.getPhone().isEmpty() && !member.getEmail().isEmpty()) {
					paymentAgreeWindow mny = new paymentAgreeWindow();
					mny.setVisible(true);
					btnAccept.setEnabled(true);
					dispose();
				} else {
					btnAccept.setEnabled(false);
					lbReturn.setForeground(Color.RED);
					lbReturn.setText("��ĭ�� ä���ּ���!");
				}


			}
		});
		mainPanel.add(btnAccept);

		JButton btnClose = (JButton) btnCreator.createWithIcon("\uB2EB\uAE30"
				, "C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"
				, 315, 451, 97, 23);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mainPanel.add(btnClose);

		lbReturn = (JLabel) labelCreator.create("", null, 424, 451, 145, 38);
		mainPanel.add(lbReturn);
	}

	private void addTotalPriceLabel() {
		JLabel lbTotalPrice = (JLabel) labelCreator.createWithIcon("\uCD1D \uACB0\uC81C\uAE08\uC561"
				,"C:\\dev2020\\java_ws\\FamilyCafeteria\\icons\\control_play_blue.png"
				, -1, -1, -1, -1);
		subPanel.add(lbTotalPrice);

		JLabel lbTotalMoney = (JLabel) labelCreator.createWithHorizontal("", null, -1, -1, -1, -1, 0);

		int totalPrice = 0;
		ArrayList<BasketPanel>odList = BasketContainer.bkList;
		for (int i = 0; i < odList.size(); i++) {
			int OnePdtotalPrice =Integer.parseInt(odList.get(i).pnOC.txtVal.getText());
			int productPrice = odList.get(i).product.getPrice();
			int onePdtotalPrice =productPrice *OnePdtotalPrice;

			 totalPrice += onePdtotalPrice;
		}

		lbTotalMoney.setText(String.valueOf(totalPrice) +"��");

		subPanel.add(lbTotalMoney);
	}



	private void inputCreditCard() {
		JTextField txtDash;
		JTextField txtDash2;
		JTextField txtDash3;


		JLabel lbCardComp = (JLabel) labelCreator.createWithIcon("\uCE74\uB4DC\uC0AC\uB97C \uC120\uD0DD\uD574\uC8FC\uC138\uC694"
				, "C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"
				, -1, -1, -1, -1);
		subPanel.add(lbCardComp);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(UIManager.getColor("text"));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uAD6D\uBBFC", "\uBE44\uC528", "\uC6B0\uB9AC", "\uD558\uB098", "\uD558\uB098(\uAD6C)\uC678\uD658", "\uC2E0\uD55C", "\uB18D\uD611", "\uAE30\uC5C5"}));
		comboBox.setSelectedIndex(0);
		subPanel.add(comboBox);

		JLabel lbCardNo = (JLabel) labelCreator.createWithIcon("\uCE74\uB4DC \uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694"
				,"C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\control_play_blue.png"
				, -1, -1, -1, -1);
		subPanel.add(lbCardNo);

		craditCardPaenl = new JPanel();
		craditCardPaenl.setBackground(UIManager.getColor("text"));
		subPanel.add(craditCardPaenl);

		txtFirstCardNo = new JTextField();
		txtFirstCardNo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtFirstCardNo.setForeground(Color.BLACK);
				txtFirstCardNo.setBackground(Color.YELLOW);
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtFirstCardNo.setBackground(Color.WHITE);
				txtFirstCardNo.setForeground(Color.BLACK);
			}
		});
		txtFirstCardNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				showCardImg(txtFirstCardNo);
			}
		});
		craditCardPaenl.add(txtFirstCardNo);
		txtFirstCardNo.setColumns(4);

		txtDash = new JTextField();
		txtDash.setBackground(new Color(192, 192, 192));
		txtDash.setText("-");
		craditCardPaenl.add(txtDash);
		txtDash.setColumns(1);

		pfSecond = new JPasswordField();
		pfSecond.setColumns(4);
		pfSecond.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfSecond.setForeground(Color.BLACK);
				pfSecond.setBackground(Color.YELLOW);
			}
			@Override
			public void focusLost(FocusEvent e) {
				pfSecond.setBackground(Color.WHITE);
				pfSecond.setForeground(Color.BLACK);
			}
		});
		craditCardPaenl.add(pfSecond);

		txtDash2 = new JTextField();
		txtDash2.setText("-");
		txtDash2.setColumns(1);
		txtDash2.setBackground(Color.LIGHT_GRAY);
		craditCardPaenl.add(txtDash2);

		pfThird = new JPasswordField();
		pfThird.setColumns(4);
		pfThird.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfThird.setForeground(Color.BLACK);
				pfThird.setBackground(Color.YELLOW);
			}
			@Override
			public void focusLost(FocusEvent e) {
				pfThird.setBackground(Color.WHITE);
				pfThird.setForeground(Color.BLACK);
			}
		});
		craditCardPaenl.add(pfThird);

		txtDash3 = new JTextField();
		txtDash3.setText("-");
		txtDash3.setColumns(1);
		txtDash3.setBackground(Color.LIGHT_GRAY);
		craditCardPaenl.add(txtDash3);

		txtLast = new JTextField();
		txtLast.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtLast.setForeground(Color.BLACK);
				txtLast.setBackground(Color.YELLOW);
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtLast.setBackground(Color.WHITE);
				txtLast.setForeground(Color.BLACK);
			}
		});
		craditCardPaenl.add(txtLast);
		txtLast.setColumns(4);

		lbCardImage = new JLabel("");
		lbCardImage.setSize(350, 400);
		craditCardPaenl.add(lbCardImage);

	}



	private void setSubPaymentPanel() {
		subPanel = new JPanel();
		subPanel.setBackground(new Color(255, 0, 0, 0));
		subPanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(255, 255, 255), new Color(0, 0, 0), new Color(255, 255, 255)));
		subPanel.setBounds(12, 95, 557, 346);
		mainPanel.add(subPanel);
		subPanel.setLayout(new GridLayout(6, 2, 0, 0));

		JLabel lbSentence = (JLabel) labelCreator.createWithHorizontal("\uACB0\uC81C \uAE08\uC561\uC740 \uB2E4\uC74C\uACFC \uAC19\uC2B5\uB2C8\uB2E4"
				,"����", 119, 56, 324, 29, 20);
		mainPanel.add(lbSentence);
	}

	private void setMainPaymentPanel() {

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);

		JLabel lbTitle = (JLabel) labelCreator.createWithIcon("\uC2E0\uC6A9\uCE74\uB4DC"
				, "C:\\dev2020\\java_ws\\FamilyCafeteria\\icons\\control_fastforward_blue.png"
				, 12, 21, 110, 38);//
		lbTitle.setFont(new Font("����", Font.BOLD, 18));
		mainPanel.add(lbTitle);
	}


	public void showCardImg(JTextField txtFirstCardNo) {
		if ( txtFirstCardNo != null ) {
			if ( txtFirstCardNo.getText().equals("9420") ||
					txtFirstCardNo.getText().equals("9421") ||
					txtFirstCardNo.getText().equals("9430")) { // bc
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\bc.png");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if ( txtFirstCardNo.getText().equals("9409") ) { // �Ե�
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\lt.jpg");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if ( txtFirstCardNo.getText().equals("9410")) { // �Ｚī��
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\ss.PNG");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if ( txtFirstCardNo.getText().equals("9407")) { // ����
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\soo.jpg");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if ( txtFirstCardNo.getText().equals("9420")) { // ����
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\sh.jpg");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if ( txtFirstCardNo.getText().equals("9411") ||
					txtFirstCardNo.getText().equals("9441") ||
					 txtFirstCardNo.getText().equals("9463")) { // ����
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\nh.png");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if ( txtFirstCardNo.getText().equals("9436") ||
					txtFirstCardNo.getText().equals("9445") ||
					 txtFirstCardNo.getText().equals("9490")) { // kb
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\kb.png");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if (txtFirstCardNo.getText().equals("9425") ||
					txtFirstCardNo.getText().equals("9445")) { // �츮
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\wr.png");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if ( txtFirstCardNo.getText().equals("9400")) { // ��Ƽ
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\ct.png");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
			if ( txtFirstCardNo.getText().equals("9490")) { // ����
				ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\card\\hd.jpg");
				lbCardImage.setIcon(ic);
				lbCardImage.repaint();
			}
		} else {
			lbCardImage.setText("");
		}


	}
}
