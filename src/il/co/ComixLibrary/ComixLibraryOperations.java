package il.co.ComixLibrary;

import java.util.Scanner;

public class ComixLibraryOperations {
	
	private int a;
	private String d;
	
	Scanner scn = new Scanner(System.in);
	//input digit method
	public int inputDigit(){
		while(true){
			if (scn.hasNext()){
				d=scn.next();
				a=Integer.parseInt(d);
				break;
			}
			else {
				System.out.println("ERROR INPUT!" + "\n" + "Input a digit again please!");
				d=scn.next();
				continue;
			}
		}		
		return a;
	}
	
	// Exit Program Method//			
		public int exitProgram() {
			while(true) {
	// Input the choice digit //	
				while(true) {
					if(scn.hasNextInt()){
						a = scn.nextInt();
					break;
					}
					else {
					System.out.println("ERROR INPUT" + "\n" + "Leave Comix Library: 1, Continue: 2");
					d = scn.next();
					continue;
					}
				}
			// Check the choice (1 or 2)//
			if (a >=1 && a<=2){
			break;
			}
			else {
				System.out.println("ERROR INPUT" + "\n" + "Leave Comix Library: 1, Continue: 2");
				continue;
			}
		}
		return a;
	}
		
		// INPUT VALUE METHOD
		public String inputValue(){
			while(true){
				if (scn.hasNext()){
					d = scn.next();
					break;
				}else
					System.out.println("ERROR INPUT" + "\n" + "Please try againe!");
					continue;
			}
			
			return d;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
