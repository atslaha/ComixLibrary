package main.java.il.co.ComixLibrary;

//import main.java.il.co.ComixLibrary.ComixNotation;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.ReadableInstant;
import org.joda.time.field.AbstractReadableInstantFieldProperty;

public class ComixLibraryOperations {

	private int a;
	private String d;

	private Scanner scn = new Scanner(System.in);

	// input digit method
	int inputDigit() {
		while (true) {
			if (scn.hasNextInt()) {
				d = scn.next();
				a = Integer.parseInt(d);
				break;
			} else {
				System.out.println("ERROR INPUT!" + "\n" + "Input a digit again please!");
				d = scn.nextLine();
				d = scn.next();
			}
		}
		return a;
	}

	// Exit Program Method//
	int exitProgram() {
		while (true) {
			// Input the choice digit //
			while (true) {
				if (scn.hasNextInt()) {
					a = scn.nextInt();
					break;
				} else {
					System.out.println("ERROR INPUT" + "\n" + "Leave Comix Library: 1, Continue: 2");
					d = scn.next();
				}
			}
			// Check the choice (1 or 2)//
			if (a >= 1 && a <= 2) {
				break;
			} else {
				System.out.println("ERROR INPUT" + "\n" + "Leave Comix Library: 1, Continue: 2");
			}
		}
		return a;
	}

	// INPUT VALUE METHOD
	String inputValue() {
		Scanner scnn = new Scanner(System.in);
		while (true) {
			if (scnn.hasNext()) {
				d = scnn.nextLine();
				// scnn.close();
				break;
			} else{
				System.out.println("ERROR INPUT" + "\n" + "Please try againe!");
				String falureInput=scnn.nextLine();
				falureInput=scnn.next();				
		      }
		}

		return d;
	}
	
