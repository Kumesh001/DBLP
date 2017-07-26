// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

public class Search implements ActionListener {

	//objects o=objects.getobject();
	private static JButton q1=new JButton();
	private static JButton q2=new JButton();
	private static int q;
	
	public Search(){}
	
	public void set_q(int val)
	{
		q=val;
	}
	
	public JButton get_query1_search_button()
	{
		
		q1.setText("Search");
		q1.setBackground(Color.red);
		q1.addActionListener(new Search());

		return q1;
	}
	
	public JButton get_query2_search_button()
	{
		q2.setText("Search");
		q2.setBackground(Color.red);
		q2.addActionListener(new Search(){
			public void actionPerformed(ActionEvent e)
			{
					objects o=new objects();
					System.out.println("Searching Query2	=====>   "+q );
					o.getnotify().call_check_on_query2_gui();
			}
		});
		
		return q2;
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
			objects o=new objects();
			System.out.println("Searching Query1	"+q );
			o.getnotify().call_check_on_query1_gui();
	}
	
}
