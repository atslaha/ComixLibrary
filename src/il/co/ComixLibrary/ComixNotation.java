package il.co.ComixLibrary;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


public class ComixNotation implements Serializable {
	private DateTime issueYear;
	private String comixTitle;
	private String issueName;
	private String mainHeroName;
	private transient Calendar dateOfBuying;
	
	public ComixNotation(DateTime issueYear, String mainHeroName, String issueName, String comixTitle, Calendar dateOfBuying){
		this.issueYear=issueYear;
		this.mainHeroName=mainHeroName;
		this.issueName=issueName;
		this.comixTitle=comixTitle;
		this.dateOfBuying=dateOfBuying;}
	
	public ComixNotation(){this(new DateTime(2015,10,11,0,0),"EmptyLine","EmptyLine","EmptyLine", new GregorianCalendar(2016,1,28));}
	
	public Object getComixNotation(){
		return new ComixNotation(issueYear, mainHeroName, issueName, comixTitle, dateOfBuying);}
	
	public void setIssueYear(DateTime issueYear){this.issueYear=issueYear;}
	public void setIssueYearYear(int year){this.issueYear = issueYear.year().setCopy(year);}
	public void setIssueYearMonth(int month){this.issueYear = issueYear.monthOfYear().setCopy(month);}
	public void setIssueYearDay(int day){this.issueYear = issueYear.dayOfMonth().setCopy(day);}
	
	public void setComixTitle(String comixTitle){this.comixTitle=comixTitle;}
	public void setIssueName(String issueName){this.issueName=issueName;}
	public void setMainHeroName(String mainHeroName){this.mainHeroName=mainHeroName;}
	
	public void setDateOfBuying(Calendar dateOfBuying){this.dateOfBuying=dateOfBuying;}
	public void setDateOfBuyingYear(int year){this.dateOfBuying.set(Calendar.YEAR, year);}
	public void setDateOfButingMonth(int month){this.dateOfBuying.set(Calendar.MONTH, month);}
	public void setDateOfBuingDay(int day){this.dateOfBuying.set(Calendar.DAY_OF_MONTH, day);}
		
	public DateTime getIssueYear(){return issueYear;}
	public String getComixTitle(){return comixTitle;}
	public String getIssueName(){return issueName;}
	public String getMainHeroName(){return mainHeroName;}
	public Calendar getDateOfBuying(){return dateOfBuying;}
	
	@Override
	public String toString(){
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy MM dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
		return fmt.print(issueYear)+"  "+mainHeroName+"  "+issueName+"  "+comixTitle+"  "+sdf.format(dateOfBuying.getTime());}
	
	@Override
	public boolean equals(Object s){
		if (s == this)
			return true;
		if(!(s instanceof ComixNotation))
			return false;
		ComixNotation other = (ComixNotation) s;
		return (issueYear == other.issueYear)&&(mainHeroName == other.mainHeroName)&&(issueName == other.issueName)&&(comixTitle == other.comixTitle)&&(dateOfBuying == other.dateOfBuying);
	}
	
	@Override
	public int hashCode(){
		Integer result = 17;
		result = 37*result + issueYear.hashCode();
		result = 37*result + mainHeroName.hashCode();
		result = 37*result + issueName.hashCode();
		result = 37*result + comixTitle.hashCode();
		result = 37*result + dateOfBuying.hashCode();
		return result;
	}
	
	// Test method for Testing JUnit
	public boolean getBool(){
		return true;
	} 

	public static void main(String[] args) {
		ComixNotation notation1 = new ComixNotation();
		System.out.println(notation1);
		DateTime test = new DateTime(2015, 6, 10, 19, 0);
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd MM yyyy HH:mm");
		int a = 3000;
		test = test.hourOfDay().setCopy(20);
		test = test.dayOfMonth().setCopy(30);
		test = test.monthOfYear().setCopy(4);
		test = test.year().setCopy(a);
		
		
		System.out.println(fmt.print(test));
		
		Calendar cal = new GregorianCalendar(2016,1,28);//Calendar.getInstance();
		 cal.set(Calendar.HOUR, 13);
		 cal.set(Calendar.MINUTE, 25);
		 cal.set(Calendar.SECOND, 12);
		 cal.set(Calendar.YEAR, 3000);
		 cal.set(Calendar.MONTH, 8);
		 cal.set(Calendar.DAY_OF_MONTH, 30);
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		 System.out.println(sdf.format(cal.getTime()));
		

	}

}
