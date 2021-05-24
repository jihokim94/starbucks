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
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logo\\\uB85C\uACE0(50x50).jpg"));
		setTitle("\uC544\uC774\uB514 / \uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30 \uC2DC\uC2A4\uD15C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 457);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("images\\logo\\\uB85C\uACE0(150x150).png"));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel.setBounds(17, 10, 600, 150);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 12));
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
		
		JLabel lblNewLabel_2 = new JLabel("\uC544\uC774\uB514, \uBE44\uBC00\uBC88\uD638\uAC00 \uC0DD\uAC01\uB098\uC9C0 \uC54A\uC73C\uC138\uC694?");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(7, 221, 610, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\uBCF8\uC778 \uC778\uC99D\uC744 \uD1B5\uD574 \uC2A4\uD0C0\uBC85\uC2A4 \uD68C\uC6D0 \uC544\uC774\uB514, \uBE44\uBC00\uBC88\uD638\uB97C \uCC3E\uC73C\uC2E4 \uC218 \uC788\uC2B5\uB2C8\uB2E4.");
		label.setForeground(new Color(0, 102, 51));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label.setBounds(7, 246, 610, 15);
		contentPane.add(label);
		
		JPanel pnId = new JPanel();
		pnId.setBorder(new LineBorder(new Color(0, 102, 51), 1, true));
		pnId.setBackground(new Color(255, 255, 255));
		pnId.setBounds(17, 286, 600, 111);
		contentPane.add(pnId);
		pnId.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("\uC544\uC774\uB514 / \uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblNewLabel_3.setBounds(174, 10, 252, 15);
		pnId.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC544\uB798 \uBC84\uD2BC\uC744 \uC120\uD0DD\uD558\uC2DC\uBA74, \uBCF8\uC778\uC778\uC99D\uC744 \uD1B5\uD574 \uACE0\uAC1D\uB2D8\uC758 \uC544\uC774\uB514\uC640 \uBE44\uBC00\uBC88\uD638\uB97C \uCC3E\uC544\uB4DC\uB9BD\uB2C8\uB2E4.");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(12, 35, 576, 15);
		pnId.add(lblNewLabel_4);
		
		JButton btnFindId = new JButton("\uC544\uC774\uB514 / \uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnFindId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdFindDialog dlg = new IdFindDialog();
				dlg.setVisible(true);
			}
		});
		btnFindId.setFont(new Font("±¼¸²", Font.PLAIN, 12));
		btnFindId.setBackground(new Color(0, 102, 51));
		btnFindId.setForeground(new Color(255, 255, 255));
		btnFindId.setBounds(209, 60, 182, 41);
		pnId.add(btnFindId);
	}
}
