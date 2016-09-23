package main.java.il.co.ComixLibrary;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

//remove this comment
public class ComixLibrary {

	private static Map<String, ComixNotation> library = new HashMap<>();
	private static Integer id = 1;
	
	static void comixLibrary(int operations) {
		switch (operations) {
		case 1:// show notations
			System.out.println("All Notations in the Comix Library:" + "\n");
			for (ComixNotation p : library.values()) {
				System.out.println(p);
			}
			System.out.println();
			break;

		case 2: // add comix
			int inputYear = 0;
			int inputMonthOfYear = 0;
			int inputDayOfMonth = 0;
			ComixLibraryOperations clo = new ComixLibraryOperations();
			String comixTitle, issueName, mainHeroName;
			DateTime issueYear = new DateTime();
			Calendar dateOfBuying = new GregorianCalendar();
			System.out.println("Input Year of isuue!");
			inputYear = clo.inputDigit();
			issueYear = issueYear.year().setCopy(inputYear);
			
			System.out.println("Input Month of issue! in format (1-12)");			
			while (true){
			    inputMonthOfYear = clo.inputDigit();
			    if ( 0 <inputMonthOfYear && inputMonthOfYear <=12 ){
			issueYear = issueYear.monthOfYear().setCopy(inputMonthOfYear);
			break;
			    }else System.out.println("Input Digit (1-12)");
			    }
			
			System.out.println("Input Day of issue! (1-30(31,28,29)");
			while (true){
				inputDayOfMonth = clo.inputDigit();
				int lastDayOfMonth = 0;
				lastDayOfMonth = getLastDayOfMonth(inputMonthOfYear, inputYear);
				if ( 0 <inputDayOfMonth && inputDayOfMonth <=lastDayOfMonth ){					
			        issueYear = issueYear.dayOfMonth().setCopy(inputDayOfMonth);
			        break;
				}else System.out.println("Input Digit (1-30(31,28,29))");
				}
			
			System.out.println("Input the Main Hero name!");
			mainHeroName = clo.inputValue();
			System.out.println("Input the issue Name!");
			issueName = clo.inputValue();
			System.out.println("Input Comix Title!");
			comixTitle = clo.inputValue();
			
			System.out.println("Input Year of buying!");
			inputYear = clo.inputDigit();
			dateOfBuying.set(Calendar.YEAR, inputYear);
			
			System.out.println("Input Month of buying!");
			while (true){
			    inputMonthOfYear = clo.inputDigit();
			    if ( 0 <inputMonthOfYear && inputMonthOfYear <=12 ){
			dateOfBuying.set(Calendar.MONTH, (inputMonthOfYear - 1));
			break;
			    }else System.out.println("Input Digit (1-12)");
			    }
			
			System.out.println("Input Day of buying!");
			while (true){
				inputDayOfMonth = clo.inputDigit();
				int lastDayOfMonth = 0;
				lastDayOfMonth = getLastDayOfMonth(inputMonthOfYear, inputYear);
				if ( 0 <inputDayOfMonth && inputDayOfMonth <=lastDayOfMonth ){	
			dateOfBuying.set(Calendar.DAY_OF_MONTH, inputDayOfMonth);
			break;
				}else System.out.println("Input Digit (1-30(31,28,29))");
				}
			
			
			ComixNotation CN = new ComixNotation(issueYear, mainHeroName, issueName, comixTitle, dateOfBuying);
			library.put(issueName, CN);
			 serData();

			// System.out.println();

			break;

		}

	}

	public static int getLastDayOfMonth( int month,  int year) {
		int JANUARY = 1;
	    int DECEMBER = 12;
		int FIRST_OF_THE_MONTH = 1;
		LocalDate aDate = new LocalDate(year, month, FIRST_OF_THE_MONTH);
		int lastDay=0;
        lastDay = aDate.dayOfMonth().getMaximumValue();
        return lastDay;
	}
	
	public static void serData() {
		try {
			FileOutputStream fileOut = new FileOutputStream("profiles.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(library);
			fileOut.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!" + "\n");
			System.exit(1);
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exeption!");
			System.exit(2);
		}

	}

	public static void deserData() {
		Object retObject = null;
		try {
			FileInputStream fileIn = new FileInputStream("profiles.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			retObject = in.readObject();
			library = (Map<String, ComixNotation>) retObject;
			// book = (Map<String, PhoneNotation>) retObject;
			fileIn.close();
			in.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found!" + "\n");
			System.exit(1);
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exeption!");
			System.exit(2);
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found");
			System.exit(3);
		}

	}

	public static void main(String[] args) {
	//TODO
	}

}
