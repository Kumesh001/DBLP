// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109

public class objects {

	private static Start start=new Start();
	private static GUI gui=new GUI();
	private static GUI2 gui2=new GUI2();
	private static Check_text check=new Check_text();
	private static ButtonListner bl=new ButtonListner();
	private static Database db=new Database();
	private static Notifier notify=new Notifier();
	private static Query1 q1=new Query1();
	private static Query2 q2=new Query2();
	private static Entity_Resolution entity=new Entity_Resolution();
	private static Search s=new Search();
	
	//private static objects o=new objects();
	
	public objects()
	{}
	
	public void reset()
	{
		objects o=new objects();
		o.set_GUI();
		o.set_GUI2();
		o.setbl();
		o.setcheck();
		o.setdb();
		o.setentity();
		o.setnotify();
		o.setquery1();
		o.setquery2();
		o.setsearch();
	}
	
	public Start get_start()
	{
		return start;
	}
	
	public void set_start()
	{
		start=new Start();
	}
	
	public GUI get_GUI()
	{
		return gui;
	}
	
	public void set_GUI()
	{
		gui=new GUI();
	}
	
	public void set_GUI2()
	{
		gui2=new GUI2();
	}
	
	public GUI2 get_GUI2()
	{
		return gui2;
	}
	
	public Check_text getcheck()
	{
		check=new Check_text();
		return check;
	}
	
	public void setcheck()
	{
		check=new Check_text();
	}
	
	public ButtonListner getbl()
	{
		return bl;
	}
	
	public void setbl()
	{
		bl=new ButtonListner();
	}
	
	public Database getdb()
	{
		return db;
	}
	
	public void setdb()
	{
		db=new Database();
	}
	
	public Notifier getnotify()
	{
		return notify;
	}
	
	public void setnotify()
	{
		notify=new Notifier();
	}
	
	public Query1 getquery1()
	{
		return q1;
	}
	
	public void setquery1()
	{
		q1=new Query1();
	}
	
	public Query2 getquery2()
	{
		return q2;
	}
	
	public void setquery2()
	{
		q2=new Query2();
	}
	
	public Entity_Resolution getentity()
	{
		return entity;
	}
	
	public void setentity()
	{
		entity=new Entity_Resolution();
	}
	
	public Search getsearch()
	{
		return s;
	}
	
	public void setsearch()
	{
		s=new Search();
	}
	
	
}
