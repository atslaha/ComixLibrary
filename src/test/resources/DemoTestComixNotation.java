package test.resources;

import il.co.ComixLibrary.ComixNotation;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DemoTestComixNotation {

    @Test
    public void ShouldReturnTrue() {
        ComixNotation demoNotation = new ComixNotation();
        assertTrue(demoNotation.getBool());
    }

    @Test
    public void ShouldReturnTrue1() {
        ComixNotation demoNotation = new ComixNotation();
        assertTrue(demoNotation.getBooll());
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
