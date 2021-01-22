package ui.payment;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoneyComplete extends JFrame {
/*
 * 최종 결제 화면 
 * 확인 누르면 종료되도록
 */
	private JPanel contentPane;
	JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoneyComplete frame = new MoneyComplete();
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
	public MoneyComplete() {
		setTitle("\uACB0\uC81C\uC644\uB8CC");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\dev2020\\java_ws\\TProject\\images\\icon_card.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 359, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uACB0\uC81C\uAC00 \uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4.\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 10, 142, 56);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\uAC10\uC0AC\uD569\uB2C8\uB2E4");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(95, 33, 142, 56);
		contentPane.add(label);
		
		btnOk = new JButton("\uD655\uC778");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Money2 m2 = new Money2();
				m2.setVisible(false);
				
			}
		});
		btnOk.setBounds(122, 114, 97, 23);
		contentPane.add(btnOk);
	}
}
