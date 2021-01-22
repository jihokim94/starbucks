package member;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import data.Member;
import data.db.MemberDBMgr;
import ui.main.MainFrame;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MemberJoinFrame extends JFrame {
	private JTextField txtId;
	private JPasswordField pfPassword;
	private JPasswordField pfPasswordCheck;
	private JTextField txtName;
	private JTextField txtMonth;
	private JTextField txtDay;
	private JTextField txtPhone2;
	private JTextField txtPhone3;
	private JTextField txtmail;
	private JTextField txtComboTomail;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	JComboBox comboMail;
	JLabel lbPwMessage;
	JLabel lbPwCheckMessage;
	JButton btnNext;
	JButton btnIdCheck;

	MemberDBMgr mgr;

	public MemberJoinFrame() {
		setResizable(false);
		setTitle("\uC2A4\uD0C0\uBC85\uC2A4 \uD68C\uC6D0\uAC00\uC785 \uC2DC\uC2A4\uD15C");

		mgr = new MemberDBMgr();
		getContentPane().setBackground(Color.WHITE);
		setSize(725, 700);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(150x150).png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 21, 695, 150);
		getContentPane().add(label);

		JLabel label_1 = new JLabel("회원가입은 무료이며, 가입 즉시 서비스를 이용하실 수 있습니다. (회원가입은 만 14세 이상부터 가능합니다.)");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(66, 200, 586, 15);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel("스타벅스의 서비스를 이용하기 위해서는 아래의 항목을 모두 입력하셔야 합니다.");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(106, 181, 506, 15);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel("* 개인정보 입력");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("굴림", Font.PLAIN, 12));
		label_3.setBackground(Color.WHITE);
		label_3.setBounds(12, 235, 682, 15);
		getContentPane().add(label_3);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 261, 695, 345);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lbId = new JLabel("아이디");
		lbId.setFont(new Font("굴림", Font.PLAIN, 12));
		lbId.setHorizontalAlignment(SwingConstants.TRAILING);
		lbId.setBounds(12, 24, 103, 15);
		panel.add(lbId);

		JLabel lbPw = new JLabel("비밀번호");
		lbPw.setFont(new Font("굴림", Font.PLAIN, 12));
		lbPw.setHorizontalAlignment(SwingConstants.TRAILING);
		lbPw.setBounds(12, 63, 103, 15);
		panel.add(lbPw);

		JLabel lbPwCheck = new JLabel("비밀번호 재확인");
		lbPwCheck.setFont(new Font("굴림", Font.PLAIN, 12));
		lbPwCheck.setHorizontalAlignment(SwingConstants.TRAILING);
		lbPwCheck.setBounds(12, 101, 103, 15);
		panel.add(lbPwCheck);

		JLabel lbName = new JLabel("이름");
		lbName.setFont(new Font("굴림", Font.PLAIN, 12));
		lbName.setHorizontalAlignment(SwingConstants.TRAILING);
		lbName.setBounds(12, 143, 103, 15);
		panel.add(lbName);

		JLabel lbGender = new JLabel("성별");
		lbGender.setFont(new Font("굴림", Font.PLAIN, 12));
		lbGender.setHorizontalAlignment(SwingConstants.TRAILING);
		lbGender.setBounds(12, 186, 103, 15);
		panel.add(lbGender);

		JLabel lbPhone = new JLabel("핸드폰번호");
		lbPhone.setFont(new Font("굴림", Font.PLAIN, 12));
		lbPhone.setHorizontalAlignment(SwingConstants.TRAILING);
		lbPhone.setBounds(12, 271, 103, 15);
		panel.add(lbPhone);

		JLabel lbBirth = new JLabel("생년월일");
		lbBirth.setFont(new Font("굴림", Font.PLAIN, 12));
		lbBirth.setHorizontalAlignment(SwingConstants.TRAILING);
		lbBirth.setBounds(12, 227, 103, 15);
		panel.add(lbBirth);

		JLabel lbEmail = new JLabel("이메일");
		lbEmail.setFont(new Font("굴림", Font.PLAIN, 12));
		lbEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lbEmail.setBounds(12, 310, 103, 15);
		panel.add(lbEmail);

		txtId = new JTextField();
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtId.setForeground(Color.BLACK);
				txtId.setBackground(Color.YELLOW);
				String login = txtId.getText();
				if (login.equals("ID을 입력하세요!"))
					txtId.setText("");

			}

			@Override
			public void focusLost(FocusEvent e) {
				txtId.setBackground(Color.WHITE);
				txtId.setForeground(Color.LIGHT_GRAY);
				String login = txtId.getText();
				if (login.isEmpty()) {
					txtId.setText("ID을 입력하세요!");
				}
			}
		});
		txtId.setFont(new Font("굴림", Font.PLAIN, 12));
		txtId.setBounds(127, 21, 142, 21);
		panel.add(txtId);
		txtId.setColumns(10);

		pfPassword = new JPasswordField();
		pfPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfPassword.setBackground(Color.ORANGE);
			}

			@Override
			public void focusLost(FocusEvent e) {
				pfPassword.setBackground(Color.WHITE);
			}
		});
		pfPassword.setFont(new Font("굴림", Font.PLAIN, 12));
		pfPassword.setBounds(127, 60, 142, 21);
		panel.add(pfPassword);

		pfPasswordCheck = new JPasswordField();
		pfPasswordCheck.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				pfPasswordCheck.setBackground(Color.ORANGE);
				String pw1 = new String(pfPasswordCheck.getPassword());
				System.out.println("첫번째 암호: " + pw1);
				if (pw1.isEmpty() && pw1.length() < 4) {
					lbPwMessage.setForeground(Color.RED);
					lbPwMessage.setText("패스워드를 다시 확인해주세요");
					pfPasswordCheck.requestFocusInWindow();
					// 포커스 이동 요청..
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				pfPasswordCheck.setBackground(Color.WHITE);
				String pw1 = new String(pfPasswordCheck.getPassword());
				String pw2 = new String(pfPasswordCheck.getPassword());
				System.out.println("두번째 암호: " + pw2);
				if (pw2.isEmpty()) {
					lbPwCheckMessage.setForeground(Color.RED);
					lbPwCheckMessage.setText("패스워드를 다시 확인해주세요");
//					pfPasswordSecond.requestFocusInWindow();
				} else { // 두개 양쪽 비교...
					if (pw2.equals(pw1)) {
						System.out.println("사용가능한 비밀번호입니다.");
						lbPwCheckMessage.setForeground(Color.BLUE);
						lbPwCheckMessage.setText("사용가능한 비밀번호입니다.");
						lbPwMessage.setText("");
						// 가입 버튼 활성화! ㅜㅜ

						checkJoinAvailable();

					} else {
						System.out.println("암호가 불일치합니다.");
						lbPwCheckMessage.setForeground(Color.RED);
						lbPwCheckMessage.setText("암호가 불일치합니다.");
						pfPassword.requestFocusInWindow();
					}
				}
			}
		});
		pfPasswordCheck.setFont(new Font("굴림", Font.PLAIN, 12));
		pfPasswordCheck.setBounds(127, 98, 142, 21);
		panel.add(pfPasswordCheck);

		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtName.setForeground(Color.BLACK);
				txtName.setBackground(Color.ORANGE);
				String name = txtName.getText();
				if (name.equals("실명을 입력 하세요!"))
					txtName.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				txtName.setBackground(Color.WHITE);
				txtName.setForeground(Color.LIGHT_GRAY);
				String name = txtName.getText();
				if (name.isEmpty()) {
					txtName.setText("실명을 입력 하세요!");
				}
			}
		});
		txtName.setFont(new Font("굴림", Font.PLAIN, 12));
		txtName.setColumns(10);
		txtName.setBounds(127, 140, 142, 21);
		panel.add(txtName);

		JRadioButton rdBtnMale = new JRadioButton("남성");
		rdBtnMale.setFont(new Font("굴림", Font.PLAIN, 12));
		buttonGroup.add(rdBtnMale);
		rdBtnMale.setSelected(true);
		rdBtnMale.setBounds(123, 182, 49, 23);
		panel.add(rdBtnMale);

		JRadioButton rdBtnFemale = new JRadioButton("여성");
		rdBtnFemale.setFont(new Font("굴림", Font.PLAIN, 12));
		buttonGroup.add(rdBtnFemale);
		rdBtnFemale.setBounds(183, 182, 49, 23);
		panel.add(rdBtnFemale);

		JComboBox comboYear = new JComboBox();
		comboYear.setModel(new DefaultComboBoxModel(new String[] { "1980", "1981", "1982", "1983", "1984", "1985",
				"1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998",
				"1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011",
				"2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020" }));
		comboYear.setSelectedIndex(12);
		comboYear.setFont(new Font("굴림", Font.PLAIN, 12));
		comboYear.setBounds(127, 224, 105, 21);
		panel.add(comboYear);

		JLabel lblNewLabel = new JLabel("\uB144");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel.setBounds(244, 227, 12, 15);
		panel.add(lblNewLabel);

		txtMonth = new JTextField();
		txtMonth.setFont(new Font("굴림", Font.PLAIN, 12));
		txtMonth.setBounds(268, 224, 116, 21);
		txtMonth.setHorizontalAlignment(JTextField.CENTER);
		panel.add(txtMonth);
		txtMonth.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("\uC6D4");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(396, 227, 12, 15);
		panel.add(lblNewLabel_1);

		txtDay = new JTextField();
		txtDay.setHorizontalAlignment(JTextField.CENTER);
		txtDay.setFont(new Font("굴림", Font.PLAIN, 12));
		txtDay.setColumns(10);
		txtDay.setBounds(420, 224, 116, 21);
		panel.add(txtDay);

		JLabel lblNewLabel_2 = new JLabel("\uC77C");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(548, 227, 12, 15);
		panel.add(lblNewLabel_2);

		JComboBox comboPhone = new JComboBox();
		comboPhone.setFont(new Font("굴림", Font.PLAIN, 12));
		comboPhone.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "017", "018", "019", "070" }));
		comboPhone.setBounds(127, 268, 105, 21);
		panel.add(comboPhone);

		JLabel lblNewLabel_3 = new JLabel("-");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(244, 271, 6, 15);
		panel.add(lblNewLabel_3);

		txtPhone2 = new JTextField();
		txtPhone2.setHorizontalAlignment(JTextField.CENTER);
		txtPhone2.setFont(new Font("굴림", Font.PLAIN, 12));
		txtPhone2.setBounds(262, 268, 116, 21);
		panel.add(txtPhone2);
		txtPhone2.setColumns(10);

		JLabel label_4 = new JLabel("-");
		label_4.setFont(new Font("굴림", Font.PLAIN, 12));
		label_4.setBounds(390, 271, 6, 15);
		panel.add(label_4);

		txtPhone3 = new JTextField();
		txtPhone3.setHorizontalAlignment(JTextField.CENTER);
		txtPhone3.setFont(new Font("굴림", Font.PLAIN, 12));
		txtPhone3.setBounds(408, 268, 116, 21);
		panel.add(txtPhone3);
		txtPhone3.setColumns(10);

		txtmail = new JTextField();
		txtmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtmail.setFont(new Font("굴림", Font.PLAIN, 12));
		txtmail.setBounds(127, 307, 116, 21);
		panel.add(txtmail);
		txtmail.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("@");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(254, 310, 12, 15);
		panel.add(lblNewLabel_4);

		txtComboTomail = new JTextField();
		txtComboTomail.setHorizontalAlignment(SwingConstants.CENTER);
		txtComboTomail.setFont(new Font("굴림", Font.PLAIN, 12));
		txtComboTomail.setBounds(278, 307, 116, 21);
		panel.add(txtComboTomail);
		txtComboTomail.setColumns(10);

		comboMail = new JComboBox();
		comboMail.setFont(new Font("굴림", Font.PLAIN, 12));
		comboMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtComboTomail.setText(comboMail.getSelectedItem().toString());
			}
		});
		comboMail.setModel(new DefaultComboBoxModel(new String[] { "\uC9C1\uC811\uC785\uB825", "naver.com",
				"hanmail.net", "nate.com", "yahoo.com", "gmail.com", "hotmail.com" }));
		comboMail.setBounds(408, 307, 116, 21);
		panel.add(comboMail);

		lbPwMessage = new JLabel("4자 이상으로 넣어주세요");
		lbPwMessage.setFont(new Font("굴림", Font.PLAIN, 12));
		lbPwMessage.setBounds(281, 63, 389, 15);
		panel.add(lbPwMessage);

		btnIdCheck = new JButton("중복확인");
		btnIdCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String targetLogin = txtId.getText();
				if (targetLogin.isEmpty() || targetLogin == null) {
					System.out.println("아이디를 다시 입력하세요");
				} else {
					Member mb = mgr.getOneMemberByLogin(targetLogin);
					if (mb == null) {// 없는 아이디 일경우 사용 가능
						JOptionPane.showMessageDialog(null, "사용가능한 아이디입니다.");
						bLoginDup = false;
					} else { // 이미 유저가 있음
						System.out.println("중복된 아이디가 있습니다.");
						JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.");
						bLoginDup = true;
					}
				}
			}
		});
		btnIdCheck.setFont(new Font("굴림", Font.PLAIN, 12));
		btnIdCheck.setBackground(Color.WHITE);
		btnIdCheck.setBounds(281, 20, 97, 23);
		panel.add(btnIdCheck);

		lbPwCheckMessage = new JLabel("비밀번호를 한번 더 입력해주세요.");
		lbPwCheckMessage.setBackground(Color.WHITE);
		lbPwCheckMessage.setFont(new Font("굴림", Font.PLAIN, 12));
		lbPwCheckMessage.setBounds(281, 101, 389, 15);
		panel.add(lbPwCheckMessage);

		JButton btnCancel = new JButton("취소하기");
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
			}
		});
		btnCancel.setFont(new Font("굴림", Font.PLAIN, 12));
		btnCancel.setBackground(new Color(0, 102, 51));
		btnCancel.setBounds(168, 621, 178, 30);
		getContentPane().add(btnCancel);

		btnNext = new JButton("다음단계");
		btnNext.setForeground(new Color(255, 255, 255));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("회원가입 DB 통신...");
				// 입력 데이터 추출
				String login = txtId.getText();
				String pw = new String(pfPassword.getPassword());
				String name = txtName.getText();
				int gender = rdBtnFemale.isSelected() ? Member.GENDER_FEMALE : Member.GENDER_MALE;
				String birth = comboYear.getSelectedItem() + txtMonth.getText() + txtDay.getText();
				String phone = (String)comboPhone.getSelectedItem() + txtPhone2.getText() + txtPhone3.getText();
				String email = txtmail.getText() + txtComboTomail.getText();

				// DB 연동
				Member mb = new Member(name, login, pw, gender, birth, email, phone);
				boolean b = mgr.insertOneMember(mb);
				if (b) {
					JOptionPane.showMessageDialog(null, "감사합니다, 회원가입에 성공하셨습니다.");
				} else {
					JOptionPane.showMessageDialog(null, "감사합니다, 회원가입에 성공하셨습니다.");
				}

				dispose();
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
			}
		});
		btnNext.setFont(new Font("굴림", Font.PLAIN, 12));
		btnNext.setBackground(new Color(0, 102, 51));
		btnNext.setBounds(378, 621, 178, 30);
		getContentPane().add(btnNext);

	}

	private boolean bLoginDup; // false 중복아님..

	protected void checkJoinAvailable() {
		// 길이, 중복.. 범위. 구성.. 체크..
		// 검증.. validation + 보안?
		String pw1 = new String(pfPassword.getPassword());
		String pw2 = new String(pfPasswordCheck.getPassword());

		if (!txtId.getText().isEmpty() && !txtName.getText().isEmpty()
				&& (!pw1.isEmpty() && !pw2.isEmpty() && pw1.equals(pw2)) && this.bLoginDup == false) {
			btnNext.setEnabled(false);
		} else {
			btnNext.setEnabled(true);
		}

	}
}
