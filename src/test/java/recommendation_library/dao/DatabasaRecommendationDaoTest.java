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
import recommendation.io.IO;
import recommendation.io.KonsoliIO;
import recommendation_library.UserInterface;
import recommendation_library.domain.Recommendation;

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
        db_dao = new DatabaseRecommendationDao("test.db");
        io = mock(KonsoliIO.class);
        ui = new UserInterface(io, db_dao);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createRecommendationAddsToTheDatabase() {
        when(io.nextLine())
                .thenReturn("bob")
                .thenReturn("book")
                .thenReturn("readable");
                
        ui.add();
        verify(io, times(3)).nextLine();
        assertFalse(db_dao.getAll().isEmpty());
    }

}
