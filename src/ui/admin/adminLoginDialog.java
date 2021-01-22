package ui.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import data.db.AdminDBMgr;
import data.db.MemberDBMgr;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminLoginDialog extends JDialog {

   private final JPanel contentPanel = new JPanel();
   private JTextField txtLogin;
   private JPasswordField psfPW;
   adminLoginDialog loginDlg;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      try {
    	  adminLoginDialog dialog = new adminLoginDialog();
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setVisible(true);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Create the dialog.
    */
   public adminLoginDialog() {
	   this.loginDlg =loginDlg;
   	setTitle("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
      setBounds(100, 100, 532, 511);
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBackground(new Color(0, 102, 51));
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);
      
      JPanel panel = new JPanel();
      panel.setBackground(new Color(255, 255, 255));
      panel.setBounds(50, 206, 415, 256);
      contentPanel.add(panel);
      panel.setLayout(null);
      
      txtLogin = new JTextField();
      txtLogin.setBorder(new LineBorder(new Color(0, 102, 51)));
      txtLogin.setForeground(Color.BLACK);
      txtLogin.setBounds(14, 49, 389, 37);
      panel.add(txtLogin);
      txtLogin.setColumns(10);
      
      JLabel lblNewLabel_2 = new JLabel("\uBE44\uBC00\uBC88\uD638");
      lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
      lblNewLabel_2.setBounds(12, 106, 391, 15);
      panel.add(lblNewLabel_2);
      
      JLabel label = new JLabel("\uC544\uC774\uB514");
      label.setFont(new Font("굴림", Font.BOLD, 12));
      label.setBounds(12, 22, 391, 15);
      panel.add(label);
      
      JButton button = new JButton("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
      button.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		String login =txtLogin.getText();
      		String pw =new String(psfPW.getPassword());
      		
      		AdminDBMgr mgr = new AdminDBMgr();
      		int r =mgr.loginProcess(login, pw);
      		switch (r) {
            case MemberDBMgr.LOGIN_SUCCESS:

               JOptionPane.showMessageDialog(null, "로그인에 성공하셨습니다.");
               
               setVisible(false);
               adminMain adMain = new adminMain();
               adMain.setVisible(true);
               
               break;
               
              

            case MemberDBMgr.LOGIN_NOT_FOUND:
              
               JOptionPane.showMessageDialog(null, "회원의 정보를 찾을 수 없습니다.");
               break;

            case MemberDBMgr.LOGIN_PW_MISMATCH:
              
               JOptionPane.showMessageDialog(null, "로그인 혹은 비밀번호가 틀리셨습니다.");
               break;

            case MemberDBMgr.LOGIN_ERROR:
               
               JOptionPane.showMessageDialog(null, "지원하지 않는 서비스입니다.");
               break;
               
               
              

            }
      		
      		
      	}
      });
      button.setFont(new Font("굴림", Font.BOLD, 13));
      button.setForeground(new Color(0, 0, 0));
      button.setBackground(new Color(0, 102, 51));
      button.setBounds(12, 194, 391, 40);
      panel.add(button);
      
      psfPW = new JPasswordField();
      psfPW.setBorder(new LineBorder(new Color(0, 121,51)));
      psfPW.setBounds(14, 131, 389, 37);
      panel.add(psfPW);
      
      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(150x150).png"));
      lblNewLabel.setBounds(12, 10, 492, 150);
      contentPanel.add(lblNewLabel);
      
      JLabel label_1 = new JLabel("스타벅스 관리자 로그인");
      label_1.setForeground(new Color(255, 255, 255));
      label_1.setHorizontalAlignment(SwingConstants.CENTER);
      label_1.setFont(new Font("굴림", Font.BOLD, 18));
      label_1.setBounds(50, 170, 415, 26);
      contentPanel.add(label_1);
   }
}