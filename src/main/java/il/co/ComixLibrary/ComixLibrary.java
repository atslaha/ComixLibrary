package main.java.il.co.ComixLibrary;

import org.joda.time.DateTime;

import java.io.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

//remove this comment
public class ComixLibrary {

    private static Map<String, ComixNotation> library = new HashMap<>();

    static void comixLibrary(int operations) {
        switch (operations) {
            case 1://show notations
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
                issueYear.year().setCopy(clo.inputDigit());
                System.out.println("Input Month of issue!");
                issueYear.monthOfYear().setCopy(clo.inputDigit());
                System.out.println("Input Day of issue!");
                issueYear.dayOfMonth().setCopy(clo.inputDigit());
                System.out.println("Input the Main Hero name!");
                mainHeroName = clo.inputValue();
                System.out.println("Input the issue Name!");
                issueName = clo.inputValue();
                System.out.println("Input Comix Title!");
                comixTitle = clo.inputValue();
                System.out.println("Input Year of buying!");
                dateOfBuying.set(Calendar.YEAR, clo.inputDigit());
                System.out.println("Input Month of buying!");
                dateOfBuying.set(Calendar.MONTH, clo.inputDigit());
                System.out.println("Input Day of buying!");
                dateOfBuying.set(Calendar.DAY_OF_MONTH, clo.inputDigit());
                ComixNotation CN = new ComixNotation(issueYear, mainHeroName, issueName, comixTitle, dateOfBuying);
                library.put(comixTitle, CN);
//			serData();
//			System.out.println();


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
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exeption!");
            System.exit(2);
        }

    }

    public static void deserData() {
        Object retObject;
        try {
            FileInputStream fileIn = new FileInputStream("profiles.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retObject = in.readObject();
            //book = (Map<String, PhoneNotation>) retObject;
            fileIn.close();
            in.close();
            library = (Map<String, ComixNotation>) retObject;
        } catch (FileNotFoundException e) {
            System.out.println("File not found!" + "\n");
            System.exit(1);
            //e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exeption!");
            System.exit(2);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
            System.exit(3);
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
