package ui.admin;

import adminFactory_sh.JButtonCreator;
import adminFactory_sh.JLabelCreator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import data.Member;
import data.db.MemberDBMgr;

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CustomerInfo extends JFrame {

   private JPanel contentPane;
   private JTextField txtSearch;
   private final ButtonGroup buttonGroup = new ButtonGroup();
   private JTextField txtName;
   private JTextField txtLogin;
   private JTextField txtPw;
   private JTextField txtEmail;
   private JTextField txtPhone;
   private JTextField txtBirth;
   private final ButtonGroup btnGroup = new ButtonGroup();
   
   MemberDBMgr mgr;  
   JRadioButton rdMale;
   JRadioButton rdFemale;
   DefaultTableModel dtm;
   private JTable MemberTable;
   private JTextField txtId;

   
   public CustomerInfo() {
      this.mgr = new MemberDBMgr();
      setResizable(false);
      setTitle("\uD68C\uC6D0\uC815\uBCF4 \uBC0F \uAD00\uB9AC");
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setBounds(100, 100, 999, 710);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);
      
      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.SOUTH);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBackground(new Color(0, 128, 0));
      panel_1.setForeground(Color.BLACK);
      contentPane.add(panel_1, BorderLayout.CENTER);
      panel_1.setLayout(null);
      
      JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uB9AC\uC2A4\uD2B8");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
      lblNewLabel.setBounds(97, 16, 147, 29);
      panel_1.add(lblNewLabel);
      
      JButton btnAllMembers = new JButton("\uD68C\uC6D0 \uC804\uCCB4 \uB9AC\uC2A4\uD2B8");
      btnAllMembers.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	txtSearch.setText("");
            showSpecificMember("");
            
         }
      });
      btnAllMembers.setBounds(813, 13, 147, 23);
      panel_1.add(btnAllMembers);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
      scrollPane.setBounds(256, 52, 715, 581);
      panel_1.add(scrollPane);
//      String [] headings = {"관리 번호","이름","아이디","비밀번호","이메일","휴대폰 번호","생년월일","성별"};
//                  
//      Object [][] rowdata = new Object[mbList.size()][headings.length]; // coustomer.getUserList();  // return Object[][size = 5]디비에서  오브젝트 2차 배열로 요소갑들 불러와서 저장
//      showAllMemberDB();
         
//      table = new JTable(rowdata, headings);
//      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//      scrollPane.setViewportView(table);
      
      MemberTable = new JTable();
//      showAllMemberDB();
      MemberTable.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            int selRow = MemberTable.getSelectedRow();
            
            txtId.setText(MemberTable.getValueAt(selRow, 0).toString());
            txtName.setText(MemberTable.getValueAt(selRow, 1).toString());
            txtLogin.setText(MemberTable.getValueAt(selRow,2).toString());
            txtPw.setText(MemberTable.getValueAt(selRow, 3).toString());
            txtEmail.setText(MemberTable.getValueAt(selRow, 4).toString());
            txtPhone.setText(MemberTable.getValueAt(selRow, 5).toString());
            txtBirth.setText(MemberTable.getValueAt(MemberTable.getSelectedRow(), 6).toString());
            
            if((MemberTable.getValueAt(MemberTable.getSelectedRow(), 7) == "남자")) {
               rdMale.setSelected(true);
            }else {
               rdFemale.setSelected(true);
            }
            
            
         
           
         
            
         }
      });
      scrollPane.setViewportView(MemberTable);
