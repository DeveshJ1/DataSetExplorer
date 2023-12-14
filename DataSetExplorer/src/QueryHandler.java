
public class QueryHandler {
	private static DataSetList list;
	public QueryHandler(DataSetList list) {
		this.list=list;
	}

	public String processQuery(String userVal) {
		String [] queries= userVal.trim().split("\\s+");
		 if (queries.length > 4 || queries.length % 2 != 0) {
	            return "Invalid Query! Try Again!";
	        } else {
	            switch (queries.length) {
	                case 2:
	                    return processSingleQuery(queries[0], queries[1]);
	                case 4:
	                    return processDoubleQuery(queries[0], queries[1], queries[2], queries[3]);
	                default:
	                    return "Invalid Query. Try Again!";
	            }
	        }
	}

	private static String processSingleQuery(String field, String keyword) {
		switch (field.toLowerCase())
		{
        	case "title":
        		return handleTitleQuery(keyword);
        	case "description":
        		return handleDescriptionQuery(keyword);
        	case "url":
        		return handleUrlQuery(keyword);
        	default:
        		return "Invalid Query. Try Again!";
		}		
	}


	private static String processDoubleQuery(String field1, String keyword1, String field2, String keyword2) 
	{
		  if (field1.equalsIgnoreCase("title") && field2.equalsIgnoreCase("description"))
		  {
		      return handleTitleAndDescriptionQuery(keyword1, keyword2);
		  } 
		  else if(field1.equalsIgnoreCase("description") && field2.equalsIgnoreCase("title"))
		  {
			  return handleDescriptionAndTitleQuery(keyword1,keyword2);
		  }
		  else if (field1.equalsIgnoreCase("title") && field2.equalsIgnoreCase("url"))
		  {
		      return handleTitleAndUrlQuery(keyword1, keyword2);
		  } 
		  else if(field1.equalsIgnoreCase("url") && field2.equalsIgnoreCase("title")) 
		  {
			  return handleUrlAndTitleQuery(keyword1,keyword2);
		  }
		  else if (field1.equalsIgnoreCase("description") && field2.equalsIgnoreCase("url")) 
		  {
		      return handleDescriptionAndUrlQuery(keyword1, keyword2);
		  } 
		  else if(field1.equalsIgnoreCase("url") && field2.equalsIgnoreCase("description")) 
		  {
			  return handleUrlAndDescriptionQuery(keyword1,keyword2);
		  }
		  else 
		  {
		            return "Invalid Query. Try Again!";
		  }
	}
	
	private static String handleTitleQuery(String keyword) 
	{
        DataSetList result = list.getByTitle(keyword);
        return getResultMessage(result);
    }
	private static String handleDescriptionQuery(String keyword) 
	{
		DataSetList result = list.getByDescription(keyword);
        return getResultMessage(result);
	}

	private static String handleUrlQuery(String keyword)
	{
		DataSetList result = list.getByUrl(keyword);
        return getResultMessage(result);
	}
	private static String handleTitleAndDescriptionQuery(String keyword1, String keyword2) 
	{
		DataSetList result= list.getByTitle(keyword1);
		if(result==null) 
		{
			return getResultMessage(result);
		}
		else 
		{
			return getResultMessage(result.getByDescription(keyword2));
		}
	}
	private static String handleDescriptionAndTitleQuery(String keyword1, String keyword2) 
	{
		DataSetList result= list.getByDescription(keyword1);
		if(result==null) 
		{
			return getResultMessage(result);
		}
		else 
		{
			return getResultMessage(result.getByTitle(keyword2));
		}	
	}
	private static String handleTitleAndUrlQuery(String keyword1, String keyword2) 
	{
		DataSetList result= list.getByTitle(keyword1);
		if(result==null) 
		{
			return getResultMessage(result);
		}
		else 
		{
			return getResultMessage(result.getByUrl(keyword2));
		}	
	}
	private static String handleUrlAndTitleQuery(String keyword1, String keyword2)
	{
		DataSetList result= list.getByUrl(keyword1);
		if(result==null) 
		{
			return getResultMessage(result);
		}
		else 
		{
			return getResultMessage(result.getByTitle(keyword2));
		}	
	}
	private static String handleDescriptionAndUrlQuery(String keyword1, String keyword2) 
	{
		DataSetList result= list.getByDescription(keyword1);
		if(result==null) 
		{
					return getResultMessage(result);
		}
		else 
		{
					return getResultMessage(result.getByUrl(keyword2));
		}
	}
	private static String handleUrlAndDescriptionQuery(String keyword1, String keyword2)
	{
		DataSetList result= list.getByUrl(keyword1);
		if(result==null) 
		{
			return getResultMessage(result);
		}
		else 
		{
			return getResultMessage(result.getByDescription(keyword2));
		}	
	}

	  private static String getResultMessage(DataSetList result) 
	  {
		  return (result == null) ? "No Matches Found! Try Again!" : result.toString();
	  }
	
}
