package ui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import ButtonDecorate.ButtonBound;
import ButtonDecorate.ButtonFont;
import ButtonDecorate.ButtonIcon;
import LabelDecorate.LabelBackGround;
import LabelDecorate.LabelBound;
import LabelDecorate.LabelFont;
import LabelDecorate.LabelHorizon;
import LabelDecorate.LabelIcon;
import adminFactory_jy.JButtonCreator;
import adminFactory_jy.JLabelCreator;
import data.Product;
import data.db.ProductDBMgr;

public class ProductInfo extends JFrame {
	
	private JButtonCreator btncreator;
	private JLabelCreator labelcreator;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtImagePath;
	private JTextField txtPrice;
	private JTextField txtRegDate;
	private final ButtonGroup btnHotIceGruop = new ButtonGroup();
	private JTable pdTable;
	JComboBox comboCatgory;
	JRadioButton rdHot;
	JRadioButton rdIce;
	private JTextField txtID;
	ProductDBMgr mgr ;
	ProductInfo PInfo;
	JLabel lbImage;
	private JTextField txtSearch;
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ProductInfo frame = new ProductInfo();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */

	private int getHot() {
		int hot = rdHot.isSelected()?1:2;
		return hot;
	}

	private int getPrice() {
		int price = Integer.parseInt(txtPrice.getText());
		return price;
	}

	private String getImagePath() {
		String imagePath = txtImagePath.getText();
		return imagePath;
	}

	private String getCategory() {
		String category= (String) comboCatgory.getSelectedItem();
		return category;
	}

	private int getId() {
		int id = Integer.parseInt(txtID.getText());
		return id;
	}

