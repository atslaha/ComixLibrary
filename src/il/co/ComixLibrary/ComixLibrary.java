package il.co.ComixLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import il.co.ComixLibrary.ComixNotation;


public class ComixLibrary {
	
	private static Map<String, ComixNotation> library = new HashMap<String, ComixNotation>();
	
	public static void comixLibrary(int operations){
		switch(operations){
		case 1://show notations
			System.out.println("All Contacts in the Comix Library:"+"\n");
			for (ComixNotation p : library.values()){
				System.out.println(p);
			}
			System.out.println();
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
		Object retObject = null;
		try {
			FileInputStream fileIn = new FileInputStream("profiles.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			retObject = in.readObject();
			//book = (Map<String, PhoneNotation>) retObject;
			fileIn.close();
			in.close();
			library= (Map<String, ComixNotation>) retObject;
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
