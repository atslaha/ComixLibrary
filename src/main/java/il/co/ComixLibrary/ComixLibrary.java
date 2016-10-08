package main.java.il.co.ComixLibrary;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;



//remove this comment
public class ComixLibrary {

    private Map<String, ComixNotation> library = new HashMap<>();
    private Map<String, ComixNotation> searchResults = new HashMap<>();

    public Map<String, ComixNotation> getComixLibrary(){
        return library;
    }
               
    public void setLibrary(String uuid, ComixNotation CN){
        this.library.put(uuid, CN);
    }
    
    public void deleteComixNotation(int inputNumber){        
        int count1 = 0;
        for (Map.Entry<String, ComixNotation> entry : this.library.entrySet()) {
            count1++;
            if (count1 == inputNumber) {
                String key = entry.getKey();
                this.library.remove(key);
                System.out.println("Notation has deleted successful!" + "\n");
            }
        }
    }
         
    public Map<String, ComixNotation> searchByHeroName(String inputHeroName){
        for (Map.Entry<String, ComixNotation> entry : library.entrySet()) {
            ComixNotation CN3 = entry.getValue();
            String heroName = CN3.getMainHeroName();
            Pattern pattern = Pattern.compile(inputHeroName);
            Matcher matcher = pattern.matcher(heroName);
            if (matcher.find()) {
                searchResults.put(entry.getKey(), entry.getValue());
            }
        }
        return searchResults;
    }
    
    public Map<String, ComixNotation> searchByTitle(String inputComixTitle){
        for (Map.Entry<String, ComixNotation> entry : library.entrySet()) {
            ComixNotation CN3 = entry.getValue();
            String comixTitle1 = CN3.getComixTitle();
            Pattern pattern = Pattern.compile(inputComixTitle);
            Matcher matcher = pattern.matcher(comixTitle1);
            if (matcher.find()) {
                searchResults.put(entry.getKey(), entry.getValue());
            }

        }
        return searchResults;
    }
    
    public Map<String, ComixNotation> searchYearStrictly(int inputYearIssue){
        for (Map.Entry<String, ComixNotation> entry : library.entrySet()) {
            ComixNotation CN2 = entry.getValue();
            DateTime dateIssue = CN2.getIssueYear();
            int yearIssue = dateIssue.getYear();            
            if (Objects.equals(yearIssue, inputYearIssue)) {
                searchResults.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println();
        return searchResults;
    }
    
    public Map<String, ComixNotation>  searchYearBefore(int inputYearIssue1){
        for (Map.Entry<String, ComixNotation> entry : library.entrySet()) {
            ComixNotation CN2 = entry.getValue();
            DateTime dateIssue = CN2.getIssueYear();
            int yearIssue = dateIssue.getYear();
            if (Objects.equals(yearIssue, inputYearIssue1) || yearIssue < inputYearIssue1) {
                searchResults.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println();
        return searchResults;
    }
    
    public Map<String, ComixNotation> searchYearAfter(int inputYearIssue2){
        for (Map.Entry<String, ComixNotation> entry : library.entrySet()) {
            ComixNotation CN2 = entry.getValue();
            DateTime dateIssue = CN2.getIssueYear();
            int yearIssue = dateIssue.getYear();
            // int yearIssue = entry.getValue().getIssueYear().getYear();
            if (Objects.equals(yearIssue, inputYearIssue2) || yearIssue > inputYearIssue2) {
                searchResults.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println();
        return searchResults;
    }    
        
    
    
    public void sort(int choice1){
        switch (choice1) {
        case 1: // Year of the issue

             //Stream<Map.Entry<String,ComixNotation>> sorted =
             //library.entrySet().stream().sorted(Map.Entry.comparingByValue());
            

            break;

        }
    }

    public void serData() {
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

    public void deserData() {
        Object retObject = null;
        try {
            FileInputStream fileIn = new FileInputStream("profiles.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            retObject = in.readObject();
            this.library = (Map<String, ComixNotation>) retObject;
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
        //return library;

    }

    public static void main(String[] args) {
        //TODO
        
    }

}
