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
import recommendation_library.io.IO;

public class UserInterfaceTest {

    UserInterface UI;
    IO input;
    RecommendationDao Dao;

    @Before
    public void setUp() {
        input = mock(IO.class);
        Dao = mock(RecommendationDao.class);
        UI = new UserInterface(input, Dao);
    }

    @Test
    public void checkInputCallsAdd() {
        when(input.nextLine())
            .thenReturn("Jane")
            .thenReturn("Hobitti")
            .thenReturn("Book")
            .thenReturn("Sci-fi thriller")
            .thenReturn("1234-ABCD");

        UI.checkInput(1);


        verify(input, times(5)).nextLine();
        verify(Dao, times(1)).createBookRecommendation("Jane", "Hobitti", "Book", "Sci-fi thriller", "1234-ABCD");
        verify(input, times(4)).print(anyString());

    }

    @Test
    public void checkInputUnknownCommand() {
        UI.checkInput(4);

        verify(input, times(1)).print("Unknown command");
    }

}
