/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkkisovellus;

import Lukuvinkkisovellus.dao.DatabaseRecommendationDao;
import Lukuvinkkisovellus.dao.RecommendationDao;
import Lukuvinkkisovellus.domain.Recommendation;
import Lukuvinkkisovellus.UserInterface;

/**
 *
 * @author timot
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        
        UserInterface UI = new UserInterface();
        
        UI.run();
    }
    
}
