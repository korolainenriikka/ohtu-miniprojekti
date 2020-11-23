/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

import recommendation_library.io.KonsoliIO;
import recommendation_library.dao.DatabaseRecommendationDao;
import recommendation_library.dao.RecommendationDao;
import recommendation_library.domain.Recommendation;
import recommendation_library.UserInterface;

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
