// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Next20 implements ActionListener {
	
	private JButton b=new JButton("Next");
	
	public JButton getb()
	{
		b.addActionListener(new Next20());
		return b;
	}
	
	public JButton getb2()
	{
		b.addActionListener(new Next20(){
			public void actionPerformed(ActionEvent e)
			{
				///////////take data from notifier and send it to gui2 to upgrade the table
				objects o=new objects();
				o.get_GUI2().puttable(o.getquery2().getdata(),o.getnotify().getnext());
			}
		});
		return b;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		///////////take data from notifier and send it to gui to upgrade the table
		objects o=new objects();
		o.get_GUI().puttable(o.getquery1().return_list(),o.getnotify().getnext());
	}

}
