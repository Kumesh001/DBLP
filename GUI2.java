// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

public class GUI2 implements ActionListener {

	private static JTextField publications=new JTextField();
	private static JTextArea box=new JTextArea();
	public JFrame f; 
	public JButton reset =new JButton("Reset");
	private static String column[]={"S.No","Author"}; 
	private static String row[][]={{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},
			{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""},{"",""}};
	private static JTable jt=new JTable(row,column);
	
	public GUI2()
	{}
	
	public JTable gettable()
	{
		return jt;
	}
//	
//	public void settable(JTable jt1,JTable jt2)
//	{
////		  objects o=new objects();
////		o.get_GUI().gettable()=jt2;
//		jt=jt2;
//		System.out.println("Table is changed2222");
//	}
	
	public JTextField getpublications()
	{
		return publications;
	}
	

	public void setmessage(String message)
	{
		box.setText(message);
	}
	
	public JTextArea getbox()
	{
		box.setEditable(false);
		return box;
	}

	
	public JButton Query2_Button()
	{
		JButton b=new JButton("Query2");
		b.addActionListener(new GUI2());
		return b;
	}
	
	public void puttable(ArrayList<String> data,int k)
	{
		  objects o=new objects();

		  JTable jt2=o.get_GUI2().gettable();
		  
//		  DefaultTableModel tableModel = new DefaultTableModel(data,k) {
//
//			    @Override
//			    public boolean isCellEditable(int row, int column) {
//			       //all cells false
//			       return false;
//			    }
//			};
		  
		  for(int i=0;i<20;i++)
		  {
			  if(i+k<data.size()){
			  String q=data.get(i+k);
			  jt2.setValueAt(String.valueOf(i+1), i, 0);
			  jt2.setValueAt(q, i, 1);
			  }
			  else
			  {
				  jt2.setValueAt(String.valueOf(i+1), i, 0);
				  jt2.setValueAt("", i, 1);
			  }
			  
		  }
		  
		  o.getnotify().setnext(k+20);
	
		//return jt2;
	}

public void start(){ 
	Start s=new Start();
	s.f.setVisible(false);
  f=new JFrame();    
  JPanel panel1 = WestPanel();										//left	
  JPanel panel2 = new JPanel();										//right	
  JPanel panel3 = new JPanel();										//upper
  
  JLabel label1 = new JLabel("DBLP QUERY SEARCH ENGINE",JLabel.CENTER);
  Font font = new Font("Serif", Font.BOLD, 100);
  label1.setFont(font);
  panel3.add(label1,BorderLayout.CENTER);
  
//  String data2[][]={ {"101","Amit","670000"},  
//          {"102","Jai","780000"}, {"101","Sachin","700000"}};  
//String column2[]={"2015111","VAibhav","10,00,000"}; 
//JTable jt2=new JTable(data2,column2);
//DefaultTableModel tableModel = new DefaultTableModel(data2, column2) {
//
//    @Override
//    public boolean isCellEditable(int row, int column) {
//       //all cells false
//       return false;
//    }
//};
//
//jt2.setModel(tableModel);
//jt2.setMinimumSize(new Dimension(500,500));
  JScrollPane sp2=new JScrollPane(jt);
  sp2.setPreferredSize(new Dimension(1400,750));
//panel2.add(sp2);
//JScrollPane sp2=new JScrollPane(jt2);
//sp2.setMinimumSize(new Dimension(1000,1000));
//jt2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
panel2.add(sp2);
//panel2.setMinimumSize(new Dimension(1000,1000));
 
  
  JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, panel1,panel2);
  splitPane1.setOneTouchExpandable(true);
  splitPane1.setDividerSize(10);
  splitPane1.setDividerLocation(500);
  
  JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel3,splitPane1);
  splitPane2.setOneTouchExpandable(true);
  splitPane2.setDividerLocation(200);
  splitPane2.setDividerSize(20);
  
   
    f.add(splitPane2);
    f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    f.setUndecorated(false);
    f.setVisible(true);
} 

///////////////////////////////////////////////////////////////////////////////////////////
public JPanel WestPanel()
{
	JPanel panel =new JPanel(new GridLayout(16,0));
	panel.add(new JLabel());
	panel.add(new JLabel("QUERY2",JLabel.CENTER));
	panel.add(new JLabel());
	
	
	panel.add(new JLabel());
	
	panel.add(new JLabel());
	
	JPanel p2=new JPanel(new GridLayout(0,2));
	p2.add(new JLabel("No. of Publications -",JLabel.CENTER));
	objects o=new objects();
	p2.add(o.get_GUI2().getpublications());
	panel.add(p2);
	
	panel.add(new JLabel());
	
	panel.add(new JLabel());											

	panel.add(new JLabel());
	

	
	panel.add(new JLabel());
	
	panel.add(new JLabel());
	
	
	JPanel p7=new JPanel(new GridLayout(0,5));
	p7.add(new JLabel());
	
	p7.add(o.getsearch().get_query2_search_button());
	p7.add(new JLabel());
	p7.add(o.get_GUI2().reset);
	p7.add(new JLabel());
	panel.add(p7);
	
	
	panel.add(new JLabel());
	
	JPanel p8=new JPanel(new GridLayout(0,5));
	p8.add(new JLabel());
	p8.add(new JLabel());
	Next20 n=new Next20();
	p8.add(n.getb2());
	p8.add(new JLabel());
	p8.add(new JLabel());
	panel.add(p8);
	

	panel.add(new JLabel());
	
	panel.add(o.get_GUI2().getbox());
	
	    
	return panel;
	
}
 


/////////////////////////////////////////////////////////////////////////////////////////////////////////
public void actionPerformed(ActionEvent e)
{
	objects o=new objects();
	o.get_GUI2().start();
}



public static void main(String[] args) {  
	try {
	    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
	        if ("Nimbus".equals(info.getName())) {
	            UIManager.setLookAndFeel(info.getClassName());
	            break;
	        }
	    }
	} catch (Exception e) {
	    // If Nimbus is not available, you can set the GUI to another look and feel.
	}
	GUI2 g=new GUI2();
	g.start();
} 
	
}
