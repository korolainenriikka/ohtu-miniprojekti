/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

import recommendation_library.io.IO;
import recommendation_library.dao.RecommendationDao;
import recommendation_library.domain.BookRecommendation;
import java.util.List;
import recommendation_library.domain.DatabaseService;

/**
 *
 * @author jhku
 */
public class UserInterface {

    private IO io;
    private DatabaseService service;

    public UserInterface(IO io, RecommendationDao dao) {
        this.io = io;
        this.service = new DatabaseService(dao);
    }

    /**
     * launch the application
     */
    public void run() {
        while (true) {
            this.io.print("[1] Add recommendation, [2] List recommendations, [3] Exit");
            int input = Integer.valueOf(io.nextLine());
            if (input == 3) {
                break;
            }
            checkInput(input);
        }
        // Personal test of service.editBookRecommendation method
//        service.addBook("Bob", "name", "good", "12345");
//        list();
//        service.editBookRecommendation("name", "title", "a better title");
//        list();
    }

    /**
     * 
     * @param input number given from user. 1 for "add", 2 for "list", 3 for "exit"
     */
    public void checkInput(int input) {
        if (input == 1) {
            addBook();
        } else if (input == 2) {
            list();
        } else {
            this.io.print("Unknown command");
        }
    }

    /**
     * add a book recommendation to the library
     */
    public void addBook() {
        
        this.io.print("Type the author of the book recommendation");
        String author = io.nextLine();
        
        this.io.print("Type the title of the book recommendation");
        String title = io.nextLine();
        if (service.titleAlreadyExists(title)) {
            System.out.println("Title already exists");
            // Do some logic here
        }

        this.io.print("Type the description of the book recommendation");
        String description = io.nextLine();
        
        this.io.print("Type the ISBN of the book recommendation");
        String isbn = io.nextLine();

        if (service.addBook(author, title, description, isbn)) {
            this.io.print("Recommendation added");
        }
        else {
            this.io.print("Addition failed");
        
        }
    }

    /**
     * list all book recommendations contained within the library
     */
    public void list() {
        List<BookRecommendation> list = service.getAllBookRecommendations();
        int i = 1;
        for (BookRecommendation r : list) {
            this.io.print("Recommendation " + i++ + System.lineSeparator()
                    + "Author: " + r.getAuthor() + System.lineSeparator()
                    + "Title: " + r.getTitle() + System.lineSeparator()
                    + "Description: " + r.getDescription() + System.lineSeparator()
                    + "ISBN: " + r.getIsbn() + System.lineSeparator()
                    + "Added: " + r.getAddDate());
        }
    }

}