//      showAllMemberDB();
      
      txtSearch = new JTextField();
      txtSearch.addKeyListener(new KeyAdapter() {
      	@Override
      	public void keyReleased(KeyEvent e) {
//      		String target =txtSearch.getText();
//      		searchMember(target);
      	}
      });
      
      txtSearch.setBounds(368, 14, 337, 21);
      panel_1.add(txtSearch);
      txtSearch.setColumns(10);
      
      JPanel panel_2 = new JPanel();
      panel_2.setBackground(new Color(255, 255, 255));
      panel_2.setBounds(12, 55, 232, 578);
      panel_1.add(panel_2);
      panel_2.setLayout(null);
      
      JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
      lblNewLabel_1.setFont(new Font("돋움", Font.BOLD, 14));
      lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_1.setBounds(12, 69, 69, 31);
      panel_2.add(lblNewLabel_1);
      
      txtName = new JTextField();
      txtName.setHorizontalAlignment(SwingConstants.CENTER);
      txtName.setBounds(93, 69, 116, 34);
      panel_2.add(txtName);
      txtName.setColumns(10);
      
      JLabel label = new JLabel("\uC544\uC774\uB514");
      label.setFont(new Font("돋움", Font.BOLD, 14));
      label.setHorizontalAlignment(SwingConstants.CENTER);
      label.setBounds(12, 125, 69, 31);
      panel_2.add(label);
      
      txtLogin = new JTextField();
      txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
      txtLogin.setColumns(10);
      txtLogin.setBounds(93, 125, 116, 34);
      panel_2.add(txtLogin);
      
      JLabel label_1 = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
      label_1.setFont(new Font("돋움", Font.BOLD, 14));
      label_1.setHorizontalAlignment(SwingConstants.CENTER);
      label_1.setBounds(12, 191, 69, 31);
      panel_2.add(label_1);
      
      txtPw = new JTextField();
      txtPw.setHorizontalAlignment(SwingConstants.CENTER);
      txtPw.setColumns(10);
      txtPw.setBounds(93, 191, 116, 34);
      panel_2.add(txtPw);
      
      JLabel label_2 = new JLabel("\uC774\uBA54\uC77C");
      label_2.setFont(new Font("돋움", Font.BOLD, 14));
      label_2.setHorizontalAlignment(SwingConstants.CENTER);
      label_2.setBounds(12, 248, 69, 31);
      panel_2.add(label_2);
      
      txtEmail = new JTextField();
      txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
      txtEmail.setColumns(10);
      txtEmail.setBounds(93, 248, 116, 34);
      panel_2.add(txtEmail);
      
      JLabel label_3 = new JLabel("\uD734\uB300\uD3F0");
      label_3.setFont(new Font("돋움", Font.BOLD, 14));
      label_3.setHorizontalAlignment(SwingConstants.CENTER);
      label_3.setBounds(12, 309, 69, 31);
      panel_2.add(label_3);
      
      txtPhone = new JTextField();
      txtPhone.setText("-\uB97C\uBE7C\uACE0\uC785\uB825");
      txtPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtPhone.setForeground(Color.BLACK);
				txtPhone.setBackground(Color.YELLOW);
				String phone = txtPhone.getText();
				
				if( phone.equals("-를빼고입력") )
					txtPhone.setText("");
			}			
			@Override
			public void focusLost(FocusEvent e) {
				txtPhone.setBackground(Color.WHITE);
				txtPhone.setForeground(Color.BLACK);
				String phone = txtPhone.getText();
				if(phone.contains("-"))
				{
					JOptionPane.showMessageDialog(null, "-를빼고입력");
					txtPhone.setText("-를빼고입력");
				}
				if( phone.isEmpty() ) {
					txtPhone.setText("-를빼고입력");
				}
			}
		});
      txtPhone.setHorizontalAlignment(SwingConstants.CENTER);
      txtPhone.setColumns(10);
      txtPhone.setBounds(93, 309, 116, 34);
      panel_2.add(txtPhone);
      
      JLabel label_4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
      label_4.setFont(new Font("돋움", Font.BOLD, 14));
      label_4.setHorizontalAlignment(SwingConstants.CENTER);
      label_4.setBounds(12, 372, 69, 31);
      panel_2.add(label_4);
      
      txtBirth = new JTextField();
      txtBirth.setText("yyyymmdd\uD615\uC2DD");
      txtBirth.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtBirth.setForeground(Color.BLACK);
				txtBirth.setBackground(Color.YELLOW);
				String birth = txtBirth.getText();
				if( birth.equals("yyyymmdd형식")) {
					txtBirth.setText("");
				} 
					
			}			
			@Override
			public void focusLost(FocusEvent e) {
				txtBirth.setBackground(Color.WHITE);
				txtBirth.setForeground(Color.BLACK);
				String birth = txtBirth.getText();
				if(birth.contains("-") || birth.toCharArray().length>=9 ||birth.toCharArray().length <=7) {
					JOptionPane.showMessageDialog(null, "yyyymmdd형식에 맞지 않습니다");
					txtBirth.setText("yyyymmdd형식");
				}
					
				if( birth.isEmpty() ) {
					txtBirth.setText("yyyymmdd형식");
				}
			}
		});
      txtBirth.setHorizontalAlignment(SwingConstants.CENTER);
      txtBirth.setColumns(10);
      txtBirth.setBounds(93, 372, 116, 34);
      panel_2.add(txtBirth);
      
      JLabel label_5 = new JLabel("\uC131\uBCC4");
      label_5.setFont(new Font("돋움", Font.BOLD, 14));
      label_5.setHorizontalAlignment(SwingConstants.CENTER);
      label_5.setBounds(12, 429, 69, 31);
      panel_2.add(label_5);
      
       rdMale = new JRadioButton("\uB0A8\uC790");
      btnGroup.add(rdMale);
      rdMale.setBounds(93, 437, 57, 23);
      panel_2.add(rdMale);
      
      rdFemale = new JRadioButton("\uC5EC\uC790");
      btnGroup.add(rdFemale);
      rdFemale.setBounds(154, 437, 57, 23);
      panel_2.add(rdFemale);
      
      
      JButton btnTxtClear = new JButton("\uC9C0\uC6B0\uAE30");
      btnTxtClear.setBounds(128, 497, 92, 23);
      panel_2.add(btnTxtClear);
      
      JButton btnUpdateMember = new JButton("\uD68C\uC6D0\uC218\uC815");
      btnUpdateMember.setBounds(24, 530, 92, 23);
      panel_2.add(btnUpdateMember);
      
      
      JButton btnAddMember = new JButton("\uD68C\uC6D0\uCD94\uAC00");
      btnAddMember.setBounds(24, 497, 92, 23);
      panel_2.add(btnAddMember);
      
      JButton btnDeleteMember = new JButton("\uD68C\uC6D0\uC0AD\uC81C");
      btnDeleteMember.setBounds(128, 530, 92, 23);
      panel_2.add(btnDeleteMember);
      
      txtId = new JTextField();
      txtId.setEditable(false);
      txtId.setHorizontalAlignment(SwingConstants.CENTER);
      txtId.setColumns(10);
      txtId.setBounds(93, 9, 116, 34);
      panel_2.add(txtId);
      
      JLabel label_6 = new JLabel("\uAD00\uB9AC\uBC88\uD638");
      label_6.setHorizontalAlignment(SwingConstants.CENTER);
      label_6.setFont(new Font("돋움", Font.BOLD, 14));
      label_6.setBounds(12, 11, 69, 31);
      panel_2.add(label_6);
      
      JButton btnSearch = new JButton("\uAC80\uC0C9");
      btnSearch.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String target =txtSearch.getText();
            searchMember(target);
            
         }
      });
      btnSearch.setBounds(720, 13, 81, 23);
      panel_1.add(btnSearch);
      
