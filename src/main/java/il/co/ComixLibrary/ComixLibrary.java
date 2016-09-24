package main.java.il.co.ComixLibrary;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//remove this comment
public class ComixLibrary {

	private static Map<String, ComixNotation> library = new HashMap<>();
	
	
	static void comixLibrary(int operations) {
		switch (operations) {
		case 1:// show notations
			System.out.println("All Notations in the Comix Library:" + "\n");
			int count = 0;
			for (ComixNotation p : library.values()) {
				count++;
				System.out.println(count + ": " + p);
			}
			System.out.println();
			break;

		case 2: // add comix
			int inputYear = 0;
			int inputMonthOfYear = 0;
			int inputDayOfMonth = 0;
			String uuid = UUID.randomUUID().toString();
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
			library.put(uuid, CN);
			 serData();

			// System.out.println();

			break;
			
		case 3://Delete ComixNotation
			ComixLibraryOperations clo1 = new ComixLibraryOperations();
			System.out.println("Input number of Comix Notation!");
			int inputNumber = clo1.inputDigit();
			int count1 = 0;
			for (Map.Entry<String, ComixNotation> entry : library.entrySet()){
				count1++;
				if (count1 == inputNumber){
					String key = entry.getKey();
					library.remove(key);
					System.out.println("Notation has deleted successful!"+ "\n");					
				}
			}
			serData();
			break;
			
		case 4: //Search ComixNotation
			
			
			ComixLibraryOperations inputSearch = new ComixLibraryOperations();
			int choice = 0;
			while(true){
				System.out.println("How you want to search:" + "\n"+ "1.Year of the issue;" 
		                      + "\n" +  "2.The main hero name;" + "\n" + "3.Comix Title" + "\n");
				choice = inputSearch.inputDigit();
				if ( 0<choice && choice<4 ){
					break;
				}	else System.out.println("Try again!" + "\n");		
			}
			     switch (choice){
			          case 1:// Search by Year of the issue
			        	  while(true){
			  				System.out.println("How you want to search:" + "\n"+ "1.Strictly year of the issue;" 
			  		                      + "\n" +  "2.Before year of the issue incl.;" + "\n" + "3.After year of the issue incl." + "\n");
			  				choice = inputSearch.inputDigit();
			  				if ( 0<choice && choice<4 ){
			  					break;
			  				}	else System.out.println("Try again!" + "\n");		
			  			}
			            
			        	      switch (choice){
			        	           case 1://strictly YYYY
			        	           System.out.println("Enter year of the issue! (YYYY)" + "\n");
				        	       int inputYearIssue = 0;
				        	       inputYearIssue = inputSearch.inputDigit();
				        	         for (Map.Entry<String, ComixNotation> entry: library.entrySet()){
				        		        ComixNotation CN2 = entry.getValue();
				        		        DateTime dateIssue = CN2.getIssueYear();
				        		        int yearIssue = dateIssue.getYear();
				        		        //int yearIssue = entry.getValue().getIssueYear().getYear();
				        		        if(Objects.equals(yearIssue, inputYearIssue)){
				        			        System.out.println(entry.getValue());
				        		        }
				        	         }
				        	        System.out.println();
				        	        break;
				        	        
			        	           case 2://Before year of the issue incl.
			        	        	   System.out.println("Enter year of the issue! (YYYY)" + "\n");
					        	       int inputYearIssue1 = 0;
					        	       inputYearIssue1 = inputSearch.inputDigit();
					        	         for (Map.Entry<String, ComixNotation> entry: library.entrySet()){
					        		        ComixNotation CN2 = entry.getValue();
					        		        DateTime dateIssue = CN2.getIssueYear();
					        		        int yearIssue = dateIssue.getYear();
					        		        //int yearIssue = entry.getValue().getIssueYear().getYear();
					        		        if(Objects.equals(yearIssue, inputYearIssue1) || yearIssue<inputYearIssue1 ){
					        			        System.out.println(entry.getValue());
					        		        }
					        	         }
					        	        System.out.println();
			        	        	   break;
			        	        	   
			        	           case 3:
			        	        	   System.out.println("Enter year of the issue! (YYYY)" + "\n");
					        	       int inputYearIssue2 = 0;
					        	       inputYearIssue2 = inputSearch.inputDigit();
					        	         for (Map.Entry<String, ComixNotation> entry: library.entrySet()){
					        		        ComixNotation CN2 = entry.getValue();
					        		        DateTime dateIssue = CN2.getIssueYear();
					        		        int yearIssue = dateIssue.getYear();
					        		        //int yearIssue = entry.getValue().getIssueYear().getYear();
					        		        if(Objects.equals(yearIssue, inputYearIssue2) || yearIssue>inputYearIssue2 ){
					        			        System.out.println(entry.getValue());
					        		        }
					        	         }
					        	        System.out.println();
			        	        	   break;
				        	  
			        	      }
				        	  break;
				      
			          case 2://Search by The main hero name
			        	  System.out.println("Enter Hero's Name! (*Name/*Name*/Name*)" + "\n");
			        	  String inputHeroName = inputSearch.inputValue();
			        	  inputHeroName=inputHeroName.replaceAll("[*]", "(.*)");
			        	  for (Map.Entry<String, ComixNotation> entry: library.entrySet()){
			        		  ComixNotation CN3 = entry.getValue();
			        		  String heroName = CN3.getMainHeroName();
			        		  Pattern pattern = Pattern.compile(inputHeroName);
			        		  Matcher matcher = pattern.matcher(heroName);
			        		  if (matcher.find()){
			        			  System.out.println(entry.getValue());
			        		  }
		        		        
			        	  }
			        	  
			        	  break;
			          
			          case 3://Search by Comix Title
			        	  System.out.println("Enter Comix's Title! (*Title/*Title*/Title*)" + "\n");
			        	  String inputComixTitle = inputSearch.inputValue();
			        	  inputComixTitle=inputComixTitle.replaceAll("[*]", "(.*)");
			        	  for (Map.Entry<String, ComixNotation> entry: library.entrySet()){
			        		  ComixNotation CN3 = entry.getValue();
			        		  String comixTitle1 = CN3.getComixTitle();
			        		  Pattern pattern = Pattern.compile(inputComixTitle);
			        		  Matcher matcher = pattern.matcher(comixTitle1);
			        		  if (matcher.find()){
			        			  System.out.println(entry.getValue());
			        		  }
		        		        
			        	  }
			        	  break;
			        	  
			          case 4:
			        	  break;
			     }

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
