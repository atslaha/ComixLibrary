package il.co.ComixLibrary;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;


public class ComixNotation implements Serializable {
	private String issueYear;
	private String comixTitle;
	private String issueName;
	private String mainHeroName;
	private transient Calendar dateOfBuying;
	
	public ComixNotation(String issueYear, String mainHeroName, String issueName, String comixTitle, Calendar dateOfBuying){
		this.issueYear=issueYear;
		this.mainHeroName=mainHeroName;
		this.issueName=issueName;
		this.comixTitle=comixTitle;
		this.dateOfBuying=dateOfBuying;}
	
	public ComixNotation(){this("EmptyLine","EmptyLine","EmptyLine","EmptyLine", new GregorianCalendar(2016,1,28));}
	
	public Object getComixNotation(){
		return new ComixNotation(issueYear, mainHeroName, issueName, comixTitle, dateOfBuying);}
	
	public void setIssueYear(String issueYear){this.issueYear=issueYear;}
	public void setComixTitle(String comixTitle){this.comixTitle=comixTitle;}
	public void setIssueName(String issueName){this.issueName=issueName;}
	public void setMainHeroName(String mainHeroName){this.mainHeroName=mainHeroName;}
	public void setDateOfBuying(Calendar dateOfBuying){this.dateOfBuying=dateOfBuying;}
	
	public String getIssueYear(){return issueYear;}
	public String getComixTitle(){return comixTitle;}
	public String getIssueName(){return issueName;}
	public String getMainHeroName(){return mainHeroName;}
	public Calendar getDateOfBuying(){return dateOfBuying;}
	
	@Override
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
		return issueYear+"  "+mainHeroName+"  "+issueName+"  "+comixTitle+"  "+sdf.format(dateOfBuying.getTime());}
	
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

	public static void main(String[] args) {
		ComixNotation notation1 = new ComixNotation();
		System.out.println(notation1);
		DateTime test = new DateTime();

	}

}
