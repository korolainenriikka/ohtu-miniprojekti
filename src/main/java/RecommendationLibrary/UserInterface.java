/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecommendationLibrary;

import RecommendationLibrary.dao.DatabaseRecommendationDao;
import RecommendationLibrary.dao.RecommendationDao;
import RecommendationLibrary.domain.Recommendation;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jhku
 */
public class UserInterface {

    private Scanner reader;
    private RecommendationDao dbDao;

    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.dbDao = new DatabaseRecommendationDao();
    }

    public void run() {
        while (true) {
            System.out.println("[1] Add recommendation, [2] List recommendations, [3] Exit");
            int input = Integer.valueOf(reader.nextLine());
            if (input == 3) {
                break;
            }
            checkInput(input);
        }
    }

    public void checkInput(int input) {
        if (input == 1) {
            add();
        } else if (input == 2) {
            list();
        } else {
            System.out.println("Unknown command");
        }
    }

    public void add() {
        System.out.println("Type the name of the recommendation");
        String name = reader.nextLine();

        System.out.println("Type the author of the recommendation");
        String author = reader.nextLine();

        System.out.println("Type the description of the recommendation");
        String description = reader.nextLine();

        dbDao.createRecommendation(name, author, description);
        System.out.println("");

    }

    public void list() {
        List<Recommendation> list = dbDao.getAll();
        int i = 1;
        for (Recommendation r : list) {
            System.out.println(i++ + ":   " + r.getAuthor()
                    + ", " + r.getTitle() + ": " + r.getDescr());
        }
        System.out.println("");
    }

}
