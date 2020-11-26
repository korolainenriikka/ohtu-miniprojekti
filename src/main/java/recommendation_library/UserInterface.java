/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

import recommendation_library.io.IO;
import recommendation_library.dao.RecommendationDao;
import recommendation_library.domain.Recommendation;
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
            add();
        } else if (input == 2) {
            list();
        } else {
            this.io.print("Unknown command");
        }
    }

    /**
     * add a recommendation to the library
     */
    public void add() {
        this.io.print("Type the name of the recommendation");
        String name = io.nextLine();

        this.io.print("Type the author of the recommendation");
        String author = io.nextLine();

        this.io.print("Type the description of the recommendation");
        String description = io.nextLine();

        dbDao.createRecommendation(name, author, description);
        this.io.print("Recommendation added");
    }

    /**
     * list all recommendations contained within the library
     */
    public void list() {
        List<Recommendation> list = dbDao.getAll();
        int i = 1;
        for (Recommendation r : list) {
            this.io.print(i++ + ":   " + r.getAuthor()
                    + ", " + r.getTitle() + ": " + r.getDescr());
        }
    }

}
