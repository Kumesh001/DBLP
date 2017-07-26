// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

import javax.swing.JTextField;
import javax.swing.plaf.*;
import java.util.*;
import javax.swing.*; 
import java.awt.event.*;  
import java.awt.*;
import java.awt.List;
import java.awt.font.*; 
import java.awt.geom.*;
import java.awt.event.ActionEvent;

public class Query1 extends Search {
	
	private String authorname;
	private String titletag;
	private int flag;
	private JTextField text;
	private JButton button;
	private static ArrayList<query1_data> data=new ArrayList<query1_data>();
	//objects o=objects.getobject();
	
//////////////////////////////////////////////////////////////////	
	
	 
	 public ArrayList<query1_data> return_list()
	 {
		 return data;
	 }
	 
	 public void update(ArrayList<query1_data> new_data)
	 {
		data=new_data; 
	 }
	 
		public Query1()
		{
		}	 
	
//////////////////////////////////////////////change from q to this	
	public void method()
	{
		ArrayList<query1_data> arr=new ArrayList<query1_data>();
		// n=query1_gui.get_notifier();
		 objects o=new objects();
		 ButtonListner bl=o.getbl();
		// if(o.getnotify().data_available()==0)
		if(bl.check_b1()==1&&bl.check_b2()==1)										//search by title and name
		{
			o.getquery1().search_by_title_and_name(o.getdb().getauthorname(), o.getdb().gettitletag());
			arr=o.getquery1().return_list();
		}else if(bl.check_b1()==1)								//search by name
		{
			o.getquery1().search_by_name(o.getdb().getauthorname());
			arr=o.getquery1().return_list();
		}else if(bl.check_b2()==1)							//search by title
		{
			o.getquery1().search_by_title(o.getdb().gettitletag());
			arr=o.getquery1().return_list();
		}
		
		//q.update(arr);
		//q.display(data);
		
		if(bl.check_b3()==1)					//since_year
		{
			arr=o.getquery1().from_year(o.getdb().getsinceyear());										
		}
		else if(bl.check_b4()==1&&bl.check_b5()==1)						//in between year
		{
			arr=o.getquery1().inbetween_year(o.getdb().getyear1(), o.getdb().getyear2());
		}
		else if(bl.check_b6()==1)					//sort by year
		{
			arr=o.getquery1().sort_by_year();
		}
		else if(bl.check_b7()==1)					//sort by relevance
		{
			arr=o.getquery1().sort_by_relevance(arr, o.getdb().getauthorname());
		}
		
		o.getquery1().update(arr);
		o.getquery1().display(arr);
		//o.get_GUI().gettable().setValueAt("scdsfbgfvccsd", 1, 2);
		//o.get_GUI().settable(o.get_GUI().gettable(), o.get_GUI().puttable(0));
		System.out.println("offset=======>"+o.getnotify().getnext());
		o.get_GUI().puttable(o.getquery1().return_list(),o.getnotify().getnext());
		System.out.println("Table is changed");
	}

//	private Query1(String name, int f)
//	{
//		flag=f;
//		if(f==1)
//		{
//			authorname=name;
//		}
//		else if(f==2)
//		{
//			titletag=name;
//		}
//	}
	

	public JButton query_button()
	{
		//button.addActionListener(new Query1());
		return button;
	}
	
	 public void actionPerformed(ActionEvent e) {
		 objects o=new objects();
		 System.out.println("in Query1 !!!");
		 o.getnotify().set_which_query(1);
		 
     }
	 
	 public void search_by_name(String name)
	 {
		 dblp1 d=new dblp1();
		 d.parseit(data, 1, name,name);
	 }
	
	 public void search_by_title(String name)
	 {
		 dblp1 d=new dblp1();
		 d.parseit(data, 2, name,name);
	 }
	 
