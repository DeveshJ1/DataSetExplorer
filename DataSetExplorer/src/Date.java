
public class Date implements Comparable<Date> {
	private int year;
	private int month;
	private int day; 
	public Date( int year, int month, int day)
	{
		if(year<1) 
		{
			throw new IllegalArgumentException("Invalid Year!");
		}
		else if(month<1 || month>12) 
		{
			throw new IllegalArgumentException("Invalid Month!");

		}
		else if(day<1) 
		{
			throw new IllegalArgumentException("Invalid Day!");
		}
		else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) 
		{
			if(day>31) 
			{
				throw new IllegalArgumentException("Invalid Day!");
			}
		}else if(month==2 && ((year %4 ==0 && year%100!=0)|| year%400==0)) 
		{
			if(day>29) 
			{
				throw new IllegalArgumentException("Invalid Day!");
			}
		}else if (month==2) 
		{
			if(day>28) 
			{
				throw new IllegalArgumentException("Invalid Day!");
			}
		}else 
		{
			if(day>30) 
			{
				throw new IllegalArgumentException("Invalid Day!");
			}
		}
		this.year=year;
		this.day=day;
		this.month=month;
	}
	public int getYear() 
	{
		return this.year;
	}
	public int getMonth() 
	{
		return this.month;
	}
	public int getDay() 
	{
		return this.day;
	}
	@Override
	public int compareTo(Date o) {
		// TODO Auto-generated method stub
		if(o==null) 
		{
			throw new NullPointerException("Object is Null");
		}
		else if(!(o instanceof Date)) 
		{
			throw new ClassCastException("Invalid Class!");
		} else {
			
		    if(this.year!=o.year) 
			{
				return this.year-o.year;
			}
			else if(this.month!=o.month) 
			{
				return this.month-o.month;
			}
			else if(this.day!=o.day) 
			{
				return this.day-o.day;
			}
		}
		
		return 0;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if(this==obj) 
		{
			return true;
		}
		if(obj==null) 
		{
			return false;
		}
		if(!(obj instanceof Date)) 
		{
			return false;
		}
		Date temp = (Date) obj;
		if(temp.year==this.year && temp.month==this.month && temp.day==this.day) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	@Override
	public String toString() 
	{
		StringBuilder ans= new StringBuilder();
		if (month<10 && day<10) 
		{
			ans.append(year).append("-0").append(month).append("-0").append(day);
		}
		else if(month <10) 
		{
			ans.append(year).append("-0").append(month).append("-").append(day);
		} 
		else if(day<10) 
		{
			ans.append(year).append("-").append(month).append("-0").append(day);
		} 
		else 
		{
			ans.append(year).append("-").append(month).append("-").append(day);
		}
		return ans.toString();
	}
	
}
