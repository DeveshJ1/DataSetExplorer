
import java.net.URL;
import java.util.ArrayList;

public class DataSet implements Comparable<DataSet> {
	private String title;
	private String description;
	private ArrayList<URL> links;
	private Date date;
	private String hatTips;
	public DataSet(String title, String description, ArrayList<URL> links) 
	{
		if(title == null || title.isEmpty() || description==null || description.isEmpty()) 
		{
			throw new IllegalArgumentException("Invalid Title!");
		}
		if( description==null || description.isEmpty()) 
		{
			throw new IllegalArgumentException("Invalid Description!");
		} 
		if(links.isEmpty() || links==null) 
		{
			throw new IllegalArgumentException("Invalid Links!");
		}
		this.title=title;
		this.description=description;
		this.links=links;
	}
	public void setDate(Date date) 
	{
		if(date==null || date.getYear()<2000) 
		{
			throw new IllegalArgumentException("Invalid Year for set Date!");
		}
		else 
		{
			this.date=date;
		}
	}
	public Date getDate() 
	{
		return this.date;
	}
	public void setHatTips(String HatTips) 
	{
		if(HatTips==null) 
		{
			throw new IllegalArgumentException("Invalid HatTips!");
		}
		else {
		this.hatTips=HatTips;
		}
	}
	public String getHatTips() 
	{
		if(this.hatTips==null) 
		{
			return "";
		}
		else 
		{
			return this.hatTips;
		}
	}
	public String getTitle() 
	{
		return this.title;
	}
	public String getDescription() 
	{
		return this.description;
	}
	public ArrayList<URL> getLinks()
	{
		return this.links;
	}
	@Override
	public int compareTo(DataSet o) {
		if(o==null) 
		{
			throw new NullPointerException("Dataset is Null!");
			
		}
		else if (! (o instanceof DataSet)) 
		{
			throw new ClassCastException("Invalid CLass!");
		}
		else 
		{
			if(this.date.compareTo(o.date)== 0 || this.date==null || o.date==null) 
			{
				return this.title.compareToIgnoreCase(o.title);
			}
			else 
			{
				return this.date.compareTo(o.date);
			}
		}
	}
	@Override
	public boolean equals(Object obj) 
	{
		if(this==obj) 
		{
			return true;
		}
		else if (obj==null) 
		{
			return false;
		}
		else if(!(obj instanceof Date)) 
		{
			return false;
		}
		DataSet temp= (DataSet) obj;
		if(this.date.compareTo(temp.date)==0 && this.title.equalsIgnoreCase(temp.title)) 
		{
			return true;
		} else 
		{
			return false; 
		}
	}
	@Override
	public String toString() 
	{
		StringBuilder ans= new StringBuilder();
		if(date==null) 
		{
			ans.append("\n").append(title).append("\n").append(description).append("\n");
		}
		else 
		{
			ans.append(date).append("\n").append(title).append("\n").append(description).append("\n");
		}
		for(int i=0;i<links.size();i++) 
		{
			ans.append(links.get(i));
			ans.append("\n");
		}
		ans.append("\n-----\n");
		return ans.toString();
	}
	
	
}