//      showSpecificMember(txtSearch.getText());
      
      JLabel lblNewLabel_2 = new JLabel("\uD68C\uC6D0 \uAC80\uC0C9");
      lblNewLabel_2.setFont(new Font("HY나무B", Font.BOLD, 18));
      lblNewLabel_2.setBackground(Color.BLACK);
      lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel_2.setBounds(260, 13, 114, 23);
      panel_1.add(lblNewLabel_2);
      
      JLabel lbImage = new JLabel("");
      ImageIcon ic = new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(150x150).png");
	  Image scaled = ic.getImage().getScaledInstance(60, 40, Image.SCALE_FAST);
		
		ic.setImage(scaled);
		lbImage.setIcon(ic);
      lbImage.repaint();
      lbImage.setBounds(23, 2, 81, 53);
      panel_1.add(lbImage);
      btnDeleteMember.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(txtId.getText());
            String login = txtLogin.getText();
            System.out.println(id);
            System.out.println(login);
            boolean b =mgr.deleteOneMember(id, login);
            if (b) {
               JOptionPane.showMessageDialog(null, login+"회원 삭제 성공");
            }else {
//               System.out.println("회원 삭제 실패 ");
               
               JOptionPane.showMessageDialog(null, login+"회원 삭제 실패");
            }
         }
      });
      btnAddMember.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            
            
            String name =txtName.getText();
             String login =txtLogin.getText();
             String pw =txtPw.getText();
             int gender  = rdMale.isSelected() ? 1:2;
             String birth = txtBirth.getText();
             String email = txtEmail.getText();
             String phone = txtPhone.getText();
             
             
             Member mb = new Member(name, login, pw, gender, birth, email, phone);
