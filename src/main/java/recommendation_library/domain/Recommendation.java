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
public class Recommendation {
    
    String author;
    String title;
    String description;
    
    public Recommendation(String author, String title, String descr) {
        this.author = author;
        this.title = title;
        this.description = descr;        
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getDescr() {
        return this.description;
    }
}
