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

import uimainFactory.JButtonCreator;
import uimainFactory.JLabelCreator;

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
		JButtonCreator buttoncreator = new JButtonCreator();
		JLabelCreator labelcreator = new JLabelCreator();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logo\\로고(50x50).jpg"));
		setTitle("아이디 / 비밀번호 찾기 시스템");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 457);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel StarbucksLogoLabel = (JLabel) labelcreator.createWithIcon("스타벅스 멤버 비밀번호 찾기","images\\logo\\로고(150x150).png" ,17, 10, 600, 150);
		StarbucksLogoLabel.setForeground(Color.BLACK);
		contentPane.add(StarbucksLogoLabel);
		
		JLabel FrameTitleLabel = (JLabel) labelcreator.createWithFont("아이디/비밀번호 찾기", "굴림", Font.PLAIN, 263, 176, 118, 15, 12);
		FrameTitleLabel.setForeground(Color.BLACK);
		contentPane.add(FrameTitleLabel);
		
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
		
		JLabel FrameDescriptLabel = (JLabel) labelcreator.createWithFont("아이디, 비밀번호가 생각나지 않으세요?", "굴림", Font.PLAIN, 7, 221, 610, 15, 15);
		contentPane.add(FrameDescriptLabel);
		
		JLabel FrameDescriptLabel2 = (JLabel) labelcreator.createWithFont("본인 인증을 통해 스타벅스  회원 아이디, 비밀번호를 찾으실 수 있습니다.", "굴림", Font.BOLD, 7, 246, 610, 15, 15);
		FrameDescriptLabel2.setForeground(new Color(0, 102, 51));
		contentPane.add(FrameDescriptLabel2);
		
		JPanel pnId = new JPanel();
		pnId.setBorder(new LineBorder(new Color(0, 102, 51), 1, true));
		pnId.setBackground(new Color(255, 255, 255));
		pnId.setBounds(17, 286, 600, 111);
		contentPane.add(pnId);
		pnId.setLayout(null);
		
		JLabel FrameDescriptLabel3 = (JLabel) labelcreator.createWithFont("아이디 / 비밀번호 찾기", "굴림", Font.BOLD, 174, 10, 252, 15, 12);
		pnId.add(FrameDescriptLabel3);
		
		JLabel FrameDescriptLabel4 =  (JLabel) labelcreator.createWithFont("아래 버튼을 선택하시면, 본인인증을 통해 고객님의 아이디와 비밀번호를 찾아드립니다.", "굴림", Font.PLAIN, 12, 35, 576, 15, 12);
		pnId.add(FrameDescriptLabel4);
		
		JButton btnFindId = (JButton) buttoncreator.createWithFont("아이디 / 비밀번호 찾기", "굴림", Font.PLAIN,209, 60, 182, 41,12);
		btnFindIdFunction(btnFindId);
		btnFindId.setBackground(new Color(0, 102, 51));
		btnFindId.setForeground(new Color(255, 255, 255));

		pnId.add(btnFindId);
	}

	private void btnFindIdFunction(JButton btnFindId) {
		btnFindId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdFindDialog dlg = new IdFindDialog();
				dlg.setVisible(true);
			}
		});
	}
}
