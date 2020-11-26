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

/**
 *
 * @author jhku
 */
public class UserInterface {

    private IO io;
    private RecommendationDao dbDao;

    public UserInterface(IO io, RecommendationDao dao) {
        this.io = io;
        this.dbDao = dao;
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
        
        this.io.print("Type the author of the recommendation");
        String author = io.nextLine();
        
        this.io.print("Type the title of the recommendation");
        String title = io.nextLine();

        this.io.print("Type the type of the recommendation");
        String type = io.nextLine();

        this.io.print("Type the description of the recommendation");
        String description = io.nextLine();
        
        this.io.print("Type the ISBN of the recommendation");
        String isbn = io.nextLine();

        dbDao.createBookRecommendation(author, title, type, description, isbn);
        this.io.print("Recommendation added");
    }

    /**
     * list all book recommendations contained within the library
     */
    public void list() {
        List<BookRecommendation> list = dbDao.getAllBookRecommendations();
        int i = 1;
        for (BookRecommendation r : list) {
            this.io.print(i++ + ":   " + r.getAuthor()
                    + ", " + r.getTitle() + ": " + r.getDescription());
        }
    }

}
