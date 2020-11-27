/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

/**
 * @author jhku
 */

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import recommendation_library.dao.RecommendationDao;
import recommendation_library.domain.DatabaseService;
import recommendation_library.io.IO;

public class UserInterfaceTest {

    UserInterface UI;
    IO input;
    DatabaseService service;
    RecommendationDao test_dao;

    @Before
    public void setUp() {
        input = mock(IO.class);
        test_dao = mock(RecommendationDao.class);
        service = mock(DatabaseService.class);
        UI = new UserInterface(input, test_dao);
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
        UI.checkInput(5);

        verify(input, times(1)).print("Unknown command");
    }
    
    @Test
    public void checkInputCallsList() {
        UI.checkInput(2);

        verify(test_dao, times(1)).getAllBookRecommendations();

    }

}
