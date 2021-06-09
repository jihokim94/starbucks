package ui.admin;

import java.awt.BorderLayout;
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
import PanelDecorate.PanelBackground;
import PanelDecorate.PanelBorder;
import PanelDecorate.PanelLayout;
import TextDecorate.NonTextEditable;
import TextDecorate.TextBound;
import TextDecorate.TextColumns;
import data.Product;
import data.db.ProductDBMgr;

public class ProductInfo extends JFrame {
	
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
		JPanel pnSub = new PanelLayout(new PanelBackground(new JPanel(),255, 255, 255)).getPanel();
		splitPane.setRightComponent(pnSub);
		
		lbImage = 
				new LabelBackGround(new LabelHorizon(new LabelIcon(new LabelBound(new JLabel(""), 12, 20, 245, 220), "C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\\uB85C\uACE0(150x150).png")), 0, 255, 0).getLabel();
		pnSub.add(lbImage);
		
		JLabel lbID = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\\uAD00\\uB9AC \\uBC88\\uD638"),266,105, 18,13 ), "����",12,Font.BOLD)).getLabel();
		pnSub.add(lbID);
		
		JLabel lb_productName = 
				new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uC0C1\uD488\uBA85"),314,105, 18,13 ), "����",12,Font.BOLD)).getLabel();
		pnSub.add(lb_productName);
		
		txtName =  new TextColumns(new TextBound(new JTextField(),129,311, 128 ,21), 10).getTextField();
		pnSub.add(txtName);
		
		JLabel lb_category = 
				new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uCE74\uD14C\uACE0\uB9AC"),360,105, 18,13 ), "����",12,Font.BOLD)).getLabel();
		pnSub.add(lb_category);
		
		JLabel lb_imagePath = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uC0AC\uC9C4\uD30C\uC77C\uACBD\uB85C"),405,105, 18,13), "����",12,Font.BOLD)).getLabel();
		pnSub.add(lb_imagePath);
		
		txtImagePath = new TextColumns(new TextBound(new JTextField(),129, 404,105 ,21), 10).getTextField();
		pnSub.add(txtImagePath);
		
		JLabel lb_price = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uAC00\uACA9"),457,105, 18,13), "����",12,Font.BOLD)).getLabel();

		pnSub.add(lb_price);
		
		txtPrice = new TextColumns(new TextBound(new JTextField(),129,454,128 ,21), 10).getTextField();
		pnSub.add(txtPrice);
		
		JLabel lb_presence = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uC720\uBB34"),504,105, 18 ,13), "����",12,Font.BOLD)).getLabel();

		pnSub.add(lb_presence);
		
		JButton btnProductAdd = setBtnProductAdd();
		pnSub.add(btnProductAdd);
		
		JButton button = setBtnInitialize();
		pnSub.add(button);
		
		JButton btnProductModify = setBtnProductModify();
		pnSub.add(btnProductModify);
		
		JButton btnProductRemove = setBtnProductRemove();
		pnSub.add(btnProductRemove);
		
		JLabel lb_realeaseDate = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uCD9C\uC2DC\uC77C"),541,105, 18,13), "����",12,Font.BOLD)).getLabel();
		pnSub.add(lb_realeaseDate);
		
		txtRegDate=new NonTextEditable(new TextColumns(new TextBound(new JTextField(),129,538, 128 ,21), 10)).getTextField();
		pnSub.add(txtRegDate);
		
		setBtnRd(129, 500, 62, 23,"HOT");
		pnSub.add(rdHot);
		
		setBtnRd(195, 500, 53, 23,"ICE");
		pnSub.add(rdIce);
		
		setComboCategory();
		pnSub.add(comboCatgory);
		txtID=new NonTextEditable(new TextColumns(new TextBound(new JTextField(),129,265, 128 ,21), 10)).getTextField();
		pnSub.add(txtID);
		
