package menu.main.components;

import javax.swing.JPanel;
import javax.swing.JScrollBar;

import data.Product;
import data.db.ProductDBMgr;
import menu.basket.BasketDialog;
import menu.main.MainMenuFrame;
import menu.product.ProductPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;

public class MenuPanel extends JPanel
{
   MainMenuFrame frm;
   public JPanel pnCard;
   public CardLayout card;
   
   /**
    * Create the panel.
    */
   public MenuPanel(MainMenuFrame frm)
   {
      setPreferredSize(new Dimension(600, 500));
      this.frm = frm;
      ProductDBMgr mgr = new ProductDBMgr();
      HashMap<Integer, ArrayList<Product>> prMap = mgr.getProductsByType(); 
      
      System.out.println(prMap);
         
      
      setOpaque(true);
      setBackground(Color.white);
      setLayout(new BorderLayout(0, 0));
      

      
      card = new CardLayout(0, 0);
      pnCard = new JPanel();
      pnCard.setLayout(card);
      add(pnCard);
      
      ArrayList<Product> prList = null;
      
      for (int i = 0; i < Product.CATEGORY.length; i++)
      {
         prList = prMap.get(i);
         
         JPanel temp = new JPanel();
         temp.setLayout(new BorderLayout());
         
         
         JScrollPane scrollPane = new JScrollPane();
         scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
         scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
         scrollPane.getVerticalScrollBar().setUnitIncrement(15);
         temp.add(scrollPane, BorderLayout.CENTER);
         
         
         JPanel pn = new JPanel();
         pn.setLayout(new GridLayout(0, 3));
         
         pn.setOpaque(true);
         pn.setBackground(Color.white);
         
         for (int j = 0; j < prList.size(); j++)
         {
            Product pr = prList.get(j);
            ProductPanel pp = new ProductPanel(pr);
            pp.setPreferredSize(new Dimension(200, 250));
            pp.addMouseListener(new MouseAdapter()
            {
               @Override
               public void mouseClicked(MouseEvent e)
               {
                  BasketDialog bd = new BasketDialog(frm, pr);
                  bd.setVisible(true);
               }
            });
            pn.add(pp);
            scrollPane.setViewportView(pn);
         }
         pnCard.add(Product.CATEGORY[i], temp);
         prList.clear();
      }
      
   }

}