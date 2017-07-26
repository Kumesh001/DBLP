
// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Check_text {

	//objects o=objects.getobject();
	
	public Check_text()
	{}
	
	
	public void check_for_query1()
	{
		System.out.println("checking");
		JTextField text;
		String str1,str2;
		objects o=new objects();
		GUI query1_gui=o.get_GUI();
		text=query1_gui.get_name();
		str1=text.getText();
		System.out.println("here");
		ButtonListner bl=o.getbl();
		if(str1.trim().length()!=0)											////////name
         {
        	bl.set_b1(1);
        	System.out.println("b1 is set"+ "  your string = "+str1.trim());
        	o.getdb().setauthor(str1.trim());
         }
		
		text=query1_gui.get_title();								
		str2=text.getText();
		if(str2.trim().length()!=0)											///////title
         {
        	bl.set_b2(1);
        	System.out.println("b2 is set");
        	o.getdb().settitle(str2.trim());
         }
		
		if(str1.trim().length()==0&&str2.trim().length()==0)
		{
			System.out.println("str1="+str1.trim()+" str2="+str2.trim());
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Name and Title field both cannot be empty!!!");
			System.out.println("Name and Title field both cannot be empty!!!"); 
			o.get_GUI().setmessage("Name and Title field both cannot be empty!!!");
			o.get_GUI().f.setVisible(false);
			o.reset();
			GUI g=new GUI();
			Start st=new Start();
			st.f.setVisible(false);
			g.start();
		}
		else{
		System.out.println("in else");
		String str;
		text=query1_gui.get_sinceyear();
		str=text.getText();
		if(str.trim().length()!=0)										///////////since year
         {
        	bl.set_b3(1);
        	System.out.println("b3 is set");
        	o.getdb().setsinceyear(Integer.parseInt(str.trim()));
         }
		String year1,year2;
		text=query1_gui.get_year1();
		year1=text.getText();
		if(year1.trim().length()!=0)										//////////year1
         {
        	bl.set_b4(1);
        	System.out.println("b4 is set");
        	o.getdb().setyear1(Integer.parseInt(str.trim()));
         }
		
		text=query1_gui.get_year2();
		year2=text.getText();
		if(year2.trim().length()!=0)										/////////year2
         {
        	bl.set_b5(1);
        	System.out.println("b5 is set");
        	o.getdb().setyear2(Integer.parseInt(str.trim()));
         }
		
		if(year1.trim().length()==0&&year2.trim().length()!=0)
		{
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Both the Fields in custom range must be filled!!!");
			System.out.println("Both the Fields in custom range must be filled!!!"); 
			o.get_GUI().setmessage("Both the Fields in custom range must be filled!!!");
			o.get_GUI().f.setVisible(false);
			o.reset();
			GUI g=new GUI();
			Start st=new Start();
			st.f.setVisible(false);
			g.start();
		}
		else if(year1.trim().length()!=0&&year2.trim().length()==0)
		{
			JFrame f=new JFrame();
			JOptionPane.showMessageDialog(f,"Both the Fields in custom range must be filled!!!");
			System.out.println("Both the Fields in custom range must be filled!!!"); 
			o.get_GUI().setmessage("Both the Fields in custom range must be filled!!!");
			o.get_GUI().f.setVisible(false);
			o.reset();
			GUI g=new GUI();
			Start st=new Start();
			st.f.setVisible(false);
			g.start();
		}
		
		//////////////////////////////////////////////////////////////////////////////////////year1 and year2 must be checked
		if(query1_gui.get_r1().isSelected())							////////r1
		{
			bl.set_b6(1);
			System.out.println("b6 is set");
			
		}
		
		if(query1_gui.get_r2().isSelected())							////////r2
		{
			bl.set_b7(1);
			System.out.println("b7 is set");
		}
				
		o.getnotify().start_query1();
		}
		
	}
	
	public void check_for_query2()
	{
		JTextField text;
		String str;
		objects o=new objects();
		GUI2 query2_gui=o.get_GUI2();
		text=query2_gui.getpublications();
		str=text.getText();
		System.out.println("here");
		if(str.trim().length()!=0)											////////name
         {
        	System.out.println("b1 is set"+ "  your string = "+str.trim());
        	o.getdb().setauthor(str.trim());
        	o.getquery2().setk(Integer.parseInt(str.trim()));
        	o.getquery2().query2();
         }else 
         {
        	// o.get_GUI2().setmessage("This Field cannot be empty!!!");
        	JFrame f=new JFrame();
 			JOptionPane.showMessageDialog(f,"This Field must not be empty!!!");
 			System.out.println("This Field must not be empty!!!"); 
 			o.get_GUI2().setmessage("This Field must not be empty!!!");
 			o.get_GUI2().f.setVisible(false);
 			o.reset();
 			GUI2 g=new GUI2();
 			Start st=new Start();
 			st.f.setVisible(false);
 			st.start();
         }
		
				
		o.getnotify().start_query2();
		
		
		
	}
	
}