//             MemberDBMgr mgr = new MemberDBMgr();
            
             if(mb != null) {
            	 JOptionPane.showMessageDialog(null, login+"회원가입 추가성공");
            	 mgr.AddOneMember(mb);
                
                  
             }else {
            	 JOptionPane.showMessageDialog(null, login+"회원가입 추가실패");
                System.out.println("올바른 정보를 기입해 주세요!");
             }
            
             
            
         }
      });
      btnUpdateMember.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            String login =txtLogin.getText();
             String pw =txtPw.getText();
             String email = txtEmail.getText();
             String phone = txtPhone.getText();
             String birth =txtBirth.getText();
             int gender =rdMale.isSelected() ? 1:2;
             
             Member mb = new Member(id,name, login, pw, gender, birth, email, phone);
             boolean b = mgr.editOneMember(mb);
             if(b) { 
                System.out.println(name +" 님의 정보를 수정했습니다");
                JOptionPane.showMessageDialog(null, name +" 님의 정보를 수정했습니다");
             } else {
                System.out.println(name +" 님의 정보를 수정 실패 하였습니다");
                JOptionPane.showMessageDialog(null, name +" 님의 정보를 수정 실패 하였습니다");
             }
             
            
            
         }
      });
      btnTxtClear.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            txtId.setText("");
            txtName.setText("");
            txtLogin.setText("");
             txtPw.setText("");
             txtEmail.setText("");
             txtPhone.setText("-를빼고입력");
             txtBirth.setText("yyyymmdd형식");
             btnGroup.clearSelection();
//             rdFemale.setSelected(false);
//             rdMale.setSelected(false);
         
            
         }
      });
      
   }
   public void showSpecificMember(String target) {
      final String [] columnNames = {"관리 번호","이름","아이디","비밀번호","이메일","휴대폰 번호","생년월일","성별"};
      
      //DB 

      ArrayList<Member> mbList =mgr.getAllMembers();
      Object[][] data = new Object[mbList.size()][columnNames.length];
      
      for (int i = 0; i < mbList.size(); i++) {
         Member mb = mbList.get(i);
         data[i][0] = mb.getId();
         data[i][1] = mb.getName();
         data[i][2] = mb.getLogin();
         data[i][3] = mb.getPw();
         data[i][4] = mb.getEmail();
         data[i][5] = mb.getPhone();
         data[i][6] = mb.getBirth();
         data[i][7] = mb.getGender() == 1 ? "남자":"여자";
         }
      
      
       dtm = new DefaultTableModel(data, columnNames);
      MemberTable.setModel(dtm);
      
      TableRowSorter<TableModel> trs=new TableRowSorter<TableModel>( MemberTable.getModel());

      MemberTable.setRowSorter(trs);

      trs.setRowFilter(RowFilter.regexFilter(target));
      

      
      
   }
   public void searchMember(String target) {
      TableRowSorter<TableModel> trs=new TableRowSorter<TableModel>( MemberTable.getModel());

      MemberTable.setRowSorter(trs);

      trs.setRowFilter(RowFilter.regexFilter(target));
   }
   
   public void showAllMemberDB() {
      final String [] columnNames = {"관리 번호","이름","아이디","비밀번호","이메일","휴대폰 번호","생년월일","성별"};
      
      //DB 

      ArrayList<Member> mbList =mgr.getAllMembers();
      Object[][] data = new Object[mbList.size()][columnNames.length];
      
      for (int i = 0; i < mbList.size(); i++) {
         Member mb = mbList.get(i);
         data[i][0] = mb.getId();
         data[i][1] = mb.getName();
         data[i][2] = mb.getLogin();
         data[i][3] = mb.getPw();
         data[i][4] = mb.getEmail();
         data[i][5] = mb.getPhone();
         data[i][6] = mb.getBirth();
         data[i][7] = mb.getGender() == 1 ? "남자":"여자";
         }
      
      
      dtm = new DefaultTableModel(data, columnNames);
      MemberTable.setModel(dtm);
   
   
      
   }
}