	 public void search_by_title_and_name(String name, String title)
	 {
		 dblp1 d=new dblp1();
		 d.parseit(data, 3, name,title);
	 }
///////////////////////////////////////////////////////////////////////////////////////////////////////////sort by year
	 public ArrayList<query1_data> sort_by_year()
	 {
		 query1_data[] arr=new query1_data[data.size()];
		 ArrayList<query1_data> new_data =new ArrayList<query1_data>();
		 for(int i=0;i<data.size();i++)
		 {
			 arr[i]=data.get(i);
		 }
		 Arrays.sort(arr);
		 for(int i=0;i<arr.length;i++)
		 {
			 System.out.println("==> year="+arr[i].get_year());
			 new_data.add(arr[i]);
		 }
		 		 
		 return new_data;
	 }
///////////////////////////////////////////////////////////////////////////////////////////////////////////between years 
	 public ArrayList<query1_data> inbetween_year(int year1,int year2)
	 {
		 ArrayList<query1_data> new_data =new ArrayList<query1_data>();
		 int k=0;
		 for(int i=0;i<data.size();i++)
		 {
			 if(Integer.parseInt(data.get(i).get_year())>=year1&&Integer.parseInt(data.get(i).get_year())<=year2)
				 k++;
		 }
		 System.out.println("count k= "+k);
		 query1_data[] arr=new query1_data[k];
		 int j=0;
		 for(int i=0;i<data.size();i++)
		 {
			 if(Integer.parseInt(data.get(i).get_year())>=year1&&Integer.parseInt(data.get(i).get_year())<=year2)
			 {
				 arr[j++]=data.get(i);
				 System.out.println("!!year="+data.get(i).get_year());
			 }
		 }
		 Arrays.sort(arr);
		 for(int i=0;i<arr.length;i++)
		 {
			 System.out.println("==> year="+arr[i].get_year());
			 new_data.add(arr[i]);
		 }
		 return new_data;
	 }
///////////////////////////////////////////////////////////////////////////////////////////////////////////from year 
	 public ArrayList<query1_data> from_year(int year)
	 {
		 ArrayList<query1_data> new_data=new ArrayList<query1_data>();
		 int k=0;
		 for(int i=0;i<data.size();i++)
		 {
			 if(Integer.parseInt(data.get(i).get_year())>=year)
				 k++;
		 }
		 System.out.println("count k= "+k);
		 query1_data[] arr=new query1_data[k];
		 int j=0;
		 for(int i=0;i<data.size();i++)
		 {
			 if(Integer.parseInt(data.get(i).get_year())>=year)
			 {
				 arr[j++]=data.get(i);
				 System.out.println("!!year="+data.get(i).get_year());
			 }
		 }
		 Arrays.sort(arr);
		 for(int i=0;i<arr.length;i++)
		 {
			 System.out.println("==> year="+arr[i].get_year());
			 new_data.add(arr[i]);
		 }
		 
		 return new_data;
	 }
///////////////////////////////////////////////////////////////////////////////////////////////////////////sort by relevance	 
	 public ArrayList<query1_data> sort_by_relevance( ArrayList<query1_data> data,String name )
		{
			String[] name1=name.split(" ");								//user input
			String[] name2;										
			query1_data q;
			HashMap<query1_data,Integer> m=new HashMap<query1_data,Integer>();
			 ValueComparator bvc = new ValueComparator(m);
		        TreeMap<query1_data, Integer> sorted_map = new TreeMap<query1_data, Integer>(bvc);
			for(int i=0;i<data.size();i++)
			{
				q=data.get(i);
				name2=q.get_author().split(" ");
				int val;
				if(name.compareTo(q.get_author().toLowerCase())==0)
				{
					m.put(q,999999);
					val=999999;
				}else if(name2[0].toLowerCase().compareTo(name1[0].toLowerCase())==0&&name2[0].length()>=4)
				{
					m.put(q,99999);
					val=99999;
				}
				else{
					int count=0;
					for(String str2:name2)
					{
						for(String str1:name1)
						{
							if(str2.toLowerCase().compareTo(str1.toLowerCase())==0)
								count++;
						}
					}
					m.put(q,count);
					val=count;
				}
				
				System.out.println("==>"+q.get_author()+"---> "+val);
			}
			sorted_map.putAll(m);
			ArrayList<query1_data> new_data=new ArrayList<query1_data>();
			for(Map.Entry<query1_data,Integer> entry : sorted_map.entrySet()) {
				query1_data qq=entry.getKey();
				new_data.add(qq);
				System.out.println("!!!==>"+qq.get_author()+"---> "+entry.getValue());
			}
			return new_data;
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////////display
	 public void display(ArrayList<query1_data> arr)
	 {
		 for(int i=0;i<arr.size();i++)
		 {
			 System.out.println(arr.get(i).get_author()+"	year="+arr.get(i).get_year()+"  count="+i);
		 }
	 }
	 
	 public static void main(String args[])
	 {
		 
	 }
	
}