// @ Vaibhav Kashyap - 2015111
// @ Umesh - 2015109s

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
public class dblp1 {
    private ArrayList<String> authorslist=new ArrayList<String>();
  //  private Entity_Resolution entity =Entity_Resolution.getobject();
    //objects o=objects.getobject();

    public void parseit( List l, int choice, String name ,String title_name)
    {
        dblp1 obj=new dblp1();
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
            	query1_data q=new query1_data();
            	private Map<String,Integer> m=new HashMap<String,Integer>();
            	
            	int flag=0;
                boolean author = false;
                boolean title = false;
                boolean pages = false;
                boolean year = false;
                boolean volume = false;
                boolean journal = false;
                boolean url = false;

                public void startElement(String uri, String localName,
                                         String qName, Attributes attributes)
                        throws SAXException {

                	 if (qName.equalsIgnoreCase("article")) {

                	 }
                	 else if (qName.equalsIgnoreCase("author")) {
                        author = true;
                    }

                    else if (qName.equalsIgnoreCase("title")) {
                        title = true;
                    }
                    else if (qName.equalsIgnoreCase("pages")) {
                        pages = true;
                    }

                    else if (qName.equalsIgnoreCase("year")) {
                        year = true;
                    }
                    else if (qName.equalsIgnoreCase("volume")) {
                        volume = true;
                    }

                    else if (qName.equalsIgnoreCase("journal")) {
                        journal = true;
                    }
                    else if (qName.equalsIgnoreCase("url")) {
                        url = true;
                    }

                }

                public void endElement(String uri, String localName,
                                       String qName)
                        throws SAXException {
                	objects o=new objects();
                	Entity_Resolution entity =o.getentity();
                	 if (qName.equalsIgnoreCase("article")) {

                		 if(choice==1){
//                			 if(name.compareTo(q.get_author())==0)
                		 if(entity.compare_name(name, q.get_author())==1)
                		 {
                			 query1_data q2=new query1_data();
                			 q2.set_author(q.get_author());
                			 q2.set_title(q.get_title());
                			 q2.set_journal(q.get_journal());
                			 q2.set_pages(q.get_pages());
                			 q2.set_year(q.get_year());
                			 q2.set_url(q.get_url());
                			 q2.set_volume(q.get_volume());
                			 l.add(q2);
                    		 System.out.println("name= "+q2.get_author()+"  year="+q2.get_year()+" title= "+q2.get_title());

                		 }
                		 }else if(choice==2)
                		 {
                			 if(name.compareTo(q.get_title())==0)
                    		 {
                				 query1_data q2=new query1_data();
                    			 q2.set_author(q.get_author());
                    			 q2.set_title(q.get_title());
                    			 q2.set_journal(q.get_journal());
                    			 q2.set_pages(q.get_pages());
                    			 q2.set_year(q.get_year());
                    			 q2.set_url(q.get_url());
                    			 q2.set_volume(q.get_volume());
                    			 l.add(q2);
                        		 System.out.println("name2= "+q.get_author()+"  year="+q.get_year());

                    		 }
                		 }else if(choice==3)
                		 {
                			 if(entity.compare_name(name, q.get_author())==1||title_name.compareTo(q.get_title())==0)
                    		 {
                				 query1_data q2=new query1_data();
                    			 q2.set_author(q.get_author());
                    			 q2.set_title(q.get_title());
                    			 q2.set_journal(q.get_journal());
                    			 q2.set_pages(q.get_pages());
                    			 q2.set_year(q.get_year());
                    			 q2.set_url(q.get_url());
                    			 q2.set_volume(q.get_volume());
                    			 l.add(q2);
                        		 System.out.println("3name="+q.get_author()+"  year="+q.get_year());

                    		 }
                		 }
                      }

                }

                public void characters(char ch[], int start, int length)
                        throws SAXException {
                	String s1="",s2="",s3="",s4="",s5="",s6="",s7="";
                	
                	if (title) {
                        s2=new String(ch, start, length);
                        title = false;
                        q.set_title(s2);
                       
                    }
                    if (author) {
                        s1=new String(ch, start, length);
                        author = false;
                        q.set_author(s1);
                       
                    }                	
                    
                    if (pages) {
                        s3=new String(ch, start, length);
                        pages = false;
            			q.set_pages(s3);
                    }                	
                    if (year) {
                    	
                        s4=new String(ch, start, length);
                       // System.out.println(s4);        
                        year = false;
            			q.set_year(s4);
            			//System.out.println(q.get_year());  

                    }
                    if (volume) {
                        s5=new String(ch, start, length);
                        volume = false;
            			q.set_volume(s5);

                    }                	
                    if (journal) {
                        s6=new String(ch, start, length);
                        journal = false;
            			q.set_journal(s6);
                        
                    }
                    if (url) {
                        s7=new String(ch, start, length);
                        url = false;
            			q.set_url(s7);

                    }
                  
                }

            };
try{
            saxParser.parse(new File("C:\\lab5\\dblp.xml"), handler);
            
}catch(Exception s){
	s.printStackTrace();
}

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    
    public void parseit2( Map<String,Integer> m)
    {
        dblp1 obj=new dblp1();
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
            	
            	String name;
            	
            	int flag=0;
                boolean author = false;
             
                public void startElement(String uri, String localName,
                                         String qName, Attributes attributes)
                        throws SAXException {

                	 if (qName.equalsIgnoreCase("article")) {
                		 
                     }
                	 else if (qName.equalsIgnoreCase("author")) {
                        author = true;
                    }

                }

                public void endElement(String uri, String localName,
                                       String qName)
                        throws SAXException {
                	 if (qName.equalsIgnoreCase("article")) {

                		 if(m.get(name)!=null)
                			{
                				m.put(name,1+m.get(name));			
                			}
                		 else 
                		 {
                			 m.put(name,1);
                		 }
                		 
                      }

                }

                public void characters(char ch[], int start, int length)
                        throws SAXException {
                	String s1="";
                	
                    if (author) {
                        s1=new String(ch, start, length);
                        author = false;
                        name=s1;
                    }                	
                                      
                }

            };
try{
	//DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//	dbf.setAttribute(JDK_ENTITY_EXPANSION_LIMIT, "2000");
//	System.setProperty(SP_GENERAL_ENTITY_SIZE_LIMIT, "2000");
	
            saxParser.parse(new File("C:\\lab5\\dblp.xml"), handler);
            
}catch(Exception s){
	s.printStackTrace();
}

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
