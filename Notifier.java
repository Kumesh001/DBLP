// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

import java.util.ArrayList;

public class Notifier {

	//objects o=objects.getobject();
	ArrayList<query1_data> newlist=new ArrayList<query1_data>(); 
	ArrayList<String> newlist2=new ArrayList<String>(); 
	private int which_query;
	private int flag=0;
	private int next;
	
	public Notifier()
	{}
	
	public void setflag(int val)
	{
		flag=val;
	}
	
	public void setnext(int val)
	{
		next=val;
	}
	
	public int getnext()
	{
		return next;
	}

	public void update()
	{
		objects o=new objects();
		newlist=o.getquery1().return_list();
	}
	
	public void update2(ArrayList<String> data)
	{
		objects o=new objects();
		newlist2=o.getquery2().getdata();
	}
	
	public ArrayList<query1_data> getList()
	{
		objects o=new objects();
		o.getnotify().update();
		return newlist;
	}
	
	public void set_which_query(int val)
	{
		which_query=val;
	}
	
	public int get_which_query()
	{
		return which_query;
	}
	
	public void call_check_on_query1_gui()
	{
		objects o=new objects();
		
		o.getcheck().check_for_query1();
		
		
	}
	
	public void call_check_on_query2_gui()
	{
		objects o=new objects();
		o.getcheck().check_for_query2();
	}
	
	public void start_query1()
	{
		objects o=new objects();
		o.getquery1().method();
	}
	
	public void start_query2()
	{
		objects o=new objects();
		o.getquery2().query2();
	}
	
	public int data_available()
	{
		if(flag==1)
			return 1;
		return 0;
	}
	
}
