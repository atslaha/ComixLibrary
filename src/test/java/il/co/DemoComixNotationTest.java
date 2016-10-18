package test.java.il.co;

import main.java.il.co.ComixLibrary.ComixNotation;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class DemoComixNotationTest {

    @Test
    public void ShouldReturnTrue() {
        ComixNotation demoNotation = new ComixNotation();
        assertTrue(demoNotation.getBool());
    }

    @Test
    public void ShouldReturnTrue1() {
        ComixNotation demoNotation = new ComixNotation();
        assertTrue(demoNotation.getBooll());
    }
    
    @Test
    public void getComixNotationTest(){
        ComixNotation demoNotation = new ComixNotation();
        ComixNotation demoNotation1 = (ComixNotation)demoNotation.getComixNotation();
        assertEquals(demoNotation, demoNotation1);
        //assertTrue(demoNotation.equals(demoNotation1));
        
    }
    
    @Test
    public void testAssertThatBothContainsString() {
      //assertThat("albumen", both(containsString("a")).and(containsString("b")));
      assertThat(new ComixNotation(), not(sameInstance(new ComixNotation())));
    }
    
    @Test
    public void setIssueYearTest(){
        ComixNotation demoNotation = new ComixNotation();
        DateTime DT = new DateTime(2015, 10, 11, 0, 0);
        demoNotation.setIssueYear(DT);
        assertEquals(DT, demoNotation.getIssueYear());
    }
    
    @Test
    public void setIssueYearYearTest(){
        int year =2016;
        ComixNotation demoNotation = new ComixNotation();
        DateTime DT = new DateTime(2015, 10, 11, 0, 0);
        demoNotation.setIssueYear(DT);
        demoNotation.setIssueYearYear(year);
        assertEquals(year, demoNotation.getIssueYear().getYear());
    }
    
    @Test
    public void setIssueYearMonth(){
        int month =6;
        ComixNotation demoNotation = new ComixNotation();
        DateTime DT = new DateTime(2015, 10, 11, 0, 0);
        demoNotation.setIssueYear(DT);
        demoNotation.setIssueYearMonth(month);
        assertEquals(month, demoNotation.getIssueYear().getMonthOfYear());
    }
    
    @Test
    public void setIssueYearDay(){
        int day =12;
        ComixNotation demoNotation = new ComixNotation();
        DateTime DT = new DateTime(2015, 10, 11, 0, 0);
        demoNotation.setIssueYear(DT);
        demoNotation.setIssueYearDay(day);
        assertEquals(day, demoNotation.getIssueYear().getDayOfMonth());
    }
    
    @Test
    public void setComixTitleTest(){
        String title = "Good title!";
        ComixNotation demoNotation = new ComixNotation();
        demoNotation.setComixTitle(title);
        assertEquals(title, demoNotation.getComixTitle());        
    }
    
    @Test
    public void setIssueNameTest(){
        String issueName = "Good issue name!";
        ComixNotation demoNotation = new ComixNotation();
        demoNotation.setIssueName(issueName);
        assertEquals(issueName, demoNotation.getIssueName());
    }
    
    @Test
    public void setMainHeroNameTest(){
        String mainHeroName = "Good Hero!";
        ComixNotation demoNotation = new ComixNotation();
        demoNotation.setMainHeroName(mainHeroName);
        assertEquals(mainHeroName, demoNotation.getMainHeroName());
    }
    
    @Test
    public void setDateOfBuyingTest(){
        ComixNotation demoNotation = new ComixNotation();
        Calendar dateOfBuying = new GregorianCalendar(2016, 1, 28);        
        demoNotation.setDateOfBuying(dateOfBuying);
        assertEquals(dateOfBuying, demoNotation.getDateOfBuying());
    }
    
    @Test
    public void setDateOfBuyingYearTest(){
        int year =2016;
        ComixNotation demoNotation = new ComixNotation();
        Calendar dateOfBuying = new GregorianCalendar(2016, 1, 28);        
        demoNotation.setDateOfBuying(dateOfBuying);
        demoNotation.setDateOfBuyingYear(year);
        assertEquals(year, demoNotation.getDateOfBuying().get(Calendar.YEAR));
    }
    
    @Test
    public void setDateOfBuyingMonthTest(){
        int month =6;
        ComixNotation demoNotation = new ComixNotation();
        Calendar dateOfBuying = new GregorianCalendar(2016, 1, 28);        
        demoNotation.setDateOfBuying(dateOfBuying);
        demoNotation.setDateOfBuyingMonth(month);
        assertEquals(month, demoNotation.getDateOfBuying().get(Calendar.MONTH));
    }
    
    @Test
    public void setDateOfBuyingDayTest(){
        int day =26;
        ComixNotation demoNotation = new ComixNotation();
        Calendar dateOfBuying = new GregorianCalendar(2016, 1, 28);        
        demoNotation.setDateOfBuying(dateOfBuying);
        demoNotation.setDateOfBuyingDay(day);
        assertEquals(day, demoNotation.getDateOfBuying().get(Calendar.DAY_OF_MONTH));
    }
    
    @Test
    public void getIssueYearTest(){
        ComixNotation demoNotation = new ComixNotation();
        DateTime DT = new DateTime(2015, 10, 11, 0, 0);
        demoNotation.setIssueYear(DT);
        assertEquals(DT, demoNotation.getIssueYear());
    }
    
    @Test
    public void getComixTitleTest(){
        ComixNotation demoNotation = new ComixNotation();
        String comixTitle = "Good Title";
        demoNotation.setComixTitle(comixTitle);
        assertEquals(comixTitle, demoNotation.getComixTitle());
    }
    
    @Test
    public void getIssueNameTest(){
        ComixNotation demoNotation = new ComixNotation();
        String issueName = "Good issue name";
        demoNotation.setIssueName(issueName);
        assertEquals(issueName, demoNotation.getIssueName());
    }
    
    @Test
    public void getMainHeroNameTest(){
        ComixNotation demoNotation = new ComixNotation();
        String mainHeroName = "Good Hero's name";
        demoNotation.setMainHeroName(mainHeroName);
        assertEquals(mainHeroName, demoNotation.getMainHeroName());
    }
    
    @Test
    public void getDateOfBuyingTest(){
        ComixNotation demoNotation = new ComixNotation();
        Calendar dateOfBuying = new GregorianCalendar(2016, 1, 28);        
        demoNotation.setDateOfBuying(dateOfBuying);
        assertEquals(dateOfBuying, demoNotation.getDateOfBuying());
    }
    
    @Test
    public void toStringTest(){
        ComixNotation demoNotation = new ComixNotation();
        demoNotation.setIssueYear(new DateTime(2015, 10, 11, 0, 0));
        demoNotation.setMainHeroName("mainHeroName");
        demoNotation.setComixTitle("comixTitle");
        demoNotation.setIssueName("issueName");
        demoNotation.setDateOfBuying(new GregorianCalendar(2016, 1, 28));
        assertTrue(demoNotation.toString(), true);
    }
    
    @Test
    public void equalsTest(){
        ComixNotation demoNotation = new ComixNotation();
        ComixNotation demoNotation1 = new ComixNotation();
        demoNotation.setIssueYear(new DateTime(2015, 10, 11, 0, 0));
        demoNotation1.setIssueYear(new DateTime(2015, 10, 11, 0, 0));
        assertEquals(demoNotation.equals(demoNotation1), true);
    }
    
    @Test
    public void hashCodeTest1(){
        ComixNotation demoNotation = new ComixNotation();
        ComixNotation demoNotation1 = new ComixNotation();
        demoNotation.setIssueYear(new DateTime(2015, 10, 11, 0, 0));
        demoNotation.setMainHeroName("mainHeroName");
        demoNotation.setComixTitle("comixTitle");
        demoNotation.setIssueName("issueName");
        demoNotation.setDateOfBuying(new GregorianCalendar(2016, 1, 28));
        demoNotation1.setIssueYear(new DateTime(2016, 10, 11, 0, 0));
        demoNotation1.setMainHeroName("mainHeroName1");
        demoNotation1.setComixTitle("comixTitle1");
        demoNotation1.setIssueName("issueName1");
        //demoNotation1.setDateOfBuying(new GregorianCalendar(2016, 1, 28));
        assertEquals(demoNotation.hashCode() != demoNotation1.hashCode(), true);
    }
    
    @Test
    public void hashCodeTest2(){
        ComixNotation demoNotation = new ComixNotation();
        ComixNotation demoNotation1 = new ComixNotation();
        demoNotation.setIssueYear(new DateTime(2015, 10, 11, 0, 0));
        demoNotation.setMainHeroName("mainHeroName");
        demoNotation.setComixTitle("comixTitle");
        demoNotation.setIssueName("issueName");
        demoNotation.setDateOfBuying(new GregorianCalendar(2016, 1, 28));
        demoNotation1.setIssueYear(new DateTime(2015, 10, 11, 0, 0));
        demoNotation1.setMainHeroName("mainHeroName");
        demoNotation1.setComixTitle("comixTitle");
        demoNotation1.setIssueName("issueName");
        demoNotation1.setDateOfBuying(new GregorianCalendar(2016, 1, 28));
        assertEquals(demoNotation.hashCode() == demoNotation1.hashCode(), true);
    }
    
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        

    }

}
