package edu.ucalgary.oop;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlanketTest {
    @Test
    public void testConstructor() {
        Supply blanket = new Blanket(1);
        assertNotNull("Constructor should successfully create an instance of Blanket", blanket);
    }
}