	private Date getDate() {
		String date = txtRegDate.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date regDay = null;
		try {
			regDay = sdf.parse(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return regDay;
	}
	
	public ProductInfo() {
		labelcreator = new JLabelCreator();
		btncreator = new JButtonCreator();
		
		this.PInfo =PInfo;
		this.mgr= new ProductDBMgr();
		
		setProductInfo();
		JSplitPane splitPane = setJsplitPane();
		makePnMain(splitPane);
		makePnSub(splitPane);
		
		
	}

	private void setProductInfo() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("\uC0C1\uD488\uAD00\uB9AC");
		setBounds(100, 100, 926, 734);
		setContentPane();
	}

	private void makePnSub(JSplitPane splitPane) {
		JPanel pnSub = setpnsub();
		splitPane.setRightComponent(pnSub);
		pnSub.setLayout(null);
		
		lbImage = 
				new LabelBackGround(new LabelHorizon(new LabelIcon(new LabelBound(new JLabel(""), 12, 20, 245, 220), "C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(150x150).png")), 0, 255, 0).getLabel();
		pnSub.add(lbImage);
		
		JLabel lbID = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\\uAD00\\uB9AC \\uBC88\\uD638"),266,105, 18,13 ), "굴림",12,Font.BOLD)).getLabel();
		pnSub.add(lbID);
		
		JLabel lb_productName = 
				new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uC0C1\uD488\uBA85"),314,105, 18,13 ), "굴림",12,Font.BOLD)).getLabel();
		pnSub.add(lb_productName);
		
		setTxtField(txtName,  311, 128);
		pnSub.add(txtName);
		
		JLabel lb_category = 
				new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uCE74\uD14C\uACE0\uB9AC"),360,105, 18,13 ), "굴림",12,Font.BOLD)).getLabel();
		pnSub.add(lb_category);
		
		JLabel lb_imagePath = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uC0AC\uC9C4\uD30C\uC77C\uACBD\uB85C"),405,105, 18,13), "굴림",12,Font.BOLD)).getLabel();
		pnSub.add(lb_imagePath);
		
		setTxtField(txtImagePath, 404,105);
		pnSub.add(txtImagePath);
		
		JLabel lb_price = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uAC00\uACA9"),457,105, 18,13), "굴림",12,Font.BOLD)).getLabel();

		pnSub.add(lb_price);
		
		setTxtField(txtPrice, 454,128);
		pnSub.add(txtPrice);
		
		JLabel lb_presence = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uC720\uBB34"),504,105, 18 ,13), "굴림",12,Font.BOLD)).getLabel();

		pnSub.add(lb_presence);
		
		JButton btnProductAdd = setBtnProductAdd();
		pnSub.add(btnProductAdd);
		
		JButton button = setBtnInitialize();
		pnSub.add(button);
		
		JButton btnProductModify = setBtnProductModify();
		pnSub.add(btnProductModify);
		
		JButton btnProductRemove = setBtnProductRemove();
		pnSub.add(btnProductRemove);
		
		JLabel lb_realeaseDate = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uCD9C\uC2DC\uC77C"),541,105, 18,13), "굴림",12,Font.BOLD)).getLabel();
		pnSub.add(lb_realeaseDate);
		
		setNonEditableTxtField(txtRegDate, 538);
		pnSub.add(txtRegDate);
		
		setBtnRd(rdHot,129, 500, 62, 23);
		pnSub.add(rdHot);
		
		setBtnRd(rdIce,195, 500, 53, 23);
		pnSub.add(rdIce);
		
		setComboCategory();
		pnSub.add(comboCatgory);
		
		setNonEditableTxtField(txtID, 265);
		pnSub.add(txtID);
		
		JButton btnNewButton_1 = setbtnopenFolder();
		pnSub.add(btnNewButton_1);
	}

	private void makePnMain(JSplitPane splitPane) {
		JPanel pnMain = setpnMain(splitPane);
		
		JLabel lb_productList = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uC0C1\uD488 \uB9AC\uC2A4\uD2B8"),10,165,49,13), "굴림",12,Font.BOLD)).getLabel();
		pnMain.add(lb_productList);
		
		JButton btnProductList = setBtnProductList();
		pnMain.add(btnProductList);
		
		JScrollPane scrollPane = setScrollPane();
		pnMain.add(scrollPane);
		
		setpdTable();
		scrollPane.setViewportView(pdTable);
		
		settxtSearch();
		pnMain.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnclear = setbtnClear();
		pnMain.add(btnclear);
	}
	private void setComboCategory() {
		comboCatgory = new JComboBox();
		comboCatgory.setModel(new DefaultComboBoxModel(new String[] {"Coffee", "Beverage", "Salad", "Dessert"}));
		comboCatgory.setSelectedIndex(0);
		comboCatgory.setBounds(129, 357, 128, 21);
	}
	private JScrollPane setScrollPane() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 69, 541, 553);
		return scrollPane;
	}

	private JSplitPane setJsplitPane() {
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.7);
		contentPane.add(splitPane, BorderLayout.CENTER);
		return splitPane;
	}
	
	private void setTxtField(JTextField txtField, int y,int w) {
		txtField = new JTextField();
		txtField.setColumns(10);
		txtField.setBounds(129, y,w ,21);
	}
	
	private void setNonEditableTxtField(JTextField txtField, int y) {
		txtField = new JTextField();
		txtField.setEditable(false);
		txtField.setColumns(10);
		txtField.setBounds(129, y,128 ,21);
	}
	
	private void settxtSearch() {
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String target = txtSearch.getText();
				showSearchProduct(target);
			}
		});
		txtSearch.setBounds(189, 24, 186, 25);
	}
	
	private void setBtnRd(JRadioButton rd, int x,int y, int w,int h) {
		if(rd.equals(rdIce)) {
			rd = new JRadioButton("ICE");
		}
		else {
			rd = new JRadioButton("HOT");
		}
		btnHotIceGruop.add(rd);
		rd.setBounds(x,y,w,h);
	}
	
	private JButton setbtnopenFolder() {
		JButton btnOpenFolder = new ButtonIcon(new ButtonBound(new JButton(""), 235, 403, 22, 23), 
				"C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\folder.png").getButton();
		btnOpenFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final String currentDirectoryPath 	= "./images";
				JFileChooser openDlg = new JFileChooser(currentDirectoryPath);
				int r = openDlg.showOpenDialog(PInfo);
				if( r == JFileChooser.APPROVE_OPTION ) {
					File selImgFile = openDlg.getSelectedFile();
					txtImagePath.setText(selImgFile.getPath());
					lbImage.setIcon(new ImageIcon(selImgFile.getPath()));
				}
			}
		});
		return btnOpenFolder;
	}

	private JButton setBtnProductRemove() {
		JButton button_2 = new ButtonBound(new JButton("\uC0C1\uD488 \uC0AD\uC81C"),144, 629, 113, 23);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//입력 읽어오기 
				int id =Integer.parseInt(txtID.getText());
				String name =txtName.getText();
				//product manager에게 product 삭제 요청 
				int r =mgr.deleteOneProdcut(id,name);
				if (r == 1) {
					JOptionPane.showMessageDialog(null, name+"상품 삭제 성공");
				}else {
					JOptionPane.showMessageDialog(null, name+"회원 삭제 실패");
				}
			}
		});
		return button_2;
	}
	
	private JButton setBtnProductModify() {
		JButton button_1 = new ButtonBound(new JButton("\uC0C1\uD488 \uC218\uC815"),23, 629, 108, 23).getButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//read input 
				int id = getId();
				String name = txtName.getText();
				String category = getCategory();
				String imagePath = getImagePath();
				int price = getPrice();
				int hot = getHot();
				//read date 
				Date regDay = getDate();
				//construct product object 
				Product pd = new Product(id, name, category, imagePath, price, hot, regDay);
				//product manager 객체 method 로 product 변경 요청 
				boolean b =mgr.editOneProduct(pd);
				//변경 성공,실패 print로 확인 
				checkOperation(name, b,"수정");
				
			}
		});
		return button_1;
	}
	
	private void checkOperation(String name, boolean b, String operation) {
		if(b) {
			JOptionPane.showMessageDialog(null,name+ operation+"성공!!");	
		}else {
				JOptionPane.showMessageDialog(null,name+ operation+"실패!!");	
		}
	}
	
	private JButton setBtnInitialize() {
		JButton button = new ButtonBound(new JButton("\uBAA9\uB85D \uBE44\uC6B0\uAE30"), 143, 584, 114, 23).getButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtID.setText("");
				txtName.setText("");
				txtImagePath.setText("");
				comboCatgory.setSelectedIndex(1);
				btnHotIceGruop.clearSelection();
				txtPrice.setText("");
				txtRegDate.setText("");
				lbImage.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\로고(150x150).png"));	
			}
		});
		return button;
	}
	private JButton setBtnProductAdd() {
		JButton btnNewButton = new ButtonBound(new JButton("\uC0C1\uD488 \uCD94\uAC00"),23, 584, 108, 23).getButton();
				new JButton("\uC0C1\uD488 \uCD94\uAC00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//입력 읽어오기 
				String name = txtName.getText();
				String category= getCategory() ;
				String imagePath = getImagePath();
				int price = getPrice();
				int hot = getHot();
				//product 생성 
				Product pd = new Product(name, category, imagePath, price, hot);
				//manager에게 요청 후 성공 실패 확인 
				boolean b =mgr.addNewOneProduct(pd) ;
				checkOperation(name, b, "추가");
			}
			
		});
		btnNewButton.setBounds(23, 584, 108, 23);
		return btnNewButton;
	}
	private JButton setbtnClear() {
		JButton btnclear = new ButtonIcon(new ButtonBound(new JButton(""),387, 25, 47, 23),
				"C:\\dev2020\\java_ws\\Starbucks\\images\\icons\\bin.png").getButton();
			btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearch.setText("");
				showSearchProduct("");
			}
		});
		btnclear.setToolTipText("\uD14D\uC2A4\uD2B8 \uC9C0\uC6B0\uAE30");
		return btnclear;
	}
	private JButton setBtnProductList() {
		JButton btnProductList = new ButtonBound(new ButtonFont(new JButton("\uC0C1\uD488 \uC804\uCCB4 \uB9AC\uC2A4\uD2B8"), "굴림", Font.BOLD, 12), 
				446, 22, 133, 28).getButton();
		btnProductList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSearch.setText("");
				showSearchProduct("");
			}
		});
		return btnProductList;
	}

	private JPanel setpnsub() {
		JPanel pnSub = new JPanel();
		pnSub.setBackground(new Color(255, 255, 255));
		return pnSub;
	}
	
	private JPanel setpnMain(JSplitPane splitPane) {
		JPanel pnMain = new JPanel();
		pnMain.setBackground(new Color(0, 101, 70));
		splitPane.setLeftComponent(pnMain);
		pnMain.setLayout(null);
		return pnMain;
	}
	
	private void setContentPane() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
	


	private void setpdTable() {
		pdTable = new JTable();
		pdTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				 {"관리 번호", "상품명", "카테고리", "사진파일경로", "가격", "HOT/ICE" ,"출시일"};
				int selRow = pdTable.getSelectedRow();
				
				String menu = pdTable.getValueAt(selRow, 2).toString(); 
				findMenu(menu);
				int id = (int) pdTable.getValueAt(selRow, 0);
				String name = (String) pdTable.getValueAt(selRow, 1);
				String imagePath = (String) pdTable.getValueAt(selRow, 3);
				int price =Integer.parseInt(pdTable.getValueAt(selRow, 4).toString());
				if( pdTable.getValueAt(selRow, 5).toString() == "HOT") rdHot.setSelected(true);
				else rdIce.setSelected(true);
				Date regDate = (Date) pdTable.getValueAt(selRow,6);
				String DayStr = regDate.toString();
//				Date regDate =(Date) pdTable.getValueAt(selRow, 6);
				setProduct(selRow, id, name, imagePath, price,DayStr);
//				comboCatgory.getSelectedIndex()pdTable.getValueAt(selRow, 2); // comboBox
			}

			private void setProduct(int selRow, int id, String name, String imagePath, int price,String DayStr) {
				txtID.setText(String.valueOf(id));
				txtName.setText(name);
				txtImagePath.setText(imagePath);
				lbImage.setIcon(new ImageIcon( "C:\\dev2020\\java_ws\\Starbucks\\images\\menu\\"+ imagePath));
				txtPrice.setText(String.valueOf(price));
				txtRegDate.setText(DayStr);
			}

			private void findMenu(String menu) {
				if(menu.equalsIgnoreCase("coffee")) {
					comboCatgory.setSelectedIndex(0);
				}else if (menu.equals("Beverage")) {
					comboCatgory.setSelectedIndex(1);
				}else if(menu.equals("Salad")){
					comboCatgory.setSelectedIndex(2);
				}else {
					comboCatgory.setSelectedIndex(3);
				}
			}
		});
	}


	
	public void showSearchProduct(String target) {
		final String [] columnNames = {"관리 번호", "상품명", "카테고리", "사진파일경로", "가격", "HOT/ICE" ,"출시일"};
		
		//DB 
		ProductDBMgr pdMgr = new ProductDBMgr();
		ArrayList<Product> pdList =pdMgr.getAllProducts();
		Object[][] data = new Object[pdList.size()][columnNames.length];
		//데이터 읽어오기 
		getTableData(pdList, data);
		//테이블 만들기 
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		pdTable.setModel(dtm);
				
		/*sort the table */
		TableRowSorter<TableModel> trs = sortTable();

		trs.setRowFilter(RowFilter.regexFilter(target));
	}
	private void getTableData(ArrayList<Product> pdList, Object[][] data) {
		for (int i = 0; i < pdList.size(); i++) {
			Product pd = pdList.get(i);
				data[i][0] = pd.getId();
				data[i][1] = pd.getName();
				data[i][2] = pd.getCategory();
				data[i][3] = pd.getImagePath();
				data[i][4] = pd.getPrice();
				data[i][5] = pd.getHot() == 1 ? "HOT":"ICE";
				data[i][6] = pd.getRegDay();		
		}
	}
	private TableRowSorter<TableModel> sortTable() {
		TableRowSorter<TableModel> trs=new TableRowSorter<TableModel>(pdTable.getModel());
		pdTable.setRowSorter(trs);
		return trs;
	}
	public void searchProduct(String target) {
	      TableRowSorter<TableModel> trs=new TableRowSorter<TableModel>( pdTable.getModel());

	      pdTable.setRowSorter(trs);

	      trs.setRowFilter(RowFilter.regexFilter(target));
	   }


	protected void showAllProduct() {
		String [] columnNames = {"관리 번호", "상품명", "카테고리", "사진파일경로", "가격", "HOT/ICE" ,"출시일"};
		ProductDBMgr pdMgr = new ProductDBMgr();
		ArrayList<Product> pdList = pdMgr.getAllProducts();
		Object[][] data = new Object[pdList.size()][columnNames.length];
		
		getTableData(pdList, data);
		
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		pdTable.setModel(dtm);
	}
}
