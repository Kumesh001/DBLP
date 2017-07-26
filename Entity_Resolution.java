// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Entity_Resolution {

	//objects o=objects.getobject();	
	
	public Entity_Resolution()
	{}
	
	public int compare_name(String name1, String name2)
	{
		int flag=0;
		String[] str1=name1.split(" ");
		String[] str2=name2.split(" ");
		if(name1.toLowerCase().compareTo(name2.toLowerCase())==0)
			flag=1;
		if(Character.toLowerCase(name1.charAt(0))==Character.toLowerCase(name2.charAt(0))&&str2[0].length()<=3)
		{
			if(str2[str2.length-1].toLowerCase().compareTo(str1[str1.length-1].toLowerCase())==0)
				flag=1;
		}
//		 for (String s1: name1.split(" ")) {
//			 for (String s2: name2.split(" ")) {
//		         if(s1.toLowerCase().compareTo(s2.toLowerCase())==0)
//		        	 flag=1;
//		         
//		      }
//	      }
		return flag;
	}
	
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
			if(name.compareTo(q.get_author())==0)
			{
				m.put(q,99999);
			}else if(name2[0].compareTo(name1[0])==0&&name2[0].length()>=4)
			{
				m.put(q,99999);
			}
			else{
				int count=0;
				for(String str2:name2)
				{
					for(String str1:name1)
					{
						if(str2.compareTo(str1)==0)
							count++;
					}
				}
				m.put(q,count);
			}
			
			
		}
		sorted_map.putAll(m);
		ArrayList<query1_data> new_data=new ArrayList<query1_data>();
		for(Map.Entry<query1_data,Integer> entry : sorted_map.entrySet()) {
			query1_data qq=entry.getKey();
			new_data.add(qq);
		}
		return new_data;
	}
	
}