package main.java.il.co.ComixLibrary;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import main.java.il.co.ComixLibrary.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;



//remove this comment
public class ComixLibrary {

    private Map<String, ComixNotation> library = new LinkedHashMap<>();
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
        
    
    public  <String, ComixNotation> Map<String, ComixNotation> sortByIssueYear(Map<String, ComixNotation> map) {
        List<Entry<String, ComixNotation>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ComixNotation>>(){
            public int compare( Map.Entry<String, ComixNotation> o1, Map.Entry<String, ComixNotation> o2 )
            {
                //return ((DateTime)(((main.java.il.co.ComixLibrary.ComixNotation)(o1.getValue())).getIssueYear())).compareTo
                //        ((DateTime)(((main.java.il.co.ComixLibrary.ComixNotation)(o2.getValue())).getIssueYear()));
                
                Integer issueYear1 = 0, issueYear2 = 0, issueMonth1 = 0,issueMonth2 = 0,issueDay1 = 0,issueDay2 = 0;
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
        this.library = (Map<java.lang.String, main.java.il.co.ComixLibrary.ComixNotation>) result;
        return (Map<String, ComixNotation>) library;
   }
    
    public  <String, ComixNotation> Map<String, ComixNotation> sortByMainHeroName(Map<String, ComixNotation> map) {
        List<Entry<String, ComixNotation>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ComixNotation>>(){
            public int compare( Map.Entry<String, ComixNotation> o1, Map.Entry<String, ComixNotation> o2 )
            {
                return (((main.java.il.co.ComixLibrary.ComixNotation)(o1.getValue())).getMainHeroName().toLowerCase()).compareTo
                        (((main.java.il.co.ComixLibrary.ComixNotation)(o2.getValue())).getMainHeroName().toLowerCase());
            }
        } );    

        Map<String, ComixNotation> result = new LinkedHashMap<>();        
        for (Map.Entry<String, ComixNotation> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        this.library = (Map<java.lang.String, main.java.il.co.ComixLibrary.ComixNotation>) result;
        return (Map<String, ComixNotation>) library;
    }
    
    public  <String, ComixNotation> Map<String, ComixNotation> sortComixTitle(Map<String, ComixNotation> map) {
        List<Entry<String, ComixNotation>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, ComixNotation>>(){
            public int compare( Map.Entry<String, ComixNotation> o1, Map.Entry<String, ComixNotation> o2 )
            {
                return (((main.java.il.co.ComixLibrary.ComixNotation)(o1.getValue())).getComixTitle().toLowerCase()).compareTo
                        (((main.java.il.co.ComixLibrary.ComixNotation)(o2.getValue())).getComixTitle().toLowerCase());
            }
        } );    

        Map<String, ComixNotation> result = new LinkedHashMap<>();        
        for (Map.Entry<String, ComixNotation> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        this.library = (Map<java.lang.String, main.java.il.co.ComixLibrary.ComixNotation>) result;
        return (Map<String, ComixNotation>) library;
   }
    
    public void sort(int choice1){
        switch (choice1) {
        case 1: // Year of the issue

             System.out.println(ComixLibraryOperations.sortByValue(library));

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
