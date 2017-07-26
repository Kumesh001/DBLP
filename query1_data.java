
// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

import java.io.Serializable;

public class query1_data implements Comparable<query1_data>, Serializable{

	private String author;
	private String title;
	private String pages;
	private String year;
	private String volume;
	private String journal;
	private String url;
	private static final long serialVersionUID = 5462223600l;

	query1_data()
	{
	}
	
	public String get_author()
	{
		return author;
	}
	public String get_title()
	{
		return title;
	}
	public String get_pages()
	{
		return pages;
	}
	public String get_year()
	{
		return year;
	}
	public String get_volume()
	{
		return volume;
	}
	public String get_journal()
	{
		return journal;
	}
	public String get_url()
	{
		return url;
	}
	
	public void set_author(String s)
	{
		author=s;
	}
	public void set_title(String s)
	{
		title=s;
	}
	public void set_pages(String s)
	{
		pages=s;
	}
	public void set_year(String s)
	{
		year=s;
	}
	public void set_volume(String s)
	{
		volume=s;
	}
	public void set_journal(String s)
	{
		journal=s;
	}
	public void set_url(String s)
	{
		url=s;
	}
	
	public int compareTo(query1_data m1)
	{
		if(Integer.parseInt(this.get_year())<Integer.parseInt(m1.get_year()))
			return -1;
		else if(Integer.parseInt(this.get_year())>Integer.parseInt(m1.get_year()))
			return 1;
		return 0;
	}
	
	public int compare(query1_data m1,query1_data m2)
	{
		return m1.compareTo(m2);
	}
	
}
