/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecommendationLibrary.dao;

import RecommendationLibrary.domain.Recommendation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jenni.makinen
 */


public class InMemoryRecommendationDao implements RecommendationDao {
    private List<Recommendation> recommendations;
    

    public InMemoryRecommendationDao() {
        this.recommendations = new ArrayList<>();
    }

    @Override
    public void createRecommendation(String author, String title, String descr) {
        this.recommendations.add(new Recommendation(author, title, descr));
    }

    @Override
    public List<Recommendation> getAll() {
        return this.recommendations;
    }

}
