package main.java.il.co.ComixLibrary;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * ComixNotation represents a notation with information about comic issue in the ComixLibrary
 * @author Artem Meleshko
 * @version 1.0 2016
 * 
 *
 */
public class ComixNotation implements Serializable {
    private DateTime issueYear;
    private String comixTitle;
    private String issueName;
    private String mainHeroName;
    private transient Calendar  dateOfBuying;

    /**
     * Constructs and initializes ComixNotation 
     * @param issueYear is DateTime object of the jodaTime library with the comic Issue's Date of producing.
     * @param mainHeroName is a notation with the main hero's name.
     * @param issueName is a notation with the name of all this issue. 
     * @param comixTitle is a notation with the title description of the comic magazine.
     * @param dateOfBuying is an object with the information about the date when this comic magazine was bought.
     */
    ComixNotation(DateTime issueYear, String mainHeroName, String issueName, String comixTitle, Calendar dateOfBuying) {
        this.issueYear = issueYear;
        this.mainHeroName = mainHeroName;
        this.issueName = issueName;
        this.comixTitle = comixTitle;
        this.dateOfBuying = dateOfBuying;
    }

//    public ComixNotation() {
//        this(new DateTime(2015, 10, 11, 0, 0), "EmptyLine", "EmptyLine", "EmptyLine", new GregorianCalendar(2016, 1, 28));
//    }
    
    /**
     * Constructs and initialized ComixNotaion object with the empty fields.
     */
    public ComixNotation() {
      this(null, null, null, null, null);
  }
    /**
     * Returns new ComixNotation object with the filled fields. 
     * @return new ComixNotation object 
     */
    public Object getComixNotation() {
        return new ComixNotation(issueYear, mainHeroName, issueName, comixTitle, dateOfBuying);
    }
    
    /**
     * DateTime object with the date of the issue producing
     * @param issueYear is a DateTime object with the date of the issue producing
     */
    public void setIssueYear(DateTime issueYear) {
        this.issueYear = issueYear;
    }
    
    /**
     *Sets the year field in the DateTime object issueYear. 
     * @param year is the year of the issue producing. 
     */
    public void setIssueYearYear(int year) {
        this.issueYear = issueYear.year().setCopy(year);
    }
    
    /**
     * Sets the month field in the DateTime object issueYear.
     * @param month is the month of the issue producing.
     */
    public void setIssueYearMonth(int month) {
        this.issueYear = issueYear.monthOfYear().setCopy(month);
    }
    
    /**
     * Sets the the day field in the DateTime object issueYear.
     * @param day is the day of the issue producing.
     */
    public void setIssueYearDay(int day) {
        this.issueYear = issueYear.dayOfMonth().setCopy(day);
    }

    /**
     * Sets the comixTitle field in the ComixNotation object.
     * @param comixTitle is the title description of the comic magazine.
     */
    public void setComixTitle(String comixTitle) {
        this.comixTitle = comixTitle;
    }

    /**
     * Sets the issueName field in the ComixNotation object.
     * @param issueName is the name of comic issue. 
     */
    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    /**
     * Sets the mainHeroName field in the ComixNotation object.
     * @param mainHeroName is the name of the main hero in the comic magazine.
     */
    public void setMainHeroName(String mainHeroName) {
        this.mainHeroName = mainHeroName;
    }

    /**
     * Sets the dateOfBuying field in the ComixNotation object with the Calendar object.
     * @param dateOfBuying is the Calendar object with the date of buying this comic magazine.
     */
    public void setDateOfBuying(Calendar dateOfBuying) {
        this.dateOfBuying = dateOfBuying;
    }

    /**
     * Sets the Year field in the Calendar object dateOfBuying.
     * @param year is the year of buying this comic magazine.
     */
    public void setDateOfBuyingYear(int year) {
        this.dateOfBuying.set(Calendar.YEAR, year);
    }

    /**
     * Sets the Month field in the Calendar object dateOfBuying.
     * @param month is the month of buying this comic magazine.
     */
    public void setDateOfBuyingMonth(int month) {
        this.dateOfBuying.set(Calendar.MONTH, month);
    }

    /**
     * Sets the Day field in the Calendar object dateOfBuying.
     * @param day is the day of buying this comic magazine.
     */
    public void setDateOfBuyingDay(int day) {
        this.dateOfBuying.set(Calendar.DAY_OF_MONTH, day);
    }

    /**
     * Returns a value of the DateTime object from the ComixNotation's field issueYear.
     * @return DateTime object with the date of the issue producing.
     */
    public DateTime getIssueYear() {
        return issueYear;
    }

    /**
     * Returns a value of the String object from the ComixNotation's field comixTitle.
     * @return String object with the title of the comic issue.
     */
    public String getComixTitle() {
        return comixTitle;
    }

    /**
     * Returns a value of the String object from the ComixNotation's field issueName.
     * @return String object with the name of the comic issue.
     */
    public String getIssueName() {
        return issueName;
    }

    /**
     * Returns a value of the String object from the ComixNotation's field mainHeroName.
     * @return String object with the name of the main hero in this comic issue.
     */
    public String getMainHeroName() {
        return mainHeroName;
    }

    /**
     * Returns a value of the Calendar object from the ComixNotation's field dateOfBuying.
     * @return Calendar object with the date of comic issue buying.
     */
    public Calendar getDateOfBuying() {
        return dateOfBuying;
    }

    /**
     * Returns a string representation of the object ComixNotation.
     */
    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy MM dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
        if (dateOfBuying == null){
        	return fmt.print(issueYear) + "  " + mainHeroName + "  " + issueName + "  " + comixTitle;
        }else
        return fmt.print(issueYear) + "  " + mainHeroName + "  " + issueName + "  " + comixTitle + "  " + sdf.format(dateOfBuying.getTime());
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     */
    @Override
    public boolean equals(Object s) {
        if (s == this)
            return true;
        if (!(s instanceof ComixNotation))
            return false;
        ComixNotation other = (ComixNotation) s;
        return (Objects.equals(issueYear, other.issueYear)) && (Objects.equals(mainHeroName, other.mainHeroName)) && (Objects.equals(issueName, other.issueName)) && (Objects.equals(comixTitle, other.comixTitle)) && (Objects.equals(dateOfBuying, other.dateOfBuying));
    }

    /**
     * Returns a hash code value for the object.
     */
    @Override
    public int hashCode() {
        Integer result = 17;
        result = 37 * result + issueYear.hashCode();
        result = 37 * result + mainHeroName.hashCode();
        result = 37 * result + issueName.hashCode();
        result = 37 * result + comixTitle.hashCode();
        result = 37 * result + dateOfBuying.hashCode();
        return result;
    }

    /**
     * Test method for Testing JUnit.
     * @return false.
     */
    public boolean getBool() {
        return false;
    }

    /**
     * Test method for Testing JUnit
     * @return true.
     */
    public boolean getBooll() {
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

        Calendar cal = new GregorianCalendar(2016, 1, 28);//Calendar.getInstance();
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
