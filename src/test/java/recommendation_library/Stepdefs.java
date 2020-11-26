/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation_library;

import recommendation_library.dao.InMemoryRecommendationDao;
import recommendation_library.dao.RecommendationDao;
import recommendation_library.io.StubIO;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author jenni.makinen
 */
public class Stepdefs {
    
    List<String> inputLines;
    StubIO io;
    UserInterface ui;
    RecommendationDao dao;
    
    @Before
    public void setup(){
        this.inputLines = new ArrayList<String>();
    }

    @Given("^command add is selected")
    public void commandAddSelected() {
        inputLines.add("1");
    }
    
    @When("book recommendation with author {string}, title {string}, description {string}, isbn {string} and page count {string} is added")
    public void addBookRecommendation(String author, String title, String description, String isbn, String pageCount) {
        inputLines.add(author);
        inputLines.add(title);
        inputLines.add(description);
        inputLines.add(isbn);
        inputLines.add(pageCount);
        io = new StubIO(inputLines);
        dao = new InMemoryRecommendationDao();
        ui = new UserInterface(io, dao);
        ui.run();
    }
    
    @When("^command list is selected")
    public void commandEditSelected() {
        inputLines.add("2");
    }

    @Then("system will respond with {string}")
    public void systemWillRespondWith(String expectedOutput) {
        io.getPrints().contains(expectedOutput);
    }
    
    @Then("app lists a recommendation with author {string}, title {string}, description {string}, isbn {string}, and page count {string}")
    public void listingAddedRecommendation(String author, String title, String description, String isbn, String pageCount) {
        String addDate = java.time.LocalDate.now().toString();
        
        io.getPrints().contains("Recommendation 1" + System.lineSeparator() +
                    "Author: " + author + System.lineSeparator() +
                    "Title: " + title + System.lineSeparator() +
                    "Description: " + description + System.lineSeparator() +
                    "ISBN: " + isbn + System.lineSeparator() +
                    "Page count: " + pageCount + System.lineSeparator() +
                    "Added: " + addDate);
    }    
}
