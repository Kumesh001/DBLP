import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Query2 {
	private String authorname;
	private String titletag;
	private int k;
	private JTextField text;
	private JButton button;
	private Map<String,Integer> data=new HashMap<String,Integer>();
	private ArrayList<String> new_data=new ArrayList<String>();
	
	public ArrayList<String> getdata()
	{
		return new_data;
	}
	
	public void setk(int val)
	{
		k=val;
	}
	
	public int getk()
	{
		return k;
	}
	
	

	public void query2()
	{
		int count=0;
		 dblp1 d=new dblp1();
		 d.parseit2(data);
		 ArrayList<String> new_data=new ArrayList<String>();
		 objects o=new objects();
		 for (Map.Entry<String, Integer> entry : data.entrySet())
			{
			  //  System.out.println(entry.getKey() + " - " + entry.getValue());
			    count++;
			    if(entry.getValue()>=o.getquery2().getk())
			    {
			    	new_data.add(entry.getKey());
			    }
			}
		 for(int i=0;i<new_data.size();i++)
		 {
			 System.out.println(new_data.get(i)+" =================================");
		 }
		 //System.out.println(count);
		 o.get_GUI2().puttable(new_data, o.getnotify().getnext());
	}
		
}