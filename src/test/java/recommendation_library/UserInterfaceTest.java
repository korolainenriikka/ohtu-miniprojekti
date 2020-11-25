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
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserInterfaceTest {
    
    UserInterface UI;
    
    @Before
    public void setUp(){
        UI = mock(UserInterface.class);
    }
    
    @Test
    public void checkInputCallsAdd(){
        UI.checkInput(1);
        
        verify(UI, times(1)).checkInput(1);
        
    }
    
}
