// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109
public class Database {

	private String authorname;
	private String titletag;
	private int since_year;
	private int year1;
	private int year2;
	//objects o=objects.getobject();
	
	public Database()
	{}

	public String getauthorname()
	{
		return authorname;
	}
	
	public String gettitletag()
	{
		return titletag;
	}
	
	public void setauthor(String s)
	{
		authorname=s;
	}
	
	public void settitle(String s)
	{
		titletag=s;
	}
	
	public void setsinceyear(int val)
	{
		since_year=val;
	}
	
	public void setyear1(int val)
	{
		year1=val;
	}
	
	public void setyear2(int val)
	{
		year2=val;
	}
	
	public int getsinceyear()
	{
		return since_year;
	}
	
	public int getyear1()
	{
		return year1;
	}
	
	public int getyear2()
	{
		return year2;
	}
	
}