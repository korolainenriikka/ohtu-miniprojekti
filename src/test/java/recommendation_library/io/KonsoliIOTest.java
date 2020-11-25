package recommendation_library.io;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class KonsoliIOTest {

    KonsoliIO io;
    
    @Before
    public void setUp() {
        Scanner reader = new Scanner("moi\nhellurei");
        io = new KonsoliIO(reader);
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void returnsCorrectLine() {
        
        assertEquals("moi", io.nextLine());
        assertEquals("hellurei", io.nextLine());
    }
    
    @Test
    public void printsGivenString() {
        // todo
    }

}

