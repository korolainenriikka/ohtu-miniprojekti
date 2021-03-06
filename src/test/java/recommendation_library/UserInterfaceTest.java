/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

/**
 * @author jhku
 */

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import recommendation_library.dao.DatabaseRecommendationDao;

import recommendation_library.dao.RecommendationDao;
import recommendation_library.domain.BookRecommendation;
import recommendation_library.domain.DatabaseService;
import recommendation_library.io.IO;
import recommendation_library.io.StubIO;

public class UserInterfaceTest {

    UserInterface UI;
    IO input;
    DatabaseService service;
    RecommendationDao test_dao;
    RecommendationDao db_dao;
    DatabaseService db_service;
    StubIO db_io;
    UserInterface db_ui;

    @Before
    public void setUp() {
        input = mock(IO.class);
        test_dao = mock(RecommendationDao.class);
        service = mock(DatabaseService.class);
        UI = new UserInterface(input, test_dao);
        
        db_dao = new DatabaseRecommendationDao("src/test/resources/test.db");
        db_service = new DatabaseService(db_dao);
        
        List<BookRecommendation> books = db_dao.getAllBookRecommendations();
        for (BookRecommendation b : books) {
            db_dao.deleteBookByTitle(b.getTitle());
        }
    }

    @Test
    public void checkInputCallsAdd() {
        when(input.nextLine())
            .thenReturn("Jane")
            .thenReturn("Hobitti")
            .thenReturn("Sci-fi thriller")
            .thenReturn("1234-ABCD")
            .thenReturn("10");
        

        UI.checkInput(1);


        verify(input, times(5)).nextLine();
        verify(test_dao, times(1)).createBookRecommendation("Jane", "Hobitti", "Sci-fi thriller", "1234-ABCD", 10);
        verify(input, times(6)).print(anyString());

    }

    @Test
    public void checkInputUnknownCommand() {
        UI.checkInput(999);

        verify(input, times(1)).print("Unknown command");
    }
    
    @Test
    public void checkInputCallsList() {
        UI.checkInput(2);

        verify(test_dao, times(1)).getAllBookRecommendations();
    }
    
    @Test
    public void listingRecommendationsReturnsList() {
        List<String> inputLines = new ArrayList<>();
        inputLines.add("1");
        inputLines.add("Jeff VanderMeer");
        inputLines.add("Annihilation");
        inputLines.add("Good book");
        inputLines.add("ABCD");
        inputLines.add("777");
        inputLines.add("2");
        
        db_io = new StubIO(inputLines);
        db_ui = new UserInterface(db_io, db_dao);
        db_ui.run();

        assertTrue(db_io.getPrints().contains("Recommendation 1" + System.lineSeparator()
                        + "Author: Jeff VanderMeer" + System.lineSeparator()
                        + "Title: Annihilation" + System.lineSeparator()
                        + "Description: Good book" + System.lineSeparator()
                        + "ISBN: ABCD" + System.lineSeparator()
                        + "Page count: 777" + System.lineSeparator()
                        + "Added: " + java.time.LocalDate.now().toString()));


    }

}
