package main.java.il.co.ComixLibrary;

import org.joda.time.DateTime;

public class ComixLibraryDemo {


    public static void main(String[] args) {
        ComixLibrary CL = new ComixLibrary();
        CL.deserData();
        int a;
        ComixLibraryOperations dig = new ComixLibraryOperations();
        while (true) {
            while (true) {
                System.out.println("Press: 1-Show Library; 2-add comix; 3-delete comix; 4-searce comix; 5-sort comix.");
                a = dig.inputDigit();
                if (a > 0 && a < 6) {
                    switch(a){
                    case 1://Show library
                        CL.showNotations();
                        break;
                        
                    case 2: // add comixNotation
                        ComixNotation CN = new ComixNotation();
                        CN.setIssueYear(CL.inputIssueDate());
                        CN.setMainHeroName(CL.inputMainHeroName());
                        CN.setIssueName(CL.inputIssueName());
                        CN.setComixTitle(CL.inputComixTitle());
                        CN.setDateOfBuying(CL.inputDateOfBuying());
                        CL.setLibrary(CL.inputKey(), CN);
                        CL.serData();
                        break;
                        
                    case 3:// delete ComixNotation
                        CL.deleteComixNotation();
                        CL.serData();
                        break;
                        
                    case 4: // search
                        CL.search(CL.inputChoiceOfSearch());
                        break;
                        
                    case 5: //sort
                        CL.sort(CL.inputChoiceOfSort());
                        break;
                    }
                    
                    //CM.comixLibrary(a);
                    break;
                }
            }
            // Exit the program or continue;
            System.out.println("Leave Comix Library: 1, Continue: 2");
            a = dig.exitProgram();
            if (a == 1) {
                break;
            }
        }

    }
}
