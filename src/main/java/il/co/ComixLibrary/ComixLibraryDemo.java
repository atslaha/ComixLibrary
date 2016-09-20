package main.java.il.co.ComixLibrary;

public class ComixLibraryDemo {


    public static void main(String[] args) {
        ComixLibrary.deserData();
        int a;
        ComixLibraryOperations dig = new ComixLibraryOperations();
        while (true) {
            while (true) {
                System.out.println("Press: 1-Show Library; 2-add comix; 3-delete comix; 4-edit comix; 5-searce comix; 6-sort comix.");
                a = dig.inputDigit();
                if (a > 0 && a < 7) {
                    ComixLibrary.comixLibrary(a);
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
