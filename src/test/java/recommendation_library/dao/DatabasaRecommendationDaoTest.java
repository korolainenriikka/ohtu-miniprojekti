/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import recommendation_library.UserInterface;
import recommendation_library.domain.BookRecommendation;
import recommendation_library.domain.DatabaseService;
import recommendation_library.io.IO;

/**
 *
 * @author anadis
 */
public class DatabasaRecommendationDaoTest {

    IO io;
    UserInterface ui;
    RecommendationDao db_dao;
    DatabaseService service;

    public DatabasaRecommendationDaoTest() {
    }

    @Before
    public void setUp() {
        db_dao = new DatabaseRecommendationDao("src/test/resources/test.db");
        service = new DatabaseService(db_dao);
        io = mock(IO.class);
        ui = new UserInterface(io, db_dao);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createRecommendationAddsToTheDatabase() {
        when(io.nextLine())
                .thenReturn("Jane")
                .thenReturn("Hobitti")
                .thenReturn("Sci-fi thriller")
                .thenReturn("1234-ABCD")
                .thenReturn("10");

        ui.addBook();
        verify(io, times(5)).nextLine();
        service.addBook("Jane", "Hobitti", "Sci-fi thriller", "1234-ABCD", 10);
        assertFalse(service.getAllBookRecommendations().isEmpty());

        BookRecommendation addedRecommendation = service.getAllBookRecommendations().get(0);
        assertEquals("Jane", addedRecommendation.getAuthor());
        assertEquals("Hobitti", addedRecommendation.getTitle());
        assertEquals("Sci-fi thriller", addedRecommendation.getDescription());
        assertEquals("1234-ABCD", addedRecommendation.getIsbn());
        assertEquals(10, addedRecommendation.getPageCount());
        assertEquals(addedRecommendation.getAddDate(), java.time.LocalDate.now().toString());
    }

    @Test
    public void editBookRecommendationEditsAuthor() {
        service.addBook("Bob", "book", "good", "abc", 10);
        service.editBookRecommendation("book", "author", "John");
        BookRecommendation addedRecommendation = service.getAllBookRecommendations().get(1);
        assertEquals("John", addedRecommendation.getAuthor());
    }
    
    @Test
    public void editBookRecommendationEditsTitle() {
        service.addBook("Bob", "book2", "good", "abc", 10);
        service.editBookRecommendation("book2", "title", "a better title");
        BookRecommendation addedRecommendation = service.getAllBookRecommendations().get(2);
        assertEquals("a better title", addedRecommendation.getTitle());
    }

    @Test
    public void editBookRecommendationEditsISBN() {
        service.addBook("Bob", "book3", "good", "abc", 10);
        service.editBookRecommendation("book2", "isbn", "cba");
        BookRecommendation addedRecommendation = service.getAllBookRecommendations().get(3);
        assertEquals("cba", addedRecommendation.getIsbn());
    }
    
    @Test
    public void deletesRecommencation() {
        int count = service.getAllBookRecommendations().size();
        service.addBook("Bob", "book4", "good", "abc", 10);
        assertEquals(count+1, service.getAllBookRecommendations().size());
        service.deleteRecommendation("book4");
        assertEquals(count, service.getAllBookRecommendations().size());
    }
}
