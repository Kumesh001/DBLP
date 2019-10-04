// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Start {

	public static JFrame f;
	
	public void start()
	{
		 f=new JFrame();  

		
	         
		  JPanel panel1 = WestPanel();										//left panel
		  JPanel panel2 = new JPanel();										//right	panel
		  JPanel panel3 = new JPanel();										//upper panel
		  panel3.setLayout(new BorderLayout());
		 
		  JLabel label1 = new JLabel("DBLP QUERY SEARCH ENGINE",JLabel.CENTER);
		  Font font = new Font("Serif", Font.BOLD, 100);
		  label1.setFont(font);
		  panel3.add(label1,BorderLayout.CENTER);
		  
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
	
	public JPanel WestPanel()
	{
		JPanel panel =new JPanel(new GridLayout(9,0));
		panel.add(new JLabel());
		
		objects o=new objects();
		JPanel p5=new JPanel(new GridLayout(0,3));
		p5.add(new JLabel()); 
		p5.add(o.get_GUI().Query1_Button());
		p5.add(new JLabel());
		//p5.add(new JPanel());
		panel.add(p5);
		
		panel.add(new JLabel());
		
		
		panel.add(new JLabel());
		
		panel.add(new JLabel());
	
		JPanel p6=new JPanel(new GridLayout(0,3));
		p6.add(new JLabel()); 
		p6.add(o.get_GUI2().Query2_Button());
		p6.add(new JLabel());
		panel.add(p6);
		
		panel.add(new JLabel());
		
		panel.add(new JLabel());											
		

		panel.add(new JLabel());
				
		    
		return panel;
		
	}
	
	public static void main(String args[])
	{
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
		Start s=new Start();
		s.start();
				
	}
	
}
