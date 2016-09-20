package main.java.il.co.ComixLibrary;

import java.util.Scanner;

public class ComixLibraryOperations {

	private int a;
	private String d;

	private Scanner scn = new Scanner(System.in);

	// input digit method
	int inputDigit() {
		while (true) {
			if (scn.hasNext()) {
				d = scn.next();
				a = Integer.parseInt(d);
				break;
			} else {
				System.out.println("ERROR INPUT!" + "\n" + "Input a digit again please!");
				d = scn.next();
			}
		}
		return a;
	}

	// Exit Program Method//
	int exitProgram() {
		while (true) {
			// Input the choice digit //
			while (true) {
				if (scn.hasNextInt()) {
					a = scn.nextInt();
					break;
				} else {
					System.out.println("ERROR INPUT" + "\n" + "Leave Comix Library: 1, Continue: 2");
					d = scn.next();
				}
			}
			// Check the choice (1 or 2)//
			if (a >= 1 && a <= 2) {
				break;
			} else {
				System.out.println("ERROR INPUT" + "\n" + "Leave Comix Library: 1, Continue: 2");
			}
		}
		return a;
	}

	// INPUT VALUE METHOD
	String inputValue() {
		Scanner scnn = new Scanner(System.in);
		while (true) {
			if (scnn.hasNext()) {
				d = scnn.nextLine();
				// scnn.close();
				break;
			} else
				System.out.println("ERROR INPUT" + "\n" + "Please try againe!");
		}

		return d;
	}

	public static void main(String[] args) {
		// while (a.hasNextLine()) { b += a.nextLine(); }
		// TODO

	}

}
