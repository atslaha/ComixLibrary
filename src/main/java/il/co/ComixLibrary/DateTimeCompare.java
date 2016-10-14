package main.java.il.co.ComixLibrary;

import java.util.Comparator;

public class DateTimeCompare implements Comparator{

    private Integer issueYear1 = 0;
    private Integer issueYear2 = 0;
    private Integer issueMonth1 = 0;
    private Integer issueMonth2 = 0;
    private Integer issueDay1 = 0;
    private Integer issueDay2 = 0;
    
    @Override
    public int compare(Object o1, Object o2) {
        
        if (o1 instanceof ComixNotation){
            issueYear1 = ((ComixNotation) o1).getIssueYear().getYear();
            issueMonth1 = ((ComixNotation) o1).getIssueYear().getMonthOfYear();
            issueDay1 = ((ComixNotation) o1).getIssueYear().getDayOfMonth();
        }
        
        if (o2 instanceof ComixNotation){
            issueYear2 = ((ComixNotation) o2).getIssueYear().getYear();
            issueMonth2 = ((ComixNotation) o2).getIssueYear().getMonthOfYear();
            issueDay2 = ((ComixNotation) o2).getIssueYear().getDayOfMonth();
        }
                
        if (issueYear1 != issueYear2) return ((int)(issueYear1-issueYear2));
        if (issueYear1 == issueYear2 && issueMonth1 != issueMonth2) return ((int)(issueMonth1 - issueMonth2));
        if (issueYear1 == issueYear2 && issueMonth1 == issueMonth2 && issueDay1 != issueDay2) return ((int)(issueDay1-issueDay2));
        else return 0;
        
        
        
        
    }
    
    
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
