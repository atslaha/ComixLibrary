package test.java.il.co;

import main.java.il.co.ComixLibrary.ComixNotation;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DemoComixNotationTest {

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
