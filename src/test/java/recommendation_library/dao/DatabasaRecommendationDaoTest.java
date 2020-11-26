/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import recommendation_library.UserInterface;
import recommendation_library.domain.BookRecommendation;
import recommendation_library.io.IO;
import recommendation_library.io.KonsoliIO;

/**
 *
 * @author anadis
 */
public class DatabasaRecommendationDaoTest {

    IO io;
    UserInterface ui;
    RecommendationDao db_dao;

    public DatabasaRecommendationDaoTest() {
    }

    @Before
    public void setUp() {
        db_dao = new DatabaseRecommendationDao("src/test/resources/test.db");
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
            .thenReturn("Book")
            .thenReturn("Sci-fi thriller")
            .thenReturn("1234-ABCD");
                
        ui.addBook();
        verify(io, times(5)).nextLine();
        assertFalse(db_dao.getAllBookRecommendations().isEmpty());
    }

}