		JButton btnNewButton_1 = setbtnopenFolder();
		pnSub.add(btnNewButton_1);
	}

	private void makePnMain(JSplitPane splitPane) {
		JPanel pnMain = setpnMain(splitPane);
		
		JLabel lb_productList = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("\uC0C1\uD488 \uB9AC\uC2A4\uD2B8"),10,165,49,13), "����",12,Font.BOLD)).getLabel();
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

	private void settxtSearch() {
		txtSearch = new TextBound(new JTextField(),189, 24, 186, 25).getTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String target = txtSearch.getText();
				showSearchProduct(target);
			}
		});
	}
	
	private void setBtnRd(int x,int y, int w,int h,String type) {
		JRadioButton rd ;
		if(type.equals("ICE")) {
			rdIce = new JRadioButton("ICE");
			rd = rdIce ;
		}
		else {
			rdHot = new JRadioButton("HOT");
			rd = rdHot ;
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
		JButton button_2 = new ButtonBound(new JButton("\uC0C1\uD488 \uC0AD\uC81C"),144, 629, 113, 23).getButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�Է� �о���� 
				int id =Integer.parseInt(txtID.getText());
				String name =txtName.getText();
				//product manager���� product ���� ��û 
				int r =mgr.deleteOneProdcut(id,name);
				if (r == 1) {
					JOptionPane.showMessageDialog(null, name+"��ǰ ���� ����");
				}else {
					JOptionPane.showMessageDialog(null, name+"ȸ�� ���� ����");
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
				//product manager ��ü method �� product ���� ��û 
				boolean b =mgr.editOneProduct(pd);
				//���� ����,���� print�� Ȯ�� 
				checkOperation(name, b,"����");
				
			}
		});
		return button_1;
	}
	
	private void checkOperation(String name, boolean b, String operation) {
		if(b) {
			JOptionPane.showMessageDialog(null,name+ operation+"����!!");	
		}else {
				JOptionPane.showMessageDialog(null,name+ operation+"����!!");	
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
				lbImage.setIcon(new ImageIcon("C:\\dev2020\\java_ws\\Starbucks\\images\\logo\\�ΰ�(150x150).png"));	
			}
		});
		return button;
	}
	private JButton setBtnProductAdd() {
		JButton btnNewButton = new ButtonBound(new JButton("\uC0C1\uD488 \uCD94\uAC00"),23, 584, 108, 23).getButton();
				new JButton("\uC0C1\uD488 \uCD94\uAC00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//�Է� �о���� 
				String name = txtName.getText();
				String category= getCategory() ;
				String imagePath = getImagePath();
				int price = getPrice();
				int hot = getHot();
				//product ���� 
				Product pd = new Product(name, category, imagePath, price, hot);
				//manager���� ��û �� ���� ���� Ȯ�� 
				boolean b =mgr.addNewOneProduct(pd) ;
				checkOperation(name, b, "�߰�");
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
		JButton btnProductList = new ButtonBound(new ButtonFont(new JButton("\uC0C1\uD488 \uC804\uCCB4 \uB9AC\uC2A4\uD2B8"), "����", Font.BOLD, 12), 
				446, 22, 133, 28).getButton();
		btnProductList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSearch.setText("");
				showSearchProduct("");
			}
		});
		return btnProductList;
	}

	
	private JPanel setpnMain(JSplitPane splitPane) {
		JPanel pnMain = new PanelBackground(new PanelLayout(new JPanel()), 0, 101, 70).getPanel();
		splitPane.setLeftComponent(pnMain);
		return pnMain;
	}
	
	private void setContentPane() {
		contentPane = new PanelBorder(new PanelLayout(new JPanel(),0,0), 5, 5, 5, 5).getPanel();
		setContentPane(contentPane);
	}
	


	private void setpdTable() {
		pdTable = new JTable();
		pdTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				 {"���� ��ȣ", "��ǰ��", "ī�װ�", "�������ϰ��", "����", "HOT/ICE" ,"�����"};
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
		final String [] columnNames = {"���� ��ȣ", "��ǰ��", "ī�װ�", "�������ϰ��", "����", "HOT/ICE" ,"�����"};
		
		//DB 
		ProductDBMgr pdMgr = new ProductDBMgr();
		ArrayList<Product> pdList =pdMgr.getAllProducts();
		Object[][] data = new Object[pdList.size()][columnNames.length];
		//������ �о���� 
		getTableData(pdList, data);
		//���̺� ����� 
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
		String [] columnNames = {"���� ��ȣ", "��ǰ��", "ī�װ�", "�������ϰ��", "����", "HOT/ICE" ,"�����"};
		ProductDBMgr pdMgr = new ProductDBMgr();
		ArrayList<Product> pdList = pdMgr.getAllProducts();
		Object[][] data = new Object[pdList.size()][columnNames.length];
		
		getTableData(pdList, data);
		
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		pdTable.setModel(dtm);
	}
}
