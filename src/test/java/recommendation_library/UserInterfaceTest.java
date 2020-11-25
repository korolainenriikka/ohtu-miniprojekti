/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

/**
 *
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
    public void setUp(){
        input = mock(IO.class);
        Dao = mock(RecommendationDao.class);
        UI = new UserInterface(input, Dao);
    }
    
    @Test
    public void checkInputCallsAdd(){
        when(input.nextLine()).thenReturn("Test");
        
        UI.checkInput(1);
        
        
        verify(input, times(3)).nextLine();
        verify(Dao, times(1)).createRecommendation(anyString(), anyString(), anyString());
        verify(input, times(4)).print(anyString());
        
    }
    
}
