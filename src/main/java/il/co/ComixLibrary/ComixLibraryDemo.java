package main.java.il.co.ComixLibrary;

import org.joda.time.DateTime;

public class ComixLibraryDemo {
    
    public void searchYear(int choice){
        ComixLibraryOperations inputSearchYear = new ComixLibraryOperations();
        ComixLibrary CL = new ComixLibrary();
        CL.deserData();
        switch(choice){        
        case 1:
            System.out.println("Enter year of the issue! (YYYY)" + "\n");
            int inputYearIssue = 0;
            inputYearIssue = inputSearchYear.inputDigit();
            CL.searchYearStrictly(inputYearIssue);
            break;
            
        case 2:
            System.out.println("Enter year of the issue! (YYYY)" + "\n");
            int inputYearIssue1 = 0;
            inputYearIssue1 = inputSearchYear.inputDigit();
            CL.searchYearBefore(inputYearIssue1);
            break;
            
        case 3:
            System.out.println("Enter year of the issue! (YYYY)" + "\n");
            int inputYearIssue2 = 0;
            inputYearIssue2 = inputSearchYear.inputDigit();
            CL.searchYearAfter(inputYearIssue2);
            break;
        }
    }

    public void search(int choice){
        ComixLibraryOperations inputSearch = new ComixLibraryOperations();
        ComixLibrary CL = new ComixLibrary();
        CL.deserData();
        switch(choice){
        case 1:
            while (true) {
                System.out.println("How you want to search:" + "\n" + "1.Strictly year of the issue;" + "\n"
                        + "2.Before year of the issue incl.;" + "\n" + "3.After year of the issue incl." + "\n");
                choice = inputSearch.inputDigit();
                if (0 < choice && choice < 4) {
                    break;
                } else
                    System.out.println("Try again!" + "\n");
            }
            searchYear(choice);
            break;
            
        case 2:
            System.out.println("Enter Hero's Name! (*Name/*Name*/Name*)" + "\n");
            String inputHeroName = inputSearch.inputValue();
            inputHeroName = inputHeroName.replaceAll("[*]", "(.*)");            
            CL.searchByHeroName(inputHeroName);
            break;
            
        case 3:
            System.out.println("Enter Comix's Title! (*Title/*Title*/Title*)" + "\n");
            String inputComixTitle = inputSearch.inputValue();
            inputComixTitle = inputComixTitle.replaceAll("[*]", "(.*)");
            CL.searchByTitle(inputComixTitle);
            break;
            
        }
    }

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
                        System.out.println("All Notations in the Comix Library:" + "\n");
                        CL.showNotations();
                        break;
                        
                    case 2: // add comixNotation
                        ComixNotation CN = new ComixNotation();
                        ComixLibraryOperations clo = new ComixLibraryOperations();
                        CN.setIssueYear(clo.inputIssueDate());
                        CN.setMainHeroName(clo.inputMainHeroName());
                        CN.setIssueName(clo.inputIssueName());
                        CN.setComixTitle(clo.inputComixTitle());
                        CN.setDateOfBuying(clo.inputDateOfBuying());
                        CL.setLibrary(clo.inputKey(), CN);
                        CL.serData();
                        break;
                        
                    case 3:// delete ComixNotation
                        ComixLibraryOperations clo3 = new ComixLibraryOperations();
                        System.out.println("Input number of Comix Notation!");
                        int inputNumber = clo3.inputDigit();
                        CL.deleteComixNotation(inputNumber);
                        CL.serData();
                        break;
                        
                    case 4: // search
                        ComixLibraryOperations clo1 = new ComixLibraryOperations();
                        ComixLibraryDemo CLD = new ComixLibraryDemo();
                        CLD.search(clo1.inputChoiceOfSearch());                        
                        break;
                        
                    case 5: //sort
                        ComixLibraryOperations clo2 = new ComixLibraryOperations();
                        CL.sort(clo2.inputChoiceOfSort());
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
