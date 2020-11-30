/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library.dao;

import recommendation_library.domain.BookRecommendation;
import java.util.List;

/**
 *
 * @author anadis
 */
public interface RecommendationDao {

    void createBookRecommendation(String author, String title, String description, String isbn, int pageCount);

    List<BookRecommendation> getAllBookRecommendations();

    void editBookRecommendation(String title, String fieldToBeEdited, String newValue);

    void deleteBookByTitle(String title);
}
