/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library.dao;

import recommendation_library.domain.BookRecommendation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jenni.makinen
 */


public class InMemoryRecommendationDao implements RecommendationDao {
    private List<BookRecommendation> bookRecommendations;
    

    public InMemoryRecommendationDao() {
        this.bookRecommendations = new ArrayList<>();
    }

    @Override
    public void createBookRecommendation(String author, String title, String type, String description, String isbn) {
        String addDate = java.time.LocalDate.now().toString();
        this.bookRecommendations.add(new BookRecommendation(author, title, type, description, isbn, addDate));
    }

    @Override
    public List<BookRecommendation> getAllBookRecommendations() {
        return this.bookRecommendations;
    }

}
