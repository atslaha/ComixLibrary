package test.resources;

import static org.junit.Assert.*;

import org.junit.Test;

import il.co.ComixLibrary.ComixNotation;

public class DemoTestComixNotation {
	
	@Test
	public void ShouldReturnTrue(){
		ComixNotation demoNotation = new ComixNotation();
		assertTrue(demoNotation.getBool());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
