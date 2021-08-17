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
		
		JLabel StarbucksLogoLabel = new LabelForeGround( new LabelFont(new LabelBound(new LabelIcon(new LabelHorizon(new JLabel("")),"images\\logo\\로고(150x150).png"), 17, 10, 600, 150),"굴림",12,Font.PLAIN),0,0,0).getLabel();
		contentPane.add(StarbucksLogoLabel);
		
		JLabel FrameTitleLabel = new LabelForeGround(new LabelFont(new LabelBound(new JLabel("아이디/비밀번호 찾기"), 263,176,118,15),"굴림",12,Font.PLAIN),0,0,0).getLabel();
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
		
		JLabel FrameDescriptLabel = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("아이디, 비밀번호가 생각나지 않으세요?"), 7,221,610,15),"굴림",15,Font.PLAIN)).getLabel();
		contentPane.add(FrameDescriptLabel);
		
		JLabel FrameDescriptLabel2 = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("본인 인증을 통해 스타벅스  회원 아이디, 비밀번호를 찾으실 수 있습니다."), 7,246,610,15),"굴림",15,Font.BOLD)).getLabel();
		contentPane.add(FrameDescriptLabel2);
		
		JPanel pnId = new JPanel();
		pnId.setBorder(new LineBorder(new Color(0, 102, 51), 1, true));
		pnId.setBackground(new Color(255, 255, 255));
		pnId.setBounds(17, 286, 600, 111);
		contentPane.add(pnId);
		pnId.setLayout(null);
		
		JLabel FrameDescriptLabel3 = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("아이디 / 비밀번호 찾기"), 174, 10, 252,15),"굴림",12,Font.BOLD)).getLabel();
		pnId.add(FrameDescriptLabel3);
		
		JLabel FrameDescriptLabel4 = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("아래 버튼을 선택하시면, 본인인증을 통해 고객님의 아이디와 비밀번호를 찾아드립니다."), 12, 35, 576,15),"굴림",12,Font.PLAIN)).getLabel();
		pnId.add(FrameDescriptLabel4);
		
		JButton btnFindId = new ButtonFont(new ButtonBound(new ButtonForeGround(new ButtonBackGround(new JButton("아이디 / 비밀번호 찾기"),0,102,51 ),255,255,255), 209,60,182,41),"굴림",12,Font.PLAIN).getButton();
		btnFindIdFunction(btnFindId);
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
