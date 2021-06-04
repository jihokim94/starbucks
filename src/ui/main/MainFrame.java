package ui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import data.db.MemberDBMgr;
import ui.admin.adminLoginDialog;
import ui.admin.adminMain;
import ui.find.IdOrPwFindFrame;
import LabelDecorate.LabelBackGround;
import LabelDecorate.LabelBound;
import LabelDecorate.LabelFont;
import LabelDecorate.LabelForeGround;
import LabelDecorate.LabelHorizon;
import LabelDecorate.LabelIcon;

import ButtonDecorate.ButtonBackGround;
import ButtonDecorate.ButtonBound;
import ButtonDecorate.ButtonComponent;
import ButtonDecorate.ButtonDecorator;
import ButtonDecorate.ButtonFont;
import ButtonDecorate.ButtonForeGround;
import ButtonDecorate.ButtonIcon;
import ButtonDecorate.ButtonRightAlignment;


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
		setJframe();
		// 새로운 창이 만들어지는 위치설정
		setBounds(100, 100, 821, 536);
		//ContentPane 설정
		setContentPane();

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
		JLabel StarbucksLogo = new LabelIcon(new LabelHorizon(new LabelBackGround(new JLabel(""),255,255,255 )),"images\\logo\\로고(250x250).png").getLabel();
		StarbucksLogo.setBorder(new EmptyBorder(0,0,0,0));
		contentPane.add(StarbucksLogo);
	}

	private void setJframe() {
		//프로그램 창 크기를 조절불가능하게 설정
		setResizable(false);
		//프로그램 타이틀 설정
		setTitle("스타벅스 음료 주문 프로그램");
		//실행 아이콘을 스타벅스 로고로 설정
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logo\\로고(50x50).jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setContentPane() {
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
	}

	private void displayWelcomeMessage(JPanel panel) {
		// "안녕하세요" 츨력 라벨
		JLabel HelloLabel = new LabelBound(new LabelFont(new LabelForeGround(new JLabel("반갑습니다"),0,102,51 ),"굴림",20,Font.BOLD), 29,20,275,24).getLabel();
		panel.add(HelloLabel);
		// "스타벅스입니다". 출력 라벨
		JLabel StarbucksLabel = new LabelBound(new LabelFont(new LabelForeGround(new JLabel("스타벅스입니다."),0,102,51 ),"굴림",20,Font.BOLD), 29,43,361,24).getLabel();
		panel.add(StarbucksLabel);
	}

	private void displayAdminLoginButton(JPanel panel) {
		JButton btnAdmin = new ButtonBound(new ButtonForeGround(new ButtonBackGround(new JButton("admin"),0,102,51 ),255,255,255), 308,20,82,23).getButton();
		btnAdminFunction(btnAdmin);
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
		JLabel SearchIconLabel = new LabelIcon( new LabelHorizon(new LabelBound(new LabelBackGround(new JLabel(""), 255,255,255 ), 12,394,62,62)),"images\\icons\\search.png").getLabel();
		panel.add(SearchIconLabel);

		JButton btnfindIDPW = new ButtonFont(new ButtonBound(new ButtonForeGround(new ButtonBackGround(new JButton("아이디 / 비밀번호 찾기"),0,102,51 ),255,255,255), 86,433,304,23),"굴림",12,Font.PLAIN).getButton();
		btnfindIDPWFunction(btnfindIDPW);
		panel.add(btnfindIDPW);

		JLabel SearchDescriptLabel = new LabelFont(new LabelBound(new LabelForeGround(new JLabel("고객님의 정보 인증을 통해 찾을 수 있습니다."), 0,102,51 ), 86, 413, 304, 15),"굴림",12,Font.PLAIN).getLabel();
		panel.add(SearchDescriptLabel);
		
		JLabel finderQuestionLabel = new LabelFont(new LabelBound(new JLabel("아이디 / 비밀번호를 잊으셨나요?"), 86,394,304,15),"굴림",12,Font.PLAIN).getLabel();
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

		JLabel RegisterLabel = new LabelFont(new LabelBound(new LabelHorizon(new JLabel("대한민국에서 가장 맛있는 커피, 스타벅스의 회원이 되시면")), 29,240,344,15),"굴림",12,Font.PLAIN).getLabel();
		panel.add(RegisterLabel);

		JLabel RegisterProfitLabel = new LabelFont(new LabelBound(new LabelHorizon(new JLabel("스타벅스의 다양한 서비스와 혜택을 받으실 수 있습니다.")), 29,259,344,15),"굴림",12,Font.PLAIN).getLabel();
		panel.add(RegisterProfitLabel);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 219, 378, 2);
		panel.add(separator_1);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("굴림", Font.PLAIN, 12));
		passwordField.setBounds(86, 163, 205, 21);
		panel.add(passwordField);

		lbLoginMessage = new JLabel("");
		lbLoginMessage.setFont(new Font("굴림", Font.PLAIN, 12));
		lbLoginMessage.setBounds(86, 194, 270, 15);
		panel.add(lbLoginMessage);

		JLabel IsMemberLabel = new LabelFont(new LabelBound(new JLabel("아직 스타벅스의 회원이 아니신가요?"), 86,306,304,15),"굴림",12,Font.PLAIN).getLabel();
		panel.add(IsMemberLabel);

		JButton btnRegister = new ButtonFont(new ButtonBound(new ButtonForeGround(new ButtonBackGround(new JButton("회원가입하기"),0,102,51 ),255,255,255), 86,345,304,23),"굴림",12,Font.PLAIN).getButton();
		btmRegisterFunction(btnRegister);
		panel.add(btnRegister);
		
		JLabel OffterMemberLabel = new LabelForeGround(new LabelFont(new LabelBound(new JLabel("스타벅스 회원만의 특별한 혜택을 누리세요!"), 86,325,304,15),"굴림",12,Font.PLAIN),0,102,51).getLabel();
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
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("굴림", Font.PLAIN, 12));
		txtLogin.setBounds(86, 120, 205, 21);
		panel.add(txtLogin);
		
		txtLogin.setColumns(10);

		JLabel lbLoginIdLabel = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("아이디"), 12,123,57,15),"굴림",12,Font.PLAIN)).getLabel();
		panel.add(lbLoginIdLabel);

		JLabel lbLoginPWLabel = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("비밀번호"), 12,166,57,15),"굴림",12,Font.PLAIN)).getLabel();
		panel.add(lbLoginPWLabel);

		JButton btnLogin = new ButtonFont(new ButtonBound(new ButtonForeGround(new ButtonBackGround(new JButton("로그인"),0,102,51 ),255,255,255), 303, 120, 87, 61),"굴림",12,Font.PLAIN).getButton();
		btnLoginFunction(btnLogin);
		panel.add(btnLogin);
		
		JLabel LoginImageLabel = new LabelBackGround(new LabelHorizon(new LabelIcon(new LabelBound(new JLabel(""), 12,306,62,62),"images\\icons\\login(62x62).png")),255,255,255).getLabel();
		panel.add(LoginImageLabel);
		
		JLabel RequestLoginLabel = new LabelFont(new LabelBound(new JLabel("서비스 이용을 위해 로그인 해주시기 바랍니다."), 29,86,284,16),"굴림",13,Font.PLAIN).getLabel();
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
	               lbLoginMessage.setText("로그인에 성공하셨습니다.");
	               lbLoginMessage.setForeground(Color.black);
	               JOptionPane.showMessageDialog(null, "로그인에 성공하셨습니다.");
	               Login = txtLogin.getText();
	               MainMenuFrame menuFrm = new MainMenuFrame();
	               menuFrm.setVisible(true);
	               break;

	            case MemberDBMgr.LOGIN_NOT_FOUND:
	               lbLoginMessage.setText("회원의 정보를 찾을 수 없습니다.");
	               lbLoginMessage.setForeground(Color.red);
	               JOptionPane.showMessageDialog(null, "회원의 정보를 찾을 수 없습니다.");
	               break;

	            case MemberDBMgr.LOGIN_PW_MISMATCH:
	               lbLoginMessage.setText("로그인 혹은 비밀번호가 틀리셨습니다.");
	               lbLoginMessage.setForeground(Color.red);
	               JOptionPane.showMessageDialog(null, "로그인 혹은 비밀번호가 틀리셨습니다.");
	               break;

	            case MemberDBMgr.LOGIN_ERROR:
	               lbLoginMessage.setText("지원하지 않는 서비스입니다.");
	               lbLoginMessage.setForeground(Color.red);
	               JOptionPane.showMessageDialog(null, "지원하지 않는 서비스입니다.");
	               break;

	            }
			}
		});
	}
}
