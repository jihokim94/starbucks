package ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ButtonDecorate.ButtonBackGround;
import ButtonDecorate.ButtonBound;
import ButtonDecorate.ButtonFont;
import ButtonDecorate.ButtonForeGround;
import LabelDecorate.LabelBound;
import LabelDecorate.LabelFont;
import LabelDecorate.LabelHorizon;
import LabelDecorate.LabelIcon;
import PanelDecorate.PanelBackground;
import PanelDecorate.PanelBound;
import PanelDecorate.PanelLayout;
import TextDecorate.TextBorder;
import TextDecorate.TextBound;
import TextDecorate.TextColumns;
import TextDecorate.TextForeGroud;
import data.db.AdminDBMgr;
import data.db.MemberDBMgr;

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
   	  setLoginDialog();
      
      setPanel();
      
      setIcon();
      
      setLogin();
   }

private void setLogin() {
	JLabel labelLogin = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("��Ÿ���� ������ �α���"),
			50, 170, 415, 26), "����",Font.BOLD,12)).getLabel();
      contentPanel.add(labelLogin);
}

private void setIcon() {
	JLabel lblNewLabel = new LabelHorizon(new LabelIcon(
			new LabelBound(new JLabel(""),12, 10, 492, 150), 
			"C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(150x150).png")).getLabel();
      contentPanel.add(lblNewLabel);
}

private void setLoginDialog() {
	setTitle("\uAD00\uB9AC\uC790 \uB85C\uADF8\uC778");
    setBounds(100, 100, 532, 511);
      
      getContentPane().setLayout(new BorderLayout());
      contentPanel.setBackground(new Color(0, 102, 51));
      contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
      getContentPane().add(contentPanel, BorderLayout.CENTER);
      contentPanel.setLayout(null);
}

private void setPanel() {
	JPanel panel =  new PanelLayout(new PanelBackground(new PanelBound(new JPanel(),50, 206, 415, 256),255, 255, 255)).getPanel();
      contentPanel.add(panel);
      
      txtLogin =new TextColumns(new TextBorder(new TextBound(new TextForeGroud(new JTextField(), 0,0,0),14, 49, 389, 37),0, 102, 51),10).getTextField();
      panel.add(txtLogin);
      
      JLabel lblNewLabel_2 = new LabelFont(new LabelBound(new JLabel("\uBE44\uBC00\uBC88\uD638"),
    		  12, 106, 391, 15), "����", Font.BOLD, 12).getLabel();
      panel.add(lblNewLabel_2);
      
      JLabel label = new LabelFont(new LabelBound(new JLabel("\uC544\uC774\uB514"),
    		  12, 22, 391, 15), "����", Font.BOLD, 12).getLabel();
      panel.add(label);
      
      JButton button = new ButtonFont(new ButtonForeGround(
    		  new ButtonBackGround(new ButtonBound(new JButton("\uAD00\uB9AC\uC790\uB85C\uADF8\uC778"), 12, 194, 391, 40)
    				  , 0, 102, 51), 0, 0, 0), "����", Font.BOLD, 13).getButton();
      button.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent arg0) {
      		String login =txtLogin.getText();
      		String pw =new String(psfPW.getPassword());
      		
      		AdminDBMgr mgr = new AdminDBMgr();
      		int r =mgr.loginProcess(login, pw);
      		switch (r) {
            case MemberDBMgr.LOGIN_SUCCESS:
               JOptionPane.showMessageDialog(null, "�α��ο� �����ϼ̽��ϴ�.");
               setVisible(false);
               adminMain adMain = new adminMain();
               adMain.setVisible(true);
               break;
            case MemberDBMgr.LOGIN_NOT_FOUND:
               JOptionPane.showMessageDialog(null, "ȸ���� ������ ã�� �� �����ϴ�.");
               break;
            case MemberDBMgr.LOGIN_PW_MISMATCH:
               JOptionPane.showMessageDialog(null, "�α��� Ȥ�� ��й�ȣ�� Ʋ���̽��ϴ�.");
               break;

            case MemberDBMgr.LOGIN_ERROR:
               JOptionPane.showMessageDialog(null, "�������� �ʴ� �����Դϴ�.");
               break;
            }
      	}
      });
     
      panel.add(button);
      
      setJpasswordField();
      panel.add(psfPW);
}


private void setJpasswordField() {
	psfPW = new JPasswordField();
      psfPW.setBorder(new LineBorder(new Color(0, 121,51)));
      psfPW.setBounds(14, 131, 389, 37);
}


}