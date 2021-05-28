package ui.find;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Member;
import data.db.MemberDBMgr;
import ui.main.MainFrame;
import uimainFactory.JButtonCreator;
import uimainFactory.JLabelCreator;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class IdFindDialog extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IdFindDialog dialog = new IdFindDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	JPanel pnCenter;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtCode;
	private JTextField txtId;
	private JTextField txtPwCode;

	MemberDBMgr mgr;
	private JTextField txtPhone2;
	private JTextField txtPwPhone2;
	private JTextField txtPwPhone3;

	public IdFindDialog() {

		mgr = new MemberDBMgr();

		setTitle("스타벅스 아이디/비밀번호 찾기 시스템");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		createMenuBar();

		pnCenter = new JPanel();
		pnCenter.setBounds(0, 20, 434, 241);
		getContentPane().add(pnCenter);
		pnCenter.setLayout(new CardLayout(0, 0));

		createIDFinder();
		createPWFinder();
	}

	private void createPWFinder() {
		JButtonCreator buttoncreator = new JButtonCreator();
		JLabelCreator labelcreator = new JLabelCreator();
		
		JPanel pnPwFind = new JPanel();
		pnPwFind.setBackground(new Color(255, 255, 255));
		pnCenter.add(pnPwFind, "pw");
		pnPwFind.setLayout(null);

		JLabel PurposeLabel = (JLabel) labelcreator.createWithFont("스타벅스 멤버 비밀번호 찾기","굴림", Font.PLAIN , 12, 10, 410, 15,12);
		PurposeLabel.setForeground(new Color(0, 102, 51));
		PurposeLabel.setBackground(Color.WHITE);
		pnPwFind.add(PurposeLabel);

		JLabel DescriptLabel = (JLabel) labelcreator.createWithFont("본인정보에 등록한 핸드폰번호와 입력한 핸드폰번호가 같아야","굴림", Font.PLAIN , 12, 35, 410, 15,12);
		pnPwFind.add(DescriptLabel);

		JLabel DescriptLabel2 = (JLabel) labelcreator.createWithFont("인증번호를 받을 수 있습니다.","굴림", Font.PLAIN , 12, 54, 410, 15,12);
		pnPwFind.add(DescriptLabel2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 102, 51));
		separator_1.setBounds(12, 79, 410, 2);
		pnPwFind.add(separator_1);

		JLabel lbId = (JLabel) labelcreator.createWithFont("아이디","굴림", Font.PLAIN , 12, 104, 72, 15,12);
		lbId.setHorizontalAlignment(SwingConstants.LEFT);
		pnPwFind.add(lbId);

		JLabel lbPhone2 = (JLabel) labelcreator.createWithFont("핸드폰번호","굴림", Font.PLAIN ,12, 135, 72, 15,12);
		lbPhone2.setHorizontalAlignment(SwingConstants.LEFT);
		pnPwFind.add(lbPhone2);

		JComboBox comboPwPhone = new JComboBox();
		comboPwPhone.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "017", "018", "019", "070" }));
		comboPwPhone.setFont(new Font("굴림", Font.PLAIN, 12));
		comboPwPhone.setBackground(Color.WHITE);
		comboPwPhone.setBounds(96, 132, 52, 21);
		pnPwFind.add(comboPwPhone);

		txtId = new JTextField();
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtId.getText().equals("")) {
					txtId.setText("");
				} else {
					txtId.selectAll();
				}
			}
		});
		txtId.setFont(new Font("굴림", Font.PLAIN, 12));
		txtId.setColumns(10);
		txtId.setBounds(96, 101, 198, 21);
		pnPwFind.add(txtId);

		JLabel phoneNumberSeperator = (JLabel) labelcreator.createWithFont("-","굴림", Font.PLAIN , 160, 135, 6, 15,12);
		phoneNumberSeperator.setHorizontalAlignment(SwingConstants.CENTER);
		pnPwFind.add(phoneNumberSeperator);

		txtPwCode = new JTextField();
		txtPwCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPwCode.getText().equals("")) {
					txtPwCode.setText("");
				} else {
					txtPwCode.selectAll();
				}
			}

		});
		txtPwCode.setText("인증번호 6자리 입력하기");
		txtPwCode.setForeground(Color.LIGHT_GRAY);
		txtPwCode.setFont(new Font("굴림", Font.PLAIN, 12));
		txtPwCode.setColumns(10);
		txtPwCode.setBounds(96, 163, 198, 21);
		pnPwFind.add(txtPwCode);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 102, 51));
		separator_2.setBounds(12, 196, 410, 2);
		pnPwFind.add(separator_2);

		JButton btnPwFind = (JButton) buttoncreator.createWithFont("비밀번호 찾기", "굴림", Font.PLAIN,223, 208, 116, 23,12);
		btnPwFind.setForeground(Color.WHITE);
		btnPwFind.setBackground(new Color(0, 102, 51));
		btnPwFindFunction(btnPwFind);
		pnPwFind.add(btnPwFind);

		JButton btnPwCancel = (JButton) buttoncreator.createWithFont("취소", "굴림", Font.PLAIN,351, 208, 71, 23,12);
		btnPwCancel.setForeground(Color.WHITE);
		btnPwCancel.setBackground(new Color(0, 102, 51));
		btnPwCancelFunction(btnPwCancel);
		pnPwFind.add(btnPwCancel);

		txtPwPhone2 = new JTextField();
		txtPwPhone2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPwPhone2.getText().equals("")) {
					txtPwPhone2.setText("");
				} else {
					txtPwPhone2.selectAll();
				}

			}
		});
		txtPwPhone2.setFont(new Font("굴림", Font.PLAIN, 12));
		txtPwPhone2.setColumns(10);
		txtPwPhone2.setBounds(178, 132, 52, 21);
		pnPwFind.add(txtPwPhone2);

		JLabel phoneNumberSeperator2 = (JLabel) labelcreator.createWithFont("-","굴림", Font.PLAIN , 242, 135, 6, 15,12);
		pnPwFind.add(phoneNumberSeperator2);

		txtPwPhone3 = new JTextField();
		txtPwPhone3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPwPhone3.getText().equals("")) {
					txtPwPhone3.setText("");
				} else {
					txtPwPhone3.selectAll();
				}
			}
		});
		txtPwPhone3.setFont(new Font("굴림", Font.PLAIN, 12));
		txtPwPhone3.setColumns(10);
		txtPwPhone3.setBounds(260, 132, 52, 21);
		pnPwFind.add(txtPwPhone3);

		JButton btnPwCode = (JButton) buttoncreator.createWithFont("인증번호", "굴림", Font.PLAIN,334, 131, 88, 23,12);
		btnPwCode.setBackground(Color.WHITE);
		btnPwCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ran = new Random();
				int n = ran.nextInt(900000) + 100000;
				String varCode = String.valueOf(n);

				if (txtId.getText().isEmpty() && txtPwPhone2.getText().isEmpty() && txtPwPhone3.getText().isEmpty()) {
					System.out.println("등록되지 않은 번호입니다.");
					JOptionPane.showMessageDialog(null, "등록되지 않은 번호입니다.");
				} else {
					System.out.println("인증번호는 '" + varCode + "' 입니다.");
					JOptionPane.showMessageDialog(null, "인증번호는 '" + varCode + "' 입니다.");
				}
			}
		});

		pnPwFind.add(btnPwCode);
	}

	private void btnPwCancelFunction(JButton btnPwCancel) {
		btnPwCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
			}
		});
	}

	private void btnPwFindFunction(JButton btnPwFind) {
		btnPwFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtId != null || !txtId.getText().isEmpty() || !txtPwPhone2.getText().isEmpty()
						|| !txtPwPhone3.getText().isEmpty()) {
					// 입력 데이터 추출
					String login = txtId.getText();
					System.out.println("입력하신 이름은 " + login);
					// DB 연동
					// Member mb = new Member(name, phone);
					Member b = mgr.getOneMemberFindPw(login);
					if (b != null) {
						JOptionPane.showMessageDialog(null, (login + "님의 비밀번호는 " + b.getPw() + "입니다."));
					} else {
						JOptionPane.showMessageDialog(null, login + "님의 아이디는 찾을 수 없습니다.");
					}
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "정보를 입력해주세요");
				}
			}
		});
	}

	private void createIDFinder() {
		JButtonCreator buttoncreator = new JButtonCreator();
		JLabelCreator labelcreator = new JLabelCreator();
		JPanel pnIdFind = new JPanel();
		pnIdFind.setBackground(Color.WHITE);
		pnCenter.add(pnIdFind, "id");
		pnIdFind.setLayout(null);

		JLabel lbName = (JLabel) labelcreator.createWithFont("이름","굴림", Font.PLAIN , 12, 104, 72, 15,12);
		lbName.setHorizontalAlignment(SwingConstants.LEFT);
		pnIdFind.add(lbName);

		JLabel lbPhone = (JLabel) labelcreator.createWithFont("핸드폰번호","굴림", Font.PLAIN , 12, 135, 72, 15,12);
		lbPhone.setHorizontalAlignment(SwingConstants.LEFT);
		pnIdFind.add(lbPhone);

		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtName.getText().equals("")) {
					txtName.setText("");
				} else {
					txtName.selectAll();
				}
			}
		});
		txtName.setFont(new Font("굴림", Font.PLAIN, 12));
		txtName.setBounds(96, 101, 198, 21);
		pnIdFind.add(txtName);
		txtName.setColumns(10);

		JComboBox comboPhone = new JComboBox();
		comboPhone.setBackground(new Color(255, 255, 255));
		comboPhone.setFont(new Font("굴림", Font.PLAIN, 12));
		comboPhone.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "017", "018", "019", "070" }));
		comboPhone.setBounds(96, 132, 52, 21);
		pnIdFind.add(comboPhone);

		JLabel lblNewLabel = (JLabel) labelcreator.createWithFont("-","굴림", Font.PLAIN ,160, 135, 6, 15,12);
		pnIdFind.add(lblNewLabel);

		txtPhone = new JTextField();
		txtPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPhone.getText().equals("")) {
					txtPhone.setText("");
				} else {
					txtPhone.selectAll();
				}
			}
		});
		txtPhone.setFont(new Font("굴림", Font.PLAIN, 12));
		txtPhone.setBounds(178, 132, 52, 21);
		pnIdFind.add(txtPhone);
		txtPhone.setColumns(10);

		JButton btnCode = (JButton) buttoncreator.createWithFont("인증번호", "굴림", Font.PLAIN,334, 131, 88, 23,12);
		btnCode.setBackground(new Color(255, 255, 255));
		btnCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Random ran = new Random();
				int n = ran.nextInt(900000) + 100000;
				String varCode = String.valueOf(n);

				if (txtName.getText().isEmpty() && txtPhone.getText().isEmpty() && txtPhone2.getText().isEmpty()) {
					System.out.println("등록되지 않은 번호입니다.");
					JOptionPane.showMessageDialog(null, "등록되지 않은 번호입니다.");
				} else {
					System.out.println("인증번호는 '" + varCode + "' 입니다.");
					JOptionPane.showMessageDialog(null, "인증번호는 '" + varCode + "' 입니다.");
				}
			}
		});
		pnIdFind.add(btnCode);

		txtCode = new JTextField();
