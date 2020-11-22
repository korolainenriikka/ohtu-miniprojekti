/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecommendationLibrary;

import Recommendation.io.KonsoliIO;
import RecommendationLibrary.dao.DatabaseRecommendationDao;
import RecommendationLibrary.dao.RecommendationDao;
import RecommendationLibrary.domain.Recommendation;
import RecommendationLibrary.UserInterface;

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
        
        UserInterface UI = new UserInterface(new KonsoliIO(), new DatabaseRecommendationDao());
        
        UI.run();
    }
    
}
