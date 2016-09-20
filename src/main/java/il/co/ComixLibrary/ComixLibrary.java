package main.java.il.co.ComixLibrary;

import org.joda.time.DateTime;

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
			ComixLibraryOperations clo = new ComixLibraryOperations();
			String comixTitle, issueName, mainHeroName;
			DateTime issueYear = new DateTime();
			Calendar dateOfBuying = new GregorianCalendar();
			System.out.println("Input Year of isuue!");
			issueYear = issueYear.year().setCopy(clo.inputDigit());
			System.out.println("Input Month of issue! in format (0-12)");
			issueYear = issueYear.monthOfYear().setCopy(clo.inputDigit());
			System.out.println("Input Day of issue!");
			issueYear = issueYear.dayOfMonth().setCopy(clo.inputDigit());
			System.out.println("Input the Main Hero name!");
			mainHeroName = clo.inputValue();
			System.out.println("Input the issue Name!");
			issueName = clo.inputValue();
			System.out.println("Input Comix Title!");
			comixTitle = clo.inputValue();
			System.out.println("Input Year of buying!");
			dateOfBuying.set(Calendar.YEAR, clo.inputDigit());
			System.out.println("Input Month of buying!");
			dateOfBuying.set(Calendar.MONTH, (clo.inputDigit() - 1));
			System.out.println("Input Day of buying!");
			dateOfBuying.set(Calendar.DAY_OF_MONTH, clo.inputDigit());
			ComixNotation CN = new ComixNotation(issueYear, mainHeroName, issueName, comixTitle, dateOfBuying);
			library.put(issueName, CN);
			 serData();

			// System.out.println();

			break;

		}

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
		ComixNotation CN = new ComixNotation();
		System.out.println(CN);
		String str = "aaaaaaa";
		DateTime DT = new DateTime(2015, 10, 11, 0, 0);
		Calendar CL = new GregorianCalendar(2016, 1, 28);

		// serData
		try {
			FileOutputStream fileOut = new FileOutputStream("profiles.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(CN);
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

		// deserData
		ComixNotation CN1 = new ComixNotation();
		String str1 = "FFFFF";
		DateTime DT1 = new DateTime();
		Calendar CL1 = new GregorianCalendar();
		Object retObject = null;
		try {
			FileInputStream fileIn = new FileInputStream("profiles.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			retObject = in.readObject();
			CN1 = (ComixNotation) retObject;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
		System.out.println(CN1);

	}

}
