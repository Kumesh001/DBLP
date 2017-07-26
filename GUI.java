// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

  
public class GUI implements ActionListener{  
	
	private int b1;
	private int b2;
	private int b3;
	private int b4;
	public JFrame f; 
	private int b5;
	private int b6;
	public static JButton reset=new JButton("Reset");
	private static JTextField name=new JTextField();
	private static JTextArea box=new JTextArea();
	private static JTextField title=new JTextField();
	private static JTextField since_year=new JTextField();
	private static JTextField year1=new JTextField();
	
	private	static JTextField year2=new JTextField();
	private static JRadioButton r1=new JRadioButton("Sort by Year");
	private static JRadioButton r2=new JRadioButton("Sort by Relevance");
	private static String column[]={"S.No","Author","Title","Pages","Year","Volume","Journal","URL"}; 
	private static String row[][]={{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
			{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
			{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},
			{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""},{"","","","","","","",""}
	}; 
	private static JTable jt=new JTable(row,column);
	 
	

//////////////////////////////////////////////////////////////

	public GUI()
	{}
	
	public JTable gettable()
	{
		return jt;
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

//////////////////////////////////////////////////////////////		textfields
	
	public JTextField get_name()
	{
		return name;
	}
	
	public JTextField get_title()
	{
		return title;
	}
	
	public JTextField get_sinceyear()
	{
		return since_year;
	}
	
	public JTextField get_year1()
	{
		return year1;
	}
	
	public JTextField get_year2()
	{
		return year2;
	}
	
	public JRadioButton get_r1()
	{
		return r1;
	}
	
	public JRadioButton get_r2()
	{
		return r2;
	}
	
/////////////////////////////////////////////////////////////////	
	
	
	public JButton Query1_Button()
	{
		JButton b=new JButton("Query1");
		b.addActionListener(new GUI());
		return b;
	}
	
	public void puttable(ArrayList<query1_data> data,int k)
	{
		  objects o=new objects();

		  JTable jt2=o.get_GUI().gettable();
		  
		  for(int i=0;i<20;i++)
		  {
			  if(i+k<data.size()){
			  query1_data q=data.get(i+k);
			  jt2.setValueAt(String.valueOf(i+1), i, 0);
			  jt2.setValueAt(q.get_author(), i, 1);
			  jt2.setValueAt(q.get_title(), i, 2);
			  jt2.setValueAt(q.get_pages(), i, 3);
			  jt2.setValueAt(q.get_year(), i, 4);
			  jt2.setValueAt(q.get_volume(), i, 5);
			  jt2.setValueAt(q.get_journal(), i, 6);
			  jt2.setValueAt(q.get_url(), i, 7);
			  }
			  else
			  {
				  jt2.setValueAt(String.valueOf(i+1), i, 0);
				  jt2.setValueAt("", i, 1);
				  jt2.setValueAt("", i, 2);
				  jt2.setValueAt("", i, 3);
				  jt2.setValueAt("", i, 4);
				  jt2.setValueAt("", i, 5);
				  jt2.setValueAt("", i, 6);
				  jt2.setValueAt("", i, 7); 
			  }
			  
		  }
		  
		  o.getnotify().setnext(k+20);
		
		  
		
		//return jt2;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////puttable2
	
	public JTable puttable2(int k)
	{
		  objects o=new objects();
		  ArrayList<query1_data> data=o.getquery1().return_list();
		String data2[][]={ {"vaibhav","Amit","670000"},  
		          {"102","Jai","780000"}, 
		          {"101","Sachin","700000"}};  
		String column2[]={"2015111","VAibhav","10,00,000"}; 
		JTable jt2=new JTable(data2,column2);
		DefaultTableModel tableModel = new DefaultTableModel(data2, column2) {

		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};

		jt2.setModel(tableModel);
		jt2.setMinimumSize(new Dimension(500,500));
		
		return jt2;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////

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
  
//sp2.setMinimumSize(new Dimension(1000,1000));
//jt2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  objects o=new objects();
//  JScrollPane sp2=new JScrollPane(o.get_GUI().puttable(0));
 // jt.setPreferredScrollableViewportSize(jt.getPreferredSize());
  //jt.setFillsViewportHeight(true);
  //jt.setPreferredSize(new Dimension(1500,1500));
 // jt.getColumnModel().getColumn(0).setPreferredWidth(36);
 jt.setRowHeight(100);
 //jt.getcol
 
 // jt.getColumnModel().getColumn(0).
  JScrollPane sp2=new JScrollPane(jt);
  sp2.setPreferredSize(new Dimension(1400,750));
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
	JPanel panel =new JPanel(new GridLayout(17,0));
	panel.add(new JLabel());
	panel.add(new JLabel("QUERY1",JLabel.CENTER));
	panel.add(new JLabel());
	
	JPanel p1=new JPanel(new GridLayout(0,2));
	p1.add(new JLabel("NAME  -",JLabel.CENTER));
	p1.add(name);
	panel.add(p1);
	
	panel.add(new JLabel());
	
	JPanel p2=new JPanel(new GridLayout(0,2));
	p2.add(new JLabel("TITLE  -",JLabel.CENTER));
	p2.add(title);
	panel.add(p2);
	
	panel.add(new JLabel());
	
	JPanel p3=new JPanel(new GridLayout(0,4));
	p3.add(new JLabel("SINCE YEAR  :",JLabel.LEFT)); 
	p3.add(new JPanel());
	p3.add(since_year);
	p3.add(new JPanel());
	
	panel.add(p3);											

	panel.add(new JLabel());
	
	JPanel p4=new JPanel(new GridLayout(0,4));
	p4.add(new JLabel("CUSTOM RANGE :",JLabel.LEFT)); 
	p4.add(year1);
	p4.add(new JLabel("------",JLabel.CENTER));
	p4.add(year2);
	
	panel.add(p4);
	
	panel.add(new JLabel());
	
	JPanel p5=new JPanel(new GridLayout(0,4));
	p5.add(new JLabel()); 
	p5.add(r1);
	p5.add(new JLabel());
	p5.add(new JPanel());
	panel.add(p5);
	
	JPanel p6=new JPanel(new GridLayout(0,4));
	p6.add(new JLabel());
	p6.add(r2);
	p6.add(new JLabel());
	p6.add(new JPanel());
	panel.add(p6);
	
	panel.add(new JLabel());
	
	JPanel p7=new JPanel(new GridLayout(0,5));
	p7.add(new JLabel());
	
	objects o=new objects();
	p7.add(o.getsearch().get_query1_search_button());
	p7.add(new JLabel());
	p7.add(o.get_GUI().reset);
	p7.add(new JLabel());
	panel.add(p7);
	
	JPanel p8=new JPanel(new GridLayout(0,5));
	p8.add(new JLabel());
	p8.add(new JLabel());
	Next20 n=new Next20();
	p8.add(n.getb());
	p8.add(new JLabel());
	p8.add(new JLabel());
	panel.add(p8);
	
	
	panel.add(o.get_GUI().getbox());
	
	ButtonGroup group = new ButtonGroup();
	    group.add(r1);
	    group.add(r2);
	    
	return panel;
	
}
 


/////////////////////////////////////////////////////////////////////////////////////////////////////////
public void actionPerformed(ActionEvent e)
{
objects o=new objects();
o.get_GUI().start();
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
	GUI g=new GUI();
	g.start();
} 

}  