	public String inputKey(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
	
	public DateTime inputIssueDate(){
        int inputYear = 0;
        int inputMonthOfYear = 0;
        int inputDayOfMonth = 0;        
        ComixLibraryOperations clo = new ComixLibraryOperations();        
        DateTime issueYear = new DateTime();                
        System.out.println("Input Year of isuue!");
        inputYear = clo.inputDigit();
        issueYear = issueYear.year().setCopy(inputYear);

        System.out.println("Input Month of issue! in format (1-12)");
        while (true) {
            inputMonthOfYear = clo.inputDigit();
            if (0 < inputMonthOfYear && inputMonthOfYear <= 12) {
                issueYear = issueYear.monthOfYear().setCopy(inputMonthOfYear);
                break;
            } else
                System.out.println("Input Digit (1-12)");
        }

        System.out.println("Input Day of issue! (1-30(31,28,29)");
        while (true) {
            inputDayOfMonth = clo.inputDigit();
            int lastDayOfMonth = 0;
            lastDayOfMonth = getLastDayOfMonth(inputMonthOfYear, inputYear);
            if (0 < inputDayOfMonth && inputDayOfMonth <= lastDayOfMonth) {
                issueYear = issueYear.dayOfMonth().setCopy(inputDayOfMonth);
                break;
            } else
                System.out.println("Input Digit (1-30(31,28,29))");
        }
        return issueYear;
    }
	
	public String inputMainHeroName(){
        ComixLibraryOperations clo = new ComixLibraryOperations();
        String comixTitle, issueName, mainHeroName;
        System.out.println("Input the Main Hero name!");
        mainHeroName = clo.inputValue();
        return mainHeroName;
        
        
    }
    
    public String inputIssueName(){
        ComixLibraryOperations clo = new ComixLibraryOperations();
        String issueName;
        System.out.println("Input the issue Name!");
        issueName = clo.inputValue(); 
        return issueName;
    }
    
    public String inputComixTitle(){
        ComixLibraryOperations clo = new ComixLibraryOperations();
        String comixTitle;
        System.out.println("Input Comix Title!");
        comixTitle = clo.inputValue();
        return comixTitle;
    }
    
    public Calendar inputDateOfBuying(){
        int inputYear = 0;
        int inputMonthOfYear = 0;
        int inputDayOfMonth = 0;
        ComixLibraryOperations clo = new ComixLibraryOperations();
        Calendar dateOfBuying = new GregorianCalendar();
        System.out.println("Input Year of buying!");
        inputYear = clo.inputDigit();
        dateOfBuying.set(Calendar.YEAR, inputYear);

        System.out.println("Input Month of buying!");
        while (true) {
            inputMonthOfYear = clo.inputDigit();
            if (0 < inputMonthOfYear && inputMonthOfYear <= 12) {
                dateOfBuying.set(Calendar.MONTH, (inputMonthOfYear - 1));
                break;
            } else
                System.out.println("Input Digit (1-12)");
        }

        System.out.println("Input Day of buying!");
        while (true) {
            inputDayOfMonth = clo.inputDigit();
            int lastDayOfMonth = 0;
            lastDayOfMonth = getLastDayOfMonth(inputMonthOfYear, inputYear);
            if (0 < inputDayOfMonth && inputDayOfMonth <= lastDayOfMonth) {
                dateOfBuying.set(Calendar.DAY_OF_MONTH, inputDayOfMonth);
                break;
            } else
                System.out.println("Input Digit (1-30(31,28,29))");
        }
        return dateOfBuying;
    }
    
    public int inputChoiceOfSearch(){
        ComixLibraryOperations inputSearch = new ComixLibraryOperations();
        int choice = 0;
        while (true) {
            System.out.println("How do you want to search:" + "\n" + "1.Year of the issue;" + "\n"
                    + "2.The main hero name;" + "\n" + "3.Comix Title" + "\n");
            choice = inputSearch.inputDigit();
            if (0 < choice && choice < 4) {
                break;
            } else
                System.out.println("Try again!" + "\n");
        }
        return choice;
    }
    
    public int inputChoiceOfSort(){
        ComixLibraryOperations inputSort = new ComixLibraryOperations();
        int choice1 = 0;
        while (true) {
            System.out.println("Sort by: 1. Year of the issue; 2. The main Hero name; 3. Comix Title" + "\n");
            choice1 = inputSort.inputDigit();
            if (0 < choice1 && choice1 < 4) {
                break;
            } else
                System.out.println("Try again!" + "\n");
        }
        return choice1;
    }
    
    public static int getLastDayOfMonth(int month, int year) {
        int JANUARY = 1;
        int DECEMBER = 12;
        int FIRST_OF_THE_MONTH = 1;
        LocalDate aDate = new LocalDate(year, month, FIRST_OF_THE_MONTH);
        int lastDay = 0;
        lastDay = aDate.dayOfMonth().getMaximumValue();
        return lastDay;
    }
	
    public void printSearchResults(Map<String, ComixNotation> searchResults){
        for (Map.Entry<String, ComixNotation> entry: searchResults.entrySet()){
            System.out.println(entry.getValue());
        }
    }
	
    public static <String, ComixNotation> Map<String, ComixNotation> sortByValue(Map<String, ComixNotation> map) {
        List<Entry<String, ComixNotation>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ComixNotation>>(){
            public int compare( Map.Entry<String, ComixNotation> o1, Map.Entry<String, ComixNotation> o2 )
            {
                Integer issueYear1 = 0, issueYear2 = 0, issueMonth1 = 0,issueMonth2 = 0,issueDay1 = 0,issueDay2 = 0;
                //ComixNotation CN = new ComixNotation();
                if (o1.getValue() instanceof main.java.il.co.ComixLibrary.ComixNotation){
                    
                    issueYear1 = ((main.java.il.co.ComixLibrary.ComixNotation)(o1.getValue())).getIssueYear().getYear();
                   issueMonth1 = ((main.java.il.co.ComixLibrary.ComixNotation)(o1.getValue())).getIssueYear().getMonthOfYear();
                   issueDay1 = ((main.java.il.co.ComixLibrary.ComixNotation) (o1.getValue())).getIssueYear().getDayOfMonth();
                }
                
                if (o2.getValue() instanceof main.java.il.co.ComixLibrary.ComixNotation){
                    issueYear2 = ((main.java.il.co.ComixLibrary.ComixNotation) (o2.getValue())).getIssueYear().getYear();
                    issueMonth2 = ((main.java.il.co.ComixLibrary.ComixNotation) (o2.getValue())).getIssueYear().getMonthOfYear();
                    issueDay2 = ((main.java.il.co.ComixLibrary.ComixNotation) (o2.getValue())).getIssueYear().getDayOfMonth();
                }
                        
                if (issueYear1 != issueYear2) return ((int)(issueYear1-issueYear2));
                if (issueYear1 == issueYear2 && issueMonth1 != issueMonth2) return ((int)(issueMonth1 - issueMonth2));
                if (issueYear1 == issueYear2 && issueMonth1 == issueMonth2 && issueDay1 != issueDay2) return ((int)(issueDay1-issueDay2));
                else return 0;
            }
        } );    

        Map<String, ComixNotation> result = new LinkedHashMap<>();
        for (Iterator<Entry<String, ComixNotation>> it = list.iterator(); it.hasNext();) {
            Map.Entry<String, ComixNotation> entry = (Map.Entry<String, ComixNotation>) it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
	
	
	
	
	

	public static void main(String[] args) {
		// while (a.hasNextLine()) { b += a.nextLine(); }
		// TODO

	}

}
