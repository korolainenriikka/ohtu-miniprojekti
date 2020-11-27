/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library.domain;

import java.util.ArrayList;
import java.util.List;
import recommendation_library.dao.DatabaseRecommendationDao;
import recommendation_library.dao.RecommendationDao;

/**
 *
 * @author anadis
 */
public class DatabaseService {

    private RecommendationDao dao;

    public DatabaseService(RecommendationDao dao) {
        this.dao = dao;
    }

    public boolean titleAlreadyExists(String title) {
        List<BookRecommendation> books = dao.getAllBookRecommendations();
        for (BookRecommendation book : books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean addBook(String author, String title, String description, String isbn, int pageCount) {
        if (titleAlreadyExists(title)) {
            return false;
        }
        dao.createBookRecommendation(author, title, description, isbn, pageCount);
        return true;
    }

    public List<BookRecommendation> getAllBookRecommendations() {
        List<BookRecommendation> books = dao.getAllBookRecommendations();
        return books;
    }
    
    public void editBookRecommendation(String title, String fieldToChange, String newValue) {
        this.dao.editBookRecommendation(title, fieldToChange, newValue);
    }
    
    public boolean deleteRecommendation(String title) {
        if(titleAlreadyExists(title)) {
            dao.deleteBookByTitle(title);
            return true;
        }
        return false;
    }
}
