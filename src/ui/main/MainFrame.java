package ui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import LabelDecorate.LabelBound;
import LabelDecorate.LabelFont;
import LabelDecorate.LabelHorizon;
import LabelDecorate.LabelDecorator;
import data.db.MemberDBMgr;
import ui.admin.adminLoginDialog;
import ui.admin.adminMain;
import ui.find.IdOrPwFindFrame;
import uimainFactory.JButtonCreator;
import uimainFactory.JLabelCreator;
import member.MemberJoinFrame;
import member.MemberShipFrame;
import menu.main.MainMenuFrame;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField passwordField;
	JLabel lbLoginMessage;
	public static String Login ="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public MainFrame() {

		
		//Jfraame ?¤ì •
		setJframe();
		// ?ˆë¡œ?? ì°½ì´ ë§Œë“¤?´ì??? ?„ì¹˜?¤ì •
		setBounds(100, 100, 821, 536);
		//ContentPane ?¤ì •
		settingContentPane();

		displayStarbucksLogo();

		JPanel panel = makeJPanel();

		displayLogin(panel);

		displayRegister(panel);

		displaySearchIDPW(panel);
	
		displayWelcomeMessage(panel);

		displayAdminLoginButton(panel);
	}

	private JPanel makeJPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		return panel;
	}

	private void displayStarbucksLogo() {
		JLabelCreator labelcreator = new JLabelCreator();
		JLabel StarbucksLogo = (JLabel)labelcreator.createWithIcon("", "images\\logo\\ë¡œê³ (250x250).png",0, 0, 0, 0);
		StarbucksLogo.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		contentPane.add(StarbucksLogo);
	}

	private void setJframe() {
		//?„ë¡œê·¸ë¨ ì°? ?¬ê¸°ë¥? ì¡°ì ˆë¶ˆê??¥í•˜ê²? ?¤ì •
		setResizable(false);
		//?„ë¡œê·¸ë¨ ?€?´í? ?¤ì •
		setTitle("?¤í?ë²…ìŠ¤ ?Œë£Œ ì£¼ë¬¸ ?„ë¡œê·¸ë¨");
		//?¤í–‰ ?„ì´ì½˜ì„ ?¤í?ë²…ìŠ¤ ë¡œê³ ë¡? ?¤ì •
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logo\\ë¡œê³ (50x50).jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void settingContentPane() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
	}		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(
				new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(250x250).png"));
		contentPane.add(lblNewLabel);


	private void displayAdminLoginButton(JPanel panel) {
		JButtonCreator buttoncreator = new JButtonCreator();
		JButton btnAdmin = (JButton) buttoncreator.create("admin", "êµ´ë¦¼", 308, 20, 82, 23);
		btnAdminFunction(btnAdmin);
		btnAdmin.setForeground(new Color(255, 255, 255));
		btnAdmin.setBackground(new Color(0, 121, 51));
		panel.add(btnAdmin);
	}

	private void btnAdminFunction(JButton btnAdmin) {
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminLoginDialog ad = new adminLoginDialog();
				ad.setVisible(true);
				
			}
		});
	}

	private void displaySearchIDPW(JPanel panel) {
		JButtonCreator buttoncreator = new JButtonCreator();
		JLabelCreator labelcreator = new JLabelCreator();
		JLabel SearchIconLabel = (JLabel) labelcreator.createWithIcon("","images\\icons\\search.png" , 12, 394, 62, 62);
		panel.add(SearchIconLabel);

		JButton btnfindIDPW = (JButton) buttoncreator.createWithFont("?„ì´?? / ë¹„ë?ë²ˆí˜¸ ì°¾ê¸°", "êµ´ë¦¼", Font.PLAIN, 86, 433, 304, 23,12);

		btnfindIDPW.setForeground(new Color(255, 255, 255));
		btnfindIDPW.setBackground(new Color(0, 102, 51));
		btnfindIDPWFunction(btnfindIDPW);
		panel.add(btnfindIDPW);


		JLabel SearchDescriptLabel = (JLabel) labelcreator.createWithFont("ê³ ê°?˜ì˜ ?•ë³´ ?¸ì¦?? ?µí•´ ì°¾ì„ ?? ?ˆìŠµ?ˆë‹¤.","êµ´ë¦¼",Font.PLAIN, 86, 413, 304, 15,12);
		SearchDescriptLabel.setForeground(new Color(0, 102, 51));
		panel.add(SearchDescriptLabel);
		
		JLabel finderQuestionLabel = (JLabel) labelcreator.createWithFont("?„ì´?? / ë¹„ë?ë²ˆí˜¸ë¥? ?Šìœ¼?¨ë‚˜???","êµ´ë¦¼",Font.PLAIN, 86, 394, 304, 15,12);
		panel.add(finderQuestionLabel);
	}

	private void btnfindIDPWFunction(JButton btnfindIDPW) {
		btnfindIDPW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdOrPwFindFrame IDPWFinderFrame = new IdOrPwFindFrame();
				IDPWFinderFrame.setVisible(true);
//				setVisible(false);

			}
		});
	}

	private void displayRegister(JPanel panel) {
		JButtonCreator buttoncreator = new JButtonCreator();
		JLabelCreator labelcreator = new JLabelCreator();
		
		JLabel RegisterLabel = (JLabel) labelcreator.createWithFont("?€?œë?êµ?—?? ê°€?? ë§›ìˆ?? ì»¤í”¼, ?¤í?ë²…ìŠ¤?? ?Œì›?? ?˜ì‹œë©?","êµ´ë¦¼", Font.PLAIN , 29, 240, 344, 15,12);
		RegisterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(RegisterLabel);

		JLabel RegisterProfitLabel = (JLabel) labelcreator.createWithFont("?¤í?ë²…ìŠ¤?? ?¤ì–‘?? ?œë¹„?¤ì? ?œíƒ?? ë°›ìœ¼?? ?? ?ˆìŠµ?ˆë‹¤.","êµ´ë¦¼", Font.PLAIN , 29, 259, 344, 15,12);
		RegisterProfitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(RegisterProfitLabel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 219, 378, 2);
		panel.add(separator_1);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("êµ´ë¦¼", Font.PLAIN, 12));
		passwordField.setBounds(86, 163, 205, 21);
		panel.add(passwordField);

		lbLoginMessage = new JLabel("");
		lbLoginMessage.setFont(new Font("êµ´ë¦¼", Font.PLAIN, 12));
		lbLoginMessage.setBounds(86, 194, 270, 15);
		panel.add(lbLoginMessage);

		JLabel IsMemberLabel = (JLabel) labelcreator.createWithFont("?„ì§ ?¤í?ë²…ìŠ¤?? ?Œì›?? ?„ë‹ˆ? ê????","êµ´ë¦¼", Font.PLAIN , 86, 306, 304, 15,12);
		panel.add(IsMemberLabel);

		JButton btnRegister = (JButton) buttoncreator.createWithFont("?Œì›ê°€?…í•˜ê¸?", "êµ´ë¦¼", Font.PLAIN, 86, 345, 304, 23,12);
		btnRegister.setForeground(new Color(255, 255, 255));
		btnRegister.setBackground(new Color(0, 102, 51));
		btmRegisterFunction(btnRegister);
		panel.add(btnRegister);
		
		JLabel OffterMemberLabel = (JLabel) labelcreator.createWithFont("?¤í?ë²…ìŠ¤ ?Œì›ë§Œì˜ ?¹ë³„?? ?œíƒ?? ?„ë¦¬?¸ìš”!","êµ´ë¦¼", Font.PLAIN , 86, 325, 304, 15,12);
		OffterMemberLabel.setForeground(new Color(0, 102, 51));
		panel.add(OffterMemberLabel);
	}

	private void btmRegisterFunction(JButton btnRegister) {
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberJoinFrame frm = new MemberJoinFrame();
				frm.setVisible(true);
				setVisible(false);
			}
		});
	}

	private void displayLogin(JPanel panel) {
		JButtonCreator buttoncreator = new JButtonCreator();
		JLabelCreator labelcreator = new JLabelCreator();
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("êµ´ë¦¼", Font.PLAIN, 12));
		txtLogin.setBounds(86, 120, 205, 21);
		panel.add(txtLogin);
		
		txtLogin.setColumns(10);
		
		//JLabel lbLoginId = new JLabel("?„ì´??");
		JLabel lbLoginId = new LabelBound(new LabelFont(new JLabel("?„ì´??"), "êµ´ë¦¼",12),12, 123, 57, 15).getLabel();
		
		//lbLoginId.setFont(new Font("êµ´ë¦¼", Font.PLAIN, 12));
		lbLoginId.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLoginId.setBounds(12, 123, 57, 15);
		panel.add(lbLoginId);


		JLabel lbLoginPwLabel = (JLabel) labelcreator.createWithFont("ë¹„ë?ë²ˆí˜¸","êµ´ë¦¼", Font.PLAIN ,12, 166, 57, 15,12);
		lbLoginPwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lbLoginPwLabel);

		JButton btnLogin = (JButton) buttoncreator.createWithFont("ë¡œê·¸??", "êµ´ë¦¼", Font.PLAIN,303, 120, 87, 61,12);
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(0, 102, 51));
		btnLoginFunction(btnLogin);
		panel.add(btnLogin);
		
		JLabel LoginImageLabel = (JLabel) labelcreator.createWithIcon("", "images\\icons\\login(62x62).png",12, 306, 62, 62);		
		LoginImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(LoginImageLabel);
		
		JLabel RequestLoginLabel = (JLabel) labelcreator.createWithFont("?œë¹„?? ?´ìš©?? ?„í•´ ë¡œê·¸?? ?´ì£¼?œê¸° ë°”ë?ˆë‹¤.","êµ´ë¦¼", Font.PLAIN , 29, 86, 284, 16,13);
		panel.add(RequestLoginLabel);
	}

	private void btnLoginFunction(JButton btnLogin) {
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String login = txtLogin.getText();
	            String pw = new String(passwordField.getPassword());
	            MemberDBMgr mgr = new MemberDBMgr();
	            int loginQueryResult = mgr.loginProcess(login, pw);
	            switch (loginQueryResult) {
	            case MemberDBMgr.LOGIN_SUCCESS:
	               lbLoginMessage.setText("ë¡œê·¸?¸ì— ?±ê³µ?˜ì…¨?µë‹ˆ??.");
	               lbLoginMessage.setForeground(Color.black);
	               JOptionPane.showMessageDialog(null, "ë¡œê·¸?¸ì— ?±ê³µ?˜ì…¨?µë‹ˆ??.");
	               Login = txtLogin.getText();
	               MainMenuFrame menuFrm = new MainMenuFrame();
	               menuFrm.setVisible(true);
	               break;

	            case MemberDBMgr.LOGIN_NOT_FOUND:
	               lbLoginMessage.setText("?Œì›?? ?•ë³´ë¥? ì°¾ì„ ?? ?†ìŠµ?ˆë‹¤.");
	               lbLoginMessage.setForeground(Color.red);
	               JOptionPane.showMessageDialog(null, "?Œì›?? ?•ë³´ë¥? ì°¾ì„ ?? ?†ìŠµ?ˆë‹¤.");
	               break;

	            case MemberDBMgr.LOGIN_PW_MISMATCH:
	               lbLoginMessage.setText("ë¡œê·¸?? ?¹ì? ë¹„ë?ë²ˆí˜¸ê°€ ?€ë¦¬ì…¨?µë‹ˆ??.");
	               lbLoginMessage.setForeground(Color.red);
	               JOptionPane.showMessageDialog(null, "ë¡œê·¸?? ?¹ì? ë¹„ë?ë²ˆí˜¸ê°€ ?€ë¦¬ì…¨?µë‹ˆ??.");
	               break;

	            case MemberDBMgr.LOGIN_ERROR:
	               lbLoginMessage.setText("ì§€?í•˜ì§€ ?ŠëŠ” ?œë¹„?¤ì…?ˆë‹¤.");
	               lbLoginMessage.setForeground(Color.red);
	               JOptionPane.showMessageDialog(null, "ì§€?í•˜ì§€ ?ŠëŠ” ?œë¹„?¤ì…?ˆë‹¤.");
	               break;

	            }
			}
		});
	}
}
