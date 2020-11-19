/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lukuvinkkisovellus.dao;

import Lukuvinkkisovellus.domain.Recommendation;
import java.util.List;

/**
 *
 * @author anadis
 */
public interface RecommendationDao {
    void createRecommendation(String author, String title, String descr);
    List<Recommendation> getAll();
}
