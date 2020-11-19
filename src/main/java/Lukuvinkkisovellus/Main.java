/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkkisovellus;

import Lukuvinkkisovellus.dao.DatabaseRecommendationDao;
import Lukuvinkkisovellus.dao.RecommendationDao;
import Lukuvinkkisovellus.domain.Recommendation;

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
        RecommendationDao dao = new DatabaseRecommendationDao();
        dao.createRecommendation("Bob", "Book nr One", "Informative book");
        for (Recommendation r : dao.getAll()) {
            System.out.println(r.getAuthor() + 
                    ", " + r.getTitle() + ": " + r.getDescr());
        }
    }
    
}
