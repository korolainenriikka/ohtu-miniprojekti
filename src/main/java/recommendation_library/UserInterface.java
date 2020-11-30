/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

import java.util.ArrayList;
import java.util.Arrays;
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
            this.io.print("[1] Add recommendation, [2] List recommendations, [3] Edit recommendation, [4] Delete recommendation, [5] Exit");
            int input = Integer.valueOf(io.nextLine());
            if (input == 5) {
                break;
            }
            checkInput(input);
        }

    }

    /**
     *
     * @param input number given from user. 1 for "add", 2 for "list", 3 for
     * "edit", 4 for "exit"
     */
    public void checkInput(int input) {
        if (input == 1) {
            addBook();
        } else if (input == 2) {
            list();
        } else if (input == 3) {
            edit();
        } else if (input == 4) {
            delete();
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

        this.io.print("Type the page count of the book recommendation");
        String pageCount = io.nextLine();

        try {
            int pageCountInt = Integer.parseInt(pageCount);
            if (service.addBook(author, title, description, isbn, pageCountInt)) {
                this.io.print("Recommendation added");
            } else {
                this.io.print("Addition failed");
            }
        } catch (Exception e) {
            this.io.print("Given page count is not an integer!");
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
                    + "Page count: " + r.getPageCount() + System.lineSeparator()
                    + "Added: " + r.getAddDate());
        }
    }

    /**
     * list titles of all book recommendations contained within the library
     */
    public List<String> listTitles() {
        List<BookRecommendation> recommendationList = service.getAllBookRecommendations();
        List<String> titleList = new ArrayList<>();
        for (BookRecommendation r : recommendationList) {
            titleList.add(r.getTitle());
        }
        return titleList;
    }

    /**
     * edit a book recommendation TODO: pagecount is integer, so now this can
     * only edit string fields -> should we change the field "pagecount" into
     * String in database to ease the job? TODO: should offer an option to exit
     * if given title or fieldname doesn't exist, and perhaps an option to list
     * recommendations(?)
     */
    public void edit() {
        List<String> stringFieldNames = Arrays.asList("author", "title", "description", "isbn");

        this.io.print("Enter the title of the recommendation you wish to edit:\nTitles in your library:");
        List<String> allTitles = listTitles();
        for (String title : allTitles) {
            this.io.print(title);
        };
        String titleToEdit = String.valueOf(io.nextLine());

        if (this.service.titleAlreadyExists(titleToEdit)) {
            this.io.print("Enter the fieldname of the selected recommendation you wish to edit (author, title, description, isbn, pagecount):");
            String fieldToEdit = String.valueOf(io.nextLine());

            while (!stringFieldNames.contains(fieldToEdit)) {
                this.io.print("Given fieldname doesn't exist! Enter a valid fieldname (author, title, description, isbn, pagecount):");
                fieldToEdit = String.valueOf(io.nextLine());
            }

            this.io.print("Enter a new value to insert into the selected field:");
            String newValue = String.valueOf(io.nextLine());

            try {
                this.service.editBookRecommendation(titleToEdit, fieldToEdit, newValue);
            } catch (Exception e) {
                this.io.print("Failed!");
            }

            this.io.print("Field " + fieldToEdit + " succesfully changed to " + newValue + "!");

        } else {
            this.io.print("Recommendation with the given title doesn't exist! Try again: ");
            edit();
        }
    }

    public void delete() {
        this.io.print("Enter the title of the recommendation you wish to delete:\nTitles in your library:");
        List<String> allTitles = listTitles();
        for (String title : allTitles) {
            this.io.print(title);
        };
        String titleToDelete = String.valueOf(io.nextLine());

        if (this.service.deleteRecommendation(titleToDelete)) {
            this.io.print("Recommendation deleted!");
        } else {
            this.io.print("Recommendation with the given title doesn't exist! Try again: ");
            run();
        }
    }

}
