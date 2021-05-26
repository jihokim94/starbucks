package ui.find;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class IdOrPwFindFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IdOrPwFindFrame frame = new IdOrPwFindFrame();
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
	public IdOrPwFindFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logo\\로고(50x50).jpg"));
		setTitle("아이디 / 비밀번호 찾기 시스템");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 457);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("images\\logo\\로고(150x150).png"));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel.setBounds(17, 10, 600, 150);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("아이디/비밀번호 찾기");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(263, 176, 118, 15);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		separator.setForeground(new Color(0, 102, 51));
		separator.setBounds(12, 179, 241, 8);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.WHITE);
		separator_1.setForeground(new Color(0, 102, 51));
		separator_1.setBounds(391, 182, 231, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("아이디, 비밀번호가 생각나지 않으세요?");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(7, 221, 610, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("본인 인증을 통해 스타벅스  회원 아이디, 비밀번호를 찾으실 수 있습니다.");
		label.setForeground(new Color(0, 102, 51));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setBounds(7, 246, 610, 15);
		contentPane.add(label);
		
		JPanel pnId = new JPanel();
		pnId.setBorder(new LineBorder(new Color(0, 102, 51), 1, true));
		pnId.setBackground(new Color(255, 255, 255));
		pnId.setBounds(17, 286, 600, 111);
		contentPane.add(pnId);
		pnId.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("아이디 / 비밀번호 찾기");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_3.setBounds(174, 10, 252, 15);
		pnId.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("아래 버튼을 선택하시면, 본인인증을 통해 고객님의 아이디와 비밀번호를 찾아드립니다.");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(12, 35, 576, 15);
		pnId.add(lblNewLabel_4);
		
		JButton btnFindId = new JButton("아이디 / 비밀번호 찾기");
		btnFindId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdFindDialog dlg = new IdFindDialog();
				dlg.setVisible(true);
			}
		});
		btnFindId.setFont(new Font("굴림", Font.PLAIN, 12));
		btnFindId.setBackground(new Color(0, 102, 51));
		btnFindId.setForeground(new Color(255, 255, 255));
		btnFindId.setBounds(209, 60, 182, 41);
		pnId.add(btnFindId);
	}
}
