
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("serial")
public class DataSetList extends ArrayList<DataSet> {
	public DataSetList() 
	{
		super();
	}
	public DataSetList getByTitle(String keyword) 
	{
		if (keyword==null || keyword.isEmpty()) 
		{
			throw new IllegalArgumentException("Invalid Keyword!");
		}
		DataSetList ans= new DataSetList();
		for(DataSet temp: this) 
		{
			String title= temp.getTitle();
			if(title.toLowerCase().contains(keyword.toLowerCase())) 
			{
				ans.add(temp);
			}
			
		}
		if (!ans.isEmpty()) {
            Collections.sort(ans);
            return ans;
        } else {
            return null;
        } 
	}
	public DataSetList getByDescription(String keyword) 
	{
		if (keyword==null || keyword.isEmpty()) 
		{
			throw new IllegalArgumentException("Invalid Keyword!");
		}
		DataSetList ans= new DataSetList();
		for(DataSet temp: this) 
		{
			String description= temp.getDescription();
			if(description.toLowerCase().contains(keyword.toLowerCase())) 
			{
				ans.add(temp);
			}
			
		}
		if (!ans.isEmpty()) {
            Collections.sort(ans);
            return ans;
        } else {
            return null;
        }
	}
	public DataSetList getByUrl(String keyword) 
	{
		if (keyword==null || keyword.isEmpty()) 
		{
			throw new IllegalArgumentException("Invalid Keyword!");
		}

		DataSetList ans= new DataSetList();
		for(DataSet temp: this) 
		{
			for (URL url : temp.getLinks()) {
                if (url.toString().toLowerCase().contains(keyword.toLowerCase())) {
                //	System.out.println(temp.toString());
                    ans.add(temp);
                    break; // No need to check other URLs for the same dataset
                }
            }			
		}
		
		if (!ans.isEmpty()) {
            Collections.sort(ans);
            return ans;
        } else {
            return null;
        }
	}
	@Override
	public String toString() 
	{
		StringBuilder ans= new StringBuilder();
		for(int i=0;i<this.size();i++) 
		{
			ans.append(this.get(i));
		}
		return ans.toString();
	}
}
