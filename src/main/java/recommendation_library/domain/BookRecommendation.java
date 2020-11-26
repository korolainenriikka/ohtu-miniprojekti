/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library.domain;


/**
 *
 * @author anadis
 */
public class BookRecommendation extends Recommendation {
    
    String author;
    String isbn;

    public BookRecommendation(String author, String title, String description, String isbn, String addDate) {
        super(title, Type.BOOK, description, addDate);
        this.author = author;
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
}