//		txtCode.setEnabled(false);
		txtCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtCode.getText().equals("인증번호 6자리 입력하기")) {
					txtCode.setText("");
					txtCode.setForeground(Color.black);
				} else {
					txtCode.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtCode.getText().equals("")) {
					txtCode.setText("인증번호 6자리 입력하기");
					txtCode.setForeground(Color.LIGHT_GRAY);
				} else {
					txtCode.selectAll();
				}
			}
		});
		txtCode.setForeground(Color.LIGHT_GRAY);
		txtCode.setFont(new Font("굴림", Font.PLAIN, 12));
		txtCode.setText("인증번호 6자리 입력하기");
		txtCode.setBounds(96, 163, 198, 21);
		pnIdFind.add(txtCode);
		txtCode.setColumns(10);

		JLabel TitleIDfinderLabel =(JLabel) labelcreator.createWithFont("스타벅스 멤버 아이디 찾기","굴림", Font.PLAIN ,12, 10, 410, 15,12);
		TitleIDfinderLabel.setForeground(new Color(0, 102, 51));
		TitleIDfinderLabel.setBackground(new Color(255, 255, 255));
		pnIdFind.add(TitleIDfinderLabel);

		JLabel DescriptIDfinderLabel = (JLabel) labelcreator.createWithFont("본인정보에 등록한 핸드폰번호와 입력한 핸드폰번호가 같아야","굴림", Font.PLAIN ,12, 35, 410, 15,12);
		pnIdFind.add(DescriptIDfinderLabel);

		JLabel DescriptIDfinderLabel2 =(JLabel) labelcreator.createWithFont("인증번호를 받을 수 있습니다.","굴림", Font.PLAIN ,12, 54, 410, 15,12);
		pnIdFind.add(DescriptIDfinderLabel2);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 102, 51));
		separator.setBounds(12, 79, 410, 2);
		pnIdFind.add(separator);

		JButton btnCancel = (JButton) buttoncreator.createWithFont("취소", "굴림", Font.PLAIN,351, 208, 71, 23,12);
		btnCancelFunction(btnCancel);
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(0, 102, 51));
		pnIdFind.add(btnCancel);

		JButton btnIdFind =(JButton) buttoncreator.createWithFont("아이디 찾기", "굴림", Font.PLAIN,223, 208, 116, 23,12);
		btnIdFind.setForeground(new Color(255, 255, 255));
		btnIdFind.setBackground(new Color(0, 102, 51));
		btnIdFindFunction(btnIdFind);

		pnIdFind.add(btnIdFind);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 102, 51));
		separator_3.setBounds(12, 196, 410, 2);
		pnIdFind.add(separator_3);

		txtPhone2 = new JTextField();
		txtPhone2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPhone.getText().equals("")) {
					txtPhone.setText("");
				} else {
					txtPhone.selectAll();
				}
			}
		});
		txtPhone2.setFont(new Font("굴림", Font.PLAIN, 12));
		txtPhone2.setColumns(10);
		txtPhone2.setBounds(260, 132, 52, 21);
		pnIdFind.add(txtPhone2);

		JLabel label_5 = new JLabel("-");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(242, 135, 6, 15);
		pnIdFind.add(label_5);
	}

	private void btnIdFindFunction(JButton btnIdFind) {
		btnIdFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName != null || !txtName.getText().isEmpty() || !txtPhone.getText().isEmpty()
						|| !txtPhone2.getText().isEmpty()) {
					System.out.println("회원가입 DB 통신...");
					// 입력 데이터 추출
					String name = txtName.getText();
					System.out.println("입력하신 이름은 " + name);
					// DB 연동
					// Member mb = new Member(name, phone);
					Member b = mgr.getOneMemberFindId(name);
					if (b != null) {
						JOptionPane.showMessageDialog(null, (name + "님의 아이디는 " + b.getLogin() + "입니다."));
					} else {
						JOptionPane.showMessageDialog(null, name + "님의 아이디는 찾을 수 없습니다.");
					}
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "정보를 입력해주세요");
				}
			}
		});
	}

	private void btnCancelFunction(JButton btnCancel) {
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
			}
		});
	}

	private void createMenuBar() {
		JButtonCreator buttoncreator = new JButtonCreator();
		JLabelCreator labelcreator = new JLabelCreator();
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 102, 51));
		menuBar.setBounds(0, 0, 434, 25);
		getContentPane().add(menuBar);

		JButton btnFindId =  (JButton) buttoncreator.createWithFont("아이디 찾기", "굴림", Font.PLAIN,223, 208, 116, 23,12);
		btnFindId.setBackground(Color.WHITE);
		btnFindId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) pnCenter.getLayout();
				c.show(pnCenter, "id");

			}
		});
		menuBar.add(btnFindId);

		JButton btnFindPw = (JButton) buttoncreator.createWithFont("비밀번호 찾기", "굴림", Font.PLAIN,223, 208, 116, 23,12);
		btnFindPw.setBackground(Color.WHITE);
		btnFindPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) pnCenter.getLayout();
				c.show(pnCenter, "pw");
			}
		});
		menuBar.add(btnFindPw);
	}
}
